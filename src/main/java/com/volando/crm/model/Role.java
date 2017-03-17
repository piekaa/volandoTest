package com.volando.crm.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Role 
{
	@Id
	@GeneratedValue
	private Long roleId;
	private String role;
	
	
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public Long getRoleId() {
		return roleId;
	}
	public Role() {
		super();
	}
	
	
	
	 
	
	
	
}
