package com.example.apiremedios.dto;

import com.example.apiremedios.enums.Laboratorio;
import com.example.apiremedios.enums.Via;
import com.example.apiremedios.model.Remedio;

import java.time.LocalDate;

public record DadosListaRemedioDTO(
        Long id,
        String nome,
        Via via,
        String lote,
        Laboratorio laboratorio,
        LocalDate validade
) {

    public DadosListaRemedioDTO(Remedio remedio) {
        this(remedio.getId(), remedio.getNome(), remedio.getVia(), remedio.getLote(), remedio.getLaboratorio(), remedio.getValidade());
    }
}
