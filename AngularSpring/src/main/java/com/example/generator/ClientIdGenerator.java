package com.example.generator;

import java.io.Serializable;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;

import com.example.Entity.User;
import com.example.Repository.UserRepository;

public class ClientIdGenerator implements IdentifierGenerator{

	@Autowired 
    private UserRepository userRepository;
	
	@Override
	public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
		Sort sort = new Sort(Sort.Direction.DESC, "id");
		List<User> user = userRepository.findAll(sort);
        return "";
	}
}
