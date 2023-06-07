package com.mvp.dto;

import lombok.Data;
/**
 * dto class for response output.
 * @author techversant
 * @version 1.0
 * @since 2023
 */
@Data
public class ResponseOutput {
	private int errorCode;
	private String errorMessage;
}
