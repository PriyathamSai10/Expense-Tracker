package com.example.expense.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.expense.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
	
}
