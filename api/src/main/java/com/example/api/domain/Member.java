package com.example.api.domain;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Getter;

@Getter
public class Member {

	@NotBlank(message = "enter a email")
	@Email(message = "Please enter a valid email")
	private String email;
	
	@NotBlank(message = "enter a nickname")
    @Size(min = 2, max = 10, message = "nickname is between 2 and 10 length")
	private String nickname;
	
	@NotBlank(message = "enter a nickname")
    @Size(min = 8, max = 20, message = "password is between 2 and 20 length")
	private String password;
	
	@NotBlank(message = "enter a name")
    @Size(min = 2, max = 10, message = "name is between 2 and 10 length")
	private String name;
	
	@NotBlank(message = "enter a phone number")
    @Pattern(regexp = "(01[016789])(\\d{3,4})(\\d{4})", message = "Please enter a valid phone number")
	private String tel;
}
