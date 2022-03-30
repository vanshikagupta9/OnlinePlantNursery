package com.cg.onlinenursery.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.onlinenursery.entity.Admin;
import com.cg.onlinenursery.entity.Customer;
//import com.cg.onlinenursery.exception.AdminExistsException;
import com.cg.onlinenursery.exception.AdminNotFoundException;
import com.cg.onlinenursery.exception.CustomerIdNotFoundException;
import com.cg.onlinenursery.exception.InvalidDataException;
import com.cg.onlinenursery.exception.UserExistsException;
import com.cg.onlinenursery.repository.IAdminRepository;


@Service
@Transactional
public class AdminService implements IAdminService {
	@Autowired
	private IAdminRepository adminRepository;
	Logger logger = LoggerFactory.getLogger(AdminService.class);

	@Override
	public Admin addNewAdmin(Admin admin) {

		logger.info("Inside addNewAdmin method");
		Admin admindb = adminRepository.adminName(admin.getAdminName());

		if (admindb != null || adminRepository.existsByAdminId(admin.getAdminId())) {
			logger.error("Admin already exists");
			throw new UserExistsException("Admin exists already");
		} else {
			Admin adminObj = adminRepository.save(admin);
			logger.info("admin added");
			return adminObj;
		}

	}

	@Override
	public String signout(Admin admin) {
        Optional<Admin> adm=adminRepository.findById(admin.getAdminId());
        if(adm.isPresent()) {
        	return "Logged Out";
        }
        else {
        	return "Admin Not Found";
        }

	}

	@Override
	public String adminLogin(String adminName, String password) {

		Admin admin = adminRepository.adminName(adminName);
		logger.info(admin + "Admin");
		if (admin != null) {

			if (admin.getPassword().equals(password)) {
				logger.debug("admin login");
				return "true";
			} else {

				logger.info("Invalid Password");
				return "false";
				//throw new InvalidDataException("Invalid Password");
			}
		}

		else {
			logger.info("Invalidadminname");
			return "false";
			//throw new InvalidDataException("Invalid Admin Name");

		}
	}

	@Override
	public List<Admin> getAll() {
		List<Admin> adminList = adminRepository.findAll();
		if (adminList.isEmpty()) {
			logger.error("AdminNotFoundException in getAllAdmin method");
			throw new AdminNotFoundException("No Admin found");
		} else {
			return adminList;
		}
	}
	
	
	@Override
	public void deleteAdmin(int adminId) throws AdminNotFoundException {
		logger.info("Inside deleteAdmin method");
		if (adminRepository.existsByAdminId(adminId)) {
			adminRepository.deleteByAdminId(adminId);
		} else {
			logger.error("No admin with given id found");
			throw new AdminNotFoundException("No Admin found");
		}
	}

	
}