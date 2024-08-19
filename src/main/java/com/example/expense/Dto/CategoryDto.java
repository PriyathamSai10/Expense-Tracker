package com.example.expense.Dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(
	description = "Category DTO to transfer data between client and server"
)
public record CategoryDto(Long id, 
							@Schema(description = "Category Name")
							String name) {
	
}