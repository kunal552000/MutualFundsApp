package com.ofss.MutualFundsApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ofss.MutualFundsApp.model.Investor;
import com.ofss.MutualFundsApp.payload.BuyingDTO;
import com.ofss.MutualFundsApp.payload.InvestorDTO;
import com.ofss.MutualFundsApp.payload.PmDTO;
import com.ofss.MutualFundsApp.service.InvestorService;

@RestController
@RequestMapping()
public class InvestorController {
	
	@Autowired
	InvestorService investorService;
	
	@PostMapping("/loginAsInvestor")
	public ResponseEntity<String>  investorLogin(@RequestBody InvestorDTO i)
	{
		if(investorService.checkLogin(i.getEmail(), i.getPassword()) == true)
			return new ResponseEntity<>("Sucessfully logged in",HttpStatus.OK);
		
		return new ResponseEntity<>("LoginFailed",HttpStatus.NOT_FOUND);
	}
	
	@PostMapping("buyAFund")
    public ResponseEntity<String> buyMutualFund(@RequestBody BuyingDTO b)
	{
        Investor investor = investorService.buyMutualFund(b.getInvestorId(), b.getMfId());
        if (investor != null) {
        	return new ResponseEntity<>("MutualFund bought sucessfully",HttpStatus.OK);
        } else {
        	return new ResponseEntity<>("Unable to buy fund",HttpStatus.NOT_FOUND);
        }
    }
	
}
