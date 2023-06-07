package com.mvp.common.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mvp.common.entity.UserRole;
/**
 * repository interface for user role.
 * @author techversant
 * @version 1.0
 * @since 2023
 */
@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, Integer> {

}
