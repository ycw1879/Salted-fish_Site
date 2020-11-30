package com.gomso.vo;

import lombok.Data;

@Data
public class GsReviewVO {

    private int seq;
    private int userSeq;

    private int productSeq;
    private int reviewPoint;
    private String reviewTitle;
    private String reviewContent;
    private String adminCheck;
    private String createTime;
    private String updateTime;
    private String deleteYn;
}
