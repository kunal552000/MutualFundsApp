package com.ofss.MutualFundsApp.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ofss.MutualFundsApp.model.MutualFund;
import com.ofss.MutualFundsApp.model.Shares;
import com.ofss.MutualFundsApp.payload.MutualFundDTO;
import com.ofss.MutualFundsApp.payload.SharesRequest;
import com.ofss.MutualFundsApp.repository.MutualFundRepo;
import com.ofss.MutualFundsApp.repository.SharesRepo;

@Service
public class MutualFundService {
	
	@Autowired
	MutualFundRepo mfRepo;
	
	@Autowired
	SharesRepo sharesRepo;
	
	@Autowired
	MutualFundDTO mutualFundDTO;
	
	public boolean checkvalidMF(MutualFundDTO mfDTO)
	{
		System.out.println("Inside mfDTO" + mfDTO.getIncludedShares().toString());
		for(SharesRequest s : mfDTO.getIncludedShares())
		{
			System.out.println("ShareId is " + s.getShareId());
		}
		List<Shares> existingShares = sharesRepo.findAllById(
		        mfDTO.getIncludedShares().stream()
	            .map(SharesRequest::getShareId)
	            .collect(Collectors.toList())
	    );
		
		for(Shares s : existingShares)
			System.out.println("Inside existing shares " + s.getShareId());
		
		MutualFund mutualFund = new MutualFund();
		mutualFund.setMfName(mfDTO.getMfName());
		
		calculateAndSetValues(mfDTO.getIncludedShares(), existingShares);
		
		try {
			mfRepo.save(mutualFund);
			return mutualFund != null;
		}catch (Exception e) {
			// TODO: handle exception
			e.getMessage();
			return false;
		}
	}
	
	private void calculateAndSetValues(List<SharesRequest> includedShares, List<Shares> existingShares) {
	    float totalValue = 0;
	    int totalUnits = 0;

	    for (SharesRequest shareRequest : includedShares) {
	        Shares share = existingShares.stream()
	            .filter(s -> s.getShareId() == shareRequest.getShareId())
	            .findFirst()
	            .orElse(null);

	        if (share != null) {
	            totalValue += share.getClosingPrice() * shareRequest.getUnits();
	            totalUnits += shareRequest.getUnits();
	        }
	    }

	    if (totalUnits == 0) {
	        return; 
	    }

	    float nav = totalValue / totalUnits;
	    
	}
	







}
