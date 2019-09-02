package com.ys.controller;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ys.pojo.Menu;
import com.ys.service.MenuService;

@Controller
public class MenuController {
	@Resource
	private MenuService menuServiceImpl;
	
	@RequestMapping("/show")
	public String show(Model model){
		model.addAttribute("list",menuServiceImpl.show());
		return "/index.jsp";
		
	}
	
	@RequestMapping("/showMenu")
	public String showMenu(int id,Model model){
		Map<String, Object> map = menuServiceImpl.showMenu(id);
		model.addAttribute("menu",map.get("menu"));
		model.addAttribute("allmenu", map.get("allmenu"));
		return "/update.jsp";
		
	}
	
	@RequestMapping("/update")
	public String update(Menu menu){
		int index = menuServiceImpl.update(menu);
		if(index>0){
			return "/show";
		}else{
			return "redirect:/showMenu?id="+menu.getId();
		}
		
		
	}

	
}
