package com.leilao_backend.controller;

import com.leilao_backend.dto.LeilaoDTO;
import com.leilao_backend.service.LeilaoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/leiloes")
public class LeilaoController {

    private final LeilaoService leilaoService;

    public LeilaoController(LeilaoService leilaoService) {
        this.leilaoService = leilaoService;
    }

    @GetMapping
    public List<LeilaoDTO> listarTodos() {
        return leilaoService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<LeilaoDTO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(leilaoService.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<LeilaoDTO> criarLeilao(@RequestBody LeilaoDTO leilaoDTO) {
        LeilaoDTO novoLeilao = leilaoService.criarLeilao(leilaoDTO);
        return ResponseEntity.ok(novoLeilao);
    }

    @PutMapping("/{id}")
    public ResponseEntity<LeilaoDTO> atualizarLeilao(@PathVariable Long id, @RequestBody LeilaoDTO leilaoDTO) {
        return ResponseEntity.ok(leilaoService.atualizarLeilao(id, leilaoDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarLeilao(@PathVariable Long id) {
        leilaoService.deletarLeilao(id);
        return ResponseEntity.noContent().build();
    }
}
