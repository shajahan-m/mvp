package com.mvp.dto;


import lombok.Data;
/**
 * dto class for post comment info.
 * @author techversant
 * @version 1.0
 * @since 2023
 */
@Data
public class PostCommentInfo {
	private long commentId;
	private String comment;
	private long userId;
	private String userFirstName;
	private String userLastName;
	private String createdDateTime;
	private String lastUpdatedDateTime;
	private int status;
}
