package com.Mumi.controleDeGastos.infra.api;

import com.Mumi.controleDeGastos.domain.ExpenseReason;
import com.Mumi.controleDeGastos.infra.repo.SpringDataExpenseReasonRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/reason")
public class ReasonController {
    SpringDataExpenseReasonRepository reasonRepository;
    public ReasonController(SpringDataExpenseReasonRepository reasonRepository) {
        this.reasonRepository = reasonRepository;
    }

    @PostMapping("/create")
    public ResponseEntity<String> createReason(@RequestBody String reason) {
        ExpenseReason reason1 = new ExpenseReason(reason);
        reasonRepository.save(reason1);
        return ResponseEntity.ok("Reason created successfully");
    }
    @GetMapping("/")
    public ResponseEntity<?> getAllReasons() {
        return ResponseEntity.ok(reasonRepository.findAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getReasonById(@PathVariable String id) {
        return ResponseEntity.ok(reasonRepository.findById(UUID.fromString(id)));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteReason(@PathVariable String id) {
        reasonRepository.deleteById(UUID.fromString(id));
        return ResponseEntity.ok("Reason deleted successfully");
    }
    @GetMapping("/{reason}")
    public ResponseEntity<?> getReasonByReason(@PathVariable String reason) {
        return ResponseEntity.ok(reasonRepository.findByReasonReason(reason));
    }

}
