package com.example.expense.service.impl;


import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.expense.Dto.CategoryDto;
import com.example.expense.Exception.ResourceNotFoundException;
import com.example.expense.Mapper.CategoryMapper;
import com.example.expense.entity.Category;
import com.example.expense.repository.CategoryRepository;
import com.example.expense.service.CategoryService;

import lombok.AllArgsConstructor;


@AllArgsConstructor
@Service
public class CategoryServiceImpl implements CategoryService  {

	CategoryRepository categoryRepository;


	@Override
	public CategoryDto createCategory(CategoryDto categoryDto) {
		
		Category category = CategoryMapper.mapToCategory(categoryDto);
		Category savedCategory = categoryRepository.save(category);
		
		return CategoryMapper.mapToCategoryDto(savedCategory);
	}


	@Override
	public CategoryDto getCategoryById(Long id) {
		Category category = categoryRepository
								.findById(id)
								.orElseThrow(() -> new ResourceNotFoundException("Category with id: "+id+" is not found."));

		return CategoryMapper.mapToCategoryDto(category);
	}


	@Override
	public List<CategoryDto> getCategories() {
		List<Category> categories = categoryRepository.findAll();

		return categories.stream()
						.map((category) -> CategoryMapper.mapToCategoryDto(category))
						.collect(Collectors.toList());
	}


	@Override
	public CategoryDto updateCategory(Long id, CategoryDto categoryDto) {
		Category category = categoryRepository
								.findById(id)
								.orElseThrow(() -> new ResourceNotFoundException("Category with id: "+id+" not found"));

		category.setName(categoryDto.name());
		Category savedCategory = categoryRepository.save(category);

		return CategoryMapper.mapToCategoryDto(savedCategory);
	}


	@Override
	public void deleteCategory(Long id) {
		Category category = categoryRepository
								.findById(id)
								.orElseThrow(() -> new ResourceNotFoundException("Category with id: "+id+" is not found"));

		categoryRepository.delete(category);
	}

	
}
