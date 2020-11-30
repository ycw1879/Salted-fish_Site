package com.gomso.vo;
import lombok.Data;

@Data
public class GsImageFileVO {

	private int seq;
	
	private String originFileName;
	private String alterFileName;
	private String fileExtension;
	private String createTime;
}
