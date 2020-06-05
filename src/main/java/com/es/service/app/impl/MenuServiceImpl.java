package com.es.service.app.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.es.dao.app.MenuDao;
import com.es.service.app.MenuService;

@Service
public class MenuServiceImpl implements MenuService {

	@Autowired
	private MenuDao menuDao;

	@Override
	public List<Map<String, Object>> getMenus(Map<String, Object> params) {
		List<Map<String, Object>> menus = menuDao.getMenus(params);

		return transformMenu(menus);
	}

	private List<Map<String, Object>> transformMenu(List<Map<String, Object>> menus) {
		List<Map<String, Object>> level_one = new ArrayList<Map<String, Object>>();
		// 遍历获取一级菜单
		for (Map<String, Object> menu : menus) {
			String menu_level = (String) menu.get("menu_level");
			if ("1".equals(menu_level)) {
				level_one.add(menu);
			} else {
				continue;
			}
		}
		List<Map<String, Object>> level_two = null;

		// 将二级菜单列表加入一级菜单children键中
		for (Map<String, Object> menu : level_one) {
			level_two = new ArrayList<Map<String, Object>>();
			Object menu_id = menu.get("menu_id");
			for (Map<String, Object> sub_menu : menus) {
				sub_menu.put("children", false);
				Object parent_id = sub_menu.get("parent_id");
				if(parent_id == null) {
					continue;
				}else if(parent_id.equals(menu_id)) {
					level_two.add(sub_menu);
				}else {
					continue;
				}
			}
			if(level_two.size() == 0) {
				menu.put("children", false);
			}else {
				menu.put("children", level_two);
			}
		}
		return level_one;
	}
}
