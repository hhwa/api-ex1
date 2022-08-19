package com.example.api.controller;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.example.api.domain.Member;
import com.example.api.service.CertificationService;
import com.example.api.service.MemberService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class MemberController {

	private final MemberService memberService;
	
	private final CertificationService certificationService;
	
	@PostMapping("/member/join")
	public ResponseEntity<Void> joinMember(@Valid @RequestBody Member member) {
		if(certificationService.verifyCompleteKey(member.getTel())) {
			return ResponseEntity.badRequest().build();
		}
		memberService.joinMember(member);
		
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
	
	@GetMapping("/member/exists/emails/{email}")
    public ResponseEntity<Boolean> checkEmailDuplicate(@PathVariable String email) {
        return ResponseEntity.ok(memberService.checkEmailDuplicate(email));
    }

    @GetMapping("/member/exists/nicknames/{nickname}")
    public ResponseEntity<Boolean> checkNicknameDuplicate(@PathVariable String nickname) {
        return ResponseEntity.ok(memberService.checkNicknameDuplicate(nickname));
    }

	@PostMapping("/login")
	public void memberLogin(@RequestBody Member member) {
		memberService.login(member);
	}
	
	@DeleteMapping("/logout")
	public boolean memberLogout() {
		memberService.logout();
		return true;
	}
	
	@GetMapping("/myinfo")
	public ResponseEntity<Member> getMemberInfo(@SessionAttribute(name ="email", required = false) String email) {
		Member memberInfo = memberService.getMemberByEmail(email);
		return ResponseEntity.ok(memberInfo);
	}
	
	@PatchMapping("/searchPassword")
	public void searchPassword(@SessionAttribute(name ="email", required = false) String email,
			@RequestBody Member member) {
		if(email == null) {
			if(certificationService.verifyCompleteKey(member.getTel())) {
				memberService.searchPassword(member);
			}
			
		}
	}
	
	
}