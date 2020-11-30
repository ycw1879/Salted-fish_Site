package com.gomso.dao;


import com.gomso.vo.GsProductVO;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Slf4j

public class GsProductDao {

    @Autowired
    private SqlSession sqlSession;

    public List<GsProductVO> selectGsProductBest(){
        return sqlSession.selectList("selectGsProductBest");
    }
    
    public List<GsProductVO> selectGsProductNew(){
        return sqlSession.selectList("selectGsProductNew");
    }
    
    public List<GsProductVO> selectGsProductListFromCategory(int categorySeq){
        return sqlSession.selectList("selectGsProductListFromCategory", categorySeq);
    }
}
