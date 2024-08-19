package com.example.expense.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.expense.entity.Expense;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {
	
}
