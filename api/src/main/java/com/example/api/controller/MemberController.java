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
* ȸ�� ���� ���
��ȭ��ȣ ���� �� ȸ�������� �����ؾ� �մϴ�.
* �α��� ���
�ĺ� ������ ��� ������ �α����� �����ؾ� �մϴ�.
�ĺ� ������ ��� ������ ���������� ������ �Ǵ��Ͽ� �����Ͻø� �˴ϴ�.
��) ���̵� Ȥ�� ��ȭ��ȣ + ��й�ȣ�� �Է��ϸ� �α����� �����մϴ�.
* �� ���� ���� ���
* ��й�ȣ ã�� ( �缳�� ) ���
�α��� �Ǿ� ���� ���� ���¿��� ��й�ȣ�� �缳���ϴ� ����Դϴ�.
��ȭ��ȣ ���� �� ��й�ȣ �缳���� �����ؾ� �մϴ�.

*/