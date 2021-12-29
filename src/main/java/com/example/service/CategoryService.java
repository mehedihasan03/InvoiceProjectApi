package com.example.service;

import org.springframework.data.repository.CrudRepository;

import com.example.model.Category;

public interface CategoryService extends CrudRepository<Category, Integer>{

}
