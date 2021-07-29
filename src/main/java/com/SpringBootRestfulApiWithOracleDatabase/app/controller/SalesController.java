package com.SpringBootRestfulApiWithOracleDatabase.app.controller;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(path = "/Sales")
public class SalesController {
	
    @Autowired
    private SalesDataRepository SalesRepo;
    
    @Autowired
    private JdbcTemplate jdbcTemplate;

    private final Logger LOG = LoggerFactory.getLogger(getClass());
    
// ------------------------------------------CURD functionality Used in Angular-------------------------------------------------
    
    @GetMapping("/GetAllSales")
    public  Iterable<SalesData> getAllSalesData() {
    	LOG.info("Getting all SalesData.");
        return SalesRepo.findAll();
    }
    
	@PostMapping(path = "/SalesUsers/create")
	public SalesData createUser(@RequestBody SalesData SalesData) throws IOException {
		LOG.info("Creating SalesData");
//		SalesData.setOpportunityid(UUID.randomUUID().toString());
		return SalesRepo.save(SalesData);
	}
    
    @PutMapping("/update")
    public ResponseEntity<SalesData> updateEmployee(@RequestBody SalesData SalesData) {
    	SalesData updateSalesData = SalesRepo.save(SalesData);
        return new ResponseEntity<>(updateSalesData, HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable("id") String id) {
    	System.out.println("id = "+ id);
    	SalesRepo.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
// ------------------------------------------CURD functionality Used in Angular-------------------------------------------------    
    
	@GetMapping(path = "/SalesUsersid/{id}")
	public Optional<SalesData> getUserById(@PathVariable("id") String id) throws UserDataAccessException {
		LOG.info("Getting SalesData with ID: {}.", id);
		return SalesRepo.findById(id);
	}
	   
	@PutMapping(path = "/SalesUsersid/{id}/effectivediscount/{effectivediscount}")
	public SalesData updateUserAgeById(@PathVariable("id") String userId,@PathVariable("effectivediscount") Double effectivediscount) {
		Optional<SalesData> findById = SalesRepo.findById(userId);
		SalesData SalesDatauser = findById.get();
		SalesDatauser.setEffectivediscount(effectivediscount);
		
		LOG.info("Updating SalesData Effective-Discount By Id.");
		return SalesRepo.save(SalesDatauser);
	}
	
	@DeleteMapping(path = "/delete/SalesUsersid/{id}")
	public void deleteUserById(@PathVariable("id") String userId) {

		LOG.info("Data Deleted Successfully");
		SalesRepo.deleteById(userId);
	}
		
	@PostMapping(path = "/multiSalesUsers/create")
	public List<SalesData> createUsers(@RequestBody  Iterable<SalesData> SalesData) {
		LOG.info("Creating Multiple SalesData");
		return SalesRepo.saveAll(SalesData);
	}
	
	@GetMapping(path = "/Sqlquery")
	public Iterable<SalesData> Sqlquery() {
		LOG.info("Getting all SalesData.");
		
		String sql = "SELECT * FROM sales_data";
        
        List<SalesData> SalesData = jdbcTemplate.query(sql,
                BeanPropertyRowMapper.newInstance(SalesData.class));
         
//        SalesData.forEach(System.out :: println);
        
		return SalesData;
        
	}
	
	@PutMapping("/UpdateBySalesUsersid/{id}")
    public SalesData updateCustomer(@PathVariable String id, @RequestBody SalesData updateCustomer) {
		
		Optional<SalesData> findById = SalesRepo.findById(id);
		SalesData customer = findById.get();
		
//		System.out.println("UUID = " + UUID.randomUUID().toString());		 
//      customer.setOpportunityid(UUID.randomUUID().toString());
		
        customer.setAccountname(updateCustomer.getAccountname());
        customer.setAddress1(updateCustomer.getAddress1());
        customer.setAddress2(updateCustomer.getAddress2());
        customer.setCity(updateCustomer.getCity());
        customer.setState(updateCustomer.getState());
        customer.setZipcode(updateCustomer.getZipcode());
        customer.setTotalnetrevenue(updateCustomer.getTotalnetrevenue());
        customer.setEffectivediscount(updateCustomer.getEffectivediscount());
        
        LOG.info("Update customer " + customer);
        System.out.println("Update customer " + customer);
        
        return SalesRepo.save(customer);
    }
	

	
}