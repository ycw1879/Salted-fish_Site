package com.gomso.vo;

import lombok.Data;

@Data
public class GsProductVO {
    private String productTitle;
    private String productContent;
    private int price;
    private String categoryCode;
    private int deliveryPrice;
    private String manufactureDate;
    private String manufactureAddr;
    private int isNew;
    private int isBest;
    
    private String createTime;
    private String updateTime;
    private String deleteYn;

    
    // join gs_image_file table
    private String titleFileName;

}
