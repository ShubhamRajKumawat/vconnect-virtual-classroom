package com.vconnect.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vconnect.dao.CategoryRepository;
import com.vconnect.entity.Category;

@Service
public class CategoryService {

	@Autowired
	CategoryRepository categoryRepository;

	public List<Category> getAllCatagories() { // Get list of all categories.

		List<Category> listOfCatagories = new ArrayList<>();
		categoryRepository.findAll().forEach(listOfCatagories::add);
		return listOfCatagories;
	}

	public Optional<Category> getCategoryById(int id) { // Get category by ID.
		return categoryRepository.findById(id);
	}

	public List<Category> getCategoryByName(String name) { // Get category by name.
		return categoryRepository.findAllByName(name);
	}

	public String addCategory(Category category) { // Adding Category
		categoryRepository.save(category);
		return "true";
	}

	public String updateCategory(Category category) { // Update Category
		categoryRepository.save(category);
		return "true";

	}

	public String deleteCategory(int id) { // Soft delete category
		Optional<Category> deleteCategoryInfo = categoryRepository.findById(id);
		if (deleteCategoryInfo.isPresent()) {
			Category categoryInfo = deleteCategoryInfo.get();
			categoryInfo.setStatus(false);
			categoryRepository.save(categoryInfo);
		}
		return "true";
	}

}
