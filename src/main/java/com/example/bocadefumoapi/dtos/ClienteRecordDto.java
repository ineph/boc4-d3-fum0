package com.example.bocadefumoapi.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record ClienteRecordDto(
        String vulgo,
        String obs,
        @NotBlank String nome,
        @NotBlank String endereco,
        @NotNull Boolean devedor,
        @NotNull BigDecimal valor_devido
        ) {}
