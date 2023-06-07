package com.mvp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mvp.common.entity.Category;
import com.mvp.common.repository.CategoryRepository;

/**
 * service class for category.
 * @author techversant
 * @version 1.0
 * @since 2023
 */
@Service
public class CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;
	
	/**
	 * this method for getting category info by id.
	 * @param category id.
	 * @return category object.
	 */
	public Category getCategory(int categoryId) {
		return categoryRepository.findById(categoryId).orElse(null);
	}
}
