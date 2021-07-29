package com.SpringBootRestfulApiWithOracleDatabase.app.controller;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalesDataRepository extends JpaRepository<SalesData , String> {
	 
}