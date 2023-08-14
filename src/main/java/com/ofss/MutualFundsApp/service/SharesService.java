package com.ofss.MutualFundsApp.service;



import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ofss.MutualFundsApp.model.Shares;
import com.ofss.MutualFundsApp.repository.SharesRepo;

@Service
public class SharesService {
	
	@Autowired
	SharesRepo sharesRepo;
	
	
	public List<Shares> showShares()
	{
		List<Shares> allShares = sharesRepo.findAll();
		
		return allShares;
		
		
	}

}
