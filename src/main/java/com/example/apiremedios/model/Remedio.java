package com.example.apiremedios.model;

import com.example.apiremedios.dto.DadosAtualizarRemedioDTO;
import com.example.apiremedios.dto.DadosCadastroRemedioDTO;
import com.example.apiremedios.enums.Laboratorio;
import com.example.apiremedios.enums.Via;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "remedio")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Remedio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    @Enumerated(EnumType.STRING)
    private Via via;

    private String lote;
    private int quantidade;
    private LocalDate validade;

    @Enumerated(EnumType.STRING)
    private Laboratorio laboratorio;

    private Boolean ativo;

    public Remedio(DadosCadastroRemedioDTO dadosCadastroRemedioDTO) {
        this.nome = dadosCadastroRemedioDTO.nome();
        this.via = dadosCadastroRemedioDTO.via();
        this.lote = dadosCadastroRemedioDTO.lote();
        this.quantidade = dadosCadastroRemedioDTO.quantidade();
        this.validade = dadosCadastroRemedioDTO.validade();
        this.laboratorio = dadosCadastroRemedioDTO.laboratorio();
        this.ativo = true;
    }

    public void atualizarInformacao(@Valid DadosAtualizarRemedioDTO atualizarDTO) {
        if (atualizarDTO.nome() != null) {
            this.nome = atualizarDTO.nome();
        }
        if (atualizarDTO.via() != null) {
            this.via = atualizarDTO.via();
        }
        if (atualizarDTO.laboratorio() != null) {
            this.laboratorio = atualizarDTO.laboratorio();
        }
    }

    public void inativar() {
        this.ativo = false;
    }

    public void ativar() {
        this.ativo = true;
    }
}
