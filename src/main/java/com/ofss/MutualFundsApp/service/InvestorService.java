package com.ofss.MutualFundsApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ofss.MutualFundsApp.model.Investor;
import com.ofss.MutualFundsApp.model.MutualFund;
import com.ofss.MutualFundsApp.model.PM;
import com.ofss.MutualFundsApp.repository.InvestorRepo;
import com.ofss.MutualFundsApp.repository.MutualFundRepo;

@Service
public class InvestorService {
	
	@Autowired
	InvestorRepo investorRepo;
	
	@Autowired
	MutualFundRepo mfRepo;
	
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
	
	public Investor buyMutualFund(int investorId, int fundId) {
        Investor investor = investorRepo.findOne(investorId);
        MutualFund fund = mfRepo.findOne(fundId);

        if (investor != null) {
            investor.getInvestments().add(fundId);
            return investorRepo.save(investor);
        }

        return null;
	}
	
	

}
