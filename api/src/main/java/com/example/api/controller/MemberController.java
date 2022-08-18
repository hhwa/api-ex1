package com.example.api.controller;

import java.util.Random;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.api.domain.Member;
import com.example.api.service.MemberService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class MemberController {

	private final MemberService memberService;
	
	@PostMapping("/join/mem")
	public boolean joinMember(@RequestBody Member member) {
		return true;
	}
	

	@PostMapping("/login")
	public boolean memberLogin(@RequestBody Member member) {
		return true;
	}
	
	@GetMapping("/memberinfo/{flag}")
	public boolean getMemberInfo(@PathVariable("flag") String flag) {
		memberService.getMemberByTel(flag);
		return true;
	}
	
	
	public void searchPassword() {
		
	}
	
	
}

/*
* 회원 가입 기능
전화번호 인증 후 회원가입이 가능해야 합니다.
* 로그인 기능
식별 가능한 모든 정보로 로그인이 가능해야 합니다.
식별 가능한 모든 정보가 무엇인지는 스스로 판단하여 결정하시면 됩니다.
예) 아이디 혹은 전화번호 + 비밀번호를 입력하면 로그인이 가능합니다.
* 내 정보 보기 기능
* 비밀번호 찾기 ( 재설정 ) 기능
로그인 되어 있지 않은 상태에서 비밀번호를 재설정하는 기능입니다.
전화번호 인증 후 비밀번호 재설정이 가능해야 합니다.

*/