package com.ofss.MutualFundsApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
	
}
