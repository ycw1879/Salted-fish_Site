package com.gomso.common.spring;

import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * 해당 클레스로 리턴시 json 데이터 반환
 */
public class JsonModelAndView extends ModelAndView {
	
	Map<String, Object> resultMap;
	
	public JsonModelAndView(){
		super("jsonView");
	}
	
	public JsonModelAndView(Map<String, ?> paramMap) {
		super("jsonView");
		super.addAllObjects(paramMap);
	}

	public JsonModelAndView(String attributeName, Object attributeValue){
		this();
		put(attributeName, attributeValue);
	}
	
	
	public JsonModelAndView put( String attributeName, Object attributeValue){		
		addObject(attributeName, attributeValue);
		return this;
	}
	

}
