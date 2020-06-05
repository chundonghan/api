package com.es.service.app.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.es.common.util.DateUtil;
import com.es.common.util.Pager;
import com.es.common.util.Pinyin;
import com.es.common.util.SnowflakeIdWorker;
import com.es.dao.app.ImDao;
import com.es.dao.redis.RedisDao;
import com.es.pojo.app.ImMessage;
import com.es.service.app.ImService;

@Service
public class ImServiceImpl implements ImService {
	@Autowired
	private ImDao imDao;

	@Autowired
	private RedisDao redisDao;
	
	@Value("${message.pagenum}")
	private int pageNum;
	
	@Override
	public List<Map<String, Object>> getImWindows(Map<String, Object> params) {
		String from = (String) params.get("username");
		String to = null;
		List<Map<String, Object>> imWindows = imDao.getImWindows(params);
		for(Map<String, Object> imWindow : imWindows) {
			to = (String) imWindow.get("im_window");
			//查看缓存 新消息标志 设置参数并清空
			String has_new = redisDao.hget(to, from);
			if(has_new!= null && "true".equals(has_new)) {
				imWindow.put("has_new", true);
			}else {
				imWindow.put("has_new", false);
			}
			
		}
		return imWindows;
	}
	
	@Override
	public Pager<Map<String, Object>> getImMessages(Map<String, Object> params) {
		String from_account = (String) params.get("from_account");
		String to_account = (String) params.get("to_account");
        int currentPage = (int) params.get("currentPage");
        params.clear();
        params.put("from_account", from_account);
        params.put("to_account", to_account);
        int totalCount = imDao.getImMessagesCount(params);
        Pager<Map<String, Object>> messagePager = new Pager<>(currentPage,this.pageNum,totalCount);
        int currentIndex = messagePager.getCurrentIndex();
        params.put("currentIndex", currentIndex);
        params.put("pageNum", pageNum);
        List<Map<String, Object>> messages = imDao.getImMessages(params);
        
        messagePager.setList(transformMessage(messages));
		return messagePager;
	}

	/**
	 * 重新构造分组消息列表
	 * 其结构为
	 * [
	 * 	{
	 * 		"msg_group":"",
	 * 		"msg_group_time":"",
	 * 		"chat_record_list":[
	 * 			{
	 * 				"id":"",
	 * 				"from_account":"",
	 * 				"avatar":"",
	 * 				"msg":"",
	 * 				"from_to":"",
	 * 			}
	 * 		]
	 * 	}
	 * ]
	 * @param messages
	 * @return
	 */
	private List<Map<String, Object>> transformMessage(List<Map<String, Object>> messages){
		List<Map<String, Object>> messagesGroups = new ArrayList<Map<String, Object>>();
		
		Map<String, Object> messageMap = null;
		Object msg_group = "";
		Object each_msg_group = new Object();
		List<Map<String, Object>> chatRecordList = null;
		int times = 0;
		Map<String, Object> message = null;
		for(int i =0; i<messages.size();i++) {
			message = messages.get(i);
			each_msg_group = message.get("msg_group");
			if(each_msg_group.equals(msg_group)) {
				chatRecordList.add(message);
				times ++;
			}else {//消息组不相同 次数置0
				times = 0;
			}
			// 0 即重新构造消息map分组
			if(times == 0) {
				if(messageMap!=null) {
					messageMap.put("chat_record_list", chatRecordList);
					messagesGroups.add(messageMap);
				}
				msg_group = each_msg_group;
				messageMap = new HashMap<String, Object>();
				messageMap.put("msg_group", msg_group);
				Timestamp create_timestamp = (Timestamp) message.get("create_timestamp");
				messageMap.put("msg_group_time", DateUtil.transformTimeStamp(create_timestamp));
				Object msg = message.get("msg");
				chatRecordList = new ArrayList<Map<String, Object>>();
				if(!"".equals(msg)) {
					chatRecordList.add(message);
				}
				
				
				times ++;
			}
			
		}
		messageMap.put("chat_record_list", chatRecordList);
		messagesGroups.add(messageMap);
		return messagesGroups;
	}

	@Override
	public List<Map<String, Object>> getContacts(Map<String, Object> params) {
		List<Map<String, Object>> contacts = imDao.getContacts(params);
		List<Map<String, Object>> contact_group = contactsGroupByInitial(contacts);
		return contact_group;
	}
	
