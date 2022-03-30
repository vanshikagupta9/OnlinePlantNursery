package com.cg.onlinenursery.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.onlinenursery.entity.Admin;

//@Repository
public interface IAdminRepository extends JpaRepository<Admin, Integer> {
	public Admin findByAdminIdAndPassword(int adminId, String password); // String role

	public boolean existsByAdminId(int adminId);

	public Admin findByAdminId(int adminId);

	public Admin adminName(String adminname);

	public Admin password(String password);
	
	public void deleteByAdminId(int adminId);

}