package com.mini.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mini.entity.UserAccounts;
import com.mini.service.IUserService;

@Controller
public class UserAccountController {
	@Autowired
	private IUserService userService;
	
	@GetMapping("/")
	public String index(Model model) {
		
		model.addAttribute("user",new UserAccounts());
		
		return "index";
	}
	
	@PostMapping("/save-user")
	public String handleSubmitButton(@ModelAttribute ("user") UserAccounts user , Model model) {
		
		String  msg= userService.saveOrUpdateUserAcc(user);
		Integer userId=user.getUserId();
		model.addAttribute("msg",msg+" with "+userId);
		model.addAttribute("user",new UserAccounts());//For not showing the form data after submition of the record.form data will be cleared.
		return "index";
	}
	
	@GetMapping("/view-users")
	public String getUsers(Model model) {
		
		List<UserAccounts> allUsers = userService.getAllUserAccounts();
		model.addAttribute("allUsers",allUsers);
		return "view-users";
	}
	
	@GetMapping("/edit")
	public String editUser(@RequestParam("id") Integer userId ,Model model) {
		UserAccounts userAccountRecord = userService.getUserAccount(userId);
		model.addAttribute("user",userAccountRecord);
		return "index";
	}
	
	@GetMapping("/delete")
	public String deleteUserAcc(@RequestParam("id") Integer userId,Model model) {
		boolean deleteUserAcc = userService.deleteUserAcc(userId);
		if(deleteUserAcc) {
			model.addAttribute("msg",userId+"--"+"User Account Deleted.");
		}
		return "forward:/view-users";
	}
	
	@GetMapping("/update")
	public String updateUserAccStatus(@RequestParam("id") Integer userId,@RequestParam("status") String status,Model model) {
		
		userService.updateUserAccountStatus(userId, status);
		
		if("Y".equals(status)) {
			model.addAttribute("msg","User Account  activated");
		}
		else {
			model.addAttribute("msg","User Account De-activated");
				
		}
		
		return "forward:/view-users";
	}

}
