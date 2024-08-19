package com.example.expense.service;

import java.util.*;
import com.example.expense.Dto.CategoryDto;

public interface CategoryService {
	CategoryDto createCategory(CategoryDto categoryDto);
	CategoryDto getCategoryById(Long id);
	List<CategoryDto> getCategories();
	CategoryDto updateCategory(Long id, CategoryDto categoryDto);
	void deleteCategory(Long id);
}
