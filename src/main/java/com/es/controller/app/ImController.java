package com.es.controller.app;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.es.common.util.Pager;
import com.es.dao.redis.RedisDao;
import com.es.service.app.ImService;

@RestController
public class ImController extends BaseController{
	private Logger logger = LoggerFactory.getLogger(ImController.class);
	@Autowired
	private RedisDao redisDao;
	@Autowired
	private ImService imService;
	
	/**
	 * 即时通讯窗口列表
	 * @param token 用户token
	 * @return
	 */
	@PostMapping("/im/windows")
	public List<Map<String,Object>> getImWindows(@RequestHeader(value="token",defaultValue="") String token){
		String username = redisDao.get(token);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("username", username);
		return imService.getImWindows(params);
	}
	
	@PostMapping("/im/remove/remind/{to_account}")
	public Map<String,Object> removeMessageRemind(@RequestHeader(value="token",defaultValue="") String token,
			@PathVariable(value="to_account") String to_account){
		String username = redisDao.get(token);
		long hdel = redisDao.hdel(to_account, username);
		return new HashMap<>();
	}
	
	/**
	 * 即时通讯信息列表
	 * @param token 用户token
	 * @param to_account 对方用户
	 * @param currentPage 当前页数
	 * @return
	 */
	@PostMapping("/im/messages/{to_account}/{currentPage}")
	public Pager<Map<String,Object>> getImMessages(@RequestHeader(value="token",defaultValue="") String token,
			@PathVariable(value="to_account") String to_account,
			@PathVariable(value="currentPage") String currentPage,
			@RequestBody Map<String,Object> map){
		int current_page = 1;
		try {
			current_page = Integer.parseInt(currentPage);
		}catch(Exception e) {
			current_page = 1;
		}
		String username = redisDao.get(token);
		String is_group = map.get("is_group").toString();
		Pager<Map<String,Object>> pager = null;
		if("0".equals(is_group)) {
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("from_account", username);
			params.put("to_account", to_account);
			params.put("currentPage", current_page);
			pager = imService.getImMessages(params);
		}
		if("1".equals(is_group)) {
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("user_account", username);
			params.put("group_id", to_account);
			params.put("currentPage", current_page);
			pager = imService.getImGroupMessages(params);
		}
		return pager;
	}
	
	/**
	 * 联系人列表
	 * @param token
	 * @return
	 */
	@PostMapping("/im/contacts")
	public List<Map<String,Object>> contacts(@RequestHeader(value="token",defaultValue="") String token){
		String username = redisDao.get(token);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("account", username);
		
		return imService.getContacts(params);
	}
	/**
	 * 拼音索引联系人
	 * @param token
	 * @return
	 */
	@PostMapping("/im/contact/pinyin")
	public Map<String,Object> pinyinIndexedContact(@RequestHeader(value="token",defaultValue="") String token){
		String username = redisDao.get(token);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("account", username);
		
		return imService.getPinyinIndexedContact(params);
	}
	/**
	 * 联系人信息
	 * @param account
	 * @return
	 */
	@PostMapping("/im/userinfo/{account}")
	public Map<String,Object> userinfo(@PathVariable(value="account") String account){
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("account", account);
		
		return imService.getImUserInfo(params);
	}
	
	/**
	 * 创建聊天窗口
	 * @param token
	 * @param to_account
	 * @return
	 */
	@PostMapping("/im/window/create/{to_account}")
	public Map<String,Object> createImWindow(@RequestHeader(value="token",defaultValue="") String token,
			@PathVariable(value="to_account") String to_account){
		String from_account = redisDao.get(token);

		Map<String, Object> params = new HashMap<String, Object>();
		params.put("from_account", from_account);
		params.put("to_account", to_account);
		return imService.createImWindow(params);
		
	}
	/**
	 * 删除窗口
	 * @param token
	 * @param map
	 * @return
	 */
	@PostMapping("/im/window/del")
	public Map<String,Object> delWindow(@RequestHeader(value="token",defaultValue="") String token,
			@RequestBody Map<String,Object> map){
		String user_account = redisDao.get(token);
		String to_account = map.get("to_account").toString();
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("from_account", user_account);
		params.put("to_account", to_account);
		return imService.delWindow(params);
		
	}
	@PostMapping("/im/window/type")
	public Map<String,Object> windowType(@RequestHeader(value="token",defaultValue="") String token,
			@RequestBody Map<String,Object> map){
		String user_account = redisDao.get(token);
		String to_account = map.get("to_account").toString();
		String notice_type = map.get("notice_type").toString();
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("from_account", user_account);
		params.put("to_account", to_account);
		params.put("notice_type", notice_type);
		
		return imService.windowType(params);
		
	}
	
	/**
	 * 创建群聊
	 * @param token
	 * @param map
	 * @return
	 */
	@PostMapping("/im/group/add")
	public Map<String,Object> addGroup(@RequestHeader(value="token",defaultValue="") String token,
			@RequestBody List<Map<String,Object>> checked_contacts){
		String user_account = redisDao.get(token);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("user_account", user_account);
		params.put("checked_contacts", checked_contacts);
		return imService.addGroup(params);
		
	}
	
	
	
	/**
	 * 申请联系人列表
	 * @param token
	 * @return
	 */
	@PostMapping("/im/contact/applies")
	public List<Map<String,Object>> applies(@RequestHeader(value="token",defaultValue="") String token){
		String account = redisDao.get(token);
		for(int i = 0;i< redisDao.llen("apply_to_"+account);i++) {
			redisDao.lpop("apply_to_"+account);
		}
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("account", account);
		return imService.getApplies(params);
		
	}
	/**
	 *  接受或申请联系人
	 * @param token
	 * @param map
	 * @return
	 */
	@PostMapping("/im/contact/apply")
	public Map<String,Object> acceptOrApply(@RequestHeader(value="token",defaultValue="") String token,
			@RequestBody Map<String,Object> map){
		String user_account = redisDao.get(token);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("user_account", user_account);
		params.put("contact_user_account", map.get("contact_user_account"));
		params.put("validate_msg", map.get("validate_msg"));
		return imService.acceptOrApply(params);
		
	}
	/**
	 * 对话双方是否相互为联系人
	 * @param token
	 * @param map
	 * @return
	 */
	@PostMapping("/im/contact/ifinter")
	public Map<String,Object> ifInterContact(@RequestHeader(value="token",defaultValue="") String token,
			@RequestBody Map<String,Object> map){
		String from_account = redisDao.get(token);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("from_account", from_account);
		params.put("to_account", map.get("to_account"));
		return imService.ifInterContact(params);
		
	}
	
	/**
	 * 搜索账号列表
	 * @param token
	 * @param query
	 * @return
	 */
	@PostMapping("/im/contact/search/{query}")
	public List<Map<String,Object>> searchContact(@RequestHeader(value="token",defaultValue="") String token,
			@PathVariable(value="query") String query){
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("query", query);
		return imService.searchContact(params);
		
	}
	/**
	 *      申请联系人提示数量
	 * @param token
	 * @return
	 */
	@PostMapping("/im/contact/newapply")
	public Map<String,Object> newApply(@RequestHeader(value="token",defaultValue="") String token){
		String account = redisDao.get(token);
		long newContactApplyCount = redisDao.llen("apply_to_"+account);
		Map<String, Object> retMap = new HashMap<String, Object>();
		retMap.put("count", newContactApplyCount);
		return retMap;
		
	}
	
	
}
