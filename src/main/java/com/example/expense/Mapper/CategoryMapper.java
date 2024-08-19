package com.example.expense.Mapper;


import com.example.expense.Dto.CategoryDto;
import com.example.expense.entity.Category;

public class CategoryMapper {
	public static Category mapToCategory(CategoryDto categoryDto) {
		return new Category(categoryDto.id(), categoryDto.name());
	}

	public static CategoryDto mapToCategoryDto(Category category) {
		return new CategoryDto(category.getId(), category.getName());
	}

}

