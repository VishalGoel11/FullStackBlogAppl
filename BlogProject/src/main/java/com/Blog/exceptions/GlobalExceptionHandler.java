package com.Blog.exceptions;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.Blog.payloads.ApiResponse;

@ControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(ResourceNotFound.class)
	public ResponseEntity<ApiResponse> resourceNotFound(ResourceNotFound ex){
		String message=ex.getMessage();
		return new ResponseEntity<ApiResponse>(new ApiResponse(message,false),HttpStatus.NOT_FOUND);		
	}
//	@ExceptionHandler(MethodArgumentNotValidException.class)
//	public ResponseEntity<Map<String, String>> handleMethodArgsNotValException(MethodArgumentNotValidException ex){
//		Map<String,String> res=new HashMap<>();
//		ex.getBindingResult().getAllErrors().forEach((error)->{
//			String name=((FieldError)error).getField();
//			String mess=error.getDefaultMessage();
//			res.put(name, mess);
//		});
//		return new ResponseEntity<Map<String,String>>(res,HttpStatus.BAD_REQUEST);
//		
//	}
}
