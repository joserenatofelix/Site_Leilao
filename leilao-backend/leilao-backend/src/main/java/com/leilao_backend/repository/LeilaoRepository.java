package com.leilao_backend.repository;

import com.leilao_backend.model.Leilao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LeilaoRepository extends JpaRepository<Leilao, Long> {
    // Você pode adicionar métodos personalizados aqui, se necessário
}
