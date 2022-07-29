package com.empmng.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empmng.entities.Category;
import com.empmng.exception.ResourseNotFoundException;
import com.empmng.repo.CategoryRepo;

@Service
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	private CategoryRepo categoryRepo;

	@Override
	public List<Category> getAllCategories() {
		return this.categoryRepo.findAll();
		
	}

	@Override
	public Category createCategory(Category category) {
		return this.categoryRepo.save(category);
	}

	@Override
	public void deleteCategory(Integer catId) {
		Category cat = this.categoryRepo.findById(catId)
				.orElseThrow(() -> new ResourseNotFoundException("Category", "Cat Id", catId));
		this.categoryRepo.delete(cat);

	}

}
