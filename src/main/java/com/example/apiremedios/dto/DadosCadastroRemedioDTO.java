package com.example.apiremedios.dto;

import com.example.apiremedios.enums.Laboratorio;
import com.example.apiremedios.enums.Via;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

public record DadosCadastroRemedioDTO(

        @NotBlank
        String nome,

        @Enumerated
        Via via,

        @NotBlank
        String lote,

        int quantidade,

        @Future
        LocalDate validade,

        @Enumerated
        Laboratorio laboratorio) {
}
