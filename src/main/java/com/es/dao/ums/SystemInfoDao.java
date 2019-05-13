package com.es.dao.ums;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper/* 代替mybatis xml文件  */
@Component
public interface SystemInfoDao {
	
    
    /**
     *  #系统列表
     * @param params
     * @return
     */
    List<Map<String,Object>> getSystemInfoList(Map<String,Object> params);
    
    /**
     * #用户下系统总数量
     * @param params
     * @return
     */
    int countSystemInfo(Map<String,Object> params);
}
