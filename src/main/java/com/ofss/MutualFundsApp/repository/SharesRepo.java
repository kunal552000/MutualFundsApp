package com.ofss.MutualFundsApp.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.ofss.MutualFundsApp.model.Shares;

public interface SharesRepo extends CrudRepository<Shares, Integer>{
	
	List<Shares> findAll();

}
