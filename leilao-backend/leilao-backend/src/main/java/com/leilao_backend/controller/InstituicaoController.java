package com.leilao_backend.controller;

import com.leilao_backend.dto.InstituicaoDTO;
import com.leilao_backend.service.InstituicaoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/instituicoes")
public class InstituicaoController {

    private final InstituicaoService instituicaoService;

    public InstituicaoController(InstituicaoService instituicaoService) {
        this.instituicaoService = instituicaoService;
    }

    @GetMapping
    public List<InstituicaoDTO> listarTodos() {
        return instituicaoService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<InstituicaoDTO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(instituicaoService.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<InstituicaoDTO> criarInstituicao(@RequestBody InstituicaoDTO instituicaoDTO) {
        InstituicaoDTO novaInstituicao = instituicaoService.criarInstituicao(instituicaoDTO);
        return ResponseEntity.ok(novaInstituicao);
    }

    @PutMapping("/{id}")
    public ResponseEntity<InstituicaoDTO> atualizarInstituicao(@PathVariable Long id, @RequestBody InstituicaoDTO instituicaoDTO) {
        return ResponseEntity.ok(instituicaoService.atualizarInstituicao(id, instituicaoDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarInstituicao(@PathVariable Long id) {
        instituicaoService.deletarInstituicao(id);
        return ResponseEntity.noContent().build();
    }
}
