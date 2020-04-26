package com.vconnect.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.vconnect.entity.Category;
import com.vconnect.service.CategoryService;

@CrossOrigin
@RestController
public class CategoryController {

	@Autowired
	CategoryService categoryService;

	@GetMapping(value = "/category") // fetch all the categories
	public List<Category> getCategory() {
		return categoryService.getAllCatagories();
	}

	@GetMapping(value = "/category/{id}") // fetch category by ID
	public Optional<Category> getCategoryById(@PathVariable("id") int id) {
		return categoryService.getCategoryById(id);
	}

	@GetMapping(value = "/category/{name}") // fetch category by name
	public List<Category> getCategoryByName(@RequestBody Category categoryName) {
		return categoryService.getCategoryByName(categoryName.getName());
	}

	@PostMapping(value = "/category/") // Add items in category
	public String addCategory(@RequestBody Category category) {
		return categoryService.addCategory(category);
	}

	@PutMapping(value = "/category/{id}") // Update items in category by ID
	public String updateCategory(@PathVariable("id") int id, @RequestBody Category categoryUpdate) {
		categoryUpdate.setId(id);
		return categoryService.updateCategory(categoryUpdate);
	}

	@DeleteMapping(value = "/category/{id}") // Soft Delete items in category by ID
	public String deleteCategory(@PathVariable("id") int id) {
		return categoryService.deleteCategory(id);
	}

}