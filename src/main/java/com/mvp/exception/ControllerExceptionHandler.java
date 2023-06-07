package com.mvp.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.mvp.dto.ErrorOutput;

/**
 * controller advice class for controller exception handler.
 * @author techversant
 * @version 1.0
 * @since 2023
 */
@ControllerAdvice
public class ControllerExceptionHandler {

	Logger logger = LoggerFactory.getLogger(ControllerExceptionHandler.class);

	/**
	 * this method for get exception details.
	 * @param exception object.
	 * @return error output object.
	 */
	@ExceptionHandler
	public ResponseEntity<ErrorOutput> getExceptionDetails(Exception ex) {

		logger.error(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, ex);
		ErrorOutput errorOutput = new ErrorOutput();
		errorOutput.setErrorMessage(ex.getMessage());
		return new ResponseEntity<>(errorOutput, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
