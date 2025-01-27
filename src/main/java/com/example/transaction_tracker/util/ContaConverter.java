package com.example.transaction_tracker.util;

import com.example.transaction_tracker.dto.ContaDTO;
import com.example.transaction_tracker.model.Conta;

/**
 * Conversor para transformar entre Conta e ContaDTO.
 */
public class ContaConverter {

    public static Conta toEntity(ContaDTO contaDTO) {
        return Conta.builder()
                .nome(contaDTO.getNome())
                .saldo(contaDTO.getSaldo())
                .build();
    }

    public static ContaDTO toDTO(Conta conta) {
        return ContaDTO.builder()
                .nome(conta.getNome())
                .saldo(conta.getSaldo())
                .build();
    }
}
