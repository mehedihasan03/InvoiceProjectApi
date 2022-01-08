package com.example.service;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.model.Category;

@Repository
public interface CategoryService extends CrudRepository<Category, Integer>{

	@Query("SELECT c from Category c where c.cname like %?1%")
	List<Category> searchCategories(String searchText);
}
