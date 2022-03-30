package com.cg.onlinenursery.service;

import java.util.List;

import com.cg.onlinenursery.entity.Admin;
import com.cg.onlinenursery.entity.Customer;

public interface IAdminService {
	public Admin addNewAdmin(Admin admin);

	public String signout(Admin admin);

	public List<Admin> getAll();

	public String adminLogin(String role, String password);
	
	public void deleteAdmin(int adminId);

	

}