package com.vconnect.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.vconnect.entity.Category;

public interface CategoryRepository extends CrudRepository<Category, Integer> {
	public List<Category> findAllByName(String name);		//used to find category by name.

}
