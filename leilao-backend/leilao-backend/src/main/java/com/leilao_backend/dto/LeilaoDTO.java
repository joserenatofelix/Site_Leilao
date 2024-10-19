package com.leilao_backend.dto;

import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class LeilaoDTO {
    private Long id;

    @NotNull
    private String descricao;

    @NotNull
    private BigDecimal valorInicial;

    @NotNull
    private LocalDateTime dataInicio;

    @NotNull
    private LocalDateTime dataFim;

    // Construtor padrão
    public LeilaoDTO() {
    }

    // Construtor com todos os campos
    public LeilaoDTO(Long id, String descricao, BigDecimal valorInicial, LocalDateTime dataInicio, LocalDateTime dataFim) {
        this.id = id;
        this.descricao = descricao;
        this.valorInicial = valorInicial;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getValorInicial() {
        return valorInicial;
    }

    public void setValorInicial(BigDecimal valorInicial) {
        this.valorInicial = valorInicial;
    }

    public LocalDateTime getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDateTime dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDateTime getDataFim() {
        return dataFim;
    }

    public void setDataFim(LocalDateTime dataFim) {
        this.dataFim = dataFim;
    }

    @Override
    public String toString() {
        return "LeilaoDTO{" +
                "id=" + id +
                ", descricao='" + descricao + '\'' +
                ", valorInicial=" + valorInicial +
                ", dataInicio=" + dataInicio +
                ", dataFim=" + dataFim +
                '}';
    }
}
