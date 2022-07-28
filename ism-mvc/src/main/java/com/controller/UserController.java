package com.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bean.UserBean;
import com.dao.UserDao;

@Controller
public class UserController {
	@Autowired
	UserDao userdao;
	
	@GetMapping("/ListUsers")
	public String getAllUsers(Model model) {
		List<UserBean> users = userdao.getAllUsers();
		model.addAttribute("users",users);
		return "ListUsers";
	}
	@GetMapping("/Search")
	public String Search() {
		return "Search";
	}
	@GetMapping("/DeleteUser")
	public String deleteUser(@RequestParam("userId") int userId) {
		userdao.deleteUser(userId);
		return "redirect:/ListUsers";
		
	}
	@GetMapping("/ViewUser")
	public String ViewUser(@RequestParam("userId") int userId,Model model) {
		UserBean user = userdao.userInfo(userId);
		model.addAttribute("user",user);
		return "ViewUser";
	}
	@PostMapping("/SearchInfo")
	public String SearchInfo(@RequestParam("name") String name,Model model) {
		List<UserBean> users = userdao.searchInfo(name);
		model.addAttribute("users",users);
		return "SearchResult";	
	}
}
