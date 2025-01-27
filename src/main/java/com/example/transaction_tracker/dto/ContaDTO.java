package com.example.transaction_tracker.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;

/**
 * DTO para a entidade Conta.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ContaDTO {
    private String nome;
    private Double saldo;
}
