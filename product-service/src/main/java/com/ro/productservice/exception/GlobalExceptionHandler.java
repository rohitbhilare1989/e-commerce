package com.ro.productservice.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.ro.productservice.dto.CustomErrorResponse;

@ControllerAdvice
public class GlobalExceptionHandler  {

	@ExceptionHandler(value = ResourceNotFound.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public @ResponseBody CustomErrorResponse handleException(ResourceNotFound ex) {
		return new CustomErrorResponse(new Date(),HttpStatus.NOT_FOUND.value(),"",ex.getMessage());
	}
		
}
