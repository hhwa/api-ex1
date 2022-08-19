package com.example.api.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.api.domain.Certification;
import com.example.api.service.CertificationService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class CertificationController {
	
	private final CertificationService certificationService;

	@PostMapping("/certification/send")
    public ResponseEntity<Void> sendSms(@RequestBody Certification certification) {
        certificationService.certificatedPhoneNumber(certification.getTel());
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
	
	 @PostMapping("/certification/confirms")
	 public ResponseEntity<Void> SmsVerification(@RequestBody Certification certification) {
		 certificationService.verifySms(certification);
		 return ResponseEntity.ok().build();
	 }
}
