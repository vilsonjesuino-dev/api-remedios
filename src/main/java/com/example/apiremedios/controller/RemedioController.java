package com.example.apiremedios.controller;

import com.example.apiremedios.dto.DadosAtualizarRemedioDTO;
import com.example.apiremedios.dto.DadosCadastroRemedioDTO;
import com.example.apiremedios.dto.DadosListaRemedioDTO;
import com.example.apiremedios.model.Remedio;
import com.example.apiremedios.repository.RemedioRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @RequestMapping remedio
 */

@RestController
@RequestMapping("/remedio")
public class RemedioController {

    @Autowired
    private RemedioRepository remedioRepository;

    /**
     * Permite cadastrar um registro no banco de dados
     * @Valid validando o dados
     * @param cadastroDTO
     */

    @PostMapping
    @Transactional
    public void cadastrarRemedio(@RequestBody @Valid DadosCadastroRemedioDTO cadastroDTO) {
        remedioRepository.save(new Remedio(cadastroDTO));
    }

    /**
     * Permite retornar uma lista de registros do banco de dados
     * @return List<DadosListaRemedioDTO>
     */

//    @GetMapping
//    public List<DadosListaRemedioDTO> listarRemedios() {
//        return remedioRepository.findAll().stream().map(DadosListaRemedioDTO::new).toList();
//    }

    /**
     * Permite retornar uma lista do banco de dados, se a column "ativo = 1" o estiver ativo
     * @return
     */

    @GetMapping
    public List<DadosListaRemedioDTO> listarRemedios() {
        return remedioRepository.findAllByAtivoTrue().stream().map(DadosListaRemedioDTO::new).toList();
    }

    /**
     * Permite atualizar um registro no banco de dados
     * @param atualizarDTO
     */

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizarRemedioDTO atualizarDTO) {
        var remedio = remedioRepository.getReferenceById(atualizarDTO.id());
        remedio.atualizarInformacao(atualizarDTO);
    }

    /**
     * Permite excluir um registro no banco de dados, através do parâmetro ID
     * @param id
     */

    @DeleteMapping("/{id}")
    @Transactional
    public void excluir(@PathVariable Long id) {
        remedioRepository.deleteById(id);
    }

    /**
     * Permite inativar um registro no banco de dados
     * @param id
     */

    @DeleteMapping("/inativar/{id}")
    @Transactional
    public void inativar(@PathVariable Long id) {
        var remedio = remedioRepository.getReferenceById(id);
        remedio.inativar();
    }

    /**
     * Permite ativar um registro no banco de dados
     * @param id
     */

    @PutMapping("/ativar/{id}")
    @Transactional
    public void ativar(@PathVariable Long id){
        var remedio = remedioRepository.getReferenceById(id);
        remedio.ativar();
    }
}
