package com.cg.onlinenursery.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;


@Entity
@Table(name = "customers")

public class Customer implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "customerId")
	private Integer customerId;
	@Column(name = "customerName")
	private String customerName;
	@Column(name = "customerEmail")
	private String customerEmail;
	@Column(name = "roomno")
	private Integer roomno;
	@Column(name = "district")
	private String district;
	@Column(name = "state")
	private String state;
	
	
//	@JsonIgnore
//	// @JsonProperty(access=Access.READ_ONLY)
//	@OneToMany(fetch = FetchType.LAZY, mappedBy = "customer", targetEntity = Order.class, cascade = CascadeType.ALL)
//	// @JoinColumn(name="orderId")
//	private List<Order> order;


	
	public Customer() {
		// TODO Auto-generated constructor stub
	}


	public Customer(Integer customerId, String customerName, String customerEmail, Integer roomno, String district,
		String state) {
	super();
	this.customerId = customerId;
	this.customerName = customerName;
	this.customerEmail = customerEmail;
	this.roomno = roomno;
	this.district = district;
	this.state = state;
}


	public Integer getCustomerId() {
		return customerId;
	}


	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}


	public String getCustomerName() {
		return customerName;
	}


	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}


	public String getCustomerEmail() {
		return customerEmail;
	}


	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}


	public Integer getRoomno() {
		return roomno;
	}


	public void setRoomno(Integer roomno) {
		this.roomno = roomno;
	}


	public String getDistrict() {
		return district;
	}


	public void setDistrict(String district) {
		this.district = district;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}





}