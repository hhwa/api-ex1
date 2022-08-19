package com.example.api.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.example.api.domain.Member;

@Mapper
public interface MemberMapper {
	
	void joinMember(Member member);
	Member getMemberByEmail(String email);
	Member getMemberCheck(Member member);
	int existMemberByEmail(String email);
	int existMemberByTel(String tel);
	int existMemberByNickname(String nickname);
	void updatePassword(Member member);
	

}
