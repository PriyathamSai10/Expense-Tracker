package com.example.expense.Dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import io.swagger.v3.oas.annotations.media.Schema;



@Schema(
	description = "Expense DTO to transfer data between client and server"
)
public record ExpenseDto(Long id, 
							@Schema(description = "Expense Amount") BigDecimal amount, 
							@Schema(description = "Expense created date") LocalDate expenseDate, 
							@Schema(description = "Associated Expense Category") CategoryDto categoryDto){

}