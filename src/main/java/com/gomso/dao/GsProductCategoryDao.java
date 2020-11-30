package com.gomso.dao;


import com.gomso.vo.GsProductCategoryVO;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Slf4j

public class GsProductCategoryDao {

    @Autowired
    private SqlSession sqlSession;

    public List<GsProductCategoryVO> selectGsProductCategory(){
        return sqlSession.selectList("selectGsProductCategory");
    }
}
