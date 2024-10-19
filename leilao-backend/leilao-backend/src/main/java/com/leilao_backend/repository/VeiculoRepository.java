package com.leilao_backend.repository;

import com.leilao_backend.model.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {
    // Você pode adicionar métodos personalizados aqui, se necessário
}
