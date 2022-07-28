package com.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bean.LoginBean;
import com.bean.UserBean;
import com.dao.UserDao;

@Controller
public class ValidationController {
	@Autowired
	UserDao userdao;
	@RequestMapping(value = "/SignUp", method = RequestMethod.GET)
	public String Signup(UserBean user,Model model ) {
		model.addAttribute("user",user);
		return "SignUp";
	}

	@RequestMapping(value = "/Submit", method = RequestMethod.POST)
	public String Submit(@ModelAttribute("user")@Valid UserBean userbean, BindingResult result,Model model) {

		if (result.hasErrors()) {
			
			return "SignUp";
		}else if(userdao.verify(userbean.getEmail())){
			model.addAttribute("error","Email Already Exists");
			return "SignUp";
		}else
		System.out.println(userbean.getFirstName());
		userdao.insertUser(userbean);
		model.addAttribute("msg","SignUp Done");
		return "Login";
	}

	@RequestMapping(value = "/Login", method = RequestMethod.POST)
	public String Home(@Valid LoginBean user, BindingResult result, Model model) {
		System.out.println(result.getFieldValue("email"));
		if (result.hasErrors()) {
			model.addAttribute("user",user);
				return "Login";
			
	}else {
		
		return "Home"; 
	}
	}	
	@GetMapping("/Login")
	public String Login() {
		return "Login";
	}
}
