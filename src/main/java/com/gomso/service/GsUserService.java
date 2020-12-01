package com.gomso.service;
import com.gomso.dao.GsUserDao;
import com.gomso.vo.GsUserVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class GsUserService {
	
	@Autowired
	private GsUserDao gsUserDao;
	
	public GsUserVO selectGsUserFromId(String id){
		return gsUserDao.selectGsUserFromId(id);
	}
	
	public GsUserVO selectGsUserFromIdPw(String id, String pw){
		GsUserVO param = new GsUserVO();
		param.setUserId(id);
		param.setUserPw(pw);
		return gsUserDao.selectGsUserFromIdPw(param);
	}
}
