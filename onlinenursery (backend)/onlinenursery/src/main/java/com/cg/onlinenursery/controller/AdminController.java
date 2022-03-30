package com.cg.onlinenursery.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.onlinenursery.entity.Admin;
import com.cg.onlinenursery.entity.Customer;
import com.cg.onlinenursery.exception.AdminNotFoundException;
import com.cg.onlinenursery.exception.CustomerIdNotFoundException;
import com.cg.onlinenursery.service.AdminService;
import com.cg.onlinenursery.service.IAdminService;

@RestController
@RequestMapping("/admin")
@CrossOrigin(origins="http://localhost:4200")
public class AdminController {

	@Autowired
	AdminService adminService;
	Logger logger = LoggerFactory.getLogger(AdminController.class);

	@PostMapping
	public ResponseEntity<String> addNewAdmin(@Valid @RequestBody Admin admin, HttpServletRequest request) {
		
		logger.info("Inside addNewAdmin method");
		logger.info("Admin"+admin);

		Admin adminData = adminService.addNewAdmin(admin);
//		if (admin.getAdminId() < 0) {
//			// logger.error("planters id is coming here");
//			throw new AdminNotFoundException("Admin Id cannot be negative");}
//		
		
		 if (adminData != null) {
			return new ResponseEntity<>("Added successfully", HttpStatus.OK);
		}
		else
			return new ResponseEntity<>("Admin not added", HttpStatus.OK);
	}

	@GetMapping("signin/{adminName}/{password}")
	public boolean adminLogin(@Valid @PathVariable(value = "adminName") String adminName,
			@PathVariable(value = "password") String password, HttpServletRequest request) {
		HttpSession session = request.getSession();
		String admin = adminService.adminLogin(adminName, password);
		if (admin == "true") {
			
			session.setAttribute("UserExists", admin);

			logger.info("Login successfully!" + admin);
			//return new ResponseEntity<>("true", HttpStatus.CREATED)
			return true;
		} else {
			logger.info("Login Failed!!!");

			//return new ResponseEntity<>("false", HttpStatus.BAD_REQUEST)
			return false;
		}
	}
	
	@GetMapping("/getAllAdmin")
	public ResponseEntity<List<Admin>> getAllAdmins() {
		logger.info("Inside getAllAdmins method");
		List<Admin> adminList = adminService.getAll();
		return new ResponseEntity<List<Admin>>(adminList, HttpStatus.OK);
}
	
	@DeleteMapping("/deleteAdmin")
	public ResponseEntity<Object> deleteAdmin(@Valid @RequestParam int admin, HttpServletRequest request) {
		logger.info("Inside deleteAdmin method");
		HttpSession session = request.getSession();
		String sessionUser = (String) session.getAttribute("UserExists");
		logger.info("Session User" + sessionUser);
		if (sessionUser != null) {
			adminService.deleteAdmin(admin);
			return new ResponseEntity<Object>("Admin deleted", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Admin with Admin Id Not Found", HttpStatus.BAD_REQUEST);
		}
	}
	
	
	@PostMapping("/signout")
	public ResponseEntity<String> adminSignOut(@Valid @RequestBody Admin admin, HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.removeAttribute("UserExists");
		session.invalidate();
		logger.info("Inside adminSignOut method");
		String adminData = adminService.signout(admin);

		return new ResponseEntity<String>(adminData, HttpStatus.OK);
	}

	
//	
////	@DeleteMapping("/deleteAdmin/{aid}")
//	@RequestMapping(value="/deleteAdmin/{aid}", method= {RequestMethod.DELETE, RequestMethod.GET})
//	public ResponseEntity<Object> deleteAdmin(@Valid @PathVariable(value="aid") int admin, HttpServletRequest request) {
//		System.out.println("Hi"+ admin);
//		logger.info("Inside deleteAdmin method");
//		HttpSession session = request.getSession();
//		Admin sessionUser = (Admin) session.getAttribute("UserExists");
//		logger.info("Session User" + sessionUser);
//		if (sessionUser != null) {
//			adminService.deleteAdmin(admin);
//			return new ResponseEntity<Object>("Admin deleted", HttpStatus.OK);
//		} else {
//			return new ResponseEntity<>("Admin with Admin Id Not Found", HttpStatus.BAD_REQUEST);
//		}
//	}
//	
//	@DeleteMapping("/customer/{cid}")
//	public ResponseEntity<Object> deleteCustomers(@PathVariable("cid") int customerid) {
//		System.out.println(customerid);
//				return null;
//
////		HttpSession session = request.getSession();
//		Admin admin = adminService.adminLogin(adminName, password);
//		if (admin != null) {
//			session.setAttribute("UserExists", admin);
//
//			logger.info("Login successfully!" + admin);
//			return new ResponseEntity<>(admin, HttpStatus.CREATED);
//		} else {
//			logger.info("Login Failed!!!");
//
//			return new ResponseEntity<>(admin, HttpStatus.BAD_REQUEST);
//		}
	}