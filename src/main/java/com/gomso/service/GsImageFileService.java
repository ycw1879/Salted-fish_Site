package com.gomso.service;
import com.gomso.dao.GsImageFileDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class GsImageFileService {
	
	@Autowired
	private GsImageFileDao gsImageFileDao;
}
