package com.gomso.controller;
import com.gomso.service.GsProductService;
import com.gomso.vo.GsProductVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@Slf4j
@RequestMapping(value="/")
/**
 * Index Page Controller
 */
public class HomeController {
	
	@Autowired
	private GsProductService gsProductService;
	
	@GetMapping(value={"/", ""})
	public ModelAndView index(HttpServletRequest request, HttpServletResponse response){
		ModelAndView mv = new ModelAndView("index");
		
		List<GsProductVO> bestProductList = gsProductService.selectGsProductBest();
		List<GsProductVO> newProductList = gsProductService.selectGsProductNew();
		
		mv.addObject("bestProductList", bestProductList);
		mv.addObject("newProductList", newProductList);
		
		return mv;
	}
	
	@GetMapping(value={"/map"})
	public ModelAndView map(HttpServletRequest request, HttpServletResponse response){
		ModelAndView mv = new ModelAndView("map");
		
		return mv;
	}
}