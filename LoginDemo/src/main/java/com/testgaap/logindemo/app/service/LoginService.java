package com.testgaap.logindemo.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.testgaap.logindemo.app.entity.LoginEntity;
import com.testgaap.logindemo.app.oao.LoginDao;

@Service
public class LoginService {
	
	@Autowired
	public LoginDao loginDao;

	public LoginEntity loginAdd(LoginEntity loginEntity) {
		return loginDao.save(loginEntity);
		
	}

	public List<LoginEntity> allLogin() {
		return loginDao.findAll();
		
	}

	public Optional<LoginEntity> loginOne(int id) {
		// TODO Auto-generated method stub
		return loginDao.findById(id);
	}
	
	

}
