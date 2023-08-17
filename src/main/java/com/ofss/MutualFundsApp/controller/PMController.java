package com.ofss.MutualFundsApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ofss.MutualFundsApp.model.PM;
import com.ofss.MutualFundsApp.model.Shares;
import com.ofss.MutualFundsApp.payload.PmDTO;
import com.ofss.MutualFundsApp.service.PMService;
import com.ofss.MutualFundsApp.service.SharesService;

@RestController
@RequestMapping("")
public class PMController {
	
	@Autowired
    PMService pmService;
	
	@Autowired
	SharesService shareService;
	
	@PostMapping("/loginAsPm")
	public ResponseEntity<String>  pmLogin(@RequestBody PmDTO p)
	{
		if(pmService.checkLogin(p.getEmail(), p.getPassword()) == true)
			return new ResponseEntity<>("Sucessfully logged in",HttpStatus.OK);
		else
		return new ResponseEntity<>("LoginFailed",HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("/addMF")
	public ResponseEntity<List<Shares>> addMF()
	{
		 List<Shares> allShares = shareService.showShares();
	     return new ResponseEntity<>(allShares, HttpStatus.OK);
	}
	
	
}
