package com.mvp.common.entity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

/**
 * entity class for user role.
 * @author techversant
 * @version 1.0
 * @since 2023
 */
@Data
@Entity
@Table(name="m_user_role")
public class UserRole {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="role")
	private String role;
}
