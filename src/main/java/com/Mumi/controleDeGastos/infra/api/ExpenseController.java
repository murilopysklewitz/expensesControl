package com.Mumi.controleDeGastos.infra.api;

import com.Mumi.controleDeGastos.domain.Expense;
import com.Mumi.controleDeGastos.domain.ExpenseReason;
import com.Mumi.controleDeGastos.domain.ExpensesWho;
import com.Mumi.controleDeGastos.infra.repo.SpringDataExpenseReasonRepository;
import com.Mumi.controleDeGastos.infra.repo.SpringDataExpenseRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/expense")
public class ExpenseController {
    SpringDataExpenseRepository expenseRepository;
    SpringDataExpenseReasonRepository reasonRepository;

    public ExpenseController(SpringDataExpenseRepository expenseRepository, SpringDataExpenseReasonRepository reasonRepository) {
        this.expenseRepository = expenseRepository;
        this.reasonRepository = reasonRepository;
    }
    @PostMapping("/create")
    public ResponseEntity<String> createExpense(@RequestBody ExpenseDto dto) {
        ExpenseReason reason = reasonRepository.findByReasonReason(dto.reason())
                .stream().findFirst()
                .orElseThrow(() -> new RuntimeException("Reason not found"));
        Expense expense = new Expense(BigDecimal.valueOf(dto.amount()), ExpensesWho.valueOf(dto.who()), reason, dto.description());
        expenseRepository.save(expense);
        return ResponseEntity.ok("Expense created successfully");
    }
    @GetMapping("/")
    public ResponseEntity<?> getAllExpenses() {
        return ResponseEntity.ok(expenseRepository.findAll());
    }
}
