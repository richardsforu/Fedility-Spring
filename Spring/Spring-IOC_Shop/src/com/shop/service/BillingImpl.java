package com.shop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.dao.PriceMatrix;

@Service
public class BillingImpl {

	@Autowired
	private PriceMatrix price;

	public double getCartTotal(String[] cart) {

		double tot = 0.0;
		for (String prodId : cart) {
			tot = tot + price.getItemPrice(prodId);
		}
		return tot;
	}
	
	
	public String testMethod(String p1){
		if(p1.equals("abcxyz")){
				throw new RuntimeException();
		}
		return "test Method Executed... ";
	}
	
	
	
	
}
