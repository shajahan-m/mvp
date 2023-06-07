package com.mvp.common.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

/**
 * entity class for post comment.
 * @author techversant
 * @version 1.0
 * @since 2023
 */
@Data
@Entity
@Table(name="t_post_comment")
public class PostComment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private long id;
	
	@Column(name="comment")
	private String comment;
	
	@ManyToOne
	@JoinColumn(name = "post_id",referencedColumnName = "id")
	private Post post;
	
	@ManyToOne
	@JoinColumn(name="user_id",referencedColumnName = "id")
	private User user;
	
	@Column(name = "created_date_time")
	private String createdDateTime;

	@Column(name = "last_updated_date_time")
	private String lastUpdatedDateTime;

	@Column(name = "status")
	private int status;
}
