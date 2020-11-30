package com.gomso.vo;


import lombok.Data;

@Data
public class GsUser {

    private int seq;

    private String UserId;
    private String UserPw;
    private String UserName;
    private String Phone;
    private String Address;
    private String AddressDetail;
    private String CreateTime;
    private String UpdateTime;
    private String DeleteYn;

}
