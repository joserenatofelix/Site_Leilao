package com.leilao_backend.service;

import com.leilao_backend.dto.LeilaoDTO;
import com.leilao_backend.exception.ResourceNotFoundException;
import com.leilao_backend.model.Leilao;
import com.leilao_backend.repository.LeilaoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LeilaoService {

    private static final Logger logger = LoggerFactory.getLogger(LeilaoService.class);
    private final LeilaoRepository leilaoRepository;

    @Autowired
    public LeilaoService(LeilaoRepository leilaoRepository) {
        this.leilaoRepository = leilaoRepository;
    }

    // Listar todos os leilões
    public List<LeilaoDTO> listarTodos() {
        logger.info("Listando todos os leilões");
        List<Leilao> leiloes = leilaoRepository.findAll();
        return leiloes.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    // Buscar leilão por ID
    public LeilaoDTO buscarPorId(Long id) {
        logger.info("Buscando leilão com ID: {}", id);
        Leilao leilao = findById(id);
        return convertToDTO(leilao);
    }

    // Criar novo leilão
    public LeilaoDTO criarLeilao(@Valid LeilaoDTO leilaoDTO) {
        logger.info("Criando um novo leilão: {}", leilaoDTO);
        Leilao leilao = new Leilao();
        leilao.setDescricao(leilaoDTO.getDescricao());
        leilao.setValorInicial(leilaoDTO.getValorInicial());
        leilao.setDataInicio(leilaoDTO.getDataInicio());
        leilao.setDataFim(leilaoDTO.getDataFim());
        Leilao leilaoSalvo = leilaoRepository.save(leilao);
        return convertToDTO(leilaoSalvo);
    }

    // Atualizar leilão existente
    public LeilaoDTO atualizarLeilao(Long id, @Valid LeilaoDTO leilaoDTO) {
        logger.info("Atualizando leilão com ID: {}", id);
        Leilao leilao = findById(id);
        leilao.setDescricao(leilaoDTO.getDescricao());
        leilao.setValorInicial(leilaoDTO.getValorInicial());
        leilao.setDataInicio(leilaoDTO.getDataInicio());
        leilao.setDataFim(leilaoDTO.getDataFim());
        Leilao leilaoAtualizado = leilaoRepository.save(leilao);
        return convertToDTO(leilaoAtualizado);
    }

    // Deletar leilão
    public void delete(Long id) {
        logger.info("Deletando leilão com ID: {}", id);
        Leilao leilao = findById(id);
        leilaoRepository.delete(leilao);
    }

    // Método auxiliar para converter Leilao para LeilaoDTO
    private LeilaoDTO convertToDTO(Leilao leilao) {
        LeilaoDTO dto = new LeilaoDTO();
        dto.setId(leilao.getId());
        dto.setDescricao(leilao.getDescricao());
        dto.setValorInicial(leilao.getValorInicial());
        dto.setDataInicio(leilao.getDataInicio());
        dto.setDataFim(leilao.getDataFim());
        return dto;
    }

    // Método auxiliar para buscar leilão por ID (usado internamente)
    private Leilao findById(Long id) {
        return leilaoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Leilão não encontrado com ID: " + id));
    }

    public void deletarLeilao(Long id) {
    }
}
