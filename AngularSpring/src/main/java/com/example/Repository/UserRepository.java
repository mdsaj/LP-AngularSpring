package com.example.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.Entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long>{}
