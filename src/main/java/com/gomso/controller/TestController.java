package com.gomso.controller;
import com.gomso.common.spring.JsonModelAndView;
import com.gomso.service.TestTableService;
import com.gomso.vo.TestTableVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Random;

@RestController
@Slf4j
@RequestMapping(value="/test")
public class TestController {
	
	@Autowired
	private TestTableService testTableService;
	
	@GetMapping(value="/insertOne")
	public ModelAndView insertTestTableOne(HttpServletRequest request, HttpServletResponse response){
		JsonModelAndView jmv = new JsonModelAndView();
		
		System.out.println("URI check");
		System.out.println(request.getRequestURI());
		log.debug(request.getRequestURI());
		
		TestTableVO insertTestTableVO = testTableService.insertTestTable();
		
		jmv.put("insertVO", insertTestTableVO);
		return jmv;
	}
	
	@GetMapping(value="/getList")
	public ModelAndView getTestTableList(HttpServletRequest request, HttpServletResponse response){
		JsonModelAndView jmv = new JsonModelAndView();
		
		System.out.println("URI check");
		System.out.println(request.getRequestURI());
		log.debug(request.getRequestURI());
		
		jmv.put("tableList", testTableService.selectTestTableList());
		return jmv;
	}
	
	@GetMapping(value="/getOne")
	public ModelAndView getTestTableOne(HttpServletRequest request, HttpServletResponse response){
		JsonModelAndView jmv = new JsonModelAndView();
		
		System.out.println("URI check");
		System.out.println(request.getRequestURI());
		log.debug(request.getRequestURI());
		
		int size = testTableService.selectTestTableSize();
		jmv.put("row", testTableService.selectTestTableOne(new Random().nextInt(size) + 1));
		return jmv;
	}
}
