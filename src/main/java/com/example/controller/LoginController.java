package com.example.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.User;
import com.example.request.PayLoad;
import com.example.service.UserService;

@RestController
@CrossOrigin(origins = "*")
public class LoginController {

	@Autowired
	public UserService userService;

	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody User payload) {
		Map<String, Object> map = new HashMap<String, Object>();

		try {
			List<User> userList = (List<User>) userService.findAll();

			for (User user : userList) {
				if (user.getUsername().equals(payload.getUsername())
						&& user.getPassword().equals(payload.getPassword())) {
					map.put("message", "Login Successful");
					map.put("status", "Success");
					map.put("data", user);
					return ResponseEntity.ok(map);
				}
			}
			map.put("message", "User data not found");
			map.put("status", "failed");
			map.put("data", null);
			return ResponseEntity.status(412).body(map);
		} catch (Exception e) {
			map.put("message", e.getLocalizedMessage());
			map.put("status", "Failed");
			map.put("data", null);
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(map);
		}
	}
}
