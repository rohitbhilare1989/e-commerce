package com.ro.productservice.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ResourceNotFound extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	private String message;
}