package com.gomso.service;
import com.gomso.dao.GsQuestionCommentDao;
import com.gomso.dao.GsQuestionDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class GsQuestionService {
	
	@Autowired
	private GsQuestionDao gsQuestionDao;
	
	@Autowired
	private GsQuestionCommentDao gsQuestionCommentDao;
}
