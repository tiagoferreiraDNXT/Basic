package com.example.demo.Controller;


import java.util.List;

import javax.annotation.security.RolesAllowed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.User;
import com.example.demo.Services.UserService;



@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	//Accessed by admin only
	@PostMapping("/addUser")
	@RolesAllowed("admin")
	public User addUser(@RequestBody User user) {
		return userService.createUser(user);
	}
	
	//Accessed by admin only
	@PostMapping("/addUsers")
	@RolesAllowed("admin")
	public List<User> addUsers(@RequestBody List<User> users){
		return userService.createUsers(users);
	}
	
	//Accessed by user only
	@GetMapping("/user/{id}")
	@RolesAllowed("user")
	public User getUserById(@PathVariable int id) {
		return userService.getUserById(id);	
	}
	
	//Accessed by admin only
	@GetMapping("/users")
	@RolesAllowed("admin")
	public List<User> getAllUsers(){
		return userService.getAllUsers();
	}
	
	//Accessed by admin only
	@PutMapping("/updateuser")
	@RolesAllowed("admin")
	public User updateUser(@RequestBody User user) {
		return userService.updateUser(user);
	}
	
	//Accessed by admin only
	@DeleteMapping("/user/{id}")
	@RolesAllowed("admin")
	public String deleteUSer(@PathVariable int id) {
		return userService.deleteUserById(id);
	}
	
	

}
