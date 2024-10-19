package com.leilao_backend.repository;

import com.leilao_backend.model.Imovel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImovelRepository extends JpaRepository<Imovel, Long> {
    // Você pode adicionar métodos personalizados aqui, se necessário
}
