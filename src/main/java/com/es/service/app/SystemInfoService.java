package com.es.service.app;

import java.util.List;
import java.util.Map;

import com.es.common.util.Pager;
/**
 * #系统信息业务层
 * @author Handc
 *
 */
public interface SystemInfoService {
    /**
     * #根据用户 获取系统列表
     * @param params
     * @return
     */
    Pager<Map<String, Object>> getSystemInfoPager(Map<String, Object> params);
    
    
}
