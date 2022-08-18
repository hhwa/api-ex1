package com.example.api.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.example.api.domain.Member;

@Mapper
public interface MemberMapper {
	
	void joinMember(Member member);
	String getMemberByEmail(String email);
	String getMemberByTel(String tel);
	

}
