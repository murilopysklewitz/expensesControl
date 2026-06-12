package com.Mumi.controleDeGastos.infra.repo;

import com.Mumi.controleDeGastos.domain.Expense;
import com.Mumi.controleDeGastos.domain.ExpenseReason;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface SpringDataExpenseReasonRepository extends JpaRepository<ExpenseReason, UUID> {
    List<ExpenseReason> findByReasonReason(String reason);
}
