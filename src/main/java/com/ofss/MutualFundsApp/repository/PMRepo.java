package com.ofss.MutualFundsApp.repository;


import org.springframework.data.annotation.QueryAnnotation;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.ofss.MutualFundsApp.model.PM;


public interface PMRepo extends CrudRepository<PM, Integer> {
	
	@Query(value = "SELECT * FROM portfolio_manager WHERE email =:email AND password =:password", nativeQuery = true)
	PM findByUserNamePass(@Param("email")String email, @Param("password")String password);
}
