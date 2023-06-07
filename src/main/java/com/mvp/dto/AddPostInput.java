package com.mvp.dto;

import lombok.Data;
/**
 * dto class for add post input.
 * @author techversant
 * @version 1.0
 * @since 2023
 */
@Data
public class AddPostInput {
	private String title;
	private String content;
	private int categoryId;
	private long authorId;
	private String tags;
	private String slug;
	
}
