package com.ofss.MutualFundsApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ofss.MutualFundsApp.model.PM;
import com.ofss.MutualFundsApp.repository.PMRepo;

@Service
public class PMService {
	
	@Autowired
	PMRepo pmRepo;
	
	public boolean checkLogin(String email, String password)
	{
		try {
			System.out.println(email + " " + password);
			PM pm1 = pmRepo.findByUserNamePass(email, password);
			return true;
		}
		catch(Exception e){
			System.out.println(e.getMessage());
			return false;
		}
			
	}
	

}
