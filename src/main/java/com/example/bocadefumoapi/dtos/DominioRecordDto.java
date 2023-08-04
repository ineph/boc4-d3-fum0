package com.example.bocadefumoapi.dtos;

import jakarta.validation.constraints.NotBlank;

public record DominioRecordDto(
        @NotBlank String nm_dominio,
        @NotBlank String nm_origem,
        @NotBlank String tp_dominio,
        @NotBlank String descricao
        ) {}
