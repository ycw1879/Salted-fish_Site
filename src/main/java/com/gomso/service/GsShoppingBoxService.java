package com.gomso.service;
import com.gomso.dao.GsShoppingBoxDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class GsShoppingBoxService {
	
	@Autowired
	private GsShoppingBoxDao gsShoppingBoxDao;
}
