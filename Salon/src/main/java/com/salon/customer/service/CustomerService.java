package com.salon.customer.service;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import com.salon.customer.entity.Customer;

public interface CustomerService {

	Customer add(Customer c);

	int getrevenue(String dates);

	int monthlyrevenue(String start, String end);

	int genderratio(String sex);

	int genderratiobydate(String sex, Date date1, Date date2);

	int genderratiobyday(String sex, Date day);

	int counts(String fname, String lname);

	List<Customer> information(String fname, String lname);

	int deletebyname(String fname,String lname);

	int deletelatest();

	Customer update(String firstname, String lastname, Customer c);

	List<Customer> getall();

	List<Customer> getCity();

    


}
