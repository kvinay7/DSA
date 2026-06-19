package com.karan.employeemanagementsystem.controller;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@GetMapping("/hello")
	public ResponseEntity<Map<String, String>> hello() {
		return ResponseEntity.ok(Map.of("message", "Hello World"));
	}
}
