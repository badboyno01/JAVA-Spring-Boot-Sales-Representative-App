package com.SpringBootRestfulApiWithOracleDatabase.app.controller;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {

}
