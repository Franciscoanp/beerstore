package com.hibicode.beerstore.service.exception;

import org.springframework.http.HttpStatus;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Data
@EqualsAndHashCode(callSuper = false)
public class BusinessException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	private final String code;
	private final HttpStatus status;
}
