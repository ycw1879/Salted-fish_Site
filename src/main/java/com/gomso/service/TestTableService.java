package com.gomso.service;
import com.gomso.dao.TestTableDao;
import com.gomso.vo.TestTableVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
@Slf4j
public class TestTableService {
	
	private final static String STRING_BUNDLE = "QWERTYUIOPASDFGHJKLZXCVBNM1234567890qwertyuiopasdfghjklzxcvbnm";
	
	@Autowired
	private TestTableDao testTableDao;
	
	public TestTableVO insertTestTable() {
		TestTableVO vo = new TestTableVO();
		vo.setRandomNum(new Random().nextInt());
		vo.setTestString(makeRandomString());
		
		testTableDao.insertTestTable(vo);
		return vo;
	}
	
	private String makeRandomString(){
		int size = new Random().nextInt(10) + 1;
		StringBuffer sb = new StringBuffer();
		for(int i=0; i<size; ++i){
			sb.append( STRING_BUNDLE.charAt( new Random().nextInt(STRING_BUNDLE.length()) ) );
		}
		return sb.toString();
	}
	
	public int selectTestTableSize() {
		return testTableDao.selectTestTableSize();
	}
	
	public List<TestTableVO> selectTestTableList() {
		return testTableDao.selectTestTableList();
	}
	
	public TestTableVO selectTestTableOne(int seq) {
		return testTableDao.selectTestTableOne(seq);
	}
}
