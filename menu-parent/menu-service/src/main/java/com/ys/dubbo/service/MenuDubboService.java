package com.ys.dubbo.service;

import java.util.List;

import com.ys.pojo.Menu;

public interface MenuDubboService {
	List<Menu> selAll();
	
	int updMenu(Menu menu);
	
	Menu selById(int id); 
}
