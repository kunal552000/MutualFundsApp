package com.ofss.MutualFundsApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ofss.MutualFundsApp.payload.MutualFundDTO;
import com.ofss.MutualFundsApp.service.MutualFundService;

@RestController
@RequestMapping("")
public class MutualFundController {
	
	@Autowired
	MutualFundService mfservice;
	
	@PostMapping("/addAFund")
	public ResponseEntity<String> addedMF(@RequestBody MutualFundDTO mfDTO)
	{
		if(mfservice.checkvalidMF(mfDTO) == true)
			return new ResponseEntity<>("Mutual Fund added sucessfully",HttpStatus.OK);
		else
		return new ResponseEntity<>("Cannot add this mutual fund",HttpStatus.NOT_FOUND);
	}
	
	
	
}
