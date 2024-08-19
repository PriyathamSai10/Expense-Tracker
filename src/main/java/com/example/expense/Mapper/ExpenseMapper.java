package com.example.expense.Mapper;

import com.example.expense.Dto.CategoryDto;
import com.example.expense.Dto.ExpenseDto;
import com.example.expense.entity.Category;
import com.example.expense.entity.Expense;

public class ExpenseMapper {
	public static ExpenseDto  mapToExpenseDto(Expense expense) {
		return new ExpenseDto(
				expense.getId(), 
				expense.getAmount(), 
				expense.getExpenseDate(), 
				new CategoryDto(
					expense.getCategory().getId(), 
					expense.getCategory().getName()
				)
			);
	}


	public static Expense mapToExpense(ExpenseDto expenseDto) {
		Category c = new Category();
		c.setId(expenseDto.categoryDto().id());

		return new Expense(
					expenseDto.id(),
					expenseDto.amount(),
					expenseDto.expenseDate(),
					c
				);
	}
}
