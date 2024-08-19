package com.example.expense.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.expense.Dto.CategoryDto;
import com.example.expense.service.CategoryService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;

@Tag(
	name="CRUD REST APIs for Category Resource",
	description="CRUD REST APIs for Category Resource - Create Category" +
		"Update Category, Delete Category, and Get Category"
)
@AllArgsConstructor
@RestController
@RequestMapping("/api/categories")
public class CategoryController {
	CategoryService categoryService;

	@Operation(
		summary = "Create Category REST API",
		description = "Create Category REST API to save category to database"
	)
	@ApiResponse(
		responseCode = "201",
		description = "HTTP STATUS 201 CREATED"
	)
	@PostMapping("/create")
	public ResponseEntity<CategoryDto> createCategory(@RequestBody CategoryDto categoryDto) {
		CategoryDto c = categoryService.createCategory(categoryDto);

		return new ResponseEntity<>(c, HttpStatus.CREATED);
	}
	

	@Operation(
		summary = "Get Category REST API",
		description = "Get Category REST API to get category from database"
	)
	@ApiResponse(
		responseCode = "200",
		description = "HTTP STATUS 200 OK"
	)
	@GetMapping("/get-category/{id}")
	public ResponseEntity<CategoryDto> getCategoryById(@PathVariable Long id) {
		CategoryDto categoryDto = categoryService.getCategoryById(id);

		return  ResponseEntity.ok(categoryDto);
	}

	@Operation(
		summary = "Get All Category REST API",
		description = "Get All Category REST API to get all categories from database"
	)
	@ApiResponse(
		responseCode = "200",
		description = "HTTP STATUS 200 OK"
	)
	@GetMapping("/get-all-categories")
	public ResponseEntity<List<CategoryDto>> getCategoryById() {
		List<CategoryDto> categories = categoryService.getCategories();

		return ResponseEntity.ok(categories);
	}	


	@Operation(
		summary = "Update Category REST API",
		description = "Update Category REST API to update category in a database"
	)
	@ApiResponse(
		responseCode = "200",
		description = "HTTP STATUS 200 OK"
	)
	@PutMapping("/{id}/update")
	public ResponseEntity<CategoryDto> updateCategory(@PathVariable Long id, @RequestBody CategoryDto categoryDto) {
		CategoryDto updateCategoryDto = categoryService.updateCategory(id, categoryDto);

		return ResponseEntity.ok(updateCategoryDto);
	}

	@Operation(
		summary = "Delete Category REST API",
		description = "Delete Category REST API to delete category in a database"
	)
	@ApiResponse(
		responseCode = "200",
		description = "HTTP STATUS 200 OK"
	)
	@DeleteMapping("/{id}/delete")
	public ResponseEntity<String> deleteCategory(@PathVariable Long id) {
		categoryService.deleteCategory(id);

		return ResponseEntity.ok("Category deleted successfully");

	}

}
