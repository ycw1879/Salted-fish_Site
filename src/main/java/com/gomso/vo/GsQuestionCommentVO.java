package com.gomso.vo;


import lombok.Data;

@Data
public class GsQuestionCommentVO {


    private int seq;
    private int userSeq;
    private int questionSeq;

    private String commentContent;
    private String createTime;
    private String updateTime;
    private String deleteYn;
}
