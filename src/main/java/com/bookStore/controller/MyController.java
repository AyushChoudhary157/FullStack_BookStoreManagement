package com.bookStore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.bookStore.entity.User;
import com.bookStore.service.UserService;
import jakarta.servlet.http.HttpSession;
import java.util.Objects;

@Controller
public class MyController {
	@Autowired
	private UserService userService;
	
	@GetMapping("/regPage")
	public String openRegPage(Model model) {
		model.addAttribute("user", new User());
		return "register";
	}
	
	@PostMapping("/regForm")
	public String submitRegForm(@ModelAttribute("user") User user, Model model) {
		boolean status = userService.registerUser(user);
		if(status) {
			model.addAttribute("successMsg", "User registered successfully");
		} else {
			model.addAttribute("errorMsg", "User not registered due to some error");
		}
		return "register";
	}
	
	@GetMapping("/loginPage")
	public String openLoginPage(Model model) {
		model.addAttribute("user", new User());
		return "login";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
	    session.invalidate();
	    return "redirect:/loginPage";
	}
	
	@PostMapping("/loginForm")
	public String submitLoginForm(@ModelAttribute("user") User user, Model model, HttpSession session) {
		User validUser = userService.loginUser(user.getEmail(), user.getPassword());
		if(validUser != null) {
			session.setAttribute("user", validUser);
			return "redirect:/home";
		}
		else {
			model.addAttribute("errorMsg","Email id and password didn't matched");
			return "login";
		}
	}
}
