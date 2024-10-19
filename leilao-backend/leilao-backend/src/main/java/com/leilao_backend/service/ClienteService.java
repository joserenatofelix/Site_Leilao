package com.leilao_backend.service;

import com.leilao_backend.dto.ClienteDTO;
import com.leilao_backend.exception.ResourceNotFoundException;
import com.leilao_backend.model.Cliente;
import com.leilao_backend.repository.ClienteRepository;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClienteService {

    private static final Logger logger = LoggerFactory.getLogger(ClienteService.class);
    private final ClienteRepository clienteRepository;

    @Autowired
    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    // Listar todos os clientes
    public List<ClienteDTO> listarTodos() {
        logger.info("Listando todos os clientes");
        return clienteRepository.findAll().stream()
                .map(cliente -> {
                    ClienteDTO dto = new ClienteDTO();
                    dto.setId(cliente.getId());
                    dto.setNome(cliente.getNome());
                    dto.setEmail(cliente.getEmail());
                    dto.setTelefone(cliente.getTelefone());
                    return dto;
                })
                .collect(Collectors.toList());
    }

    // Buscar cliente por ID
    public ClienteDTO buscarPorId(Long id) {
        logger.info("Buscando cliente com ID: {}", id);
        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cliente não encontrado com ID: " + id));
        ClienteDTO dto = new ClienteDTO();
        dto.setId(cliente.getId());
        dto.setNome(cliente.getNome());
        dto.setEmail(cliente.getEmail());
        dto.setTelefone(cliente.getTelefone());
        return dto;
    }

    // Criar um novo cliente
    public ClienteDTO criarCliente(@Valid ClienteDTO clienteDTO) {
        logger.info("Criando um novo cliente: {}", clienteDTO.getNome());
        Cliente cliente = new Cliente();
        cliente.setNome(clienteDTO.getNome());
        cliente.setEmail(clienteDTO.getEmail());
        cliente.setTelefone(clienteDTO.getTelefone());
        Cliente clienteSalvo = clienteRepository.save(cliente);

        ClienteDTO dto = new ClienteDTO();
        dto.setId(clienteSalvo.getId());
        dto.setNome(clienteSalvo.getNome());
        dto.setEmail(clienteSalvo.getEmail());
        dto.setTelefone(clienteSalvo.getTelefone());
        return dto;
    }

    // Atualizar cliente existente
    public ClienteDTO atualizarCliente(Long id, @Valid ClienteDTO clienteDTO) {
        logger.info("Atualizando cliente com ID: {}", id);
        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cliente não encontrado com ID: " + id));

        cliente.setNome(clienteDTO.getNome());
        cliente.setEmail(clienteDTO.getEmail());
        cliente.setTelefone(clienteDTO.getTelefone());
        Cliente clienteAtualizado = clienteRepository.save(cliente);

        ClienteDTO dto = new ClienteDTO();
        dto.setId(clienteAtualizado.getId());
        dto.setNome(clienteAtualizado.getNome());
        dto.setEmail(clienteAtualizado.getEmail());
        dto.setTelefone(clienteAtualizado.getTelefone());
        return dto;
    }

    // Deletar cliente
    public void deletarCliente(Long id) {
        logger.info("Deletando cliente com ID: {}", id);
        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cliente não encontrado com ID: " + id));
        clienteRepository.delete(cliente);
    }
}
