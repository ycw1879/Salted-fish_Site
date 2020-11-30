package com.gomso.vo;

import lombok.Data;

@Data

public class GsReview {

    private int seq;
    private int UserSeq;

    private int ProductSeq;
    private int ReviewPoint;
    private String ReviewTitle;
    private String ReviewContent;
    private String AdminCheck;
    private String CreateTime;
    private String UpdateTime;
    private String DeleteYn;

}
