package com.ys.service.impl;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ys.service.FeelService;
import com.ys.utils.FtpUtil;

@Service
public class FeelServiceImpl implements FeelService {
	 @Value("${ftpclient.host}")
	 private String host;
	 @Value("${ftpclient.port}")
	 private int port;
	 @Value("${ftpclient.username}")
	 private String username;
	 @Value("${ftpclient.password}")
	 private String password;
	 @Value("${ftpclient.basePath}")
	 private String basePath;
	 @Value("${ftpclient.filePath}")
	 private String filePath;	
	
	@Override
	public Map<String, Object> upload(MultipartFile imgFile) throws IOException {
		String fileName = UUID.randomUUID()+imgFile.getOriginalFilename().substring(imgFile.getOriginalFilename().lastIndexOf("."));
		boolean result = FtpUtil.uploadFile(host, port, username, password, basePath, filePath, fileName, imgFile.getInputStream());
		Map<String,Object> map = new HashMap<>();
		if(result){
			map.put("error", 0);
			map.put("url", "http://192.168.72.131/"+fileName);
		}else{
			map.put("error", 1);
			map.put("message", "图片上传失败!!!");
		}
		return map;
	
	}
	
	
}
