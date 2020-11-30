package com.gomso.vo;

import lombok.Data;

@Data
public class GsProductVO {


    private int seq;

    private int ProductImgFileSeq;
    private String ProductTitle;
    private String ProductContent;
    private int Price;
    private String CategoryCode;
    private int DeliveryPrice;
    private String ManufactureDate;
    private String ManufactureAddr;
    private String CreateTime;
    private String UpdateTime;
    private String DeleteYn;

}
