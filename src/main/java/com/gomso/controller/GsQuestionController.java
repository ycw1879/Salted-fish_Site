package com.gomso.controller;
import com.gomso.service.GsQuestionService;
import com.gomso.vo.GsQuestionVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@Slf4j
@RequestMapping(value="/question")
public class GsQuestionController {
	
	@Autowired
	private GsQuestionService gsQuestionService;
	
	@GetMapping(value={"", "/"})
	public void redirect(HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.sendRedirect("list");
	}
	
	@GetMapping(value="/list")
	public ModelAndView list(HttpServletRequest request, HttpServletResponse response,
	                         @RequestParam(required = false) Integer pageNo,
	                         @RequestParam(required = false) Integer pageSize,
	                         @RequestParam(required = false) Integer listStartNo,
	                         @RequestParam(required = false) Integer listEndNo){
		ModelAndView mv = new ModelAndView("post_q");
		
		if(pageNo == null) {
			pageNo = 1;
		}
		
		pageSize = gsQuestionService.selectGsQuestListPageSize();
		
		if(pageNo == 1)
			listStartNo = 1;
		else
			listStartNo = (pageNo-1) / 10 * 10 + 1;
		
		if(pageNo == 1){
			listEndNo = Math.min(pageSize, 10);
		}else
			listEndNo = Math.min(pageSize, ((pageNo-1) / 10 + 1) * 10);
		
		
		
		List<GsQuestionVO> questionList = gsQuestionService.selectGsQuestList(pageNo);
		
		mv.addObject("pageNo", pageNo);
		mv.addObject("pageSize", pageSize);
		mv.addObject("listStartNo", listStartNo);
		mv.addObject("listEndNo", listEndNo);
		mv.addObject("questionList", questionList);
		return mv;
	}
}
