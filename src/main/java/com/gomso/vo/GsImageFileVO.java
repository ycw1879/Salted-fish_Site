package com.gomso.vo;
import lombok.Data;

@Data
public class GsImageFileVO {

	private int seq;
	
	private String origin_file_name;
	private String alter_file_name;
	private String file_extension;
	private String create_time;

}
