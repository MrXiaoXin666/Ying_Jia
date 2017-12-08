package com.xiaoxin.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xiaoxin.model.Users;
import com.xiaoxin.service.LoginService;

@Controller
@RequestMapping("xiaoxin")
public class HouTaiController {
	@Autowired
	LoginService loginService;
	
	@RequestMapping(value="login",method=RequestMethod.GET)
	public String toLogin() {
		return "houtai";
		
	}
	
	@RequestMapping(value="sendcode",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> sendCode(HttpServletRequest request,HttpSession session) throws Exception {
		Map<String,Object> map = new HashMap<>();
		String mobilePhone = request.getParameter("mobilePhone");
		Integer rand=loginService.duanxin(mobilePhone);
		
		session.setAttribute("rand", rand);
		System.out.println(session.getAttribute("rand"));
		return map;
	}
	
	@RequestMapping(value="login",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> login(HttpServletRequest request,HttpSession session) {
		Map<String,Object> map = new HashMap<>();
		
		String userName = request.getParameter("userName");
		String userPass = request.getParameter("userPass");
		String mobilePhone = request.getParameter("mobilePhone");
		String code = request.getParameter("code");
		Object objCode=session.getAttribute("rand");
		if (objCode==null||"".equals(objCode.toString().trim())) {
			map.put("msg", "请获取验证码");
			return map;
		}
		List<Users> uList=loginService.findUserByName(userName);
		if (uList.size()==0) {
			map.put("msg", "用户名无效");
			return map;
		}else if (!uList.get(0).getUsersPassword().equals(userPass)) {
			map.put("msg", "密码错误");
			return map;
		}else if (!uList.get(0).getMobilePhone().equals(mobilePhone)) {
			map.put("msg", "手机号码错误");
			return map;
		}else if (!code.trim().equals(objCode.toString().trim())) {
			
			map.put("msg", "验证码错误");
			return map;
		}else {
			map.put("username",userName );
			map.put("code",0);
			return map;
		}

	}
	
	@RequestMapping(value="index",method=RequestMethod.GET)
	public String toMain() {
		
		return null;
	}
	
}
