package com.tenable.gift.model;

import javax.validation.constraints.NotBlank;

public class Member {
	
	String id;
		
	@NotBlank(message = "name is required.")
	String name;
	
	public Member() {
	}
	
	public Member(String id,String name) {
		this.id = id;
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	

}
