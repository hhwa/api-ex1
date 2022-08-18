package com.example.api.service;

import org.springframework.stereotype.Service;

@Service
public class CertificationService {


	public void certifiedPhoneNumber(String tel, String numStr) {
		
        //문자메세지 전송
		System.out.println("receiver :"+ tel);
		System.out.println("certifiedNumber :"+ numStr);
	}
}
