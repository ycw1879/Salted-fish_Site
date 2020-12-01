package com.gomso.vo;

import lombok.Data;

@Data
public class GsProductImgListVO {
    private int seq;
    private int productSeq;
    private int fileSeq;

    private String createTime;
    private String updateTime;
    private String deleteYn;
    
    // gs_image_file table
    private String fileName;
}
