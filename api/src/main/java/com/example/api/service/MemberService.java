package com.example.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.api.domain.Member;
import com.example.api.mapper.MemberMapper;

@Service
public class MemberService {

	@Autowired
	MemberMapper memberMapper;
	
	public void joinMember(Member member) {
		memberMapper.joinMember(member);
	}
	
	public String getMemberByEmail(String email) {
		return memberMapper.getMemberByEmail(email);
	}
}
