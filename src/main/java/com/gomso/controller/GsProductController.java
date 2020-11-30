package com.gomso.controller;
import com.gomso.service.GsProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@Slf4j
@RequestMapping(value="/product")
public class GsProductController {

	@Autowired
	private GsProductService gsProductService;
	
	@GetMapping(value={"/", ""})
	public void redirectList(HttpServletRequest request, HttpServletResponse response) throws Exception{
		response.sendRedirect("list");
	}
	
	@GetMapping(value="/list")
	public ModelAndView list(HttpServletRequest request, HttpServletResponse response){
		ModelAndView mv = new ModelAndView("list");
		
		
		
		return mv;
	}
}
