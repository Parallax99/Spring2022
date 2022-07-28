package com.controller;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.dao.UserDao;

@Controller
public class ProfileController {
	
	@Autowired
	UserDao userdao;
	@GetMapping("/NewProfile")
	public String newProfile() {
		return "NewProfile";
	}
	@PostMapping("/uploadprofile")
	public String uploadProfile(@RequestParam("pfp") MultipartFile file,Model model) {
		System.out.println(file.getOriginalFilename()+" "+ file.getSize() );
		String modelpath = "\"C:\\Users\\abhis\\eclipse-workspace\\ism-mvc\\src\\main\\webapp\\resources\\Images\"";
		File newFile = new File(modelpath,file.getOriginalFilename());
		try {
			FileOutputStream fos = new FileOutputStream(newFile);
			byte b[]= file.getBytes();
			fos.write(b);
			fos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "UserProfilePic";
		
	}
}
