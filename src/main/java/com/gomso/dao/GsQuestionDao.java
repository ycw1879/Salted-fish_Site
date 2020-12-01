package com.gomso.dao;
import com.gomso.vo.GsQuestionVO;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Slf4j
public class GsQuestionDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	public int selectGsQuestionSize(){
		return sqlSession.selectOne("selectGsQuestionSize");
	}
	
	public List<GsQuestionVO> selectGsQuestList(int limitStartNo){
		return sqlSession.selectList("selectGsQuestList", limitStartNo);
	}
}
