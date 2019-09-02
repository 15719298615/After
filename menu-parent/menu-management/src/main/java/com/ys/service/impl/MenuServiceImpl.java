package com.ys.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.ys.dubbo.service.MenuDubboService;
import com.ys.pojo.Menu;
import com.ys.service.MenuService;

@Service
public class MenuServiceImpl implements MenuService {
	@Reference
	private MenuDubboService menuService;

	@Override
	public List<Menu> show() {
		return menuService.selAll();
	}

	@Override
	public Map<String,Object> showMenu(int id) {
		Map<String,Object> map = new HashMap<>();
		map.put("menu",menuService.selById(id));
		map.put("allmenu",menuService.selAll());
		return map;
	}

	@Override
	public int update(Menu menu) {
		return menuService.updMenu(menu);
	}

	
	
}
