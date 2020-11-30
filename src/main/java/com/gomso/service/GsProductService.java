package com.gomso.service;
import com.gomso.dao.GsImageFileDao;
import com.gomso.dao.GsProductCategoryDao;
import com.gomso.dao.GsProductDao;
import com.gomso.dao.GsProductImgListDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class GsProductService {

    @Autowired
    private GsProductCategoryDao gsProductCategoryDaoDao;

    @Autowired
    private GsProductImgListDao gsProductImgListDao;

    @Autowired
    private GsProductDao gsProductDao;


}
