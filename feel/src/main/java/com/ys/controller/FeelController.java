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
	private FeelService feelService;
	
	@RequestMapping("upload")
	@ResponseBody
	public Map<String,Object> upload(MultipartFile imgFile){
		try {
			return feelService.upload(imgFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
