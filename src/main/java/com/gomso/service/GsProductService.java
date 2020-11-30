package com.gomso.service;
import com.gomso.dao.GsImageFileDao;
import com.gomso.dao.GsProductCategoryDao;
import com.gomso.dao.GsProductDao;
import com.gomso.dao.GsProductImgListDao;
import com.gomso.vo.GsProductCategoryVO;
import com.gomso.vo.GsProductVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class GsProductService {

    @Autowired
    private GsProductCategoryDao gsProductCategoryDao;

    @Autowired
    private GsProductImgListDao gsProductImgListDao;

    @Autowired
    private GsProductDao gsProductDao;
    
    // gs_product table
    public List<GsProductVO> selectGsProductBest(){
        return gsProductDao.selectGsProductBest();
    }
    
    public List<GsProductVO> selectGsProductNew(){
        return gsProductDao.selectGsProductNew();
    }
    
    public List<GsProductVO> selectGsProductListFromCategory(int categorySeq){
        return gsProductDao.selectGsProductListFromCategory(categorySeq);
    }
    
    public List<List<GsProductVO>> selectGsProductAllList(){
        List<List<GsProductVO>> resultList = new ArrayList<>();
        List<GsProductCategoryVO> categoryList = selectGsProductCategory();
        for(GsProductCategoryVO iter : categoryList){
            List<GsProductVO> productList = selectGsProductListFromCategory( iter.getSeq() );
            if(productList != null && !productList.isEmpty())
                resultList.add( productList );
        }
        return resultList;
    }
    
    public GsProductVO selectGsProductOne(int seq){
        return null;
    }
    
    
    // gs_product_category
    public List<GsProductCategoryVO> selectGsProductCategory(){
        return gsProductCategoryDao.selectGsProductCategory();
    }
}
