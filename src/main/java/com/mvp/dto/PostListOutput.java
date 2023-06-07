package com.mvp.dto;

import java.util.List;


import lombok.Data;
/**
 * dto class for post list output.
 * @author techversant
 * @version 1.0
 * @since 2023
 */
@Data
public class PostListOutput {
	private int errorCode;
	private String errorMessage;
	private List<PostInfo> postList;
}
