package com.ofss.MutualFundsApp.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.ofss.MutualFundsApp.model.Investor;
import com.ofss.MutualFundsApp.model.PM;

public interface InvestorRepo extends CrudRepository<Investor, Integer> {
	
	@Query(value = "SELECT * FROM investor WHERE email =:email AND password =:password", nativeQuery = true)
	Investor findByUserNamePass(@Param("email")String email, @Param("password")String password);

}
