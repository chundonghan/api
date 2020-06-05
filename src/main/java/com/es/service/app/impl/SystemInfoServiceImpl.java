package com.es.service.app.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.es.common.util.Pager;
import com.es.dao.app.SystemInfoDao;
import com.es.service.app.SystemInfoService;

@Service
public class SystemInfoServiceImpl implements SystemInfoService {

    @Autowired
    private SystemInfoDao systemInfoDao;

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public Pager<Map<String, Object>> getSystemInfoPager(Map<String, Object> params) {
        String account = (String) params.get("account");
        int currentPage = (int) params.get("currentPage");
        int pageNum = (int) params.get("pageNum");
        params.clear();
        params.put("account", account);
        int totalCount = systemInfoDao.countSystemInfo(params);
        Pager<Map<String, Object>> systemInfoPager = new Pager<>(currentPage,pageNum,totalCount);
        int currentIndex = systemInfoPager.getCurrentIndex();
        params.put("currentIndex", currentIndex);
        params.put("pageNum", pageNum);
        List<Map<String, Object>> systemInfoList = systemInfoDao.getSystemInfoList(params);
        systemInfoPager.setList(systemInfoList);
        return systemInfoPager;
    }

}
