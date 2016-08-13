package com.login.model;

public class UserModel {
	 
    private String username;
    private String password;
    private String passwordConfirm;
 
    public void reset() {
        this.username = null;
        this.password = null;
        this.passwordConfirm = null;
    }

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPasswordConfirm() {
		return passwordConfirm;
	}

	public void setPasswordConfirm(String passwordConfirm) {
		this.passwordConfirm = passwordConfirm;
	}
 
}