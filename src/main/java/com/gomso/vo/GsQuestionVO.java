package com.gomso.vo;

import lombok.Data;

@Data
public class GsQuestionVO {
    private int seq;
    private int userSeq;
    
    private String questionTitle;
    private String questionContent;
    
    private String createTime;
    private String updateTime;
    private String deleteYn;
    
    
    // gs_user table
    private String userName;
    
    // gs_question_comment table
    private int commentCnt;
}
