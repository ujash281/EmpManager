package com.empmng.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.empmng.entities.Category;
import com.empmng.services.CategoryService;

@RestController
@CrossOrigin
public class CatController {
	
	@Autowired
	private CategoryService categoryService;

	@GetMapping("/getAllCategories")
	public List<Category> findAllCategories() {
		return this.categoryService.getAllCategories();
	}
	
	@PostMapping("/createCategory")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ResponseEntity<Category> createCategory(@RequestBody Category category) {
		Category cat = this.categoryService.createCategory(category);
		return new ResponseEntity<Category>(cat,HttpStatus.CREATED);
		
	}
	
	@DeleteMapping("/deleteCategory/{catId}")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ResponseEntity<String> deleteCategory(@PathVariable Integer catId) {
		this.categoryService.deleteCategory(catId);
		return new ResponseEntity<String>("Deleted successfully!!" , HttpStatus.OK);
	}
}
