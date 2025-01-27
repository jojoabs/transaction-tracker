package com.example.transaction_tracker.controller;

import com.example.transaction_tracker.dto.ContaDTO;
import com.example.transaction_tracker.model.Conta;
import com.example.transaction_tracker.service.ContaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contas")
public class ContaController {

    @Autowired
    private ContaService contaService;

    @GetMapping
    public ResponseEntity<List<Conta>> getAllContas() {
        return ResponseEntity.ok(contaService.getAllContas());
    }

    @PostMapping
    public ResponseEntity<Conta> createConta(@RequestBody ContaDTO contaDTO) {
        return ResponseEntity.ok(contaService.createConta(contaDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Conta> getContaById(@PathVariable Long id) {
        return ResponseEntity.ok(contaService.getContaById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Conta> updateConta(@PathVariable Long id, @RequestBody ContaDTO contaDTO) {
        return ResponseEntity.ok(contaService.updateConta(id, contaDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteConta(@PathVariable Long id) {
        contaService.deleteConta(id);
        return ResponseEntity.noContent().build();
    }
}
