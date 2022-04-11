package com.salon.Repository;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Repository;

import com.salon.customer.entity.Customer;

@Transactional
@Repository
public interface CustomerRepo extends JpaRepository<Customer, Long> 
{
	@Query(value="SELECT city FROM customer_data GROUP BY city ORDER BY COUNT( id ) DESC limit 5",nativeQuery=true)
	public List<Customer> getmaxcity();
	/*REQUEST TO GET TOTAL REVENUE GENERATED ON A SPECIFIC DATE*/
	@Query(value="Select sum(price) from customer_data where date(datetime)=:dates",nativeQuery=true)
	public int getrevenue(@Param("dates") @DateTimeFormat(pattern="yyyy-MM-dd")  Date dates);
	/*REQUEST TO GET REVENUE GENERATED BETWEEN 2 ADDED DATES*/
	@Query(value="select sum(price) from customer_data where date(datetime) between :startdate and :enddate",nativeQuery=true)
	public int getmonthlyrevenue(@Param("startdate")@DateTimeFormat(pattern="yyyy-MM-dd") Date startdate,@Param("enddate")@DateTimeFormat(pattern="yyyy-MM-dd") Date enddate);
	/*REQUEST TO GET NUMBER OF MALE FEMALES VISITED IN TOTAL*/
	@Query(value="select count(id) from customer_data where gender =:sex",nativeQuery=true)
	public int getratio(@Param("sex") String sex);
	@Query(value="select count(id) from customer_data where gender =:sex and date(datetime) between :date1 and :date2",nativeQuery=true)
	public int getratiobydate(@Param("sex") String sex,@Param("date1")@DateTimeFormat(pattern="yyyy-MM-dd") Date date1,@Param("date2")@DateTimeFormat(pattern="yyyy-MM-dd") Date date2);
	@Query(value="select count(id) from customer_data where gender =:sex and date(datetime) =:day",nativeQuery=true)
	public int getratiobydate(@Param("sex") String sex,@Param("day")@DateTimeFormat(pattern="yyyy-MM-dd") Date day);
	/*GETTING COUNT OF A PARTICULAR CUSTOMER*/
	@Query(value="select count(id) from customer_data where first_name=:name and last_name=:lname",nativeQuery=true)
	public int count(@Param("name")String name,@Param("lname")String lname);
	/*DISPLAY INFORMATION OF CUSTOMER*/
	@Query(value="select * from customer_data where first_name= :fname and last_name= :lname",nativeQuery=true)
	public List<Customer> displayinfo(@Param("fname")String fname,@Param("lname")String lname);
	/* DELETE ENTRY BY NAME OF CUSTOMER*/
	@Modifying
	@Query(value="delete from customer_data where first_name=:fname and last_name=:lname",nativeQuery=true)
	public int deletebyname(@Param("fname")String fname,@Param("lname")String lname);
	/*DELETE LATEST ENTRY*/
	@Modifying
	@Query(value="delete from customer_data order by id desc limit 1",nativeQuery=true)
	public int deletelatest();
	/*UPDATING DATA BASED ON NAME OF CUSTOMER*/
	@Query(value="select id from customer_data where first_name=:fname and last_name=:lname",nativeQuery=true)
	public Long findid(@Param("fname")String fname,@Param("lname")String lname);
}
