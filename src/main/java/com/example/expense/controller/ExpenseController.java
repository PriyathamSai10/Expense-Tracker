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

import com.example.expense.Dto.ExpenseDto;
import com.example.expense.service.ExpenseService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;

@Tag(
	name="CRUD REST APIs for Expense resources",
	description="CRUD REST APIs for Expense resources - Create, Update, Get, and Delete"
)
@AllArgsConstructor
@RestController
@RequestMapping("/api/expense")
public class ExpenseController {
	ExpenseService expenseService;


	@Operation(
		summary = "Create Expense REST API",
		description = "Create Expense REST API to save a expense in a database"
	)
	@ApiResponse(
		responseCode = "201",
		description = "Http Status 201 CREATED"
	)
	@PostMapping("/create")
	public ResponseEntity<ExpenseDto> createExpense(@RequestBody ExpenseDto expenseDto) {
		ExpenseDto savedExpenseDto = expenseService.createExpense(expenseDto);

		return new ResponseEntity<>(savedExpenseDto, HttpStatus.CREATED);
	}



	@Operation(
		summary = "Get Expense REST API",
		description = "Create Expense REST API to get an expense from database"
	)
	@ApiResponse(
		responseCode = "200",
		description = "Http Status 200 OK"
	)
	@GetMapping("/{id}")
	public ResponseEntity<ExpenseDto> getExpenseById(@PathVariable	 Long id) {
		ExpenseDto expenseDto = expenseService.getExpenseById(id);

		return ResponseEntity.ok(expenseDto);
	}


	@Operation(
		summary = "Get All Expense REST API",
		description = "Create Expense REST API to get all expenses from database"
	)
	@ApiResponse(
		responseCode = "200",
		description = "Http Status 200 OK"
	)
	@GetMapping("/")
	public ResponseEntity<List<ExpenseDto>> getAllExpenses() {
		List<ExpenseDto> expenses = expenseService.getAllExpenses();

		return ResponseEntity.ok(expenses);
	}


	@Operation(
		summary = "Update Expense REST API",
		description = "Update Expense REST API to update an expense in a  database"
	)
	@ApiResponse(
		responseCode = "200",
		description = "Http Status 200 OK"
	)
	@PutMapping("/{id}/update")
	public ResponseEntity<ExpenseDto> updateExpense(@PathVariable Long id, @RequestBody ExpenseDto expenseDto){
		ExpenseDto updatedExpense = expenseService.updateExpense(id, expenseDto);

		return ResponseEntity.ok(updatedExpense);
	}

	@Operation(
		summary = "Delete Expense REST API",
		description = "Delete Expense REST API to delete an expense in a database"
	)
	@ApiResponse(
		responseCode = "200",
		description = "Http Status 200 OK"
	)
	@DeleteMapping("/{id}/delete")
	public ResponseEntity<String> deleteExpense(@PathVariable Long id){
		expenseService.deleteExpense(id);

		return ResponseEntity.ok("Expense is deleted succesfully");
	}

}
