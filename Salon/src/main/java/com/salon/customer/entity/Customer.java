package com.salon.customer.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="CUSTOMER_DATA")
public class Customer 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@Column(name="first_name",nullable=false)
	private String fname;
	@Column(name="last_name")
	private String lname;
	@Column(name="Gender")
	private String gender;
	
	@Column(name="CITY")
	private String city;
	@Column(name="Package")
	private String packages;
	@Column(name="Price")
	private Long price;
	@Column(name="Contact")
	private String contact;
	@Column(name="Mail")
	private String mail;
	
	public Customer() {
		// TODO Auto-generated constructor stub
	}
	
	public Customer(String fname, String lname, String gender,String city, String packages,String contact,String mail) {
		this.fname = fname;
		this.lname = lname;
		this.gender = gender;
		this.city = city;
		this.packages = packages;
		this.contact=contact;
		this.mail=mail;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	
	public Long getPrice() {
		return price;
	}
	public void setPrice(Long price) {
		this.price = price;
	}

	public String getPackages() {
		return packages;
	}
	public void setPackages(String packages) {
		this.packages = packages;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}

}
