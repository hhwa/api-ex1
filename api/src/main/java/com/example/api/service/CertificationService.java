package com.example.api.service;

import org.springframework.stereotype.Service;

@Service
public class CertificationService {


	public void certifiedPhoneNumber(String tel, String numStr) {
		
        //���ڸ޼��� ����
		System.out.println("receiver :"+ tel);
		System.out.println("certifiedNumber :"+ numStr);
	}
}
