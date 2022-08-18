package com.example.api.controller;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.api.service.CertificationService;

public class CertificationController {
	
	@Autowired
	CertificationService certificationService;

	@GetMapping("/check/sendSMS")
    public @ResponseBody String sendSMS(String tel) {

        Random rand  = new Random();
        String numStr = "";
        for(int i=0; i<6; i++) {
            String ran = Integer.toString(rand.nextInt(10));
            numStr+=ran;
        }

        certificationService.certifiedPhoneNumber(tel,numStr);
        return numStr;
    }
}
