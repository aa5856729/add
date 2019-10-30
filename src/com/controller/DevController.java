package com.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.entity.Dev_user;
import com.service.Dev_user.DevService;

@Controller
@RequestMapping("dev_user")
public class DevController {
	
	@Resource
	private DevService devService;
	
	@RequestMapping(value="login.html",method=RequestMethod.POST)
	public String login(String devCode,String devPassword,HttpSession session,HttpServletRequest request) {
		System.out.println("devCode:" + devCode + ",pwd:" + devPassword);
		
		Dev_user devuser = devService.login(devCode, devPassword);
		if(devuser != null) {
			session.setAttribute("devUserSession", devuser);
			return "developer/main";
		} else {
			throw new RuntimeException("用户名或密码错误");
		}
		
	}
	
	@ExceptionHandler(value=RuntimeException.class)
	public String handlerException(RuntimeException e,HttpServletRequest req) {
		req.setAttribute("e", e);
		return "devlogin";
	}
}
