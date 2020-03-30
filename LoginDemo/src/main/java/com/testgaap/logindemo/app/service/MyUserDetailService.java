package com.testgaap.logindemo.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.testgaap.logindemo.app.entity.LoginEntity;
import com.testgaap.logindemo.app.entity.MyUserDetails;
import com.testgaap.logindemo.app.oao.LoginDao;

@Service
public class MyUserDetailService implements UserDetailsService {
	
	@Autowired
	private LoginDao loginDao;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		LoginEntity loginEntity = loginDao.findByusername(username);
		UserDetails userDetails = null;
		if (loginEntity != null)
		{
			userDetails= new MyUserDetails(loginEntity);
		}
		
		else 
		{
			throw new UsernameNotFoundException("user not exist with : "+username);
		}
		return userDetails;
	}

}
