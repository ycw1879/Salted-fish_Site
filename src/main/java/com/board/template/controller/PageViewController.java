package com.board.template.controller;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * page view controller
 * 개발전 페이지 확인용 컨트롤러
 */
@RestController
@Slf4j
@RequestMapping(value="/page_view")
public class PageViewController {
	
	@GetMapping(value="")
	public void redirectPage(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.sendRedirect("/page_view/");
	}
	
	@GetMapping(value="/")
	public ModelAndView pageViewListPage(HttpServletRequest request, HttpServletResponse response){
		String uri = request.getRequestURI();
		System.out.println("URI-mapping");
		System.out.println(uri);
		return new ModelAndView("temp/page-list");
	}
	
	@GetMapping(value="/{pageName}")
	public ModelAndView tempPageViewPage(@PathVariable String pageName, HttpServletRequest request, HttpServletResponse response){
		return new ModelAndView(pageName);
	}
}
