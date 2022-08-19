package com.example.api.dao;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Repository
public class CertificationDao {

	private final int LIMIT_TIME = 3 * 60;
	
	private final int LIMIT_TIME_COMPLETE = 10 * 60;

    private final HttpSession session;

    public void createSmsCertification(String tel, String certificationNumber) {
    	session.setMaxInactiveInterval(LIMIT_TIME);
    	session.setAttribute(tel, certificationNumber);
    }

    public String getSmsCertification(String tel) {
        return (String) session.getAttribute(tel);
    }

    public void removeSmsCertification(String tel) {
    	session.removeAttribute(tel);
    }

    public boolean hasKey(String tel) {
    	if( session.getAttribute(tel) != null ) {
    		return true;
    	}
    	return false;
    }
    
    public void createCompleteKey(String tel, String completeKey) {
    	session.setMaxInactiveInterval(LIMIT_TIME_COMPLETE);
    	session.setAttribute("com"+tel, completeKey);
    }

    public String getCompleteKey(String tel) {
        return (String) session.getAttribute("com"+tel);
    }

    public void removeCompleteKey(String tel) {
    	session.removeAttribute("com"+tel);
    }

    public boolean hasCompleteKey(String tel) {
    	if( session.getAttribute("com"+tel) != null ) {
    		return true;
    	}
    	return false;
    }
}
