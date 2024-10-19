package com.leilao_backend.service;

import com.leilao_backend.dto.ImovelDTO;
import com.leilao_backend.exception.ResourceNotFoundException;
import com.leilao_backend.model.Imovel;
import com.leilao_backend.repository.ImovelRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.validation.Valid;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ImovelService {

    private static final Logger logger = LoggerFactory.getLogger(ImovelService.class);
    private final ImovelRepository imovelRepository;

    @Autowired
    public ImovelService(ImovelRepository imovelRepository) {
        this.imovelRepository = imovelRepository;
    }

    // Listar todos os imóveis
    public List<ImovelDTO> listarTodos() {
        logger.info("Listando todos os imóveis");
        List<Imovel> imoveis = imovelRepository.findAll();
        return imoveis.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    // Buscar imóvel por ID
    public ImovelDTO buscarPorId(Long id) {
        logger.info("Buscando imóvel com ID: {}", id);
        Imovel imovel = findById(id);
        return convertToDTO(imovel);
    }

    // Criar novo imóvel
    public ImovelDTO criarImovel(@Valid ImovelDTO imovelDTO) {
        logger.info("Criando um novo imóvel: {}", imovelDTO);
        Imovel imovel = new Imovel();
        imovel.setTipo(imovelDTO.getTipo());
        imovel.setEndereco(imovelDTO.getEndereco());
        // Converte o valor para BigDecimal se necessário
        imovel.setValor(BigDecimal.valueOf(imovelDTO.getValor()));
        imovel.setDescricao(imovelDTO.getDescricao());
        Imovel imovelSalvo = imovelRepository.save(imovel);
        return convertToDTO(imovelSalvo);
    }

    // Atualizar imóvel existente
    public ImovelDTO atualizarImovel(Long id, @Valid ImovelDTO imovelDTO) {
        logger.info("Atualizando imóvel com ID: {}", id);
        Imovel imovel = findById(id);
        imovel.setTipo(imovelDTO.getTipo());
        imovel.setEndereco(imovelDTO.getEndereco());
        // Converte o valor para BigDecimal se necessário
        imovel.setValor(BigDecimal.valueOf(imovelDTO.getValor()));
        imovel.setDescricao(imovelDTO.getDescricao());
        Imovel imovelAtualizado = imovelRepository.save(imovel);
        return convertToDTO(imovelAtualizado);
    }

    // Deletar imóvel
    public void deletarImovel(Long id) {
        logger.info("Deletando imóvel com ID: {}", id);
        Imovel imovel = findById(id);
        imovelRepository.delete(imovel);
    }

    // Método auxiliar para converter Imovel para ImovelDTO
    private ImovelDTO convertToDTO(Imovel imovel) {
        ImovelDTO dto = new ImovelDTO();
        dto.setId(imovel.getId());
        dto.setTipo(imovel.getTipo());
        dto.setEndereco(imovel.getEndereco());
        dto.setValor(imovel.getValor().doubleValue()); // Converte BigDecimal para double
        dto.setDescricao(imovel.getDescricao());
        return dto;
    }

    // Método auxiliar para buscar imóvel por ID (usado internamente)
    private Imovel findById(Long id) {
        return imovelRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Imóvel não encontrado com ID: " + id));
    }
}
