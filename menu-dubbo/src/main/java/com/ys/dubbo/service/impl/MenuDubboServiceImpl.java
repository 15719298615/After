package com.ys.dubbo.service.impl;

import java.util.List;

import javax.annotation.Resource;

import com.ys.dubbo.service.MenuDubboService;
import com.ys.mapper.MenuMapper;
import com.ys.pojo.Menu;

public class MenuDubboServiceImpl implements MenuDubboService {
	@Resource
	private MenuMapper menuMapper;
	
	@Override
	public List<Menu> selAll() {
		
		List<Menu> list = menuMapper.selAll();
		for (Menu menu : list) {
			if(menu.getPid()!=0){
				menu.setParent(menuMapper.sleById(menu.getPid()));
			}
			menu.setChildren(menuMapper.selByPid(menu.getId()));
		}
		
		return list;
	}

	@Override
	public int updMenu(Menu menu) {
		return menuMapper.updMenu(menu);
	}

	@Override
	public Menu selById(int id) {
		// TODO Auto-generated method stub
		return menuMapper.sleById(id);
	}
	
}
