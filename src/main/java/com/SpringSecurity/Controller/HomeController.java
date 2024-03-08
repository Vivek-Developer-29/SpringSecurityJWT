package com.SpringSecurity.Controller;

import java.security.Principal;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SpringSecurity.Entity.User;
import com.SpringSecurity.Services.UserService;

@RestController
@RequestMapping("/home")
public class HomeController {
	@Autowired
	private UserService userService;
	
	//http://localhost:8081/home/user
	@GetMapping("/user")
	public List<User> getUsers() {
		System.out.println("getting users");
		return userService.getUsers();
	}
	@GetMapping("/current-user")
	public String getLoggedInUser(Principal principal) {
		return principal.getName();
	}
	

}
