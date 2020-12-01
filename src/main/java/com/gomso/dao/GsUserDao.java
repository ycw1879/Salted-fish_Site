package com.gomso.dao;

import com.gomso.vo.GsUserVO;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@Slf4j
public class GsUserDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	public GsUserVO selectGsUserFromId(String id){
		return sqlSession.selectOne("selectGsUserFromId", id);
	}
	
	public GsUserVO selectGsUserFromIdPw(GsUserVO param){
		return sqlSession.selectOne("selectGsUserFromIdPw", param);
	}
}
