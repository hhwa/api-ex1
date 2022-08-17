package com.example.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.api.service.MemberService;

@RestController
public class MemberController {

	@Autowired
	MemberService memberService;
	
	@GetMapping("/m/{token}")
	public boolean getUserCheck(@PathVariable("token") String token) {
		System.out.println("token:"+token);
		return true;
	}
	
	@PostMapping("/m")
	public boolean joinMember(@PathVariable("token") String token) {
		return true;
	}
}
