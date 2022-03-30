package com.cg.onlinenursery.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonIgnoreProperties({ "hibernateLazyInitilizer", "handler" })
@Entity
@Table(name = "AdminTable")
@JsonInclude(Include.NON_NULL)
public class Admin implements Serializable {
	@Id
	//@GeneratedValue
	private int adminId;
	@Column(name = "Adminname", unique = true)
	private String adminName;
	@Column(name = "Password")
	private String password;
	
	
//	@JsonIgnore
//	@OneToOne(fetch = FetchType.LAZY)
//	private Customer customer;

	private static final long serialVersionUID = 1L;


	public int getAdminId() {
		return adminId;
	}


	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}


	public String getAdminName() {
		return adminName;
	}


	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}

	public Admin(@NotEmpty int adminId, String password) {

		super();
		this.adminId = adminId;
		this.password = password;

	}

	public Admin(@NotEmpty int adminId, String adminName, String password) {
		super();
		this.adminId = adminId;
		this.adminName = adminName;
		this.password = password;
	}


	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Admin(String password) {
		super();
		this.password = password;

	}


	@Override
	public String toString() {
		return "Admin [adminId=" + adminId + ", adminName=" + adminName + ", password=" + password + "]";
	}


}