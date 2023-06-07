package com.mvp.common.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

/**
 * entity class for post.
 * @author techversant
 * @version 1.0
 * @since 2023
 */
@Data
@Entity
@Table(name="m_post")
public class Post {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private long id;
	
	@Column(name="title")
	private String title;
	
	@Column(name="content")
	private String content;
	
	@ManyToOne
	@JoinColumn(name="category_id",referencedColumnName = "id")
	private Category category;
	
	@ManyToOne
	@JoinColumn(name="author_id",referencedColumnName = "id")
	private User author;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="published_date")
	private LocalDateTime publishedDate;
	
	@Column(name="tags")
	private String tags;
	
	@Column(name="slug",unique = true)
	private String slug;
	
	@Column(name="likes_count")
	private long likesCount;
	
	@Column(name = "created_date_time")
	private String createdDateTime;

	@Column(name = "last_updated_date_time")
	private String lastUpdatedDateTime;

	@Column(name = "status")
	private int status;
}
