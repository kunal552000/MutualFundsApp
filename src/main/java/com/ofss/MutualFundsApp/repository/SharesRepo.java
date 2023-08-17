package com.ofss.MutualFundsApp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ofss.MutualFundsApp.model.Shares;

public interface SharesRepo extends CrudRepository<Shares, Integer>{
	
	List<Shares> findAll();
	
	 @Query("SELECT s FROM Shares s WHERE s.shareId IN :collect")
	List<Shares> findAllById(List<Integer> collect);
	//List<Shares> findAllById(List<Integer> l);
	
	//@Query(value : "Selec");

}
