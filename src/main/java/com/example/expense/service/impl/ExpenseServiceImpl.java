package com.example.expense.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import javax.management.RuntimeErrorException;

import org.springframework.stereotype.Service;

import com.example.expense.Dto.ExpenseDto;
import com.example.expense.Exception.ResourceNotFoundException;
import com.example.expense.Mapper.CategoryMapper;
import com.example.expense.Mapper.ExpenseMapper;
import com.example.expense.entity.Category;
import com.example.expense.entity.Expense;
import com.example.expense.repository.CategoryRepository;
import com.example.expense.repository.ExpenseRepository;
import com.example.expense.service.ExpenseService;

@Service
public class ExpenseServiceImpl implements ExpenseService {

	private ExpenseRepository expenseRepository;
	private CategoryRepository categoryRespository;

	public ExpenseServiceImpl(ExpenseRepository expenseRepository, CategoryRepository categoryRespository){
		this.expenseRepository = expenseRepository;
		this.categoryRespository = categoryRespository;
	}

	@Override
	public ExpenseDto createExpense(ExpenseDto expenseDto) {
		Expense expense = ExpenseMapper.mapToExpense(expenseDto);
		Expense savedExpense = expenseRepository.save(expense);

		return ExpenseMapper.mapToExpenseDto(savedExpense);
	}

	@Override
	public ExpenseDto getExpenseById(Long id) {
		Expense expense = expenseRepository
								.findById(id)
								.orElseThrow(() -> new ResourceNotFoundException("Expense with id: " + id + " not found"));

		return ExpenseMapper.mapToExpenseDto(expense);
	}

	@Override
	public List<ExpenseDto> getAllExpenses() {
		List<Expense> expenses =  expenseRepository.findAll();
		return expenses.stream()
						.map((e) -> ExpenseMapper.mapToExpenseDto(e))
						.collect(Collectors.toList());

		
	}

	@Override
	public ExpenseDto updateExpense(Long id, ExpenseDto expenseDto) {
		Expense expense = expenseRepository
								.findById(id)
								.orElseThrow(() -> new ResourceNotFoundException("Expense with id: "+id+" is not found"));

		expense.setAmount(expenseDto.amount());
		expense.setExpenseDate(expenseDto.expenseDate());

		if(expenseDto.categoryDto() != null ){
			Category category = categoryRespository
										.findById(expenseDto.categoryDto().id())
										.orElseThrow(() -> new ResourceNotFoundException("Category with id: "+id+"is not found"));

			expense.setCategory(category);
		}

		Expense updatedExpense = expenseRepository.save(expense);
		return ExpenseMapper.mapToExpenseDto(updatedExpense);
	}

	@Override
	public void deleteExpense(Long id) {
		Expense expense = expenseRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Expense with id: "+id+" is not found"));

		expenseRepository.delete(expense);

	}
	

}
