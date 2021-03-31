package com.app.dto;

import javax.validation.constraints.NotNull;

public class LoginRequestDto {
	@NotNull
	private String email;
	@NotNull
	private String password;

	public LoginRequestDto() {
		
	}

	public LoginRequestDto(@NotNull String email, @NotNull String password) {
		super();
		this.email = email;
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "LoginRequestDto [email=" + email + ", password=" + password + "]";
	}

}
