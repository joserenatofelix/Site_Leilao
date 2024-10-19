package com.leilao_backend.service;

import com.leilao_backend.dto.VeiculoDTO;
import com.leilao_backend.exception.ResourceNotFoundException;
import com.leilao_backend.model.Veiculo;
import com.leilao_backend.repository.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VeiculoService {

    private final VeiculoRepository veiculoRepository;

    @Autowired
    public VeiculoService(VeiculoRepository veiculoRepository) {
        this.veiculoRepository = veiculoRepository;
    }

    public List<Veiculo> findAll() {
        return veiculoRepository.findAll();
    }

    public Veiculo findById(Long id) {
        return veiculoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Veículo não encontrado com ID: " + id));
    }

    public Veiculo save(Veiculo veiculo) {
        return veiculoRepository.save(veiculo);
    }

    public Veiculo update(Long id, Veiculo veiculoDetails) {
        Veiculo veiculo = findById(id);
        veiculo.setTipo(veiculoDetails.getTipo());
        veiculo.setModelo(veiculoDetails.getModelo());
        veiculo.setMarca(veiculoDetails.getMarca());
        veiculo.setAno(veiculoDetails.getAno());
        veiculo.setPlaca(veiculoDetails.getPlaca());
        return veiculoRepository.save(veiculo);
    }

    public void delete(Long id) {
        Veiculo veiculo = findById(id);
        veiculoRepository.delete(veiculo);
    }

    public List<VeiculoDTO> listarTodos() {
        List<Veiculo> veiculos = veiculoRepository.findAll();
        return veiculos.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public VeiculoDTO buscarPorId(Long id) {
        Veiculo veiculo = findById(id);
        return convertToDTO(veiculo);
    }

    public VeiculoDTO criarVeiculo(VeiculoDTO veiculoDTO) {
        Veiculo veiculo = new Veiculo();
        veiculo.setTipo(veiculoDTO.getTipo());
        veiculo.setModelo(veiculoDTO.getModelo());
        veiculo.setMarca(veiculoDTO.getMarca());
        veiculo.setAno(veiculoDTO.getAno());
        veiculo.setPlaca(veiculoDTO.getPlaca());
        Veiculo veiculoSalvo = veiculoRepository.save(veiculo);
        return convertToDTO(veiculoSalvo);
    }

    public VeiculoDTO atualizarVeiculo(Long id, VeiculoDTO veiculoDTO) {
        Veiculo veiculo = findById(id);
        veiculo.setTipo(veiculoDTO.getTipo());
        veiculo.setModelo(veiculoDTO.getModelo());
        veiculo.setMarca(veiculoDTO.getMarca());
        veiculo.setAno(veiculoDTO.getAno());
        veiculo.setPlaca(veiculoDTO.getPlaca());
        Veiculo veiculoAtualizado = veiculoRepository.save(veiculo);
        return convertToDTO(veiculoAtualizado);
    }

    public void deletarVeiculo(Long id) {
        delete(id);
    }

    private VeiculoDTO convertToDTO(Veiculo veiculo) {
        VeiculoDTO dto = new VeiculoDTO();
        dto.setId(veiculo.getId());
        dto.setTipo(veiculo.getTipo());
        dto.setModelo(veiculo.getModelo());
        dto.setMarca(veiculo.getMarca());
        dto.setAno(veiculo.getAno());
        dto.setPlaca(veiculo.getPlaca());
        return dto;
    }
}
