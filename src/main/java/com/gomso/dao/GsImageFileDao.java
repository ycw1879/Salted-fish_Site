package com.gomso.dao;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@Slf4j
public class GsImageFileDao {
	
	@Autowired
	private SqlSession sqlSession;
}
