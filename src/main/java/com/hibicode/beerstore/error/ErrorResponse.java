package com.hibicode.beerstore.error;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import static lombok.AccessLevel.PRIVATE;
import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY;

import java.util.Collections;
import java.util.List;

import org.springframework.http.HttpStatus;

@JsonAutoDetect(fieldVisibility = ANY)
@RequiredArgsConstructor(access = PRIVATE)
@Data
public class ErrorResponse {

	private final int statusCode;
	private final List<ApiError> errors;
	
	static ErrorResponse of(HttpStatus status, List<ApiError> errors) {
		return new ErrorResponse(status.value(), errors);
	}
	
	static ErrorResponse of(HttpStatus status, ApiError error) {
		return of(status, Collections.singletonList(error));
	}
	
	@JsonAutoDetect(fieldVisibility = ANY)
	@RequiredArgsConstructor
	@Data
	static class ApiError {
		private final String code;
		private final String message;
	}
	
}
