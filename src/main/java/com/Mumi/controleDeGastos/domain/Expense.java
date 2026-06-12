package com.Mumi.controleDeGastos.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;


@Getter
@NoArgsConstructor
@Entity
@Table(name = "expenses")
public class Expense {
    @Id
    @Column(name = "id", nullable = false)
    private UUID id;
    @Enumerated(EnumType.STRING)
    @Column(name = "who", nullable = false)
    private ExpensesWho who;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "reason_id", nullable = false)
    private ExpenseReason reason;
    @Column(name = "amount", nullable = false)
    private BigDecimal amount;
    @Column(name = "description")
    private String description;
    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    public Expense(BigDecimal amount, ExpensesWho who, ExpenseReason reason, String description) {
        this.id = UUID.randomUUID();
        this.amount = amount;
        this.who = who;
        this.reason = reason;
        this.description = description;
        this.createdAt = LocalDateTime.now();
    }

}
