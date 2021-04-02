package com.mulcam.ai.web.controller;

import java.io.File;
import java.io.IOException;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class UploadController {
	
	@PostMapping("upload") // post 방식으로 보낸다는 뜻
	public void upload(@RequestParam("file") MultipartFile file) { //MultipartFile 이미지 후처리를 도와주는 객체
		System.out.println(file);
		try {
			file.transferTo(new File("C:\\Users\\혜린\\TIL\\Multicampus2021\\Servlet\\tool\\temp\\snapshot.jpg"));
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
