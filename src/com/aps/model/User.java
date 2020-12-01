package com.aps.model;

public class User extends Person {

	private String permission;
	
	public User(String name, String email, String permission) {
		super(name, email);
		this.permission = permission;
		
	}

	public String getPermission() {
		return permission;
	}

	public void setPermission(String permission) {
		this.permission = permission;
	}
	
}
