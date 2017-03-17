package pl.volanto.crm.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.security.core.GrantedAuthority;

@Entity
public class Role implements GrantedAuthority
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
	public Role(String role) {
		super();
		this.role = role;
	}
	@Override
	public String getAuthority() {
		return role;
	}
	
	
	
	 
	
	
	
}
