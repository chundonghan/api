package com.es.service.app;

import java.util.List;
import java.util.Map;

import com.es.common.util.Pager;

public interface ImService {
	/**
	 * 获取即时通讯窗口列表
	 * @param params
	 * @return
	 */
	List<Map<String,Object>> getImWindows(Map<String,Object> params);
	
	/**
	 * 获取私聊消息按时间分组列表
	 * @param params
	 * @return
	 */
	Pager<Map<String, Object>> getImMessages(Map<String,Object> params);
	
	/**
	 * 获取联系人列表 按首字母分类
	 * @param params
	 * @return
	 */
	List<Map<String,Object>> getContacts(Map<String,Object> params);
	/**
	 * 获取联系人信息
	 * @param params
	 * @return
	 */
	Map<String,Object> getImUserInfo(Map<String,Object> params);

	/**
	 * 创建通讯窗口
	 * @param params
	 * @return
	 */
	Map<String, Object> createImWindow(Map<String, Object> params);
	/**
	 * 新增联系人申请列表
	 * @param params
	 * @return
	 */
	List<Map<String, Object>> getApplies(Map<String, Object> params);
	
	/**
	 * 申请好友或接受申请
	 * @param params
	 * @return
	 */
	Map<String, Object> acceptOrApply(Map<String, Object> params);
	
	/**
	 * 搜索联系人账号列表
	 * @param params
	 * @return
	 */
	List<Map<String, Object>> searchContact(Map<String, Object> params);
	
	/**
	 * 互为好友关系
	 * @param params
	 * @return
	 */
	Map<String, Object> ifInterContact(Map<String, Object> params);

	/**
	 * 删除窗口
	 * @param params
	 * @return
	 */
	Map<String, Object> delWindow(Map<String, Object> params);

	/**
	 * 修改窗口类型 置顶/免打扰
	 * @param params
	 * @return
	 */
	Map<String, Object> windowType(Map<String, Object> params);

	/**
	 * 创建群聊
	 * @param params
	 * @return
	 */
	Map<String, Object> addGroup(Map<String, Object> params);

	/**
	 * 	获取群聊消息按时间分组列表
	 * @param params
	 * @return
	 */
	Pager<Map<String, Object>> getImGroupMessages(Map<String, Object> params);

	Map<String, Object> getPinyinIndexedContact(Map<String, Object> params);
	
	
}
