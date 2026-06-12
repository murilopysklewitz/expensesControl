package com.Mumi.controleDeGastos.infra.api;

import com.Mumi.controleDeGastos.domain.ExpenseReason;
import com.Mumi.controleDeGastos.infra.repo.SpringDataExpenseReasonRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController("/reason")
public class ReasonController {
    SpringDataExpenseReasonRepository reasonRepository;
    public ReasonController(SpringDataExpenseReasonRepository reasonRepository) {
        this.reasonRepository = reasonRepository;
    }

    @PostMapping
    public ResponseEntity<String> createReason(String reason) {
        ExpenseReason reason1 = new ExpenseReason(reason);
        reasonRepository.save(reason1);
        return ResponseEntity.ok("Reason created successfully");
    }
    @GetMapping
    public ResponseEntity<?> getAllReasons() {
        return ResponseEntity.ok(reasonRepository.findAll());
    }
    @GetMapping
    public ResponseEntity<?> getReasonById(@PathVariable String id) {
        return ResponseEntity.ok(reasonRepository.findById(UUID.fromString(id)));
    }
    @PostMapping
    public ResponseEntity<String> deleteReason(String id) {
        reasonRepository.deleteById(UUID.fromString(id));
        return ResponseEntity.ok("Reason deleted successfully");
    }
    @GetMapping
    public ResponseEntity<?> getReasonByReason(String reason) {
        return ResponseEntity.ok(reasonRepository.findByReasonReason(reason));
    }

}
