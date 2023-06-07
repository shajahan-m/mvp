package com.mvp.dto;

import lombok.Data;
/**
 * dto class for error output.
 * @author techversant
 * @version 1.0
 * @since 2023
 */
@Data
public class ErrorOutput {
	private int errorCode;
	private String errorMessage;
}
