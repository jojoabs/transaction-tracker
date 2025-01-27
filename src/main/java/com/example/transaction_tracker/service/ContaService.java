package com.example.transaction_tracker.service;

import com.example.transaction_tracker.dto.ContaDTO;
import com.example.transaction_tracker.exception.ResourceNotFoundException;
import com.example.transaction_tracker.model.Conta;
import com.example.transaction_tracker.repository.ContaRepository;
import com.example.transaction_tracker.util.ContaConverter;
import com.example.transaction_tracker.util.ValidationUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Serviço responsável por gerenciar as operações relacionadas à entidade Conta.
 */
@Service
public class ContaService {

    @Autowired
    private ContaRepository contaRepository;

    /**
     * Retorna todas as contas cadastradas.
     *
     * @return lista de contas
     */
    public List<Conta> getAllContas() {
        return contaRepository.findAll();
    }

    /**
     * Cria uma nova conta.
     *
     * @param contaDTO Dados da conta
     * @return Conta criada
     */
    public Conta createConta(ContaDTO contaDTO) {
        ValidationUtils.validateNotNull(contaDTO, "ContaDTO não pode ser nulo.");
        ValidationUtils.validateStringNotEmpty(contaDTO.getNome(), "O nome da conta não pode estar vazio.");

        Conta conta = ContaConverter.toEntity(contaDTO);
        conta.setSaldo(Optional.ofNullable(contaDTO.getSaldo()).orElse(0.0)); // Define saldo padrão como 0.0 se nulo
        return contaRepository.save(conta);
    }

    /**
     * Retorna uma conta específica pelo ID.
     *
     * @param id ID da conta
     * @return Conta encontrada
     */
    public Conta getContaById(Long id) {
        return contaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Conta não encontrada com ID: " + id));
    }

    /**
     * Atualiza uma conta existente.
     *
     * @param id ID da conta
     * @param contaDTO Novos dados da conta
     * @return Conta atualizada
     */
    public Conta updateConta(Long id, ContaDTO contaDTO) {
        ValidationUtils.validateNotNull(contaDTO, "ContaDTO não pode ser nulo.");
        ValidationUtils.validateStringNotEmpty(contaDTO.getNome(), "O nome da conta não pode estar vazio.");

        Conta conta = getContaById(id);
        conta.setNome(contaDTO.getNome());
        conta.setSaldo(Optional.ofNullable(contaDTO.getSaldo()).orElse(conta.getSaldo())); // Mantém saldo atual se não fornecido
        return contaRepository.save(conta);
    }

    /**
     * Deleta uma conta pelo ID.
     *
     * @param id ID da conta
     */
    public void deleteConta(Long id) {
        Conta conta = getContaById(id);
        contaRepository.delete(conta);
    }

    /**
     * Verifica se uma conta existe pelo ID.
     *
     * @param id ID da conta
     * @return true se a conta existir, caso contrário false
     */
    public boolean existsById(Long id) {
        return contaRepository.existsById(id);
    }
}
