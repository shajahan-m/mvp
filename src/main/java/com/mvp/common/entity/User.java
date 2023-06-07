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
 * entity class for user.
 * @author techversant
 * @version 1.0
 * @since 2023
 */
@Data
@Entity
@Table(name="m_user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private long id;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="email")
	private String email;
	
	@Column(name="contact_no")
	private String contactNo;
	
	@Column(name="address")
	private String address;
	
	@ManyToOne
	@JoinColumn(name="user_role_id",referencedColumnName = "id")
	private UserRole userRole;
	
	@Column(name = "created_date_time")
	private String createdDateTime;

	@Column(name = "last_updated_date_time")
	private String lastUpdatedDateTime;

	@Column(name = "status")
	private int status;
}
