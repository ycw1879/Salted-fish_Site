package com.gomso.vo;

import lombok.Data;

@Data
public class GsProductImgListVO {

    private int seq;
    private int ProductSeq;
    private int FileSeq;

    private String CreateTime;
    private String UpdateTime;
    private String DeleteYn;
}
