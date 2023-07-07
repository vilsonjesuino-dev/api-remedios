package com.example.apiremedios.dto;

import com.example.apiremedios.enums.Laboratorio;
import com.example.apiremedios.enums.Via;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizarRemedioDTO(

        @NotNull
        Long id,
        String nome,
        Via via,
        Laboratorio laboratorio
) {
}
