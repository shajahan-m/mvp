package com.mvp.common.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mvp.common.entity.Category;
/**
 * repository interface for category.
 * @author techversant
 * @version 1.0
 * @since 2023
 */
@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