	private List<Map<String, Object>> contactsGroupByInitial(List<Map<String, Object>> contacts){
		List<Map<String, Object>> contactList = new ArrayList<Map<String, Object>>();
		List<Map<String, Object>> sharpContactList = contacts;
		Map<String, Object> initialMap;
		List<Map<String, Object>> initialGroupList;
		for (char i = 97; i <= 123; i++) {
			initialMap = new HashMap<String, Object>();
			String value;
			if (i == 123) {
				value = "#";
			} else {
				value = (i + "").toUpperCase();
			}
			initialMap.put("initial", value);
			initialGroupList = new ArrayList<Map<String, Object>>();
			if(i == 123) {
				initialGroupList = sharpContactList;
				if(initialGroupList.size()>0) {
					initialMap.put("contact_list", initialGroupList);
					contactList.add(initialMap);
				}
				continue;
			}
			
			for (int j = 0; j < contacts.size(); j++) {
				if (Pinyin.getInitialChar((String) contacts.get(j).get("nickname")) == i) {
					initialGroupList.add(contacts.get(j));
					sharpContactList.remove(contacts.get(j));
				} else {
					continue;
				}
			}
			if(initialGroupList.size()>0) {
				initialMap.put("contact_list", initialGroupList);
				contactList.add(initialMap);
			}
			
		}
		
		return contactList;
	}

	@Override
	public Map<String, Object> getImUserInfo(Map<String, Object> params) {
		return imDao.getImUserInfo(params);
	}

	@Override
	public Map<String, Object> createImWindow(Map<String, Object> params) {
		
		ImMessage imMessage =new ImMessage();
		long id = new SnowflakeIdWorker(0, 0).nextId();
		imMessage.setId(id);
		imMessage.setFrom_account(params.get("from_account").toString());
		imMessage.setTo_account(params.get("to_account").toString());
		imMessage.setMsg_group(new SnowflakeIdWorker(0, 0).nextId()+"");
		int result = imDao.saveMessage(imMessage);
		Map<String, Object> retMap = new HashMap<String, Object>();
		if(result == 1) {
			retMap = imDao.getImWindow(id);
		}
		return retMap;
	}
	
	@Override
	public List<Map<String, Object>> getApplies(Map<String, Object> params) {
		List<Map<String, Object>> applies = imDao.getApplies(params);
		if(applies == null || (applies.size() == 1 && applies.get(0)==null)) {
			return new ArrayList<Map<String, Object>>();
		}
		
		return applies;
	}

	@Override
	public Map<String, Object> acceptOrApply(Map<String, Object> params) {
		params.put("id", new SnowflakeIdWorker(0, 0).nextId());
		Map<String, Object> retMap = new HashMap<String,Object>();
		
		Map<String, Object> params2 = new HashMap<String, Object>();
		params2.put("user_account", params.get("user_account"));
		params2.put("contact_user_account", params.get("contact_user_account"));
		
		int count = imDao.existContact(params2);
		if(count>0) {
			retMap.put("msg", "already");
			return retMap;
		}
		int result = imDao.acceptOrApply(params);
		if(result>0) {
			retMap.put("msg", "succ");
		}else {
			retMap.put("msg", "failed");
		}
		return retMap;
	}
	
	@Override
	public List<Map<String, Object>> searchContact(Map<String, Object> params) {
		List<Map<String, Object>> accountList = imDao.selectUsers(params);
		if(accountList == null || (accountList.size() == 1 && accountList.get(0)==null)) {
			return new ArrayList<Map<String, Object>>();
		}
		return accountList;
	}

	@Override
	public Map<String, Object> ifInterContact(Map<String, Object> params) {
		Map<String, Object> retMap = new HashMap<String,Object>();
		int count = imDao.ifInterContact(params);
		if(count == 2) {
			retMap.put("msg", true);
		}else {
			retMap.put("msg", false);
		}
		return retMap;
	}

	@Transactional
	@Override
	public Map<String, Object> delWindow(Map<String, Object> params) {
		imDao.updateMessageFromFlag(params);
		imDao.updateMessageToFlag(params);
		Map<String, Object> retMap = new HashMap<String,Object>();
		retMap.put("msg", "succ");
		return retMap;
	}
	

	@Override
	public Map<String, Object> windowType(Map<String, Object> params) {
		Map<String,Object> windowAttr= imDao.findWindowAttr(params);
		if(windowAttr == null) {
			params.put("id", new SnowflakeIdWorker(0, 0).nextId());
			imDao.saveWindowAttr(params);
		}else {
			imDao.updateWindowAttr(params);
		}
		Map<String, Object> retMap = new HashMap<String,Object>();
		retMap.put("msg", "succ");
		return retMap;
	}

