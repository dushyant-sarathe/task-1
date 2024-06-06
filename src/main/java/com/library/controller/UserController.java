package com.library.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.library.service.UserService;
import com.library.user.User;

@RestController
@RequestMapping("/api/users")

public class UserController {
	@Autowired
	private UserService userService;

	@GetMapping("/getusers")
	public List<User> getAllUsers() {
		return userService.findAll();
	}

	@PostMapping("/adduser")
	public User addUser(@RequestBody User user) {
		return userService.save(user);
	}
	@DeleteMapping("/delete/{id}")
	public void deleteUser(@PathVariable Long id) {
		userService.deleteById(id);
	}
}
