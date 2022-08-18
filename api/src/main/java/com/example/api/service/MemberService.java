package com.example.api.service;

import org.springframework.stereotype.Service;

import com.example.api.domain.Member;
import com.example.api.mapper.MemberMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberService {

	private final MemberMapper memberMapper;
	
	public void joinMember(Member member) {
		memberMapper.joinMember(member);
	}
	
	public String getMemberByEmail(String email) {
		return memberMapper.getMemberByEmail(email);
	}
	
	public String getMemberByTel(String tel) {
		return memberMapper.getMemberByTel(tel);
	}
	
}
