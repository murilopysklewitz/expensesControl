package com.Mumi.controleDeGastos.infra.api;

import com.Mumi.controleDeGastos.domain.Expense;
import com.Mumi.controleDeGastos.domain.ExpenseReason;
import com.Mumi.controleDeGastos.domain.ExpensesWho;
import com.Mumi.controleDeGastos.infra.repo.SpringDataExpenseRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/expense")
public class ExpenseController {
    SpringDataExpenseRepository expenseRepository;

    public ExpenseController(SpringDataExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }
    @PostMapping("/create")
    public ResponseEntity<String> createExpense(@RequestBody ExpenseDto dto) {
        Expense expense = new Expense(BigDecimal.valueOf(dto.amount()), ExpensesWho.valueOf(dto.who()), new ExpenseReason(dto.reason()), dto.description());
        expenseRepository.save(expense);
        return ResponseEntity.ok("Expense created successfully");
    }
    @GetMapping("/")
    public ResponseEntity<?> getAllExpenses() {
        return ResponseEntity.ok(expenseRepository.findAll());
    }
}
