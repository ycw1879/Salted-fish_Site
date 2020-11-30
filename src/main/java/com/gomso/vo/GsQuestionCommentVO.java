package com.gomso.vo;


import lombok.Data;

@Data
public class GsQuestionCommentVO {


    private int seq;
    private int UserSeq;
    private int QuestionSeq;

    private String CommentContent;
    private String CreateTime;
    private String UpdateTime;
    private String DeleteYn;
}
