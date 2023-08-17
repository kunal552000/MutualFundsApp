package com.ofss.MutualFundsApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ofss.MutualFundsApp.model.Investor;
import com.ofss.MutualFundsApp.model.PM;
import com.ofss.MutualFundsApp.repository.InvestorRepo;

@Service
public class InvestorService {
	
	@Autowired
	InvestorRepo investorRepo;
	
	public boolean checkLogin(String email, String password)
	{
		try {
			System.out.println(email + " " + password);
			Investor investor1 = investorRepo.findByUserNamePass(email, password);
			return investor1 != null;
		}
		catch(Exception e){
			System.out.println(e.getMessage());
			return false;
		}
			
	}
	
	

}
