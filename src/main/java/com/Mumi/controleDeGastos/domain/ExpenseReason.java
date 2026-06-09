package com.Mumi.controleDeGastos.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table(name = "expense_reason")

@Getter
@NoArgsConstructor
public class ExpenseReason {
    @Id
    @Column(name = "id", unique = true, nullable = false)
    private UUID id;
    @Column(name = "reason", nullable = false, unique = true)
    private String reason;

    public ExpenseReason(String reason) {
        this.id = UUID.randomUUID();
        this.reason = reason;
    }
}
