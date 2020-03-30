package com.testgaap.logindemo.app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.testgaap.logindemo.app.entity.LoginEntity;
import com.testgaap.logindemo.app.service.LoginService;

@RestController("/")
public class LoginController {
	
	@Autowired
	public LoginService loginService;
	
	@RequestMapping("/")
	public ModelAndView home()
	{
		return new ModelAndView("home.jsp");
	}
	
	@GetMapping("/login")
	public ModelAndView loginShow()
	{
		return new ModelAndView("login.jsp");
	}
	
	@GetMapping("/logout-success")
	public ModelAndView logoutPage()
	{
		return new ModelAndView("logout.jsp");
	}
	
	
	
	 @GetMapping("/loginAll") 
	 public ModelAndView loginAll()
	 {
	 List<LoginEntity>lg= loginService.allLogin(); 
	 ModelAndView mv = new ModelAndView("logins.jsp");
	 mv.addObject("lg", lg); 
	 return mv;
	 }
	 
	
	/*
	 * @GetMapping("/loginAll") public List<LoginEntity> loginAll() { return
	 * loginService.allLogin();
	 * 
	 * }
	 */
	
	
	@GetMapping(value = "/loginAll/{id}")
	public ModelAndView loginOne(@PathVariable int id)
	{
		Optional<LoginEntity> obj = loginService.loginOne(id);
		LoginEntity obj1 = obj.orElse(null);
		ModelAndView mv = new ModelAndView("example.jsp");
		mv.addObject("obj1", obj1);
		return mv;
	}
	
	@PostMapping("/loginadd")
	public LoginEntity loginAdd(@RequestBody LoginEntity loginEntity)
	{
		return loginService.loginAdd(loginEntity);
	}

}
