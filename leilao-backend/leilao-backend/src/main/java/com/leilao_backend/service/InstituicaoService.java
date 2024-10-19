package com.leilao_backend.service;

import com.leilao_backend.dto.InstituicaoDTO;
import com.leilao_backend.exception.ResourceNotFoundException;
import com.leilao_backend.model.Instituicao;
import com.leilao_backend.repository.InstituicaoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class InstituicaoService {

    private static final Logger logger = LoggerFactory.getLogger(InstituicaoService.class);
    private final InstituicaoRepository instituicaoRepository;

    @Autowired
    public InstituicaoService(InstituicaoRepository instituicaoRepository) {
        this.instituicaoRepository = instituicaoRepository;
    }

    // Listar todas as instituições
    public List<InstituicaoDTO> listarTodos() {
        logger.info("Listando todas as instituições");
        List<Instituicao> instituicoes = instituicaoRepository.findAll();
        return instituicoes.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    // Buscar instituição por ID
    public InstituicaoDTO buscarPorId(Long id) {
        logger.info("Buscando instituição com ID: {}", id);
        Instituicao instituicao = findById(id);
        return convertToDTO(instituicao);
    }

    // Criar nova instituição
    public InstituicaoDTO criarInstituicao(@Valid InstituicaoDTO instituicaoDTO) {
        logger.info("Criando uma nova instituição: {}", instituicaoDTO);
        Instituicao instituicao = new Instituicao();
        instituicao.setNome(instituicaoDTO.getNome());
        instituicao.setEndereco(instituicaoDTO.getEndereco());
        Instituicao instituicaoSalva = instituicaoRepository.save(instituicao);
        return convertToDTO(instituicaoSalva);
    }

    // Atualizar instituição existente
    public InstituicaoDTO atualizarInstituicao(Long id, @Valid InstituicaoDTO instituicaoDTO) {
        logger.info("Atualizando instituição com ID: {}", id);
        Instituicao instituicao = findById(id);
        instituicao.setNome(instituicaoDTO.getNome());
        instituicao.setEndereco(instituicaoDTO.getEndereco());
        Instituicao instituicaoAtualizada = instituicaoRepository.save(instituicao);
        return convertToDTO(instituicaoAtualizada);
    }

    // Deletar instituição
    public void deletarInstituicao(Long id) {
        logger.info("Deletando instituição com ID: {}", id);
        Instituicao instituicao = findById(id);
        instituicaoRepository.delete(instituicao);
    }

    // Método auxiliar para converter Instituicao para InstituicaoDTO
    private InstituicaoDTO convertToDTO(Instituicao instituicao) {
        InstituicaoDTO dto = new InstituicaoDTO();
        dto.setId(instituicao.getId());
        dto.setNome(instituicao.getNome());
        dto.setEndereco(instituicao.getEndereco());
        return dto;
    }

    // Método auxiliar para buscar instituição por ID (usado internamente)
    private Instituicao findById(Long id) {
        return instituicaoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Instituição não encontrada com ID: " + id));
    }
}
