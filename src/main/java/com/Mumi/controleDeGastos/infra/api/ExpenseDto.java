package com.Mumi.controleDeGastos.infra.api;

public record ExpenseDto(double amount, String who, String reason, String description) {
}
