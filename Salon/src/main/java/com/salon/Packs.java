package com.salon;

import java.util.HashMap;

import org.springframework.stereotype.Component;

@Component
public class Packs 
{
	/*p1=haircut
	p2=hairwash
	p3=Men : Clean Up with Exfoliation + Hair Cut + Shave
	p4=Premium Waxing (Full Arms + Full Legs + Underarms)
	p5=Detan Pedicure + Dry Manicure
	p6=Basic Head to Toe Package
	p7=Keratin Hair Treatment (Shoulder Length)
	p8=Facial + Insta Detan
	p9=Haircut + Hair Wash + Hair Conditioning
	p10=Global Hair Color/Global Highlights/ (Any Length)
	p11= O3+ Facial
	p12=Advanced Gold Facial Service
	*/
	final private long p1=100;
	final private long p2=250;
	final private long p3=500;
	final private long p4=1500;
	final private long p5=2000;
	final private long p6=2500;
	final private long p7=2100;
	final private long p8=2200;
	final private long p9=800;
	final private long p10=3400;
	final private long p11=450;
	final private long p12=3500;

	HashMap<String,Long>map=new HashMap<String,Long>();
	public void addmap()
	{
		map.put("p1", p1);
		map.put("p2", p2);
		map.put("p3", p3);
		map.put("p4", p4);
		map.put("p5", p5);
		map.put("p6", p6);
		map.put("p7", p7);
		map.put("p8", p8);
		map.put("p9", p9);
		map.put("p10", p10);
		map.put("p11", p11);
		map.put("p12", p12);
		
	}
	
	public Long contain(String s)
	{
		
		addmap();
		Long value=null;
		if(map.containsKey(s))
		{
			value=map.get(s);
			return value;
		}
		return value;
		
	}
	public long getP1() {
		return p1;
	}
	public long getP10() {
		return p10;
	}
	public long getP11() {
		return p11;
	}
	public long getP5() {
		return p5;
	}
	public long getP7() {
		return p7;
	}
	
	public long getP12() {
		return p12;
	}
	public long getP3() {
		return p3;
	}
	public long getP6() {
		return p6;
	}
	public long getP2() {
		return p2;
	}
	public long getP4() {
		return p4;
	}
	public long getP8() {
		return p8;
	}
	public long getP9() {
		return p9;
	}
	
	

}
