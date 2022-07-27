package com.empmng.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empmng.entities.Category;
import com.empmng.repo.CategoryRepo;

@Service
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	private CategoryRepo categoryRepo;

	@Override
	public List<Category> getAllCategories() {
		return this.categoryRepo.findAll();
		
	}

}
