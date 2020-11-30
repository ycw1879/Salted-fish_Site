package com.gomso.vo;

import lombok.Data;

@Data
public class GsProductVO {
    private String ProductTitle;
    private String ProductContent;
    private int Price;
    private String CategoryCode;
    private int DeliveryPrice;
    private String ManufactureDate;
    private String ManufactureAddr;
    private int isNew;
    private int isBest;
    
    private String CreateTime;
    private String UpdateTime;
    private String DeleteYn;

    
    // join gs_image_file table
    private String titleFileName;

}
