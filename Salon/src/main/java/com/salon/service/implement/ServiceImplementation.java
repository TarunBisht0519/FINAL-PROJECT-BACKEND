package com.salon.service.implement;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;

import com.example.Project.exceptions.ResourceNotFoundException;
import com.salon.Packs;
import com.salon.Repository.CustomerRepo;
import com.salon.customer.entity.Customer;
import com.salon.customer.service.CustomerService;

@Service
public class ServiceImplementation implements CustomerService{

	@Autowired
	CustomerRepo repository;
	@Autowired
	Packs pack;
	public Customer add(Customer c) 
	{
		c.setFname(c.getFname().toUpperCase());
		c.setLname(c.getLname().toUpperCase());
		c.setCity(c.getCity().toUpperCase());
		c.setGender(c.getGender().toUpperCase());
		c.setPackages(c.getPackages());
		
		if(pack.contain(c.getPackages())!=null)
		{
			Long value=pack.contain(c.getPackages());
			c.setPrice(value);
			return repository.save(c);
		}
		else
		{
			System.out.println("ENTER VALID PACKAGE");
			return null;
		}
	}
	
	public int getrevenue(String dates) {
		LocalDate date12 = LocalDate.parse(dates);
		Date date = java.sql.Date.valueOf(date12);
		return repository.getrevenue(date);
		
	}

	public int monthlyrevenue(String start, String end) 
	{
		LocalDate date1 = LocalDate.parse(start);
		LocalDate date2 = LocalDate.parse(end);
		Date dates1 = java.sql.Date.valueOf(date1);
		Date dates2 = java.sql.Date.valueOf(date2);
		return repository.getmonthlyrevenue(dates1, dates2);
		
	}
	@Override
	public List<Customer> getCity() {
		return repository.getmaxcity();
	}
	
	public int genderratio(String sex) {
		return repository.getratio(sex);
	}
	
	public int genderratiobydate(String sex, Date date1, Date date2) {
		return repository.getratiobydate(sex, date1, date2);
	}
	
	public int genderratiobyday(String sex, Date day) {
		return repository.getratiobydate(sex, day);
	}
	
	public int counts(String fname, String lname) {
		return repository.count(fname, lname);
	}
	
	public List<Customer> information(String fname, String lname) {
		return repository.displayinfo(fname, lname);
	}
	@Override
	public int deletebyname(String fname,String lname) {
		return repository.deletebyname(fname, lname);
		
	}
	@Override
	public int deletelatest() {
		return repository.deletelatest();
	}
	@Override
	public Customer update(String firstname, String lastname, Customer c) {
		Long ids=repository.findid(firstname, lastname);
		if(repository.findById(ids)!=null)
		{
			Customer customer=repository.findById(ids).orElseThrow(() -> new ResourceNotFoundException("Employee","ID",ids));
			String Fname=c.getFname().toUpperCase();
			String Lname=c.getLname().toUpperCase();
			String City=c.getCity().toUpperCase();
			String sex=c.getGender().toUpperCase();
			customer.setFname(Fname);
			customer.setLname(Lname);
			customer.setCity(City);
			customer.setGender(sex);
			customer.setPackages(c.getPackages());
			if(pack.contain(c.getPackages())!=null)
			{
				Long value=pack.contain(c.getPackages());
				customer.setPrice(value);
				return repository.save(customer);
			}
			else
			{
				System.out.println("ENTER VALID PACKAGE");
				return null;
			}
			
		}
		else
		{
			System.out.println("RECORD NOT FOUND");
			return null;
		}
	}
	@Override
	public List<Customer> getall() {
		return repository.findAll();
		
	}
}
