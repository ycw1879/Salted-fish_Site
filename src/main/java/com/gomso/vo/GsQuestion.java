package com.gomso.vo;


import lombok.Data;

@Data

public class GsQuestion {


    private int seq;

    private int UserSeq;
    private String QuestionTitle;
    private String QuestionContent;
    private String CreateTime;
    private String UpdateTime;
    private String DeleteYn;

}
