package com.mvp.dto;

import java.time.LocalDateTime;
import java.util.List;
import com.mvp.common.entity.User;

import lombok.Data;

/**
 * dto class for post info.
 * 
 * @author techversant
 * @version 1.0
 * @since 2023
 */
@Data
public class PostInfo {

	private long postId;
	private String title;
	private String content;
	public int categoryId;
	private String categoryName;
	private long authorId;
	private String authorFirstName;
	private String authorLastName;
	private LocalDateTime publishedDate;
	private String tags;
	private String slug;
	private long likesCount;
	private String createdDateTime;
	private String lastUpdatedDateTime;
	private int status;
	private List<PostCommentInfo> postCommentList;
}
