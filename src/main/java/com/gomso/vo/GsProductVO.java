package com.gomso.vo;

import lombok.Data;

@Data
public class GsProductVO {
    private int seq;
    private int productImgFileSeq;
    private int categorySeq;
    
    private String productTitle;
    private String productContent;
    private int price;
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

    // join gs_product_category table
    private String categoryTitle;
}