	@SuppressWarnings("unchecked")
	@Transactional
	@Override
	public Map<String, Object> addGroup(Map<String, Object> params) {
		SnowflakeIdWorker idWorker = new SnowflakeIdWorker(0, 0);
		List<Map<String,Object>> checked_contacts = (List<Map<String, Object>>) params.get("checked_contacts");
		long group_id = idWorker.nextId();
		String group_host = params.get("user_account").toString();
		
		String group_name = "";
		List<Map<String, Object>> group_account_list = new ArrayList<Map<String, Object>>();
		Map<String, Object> group_account = new HashMap<String,Object>();
		group_account.put("id", idWorker.nextId());
		group_account.put("group_id",group_id);
		group_account.put("user_account",group_host);
		group_account_list.add(group_account);
		for(Map<String,Object> contact:checked_contacts) {
			group_name+=contact.get("nickname")+",";
			
			group_account = new HashMap<String,Object>();
			group_account.put("id", idWorker.nextId());
			group_account.put("group_id",group_id);
			group_account.put("user_account",contact.get("account"));
			group_account_list.add(group_account);
		}
		group_name = group_name.substring(0, group_name.length()-1);
		
		Map<String, Object> param1 = new HashMap<String,Object>();
		param1.put("id", group_id);
		param1.put("group_name", group_name);
		param1.put("group_host", group_host);
		imDao.saveGroup(param1);
		imDao.batchSaveGroupAccount(group_account_list);
		
		for(Map<String,Object> group_account2:group_account_list) {
			group_account2.put("id",idWorker.nextId());
			group_account2.put("msg", "");
		}
		imDao.batchCreateGroupWindow(group_account_list);
		
		Map<String, Object> retMap = new HashMap<String,Object>();
		retMap.put("msg", "succ");
		return retMap;
	}

	@Override
	public Pager<Map<String, Object>> getImGroupMessages(Map<String, Object> params) {
		String user_account = (String) params.get("user_account");
		String group_id = (String) params.get("group_id");
        int currentPage = (int) params.get("currentPage");
        params.clear();
        params.put("user_account", user_account);
        params.put("group_id", group_id);
        int totalCount = imDao.getImGroupMessagesCount(params);
        Pager<Map<String, Object>> messagePager = new Pager<>(currentPage,this.pageNum,totalCount);
        int currentIndex = messagePager.getCurrentIndex();
        params.put("currentIndex", currentIndex);
        params.put("pageNum", pageNum);
        List<Map<String, Object>> messages = imDao.getImGroupMessages(params);
        
        messagePager.setList(transformMessage(messages));
		return messagePager;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> getPinyinIndexedContact(Map<String, Object> params) {
		
		List<Map<String, Object>> contacts = imDao.getContacts(params);
		List<Map<String, Object>> accountIndexedList;
		List<Map<String, Object>> nicknamePinyinIndexedList;
		List<Map<String, Object>> nicknameInitialIndexedList;
		Map<String, Object> pinyinIndexedContact = new HashMap<>();
		for(Map<String, Object> contact : contacts) {
			
			String account = contact.get("account").toString();
			String nickname = contact.get("nickname").toString();
			String nickname_pinyin = Pinyin.getPingYin(nickname);
			String nickname_initial = Pinyin.getPinYinHeadChar(nickname);
			//account 不可能重复
			accountIndexedList = new ArrayList<>();
			accountIndexedList.add(contact);
			pinyinIndexedContact.put(account, accountIndexedList);
			//拼音重复
			Object nickname_pinyin_object = pinyinIndexedContact.get(nickname_pinyin);
			if(nickname_pinyin_object != null) {
				nicknamePinyinIndexedList = (List<Map<String, Object>>) nickname_pinyin_object;
				nicknamePinyinIndexedList.add(contact);
				pinyinIndexedContact.put(nickname_pinyin, nicknamePinyinIndexedList);
			}else {
				nicknamePinyinIndexedList = new ArrayList<>();
				nicknamePinyinIndexedList.add(contact);
				pinyinIndexedContact.put(nickname_pinyin, nicknamePinyinIndexedList);
			}
			//拼音首字母重复
			Object nickname_initial_object = pinyinIndexedContact.get(nickname_initial);
			if(nickname_initial_object !=null) {
				nicknameInitialIndexedList = (List<Map<String, Object>>) nickname_initial_object;
				nicknameInitialIndexedList.add(contact);
				pinyinIndexedContact.put(nickname_initial, nicknameInitialIndexedList);
			}else {
				nicknameInitialIndexedList = new ArrayList<>();
				nicknameInitialIndexedList.add(contact);
				pinyinIndexedContact.put(nickname_initial, nicknameInitialIndexedList);
			}
		}
		return pinyinIndexedContact;
	}



}
