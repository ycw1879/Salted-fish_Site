package com.gomso.dao;


import com.gomso.vo.GsProductImgListVO;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Slf4j

public class GsProductImgListDao {

    @Autowired
    private SqlSession sqlSession;
    
    public List<GsProductImgListVO> selectGsProductImgList(int productSeq){
        return sqlSession.selectList("selectGsProductImgList", productSeq);
    }
}
