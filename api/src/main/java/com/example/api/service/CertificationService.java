package com.example.api.service;

import java.util.Random;

import org.springframework.stereotype.Service;

import com.example.api.dao.CertificationDao;
import com.example.api.domain.Certification;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class CertificationService {

	private final CertificationDao certificationDao;

	public void certificatedPhoneNumber(String tel) {
		
		Random rand  = new Random();
        String certificationNumber = "";
        for(int i=0; i<6; i++) {
            String ran = Integer.toString(rand.nextInt(10));
            certificationNumber += ran;
        }
        System.out.println(certificationNumber);
		
		certificationDao.createSmsCertification(tel, certificationNumber);
	}
	
	public void verifySms(Certification certification) {
        if (!isVerify(certification)) {
            throw new RuntimeException("Authentication failed");
        }
        certificationDao.removeSmsCertification(certification.getTel());
        certificationDao.createCompleteKey(certification.getTel(),certification.getTel());
    }

    private boolean isVerify(Certification certification) {
        return certificationDao.hasKey(certification.getTel()) &&
        		certificationDao.getSmsCertification(certification.getTel())
                .equals(certification.getCertificationNumber());
    }
    
    public boolean verifyCompleteKey(String tel) {
        if(isVerifyCompleteKey(tel)) {
        	certificationDao.removeCompleteKey(tel);
        	return true;
        }
        return false;
    }
    
    private boolean isVerifyCompleteKey(String tel) {
    	return certificationDao.hasCompleteKey(tel) && 
        		certificationDao.getCompleteKey(tel)
        		.equals(tel);
    }
}
