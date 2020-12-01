package com.gomso.controller;
import com.gomso.common.spring.JsonModelAndView;
import com.gomso.service.GsUserService;
import com.gomso.vo.GsUserVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;

@RestController
@Slf4j
@RequestMapping(value="/")
public class LoginController {
	
	@Autowired
	private GsUserService gsUserService;
	
	@GetMapping(value="/login")
	public ModelAndView loginPage(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String loginYn = (String) request.getSession().getAttribute("loginYn");
		if("Y".equals(loginYn) ){
			response.sendRedirect("/");
			return null;
		}
		
		ModelAndView mv = new ModelAndView("login");
		return mv;
	}
	
	@PostMapping(value="/login")
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response,
	                          @RequestBody GsUserVO user) throws Exception{
		JsonModelAndView jmv = new JsonModelAndView();
		
		String id = user.getUserId();
		String pw = user.getUserPw();
		
		String loginYn = (String) request.getSession().getAttribute("loginYn");
		if("Y".equals(loginYn)){
//			jmv.put("resultCode", "400");
			response.sendRedirect("/");
			return null;
		}
		
		if(id == null || id.isEmpty()){
			jmv.put("resultCode", "401");
			return jmv;
		}

		if(pw == null || pw.isEmpty()){
			jmv.put("resultCode", "402");
			return jmv;
		}

		GsUserVO loginUser = gsUserService.selectGsUserFromId(id);
		if(loginUser == null){
			jmv.put("resultCode", "403");
			return jmv;
		}

		loginUser = gsUserService.selectGsUserFromIdPw(id, pw);
		if(loginUser == null){
			jmv.put("resultCode", "404");
			return jmv;
		}

		loginUser.setUserPw("");
		request.getSession().setAttribute("loginYn", "Y");
		request.getSession().setAttribute("loginUser", loginUser);
		
		jmv.put("resultCode", "000");
		return jmv;
	}
	
	@GetMapping(value="/logout")
	public void logout(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.getSession().removeAttribute("loginYn");
		request.getSession().removeAttribute("loginUser");
		request.getSession().invalidate();
		response.sendRedirect("/login");
	}
}
