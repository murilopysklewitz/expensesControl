package com.Mumi.controleDeGastos.infra.repo;

import com.Mumi.controleDeGastos.domain.Expense;
import com.Mumi.controleDeGastos.domain.ExpensesWho;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public interface SpringDataExpenseRepository extends JpaRepository<Expense, UUID> {
    List<Expense> findByWho(ExpensesWho who);
    List<Expense> findByReasonId(UUID reasonId);
    List<Expense> findByReasonReason(String reason);
    List<Expense> findByAmountBetween(BigDecimal min, BigDecimal max);
    List<Expense> findByCreatedAtBetween(LocalDate start, LocalDate end);

}
