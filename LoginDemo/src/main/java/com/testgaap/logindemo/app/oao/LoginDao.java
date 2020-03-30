package com.testgaap.logindemo.app.oao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.testgaap.logindemo.app.entity.LoginEntity;

@Repository
public interface LoginDao extends JpaRepository<LoginEntity, Integer>{
	
	
	LoginEntity findByusername(String username);

}
