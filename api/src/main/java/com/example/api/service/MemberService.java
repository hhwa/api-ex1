package com.example.api.service;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.example.api.domain.Member;
import com.example.api.mapper.MemberMapper;
import com.example.api.util.EncryptionUtils;

import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor   
@Service
public class MemberService {

	private final HttpSession session;
	private final MemberMapper memberMapper;
	
	public void joinMember(Member member) {
		if(checkTelDuplicate(member.getTel())) {
			throw new RuntimeException("Exists Tel");
		}
		String encryptionPassword = passwordEncryption(member.getPassword());
		member.setPassword(encryptionPassword);
		memberMapper.joinMember(member);
	}
	
	public boolean checkEmailDuplicate(String email) {
		if(memberMapper.existMemberByEmail(email) > 0) {
			return true;
		}
		return false;
	}

	public boolean checkNicknameDuplicate(String nickname) {
		if(memberMapper.existMemberByNickname(nickname) > 0) {
			return true;
		}
		return false;
	}
	
	public boolean checkTelDuplicate(String tel) {
		if(memberMapper.existMemberByTel(tel) > 0) {
			return true;
		}
		return false;
	}
	
	public String passwordEncryption(String password) {
		String encryptionPassword = EncryptionUtils.encrypt(password);
		return encryptionPassword;
	}
	
	
	public void login(Member member) {
		if(member.getPassword() != null) {
			String encryptionPassword = passwordEncryption(member.getPassword());
			member.setPassword(encryptionPassword);
			
			Member memberinfo = getMemberInfo(member);
			
			if(memberinfo != null) {
				session.setAttribute("email", member.getEmail());
				session.setAttribute("nickname", member.getNickname());
			}else {
				throw new RuntimeException("not exist member");
			}
		}else {
			throw new RuntimeException("password is null");
		}
	}
	
	public void logout() {
        session.removeAttribute("email");
        session.removeAttribute("nickname");
    }
	
	public Member getMemberInfo(Member member) {
		Member memberInfo = null;
		
		memberInfo = memberMapper.getMemberCheck(member);
		return memberInfo;
	}
	
	public Member getMemberByEmail(String email) {
		return memberMapper.getMemberByEmail(email);
	}
	
	public void searchPassword(Member member) {
		boolean existMember = false;
		if(member.getTel() != null) {
			if(checkTelDuplicate(member.getTel())) { existMember = true; }
		}else if(member.getEmail() != null) {
			if(checkEmailDuplicate(member.getEmail())) { existMember = true; }
		}else if(member.getNickname() != null) {
			if(checkNicknameDuplicate(member.getNickname())) { existMember = true; }
		}
		
		if(existMember) {
			String encryptionPassword = passwordEncryption(member.getPassword());
			member.setPassword(encryptionPassword);
			memberMapper.updatePassword(member);
		}
		
	}
}
