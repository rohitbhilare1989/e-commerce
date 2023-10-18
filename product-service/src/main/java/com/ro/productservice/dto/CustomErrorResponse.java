package com.ro.productservice.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CustomErrorResponse {
	private Date timestamp;
	private Integer status;
	private String path;
	private String message;
	
}
