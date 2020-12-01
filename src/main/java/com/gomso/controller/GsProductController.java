package com.gomso.controller;
import com.gomso.service.GsProductService;
import com.gomso.vo.GsProductCategoryVO;
import com.gomso.vo.GsProductImgListVO;
import com.gomso.vo.GsProductVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
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
	                         @PathVariable int seq) throws Exception{
		ModelAndView mv = new ModelAndView("more_page");
		
		GsProductVO product = gsProductService.selectGsProductOne(seq);
		if(product == null){
			response.sendRedirect("list");
			return null;
		}
		
		List<GsProductImgListVO> productImgList = gsProductService.selectGsProductImgList(seq);
		
		mv.addObject("product", product);
		mv.addObject("productImgList", productImgList);
		return mv;
	}
	
	@GetMapping(value="/search")
	public ModelAndView search(HttpServletRequest request, HttpServletResponse response,
	                           @RequestParam String text){
		ModelAndView mv = new ModelAndView("list");
		
		if(text == null)
			text = "";
		List<List<GsProductVO>> productSearchList = gsProductService.selectGsProductSearchList(text);
		
		mv.addObject("productCategoryList", productSearchList);
		return mv;
	}
}
