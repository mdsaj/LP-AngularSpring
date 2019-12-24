package com.example.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.example.Entity.User;

public interface UserRepository extends MongoRepository<User, Long>{}
