package com.example.transaction_tracker.controller;

import com.example.transaction_tracker.dto.ContaDTO;
import com.example.transaction_tracker.service.ContaService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.annotations.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ContaController.class)
class ContaControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ContaService contaService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void testGetAllContas() throws Exception {
        // Mockando a resposta do serviço
        Mockito.when(contaService.getAllContas())
                .thenReturn(Collections.emptyList());

        mockMvc.perform(get("/api/contas"))
                .andExpect(status().isOk())
                .andExpect(content().json("[]"));
    }

    @Test
    void testCreateConta() throws Exception {
        ContaDTO contaDTO = new ContaDTO("Nova Conta", 500.0);

        // Mockando o comportamento do serviço
        Mockito.when(contaService.createConta(Mockito.any()))
                .thenReturn(null);

        mockMvc.perform(post("/api/contas")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(contaDTO)))
                .andExpect(status().isOk());
    }
}
