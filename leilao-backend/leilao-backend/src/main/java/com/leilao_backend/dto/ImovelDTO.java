package com.leilao_backend.dto;

public class ImovelDTO {

    private Long id;
    private String tipo; // "Apartamento" ou "Casa"
    private String endereco;
    private double valor;
    private String descricao;

    // Construtor padrão
    public ImovelDTO() {
    }

    // Construtor com todos os campos
    public ImovelDTO(Long id, String tipo, String endereco, double valor, String descricao) {
        this.id = id;
        this.tipo = tipo;
        this.endereco = endereco;
        this.valor = valor;
        this.descricao = descricao;
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "ImovelDTO{" +
                "id=" + id +
                ", tipo='" + tipo + '\'' +
                ", endereco='" + endereco + '\'' +
                ", valor=" + valor +
                ", descricao='" + descricao + '\'' +
                '}';
    }
}
