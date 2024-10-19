package com.leilao_backend.controller;

import com.leilao_backend.dto.ImovelDTO;
import com.leilao_backend.service.ImovelService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/imoveis")
public class ImovelController {

    private final ImovelService imovelService;

    public ImovelController(ImovelService imovelService) {
        this.imovelService = imovelService;
    }

    @GetMapping
    public List<ImovelDTO> listarTodos() {
        return imovelService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ImovelDTO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(imovelService.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<ImovelDTO> criarImovel(@RequestBody ImovelDTO imovelDTO) {
        ImovelDTO novoImovel = imovelService.criarImovel(imovelDTO);
        return ResponseEntity.ok(novoImovel);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ImovelDTO> atualizarImovel(@PathVariable Long id, @RequestBody ImovelDTO imovelDTO) {
        return ResponseEntity.ok(imovelService.atualizarImovel(id, imovelDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarImovel(@PathVariable Long id) {
        imovelService.deletarImovel(id);
        return ResponseEntity.noContent().build();
    }
}
