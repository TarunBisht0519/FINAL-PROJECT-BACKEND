package com.salon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.salon.customer.entity.Customer;

@SpringBootApplication
public class SalonApplication {

	public static void main(String[] args) {
		SpringApplication.run(SalonApplication.class, args);
	}

}
