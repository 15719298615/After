package com.ys.controller;

import java.io.IOException;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.ys.service.FeelService;

@Controller
public class FeelController {
	@Resource
	private FeelService feelServiceImpl;
	@RequestMapping("upload")
	@ResponseBody
	public Map<String,Object> upload(MultipartFile imgFile){
		
		try {
			return feelServiceImpl.upload(imgFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
}
