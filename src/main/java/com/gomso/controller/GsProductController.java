package com.gomso.controller;
import com.gomso.service.GsProductService;
import com.gomso.vo.GsProductCategoryVO;
import com.gomso.vo.GsProductVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

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
		
		List<List<GsProductVO>> productCategoryList = gsProductService.selectGsProductAllList();
		
		mv.addObject("productCategoryList", productCategoryList);
		return mv;
	}
	
	@GetMapping(value="/view/{seq}")
	public ModelAndView view(HttpServletRequest request, HttpServletResponse response,
	                         @PathVariable int seq){
		ModelAndView mv = new ModelAndView("more_page");
		
		
		
		return mv;
	}
}
