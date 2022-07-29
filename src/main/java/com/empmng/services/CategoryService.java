package com.empmng.services;

import java.util.List;

import com.empmng.entities.Category;

public interface CategoryService {

	List<Category> getAllCategories();

	Category createCategory(Category category);

	void deleteCategory(Integer catId);
}
