package com.projects.springbootdockerizedapplication.global.exception.handler;

import java.util.Date;
import org.slf4j.MDC;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import com.projects.springbootdockerizedapplication.exception.StudentException;


@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> handlerException(Exception e){
		HttpHeaders headers =new HttpHeaders();
		String traceId = MDC.get("X-B3-TraceId");
		headers.set("traceId", traceId);
		return new ResponseEntity<>(new StudentException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(),new Date()),headers, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
