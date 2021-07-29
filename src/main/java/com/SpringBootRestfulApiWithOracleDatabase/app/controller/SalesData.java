package com.SpringBootRestfulApiWithOracleDatabase.app.controller;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name =  "sales_data")
@DynamicUpdate
public class SalesData {
	
//	Follow the Steps given Below For the "Long" Id Auto-Creation/Generation
//	@Id
//	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "author_generator")
//	@SequenceGenerator(name="author_generator", sequenceName="author_seq",allocationSize=10)
	
	
//	Follow the Steps given Below For the "String" Id Auto-Creation/Generation
	@Id 
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid")
	@Column(name = "opportunityid",updatable=false,nullable=false)
	private String opportunityid;
	
	@Column(name = "accountname")
	 private String accountname;
	
	@Column(name = "address1")
	 private String address1;
	
	@Column(name = "address2")
	 private String address2;
	
	@Column(name = "city")
	 private String city;
	
	@Column(name = "state")
	 private String state;
	
	@Column(name = "zipcode")
	 private Long zipcode;
	
	@Column(name = "totalnetrevenue")
	 private Double totalnetrevenue;
	
	@Column(name = "effectivediscount")
	 private Double effectivediscount;
	
	
	public SalesData() {
		super();
		// TODO Auto-generated constructor stub
	}
	


	 // Getter Methods 

	 public String getOpportunityid() {
	  return opportunityid;
	 }

	 public String getAccountname() {
	  return accountname;
	 }

	 public String getAddress1() {
	  return address1;
	 }

	 public String getAddress2() {
	  return address2;
	 }

	 public String getCity() {
	  return city;
	 }

	 public String getState() {
	  return state;
	 }

/*	 public String getZipcode() {
	  return zipcode;
	 }

	 public String getTotalnetrevenue() {
	  return totalnetrevenue;
	 }

	 public String getEffectivediscount() {
	  return effectivediscount;
	 }*/

	 // Setter Methods 

	 public void setOpportunityid(String opportunityid) {
	  this.opportunityid = opportunityid;
	 }

	 public void setAccountname(String accountname) {
	  this.accountname = accountname;
	 }

	 public void setAddress1(String address1) {
	  this.address1 = address1;
	 }

	 public void setAddress2(String address2) {
	  this.address2 = address2;
	 }

	 public void setCity(String city) {
	  this.city = city;
	 }

	 public void setState(String state) {
	  this.state = state;
	 }

/*	 public void setZipcode(String zipcode) {
	  this.zipcode = zipcode;
	 }

	 public void setTotalnetrevenue(String totalnetrevenue) {
	  this.totalnetrevenue = totalnetrevenue;
	 }

	 public void setEffectivediscount(String effectivediscount) {
	  this.effectivediscount = effectivediscount;
	 }*/
	 
	 
	 
	 



	@Override
	public String toString() {
		return "Sales [opportunityid=" + opportunityid + ", accountname=" + accountname + ", address1=" + address1
				+ ", address2=" + address2 + ", city=" + city + ", state=" + state + ", zipcode=" + zipcode
				+ ", totalnetrevenue=" + totalnetrevenue + ", effectivediscount=" + effectivediscount + "]";
	}



	public Long getZipcode() {
		return zipcode;
	}



	public void setZipcode(Long zipcode) {
		this.zipcode = zipcode;
	}



	public Double getTotalnetrevenue() {
		return totalnetrevenue;
	}



	public void setTotalnetrevenue(Double totalnetrevenue) {
		this.totalnetrevenue = totalnetrevenue;
	}



	public Double getEffectivediscount() {
		return effectivediscount;
	}



	public void setEffectivediscount(Double effectivediscount) {
		this.effectivediscount = effectivediscount;
	}



	public SalesData(String opportunityid, String accountname, String address1, String address2, String city,
			String state, Long zipcode, Double totalnetrevenue, Double effectivediscount) {
		super();
		this.opportunityid = opportunityid;
		this.accountname = accountname;
		this.address1 = address1;
		this.address2 = address2;
		this.city = city;
		this.state = state;
		this.zipcode = zipcode;
		this.totalnetrevenue = totalnetrevenue;
		this.effectivediscount = effectivediscount;
	}
	 
	 
}
