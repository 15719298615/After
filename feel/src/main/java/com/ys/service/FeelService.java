package com.ys.service;

import java.io.IOException;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

public interface FeelService {
	Map<String,Object> upload(MultipartFile imgFile) throws IOException;


}
