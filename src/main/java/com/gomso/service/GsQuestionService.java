package com.gomso.service;
import com.gomso.dao.GsQuestionCommentDao;
import com.gomso.dao.GsQuestionDao;
import com.gomso.vo.GsQuestionVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class GsQuestionService {
	
	@Autowired
	private GsQuestionDao gsQuestionDao;
	
	@Autowired
	private GsQuestionCommentDao gsQuestionCommentDao;
	
	public int selectGsQuestListPageSize(){
		return (gsQuestionDao.selectGsQuestionSize()-1) / 10 + 1;
	}
	
	public List<GsQuestionVO> selectGsQuestList(int pageNo){
		return gsQuestionDao.selectGsQuestList((pageNo-1) * 10 );
	}
}
