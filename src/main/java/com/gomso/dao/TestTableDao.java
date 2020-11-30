package com.gomso.dao;
import com.gomso.vo.TestTableVO;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Slf4j
public class TestTableDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	public void insertTestTable(TestTableVO param) {
		sqlSession.insert("insertTestTable", param);
	}
	
	public int selectTestTableSize() {
		return sqlSession.selectOne("selectTestTableSize");
	}
	
	public List<TestTableVO> selectTestTableList() {
		return sqlSession.selectList("selectTestTableList");
	}
	
	public TestTableVO selectTestTableOne(int seq) {
		return sqlSession.selectOne("selectTestTableOne", seq);
	}
}
