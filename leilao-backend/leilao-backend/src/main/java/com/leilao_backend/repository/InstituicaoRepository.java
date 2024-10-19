package com.leilao_backend.repository;

import com.leilao_backend.model.Instituicao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstituicaoRepository extends JpaRepository<Instituicao, Long> {
    // Você pode adicionar métodos personalizados aqui, se necessário
}
