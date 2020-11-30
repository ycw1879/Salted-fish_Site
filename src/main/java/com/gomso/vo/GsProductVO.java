package com.gomso.vo;

import lombok.Data;

@Data
public class GsProductVO {


    private int seq;

    private String ProductImgFileSeq;
    private String ProductTitle;
    private String ProductContent;
    private String Price;
    private String CategoryCode;
    private String DeliveryPrice;
    private String ManufactureDate;
    private String ManufactureAddr;
    private String CreateTime;
    private String UpdateTime;
    private String DeleteYn;
}
