package com.mvp.common.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

/**
 * entity class for category.
 * @author techversant
 * @version 1.0
 * @since 2023
 */
@Data
@Entity
@Table(name="m_category")
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="category_name")
	private String categoryName;
	
	@Column(name = "created_date_time")
	private String createdDateTime;

	@Column(name = "last_updated_date_time")
	private String lastUpdatedDateTime;

	@Column(name = "status")
	private int status;
}
