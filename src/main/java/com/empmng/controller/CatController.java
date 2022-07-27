package com.empmng.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.empmng.entities.Category;
import com.empmng.services.CategoryService;

@RestController
public class CatController {
	
	@Autowired
	private CategoryService categoryService;

	@GetMapping("/getAllCategories")
	public List<Category> findAllCategories() {
		return this.categoryService.getAllCategories();
	}
}
