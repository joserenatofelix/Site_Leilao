package com.leilao_backend.repository;

import com.leilao_backend.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    // Você pode adicionar métodos personalizados aqui, se necessário
}
