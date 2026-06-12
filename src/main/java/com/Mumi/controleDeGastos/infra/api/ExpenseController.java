package com.Mumi.controleDeGastos.infra.api;

import com.Mumi.controleDeGastos.domain.Expense;
import com.Mumi.controleDeGastos.domain.ExpenseReason;
import com.Mumi.controleDeGastos.domain.ExpensesWho;
import com.Mumi.controleDeGastos.infra.repo.SpringDataExpenseRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController("/expense")
public class ExpenseController {
    SpringDataExpenseRepository expenseRepository;

    public ExpenseController(SpringDataExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }
    @PostMapping
    public ResponseEntity<String> createExpense(double amount, String who, String reason, String description) {
        Expense expense = new Expense(BigDecimal.valueOf(amount), ExpensesWho.valueOf(who), new ExpenseReason(reason), description);
        return ResponseEntity.ok("Expense created successfully");
    }
    @GetMapping
    public ResponseEntity<?> getAllExpenses() {
        return ResponseEntity.ok(expenseRepository.findAll());
    }
}
