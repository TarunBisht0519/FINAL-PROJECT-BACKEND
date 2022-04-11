package com.salon.customer.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.salon.customer.entity.Customer;
import com.salon.customer.service.CustomerService;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class Controller 
{
	@Autowired
	CustomerService service;
	Customer customer;
	
	@PostMapping("/customer")
	public Customer addcustomer(@RequestBody Customer c)
	{
		return service.add(c);
	}
	@GetMapping("/customer/{dates}")

	public int revenue(@PathVariable String dates)
	{
		return service.getrevenue(dates);
	}
	@GetMapping("/customer/{start}/{end}")
	public int monthlyrevenue(@PathVariable String start,@PathVariable String end ) {
		return service.monthlyrevenue(start,end);
	}
	@GetMapping("/customer/gender/{sex}")
	public int ratio(@PathVariable String sex)
	{
		sex=sex.toUpperCase();
		return service.genderratio(sex);
	}
	@GetMapping("/customer/gender/{sex}/{date1}/{date2}")
	public int ratiobydate(@PathVariable String sex,@PathVariable @DateTimeFormat(pattern="yyyy-MM-dd") Date date1,@PathVariable @DateTimeFormat(pattern="yyyy-MM-dd") Date date2)
	{
		sex=sex.toUpperCase();
		return service.genderratiobydate(sex,date1,date2);
	}
	@GetMapping("/customer/gender/{sex}/{day}")
	public int ratiobyday(@PathVariable String sex,@PathVariable @DateTimeFormat(pattern="yyyy-MM-dd") Date day)
	{
		sex=sex.toUpperCase();
		return service.genderratiobyday(sex,day);
	}
	@GetMapping("/customer/count/{fname}/{lname}")
	public int getcount(@PathVariable String fname,@PathVariable String lname)
	{
		fname=fname.toUpperCase();
		lname=lname.toUpperCase();
		return service.counts(fname,lname);
	}
	@GetMapping("/customer/info/{fname}/{lname}")
	public List<Customer> info(@PathVariable String fname,@PathVariable String lname)
	{
		fname=fname.toUpperCase();
		lname=lname.toUpperCase();
		return service.information(fname,lname);
	}
	@DeleteMapping("/customer/delete/{fname}/{lname}")
	public int deletename(@PathVariable String fname,@PathVariable String lname)
	{
		fname=fname.toUpperCase();
		lname=lname.toUpperCase();
		return service.deletebyname(fname,lname);
	}
	@DeleteMapping("/customer/delete")
	public int dlatest()
	{
		return service.deletelatest();
	}
	@PutMapping("/customer/update/{firstname}/{lastname}")
	public Customer update(@PathVariable String firstname,@PathVariable String lastname,@RequestBody Customer c)
	{
		firstname=firstname.toUpperCase();
		lastname=lastname.toUpperCase();
		return service.update(firstname,lastname,c);
	}
	@GetMapping("/customer/all")
	public List<Customer> all()
	{
		return service.getall();
	}
	@GetMapping("/customer/city")
	public List<Customer> getcity()
	{
		return service.getCity();
	}

}
