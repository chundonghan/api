package com.es.dao.app;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.es.pojo.app.ImMessage;

public interface ImDao {
	//------------------------------消息------------------------------//
	List<Map<String,Object>> getImWindows(Map<String,Object> params);
	
	List<Map<String,Object>> getImMessages(Map<String,Object> params);
	
	int getImMessagesCount(Map<String,Object> params);
	
	
	
	//------------------------------联系人------------------------------//
	List<Map<String,Object>> getContacts(Map<String,Object> params);
	
	List<Map<String,Object>> getApplies(Map<String,Object> params);
	
	int acceptOrApply(Map<String,Object> params);
	
	int existContact(Map<String,Object> params);
	
	int ifInterContact(Map<String,Object> params);
	
	int removeApplied(Map<String,Object> params);
	
	int denyApply(Map<String,Object> params);
	
	Map<String,Object> getImUserInfo(Map<String,Object> params);

	int saveMessage(ImMessage imMessage);
	
	Map<String,Object> getImWindow(@Param(value="id") long id);
	
	List<Map<String,Object>> selectUsers(Map<String,Object> params);

	int updateMessageFromFlag(Map<String, Object> params);
	
	int updateMessageToFlag(Map<String, Object> params);

	int saveWindowAttr(Map<String, Object> params);

	int updateWindowAttr(Map<String, Object> params);

	Map<String, Object> findWindowAttr(Map<String, Object> params);

	int saveGroup(Map<String, Object> param);

	int batchSaveGroupAccount(List<Map<String, Object>> list);

	int batchCreateGroupWindow(List<Map<String, Object>> list);
	
	int saveGroupMessage(Map<String, Object> param);

	int getImGroupMessagesCount(Map<String, Object> params);

	List<Map<String, Object>> getImGroupMessages(Map<String, Object> params);
}
