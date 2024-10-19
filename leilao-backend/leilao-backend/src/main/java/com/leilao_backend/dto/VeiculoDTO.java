package com.leilao_backend.dto;

public class VeiculoDTO {

    private Long id;
    private String tipo; // "Moto", "Carro", "Caminhão", "Ônibus"
    private String modelo;
    private String marca;
    private int ano;
    private double valor;
    private String descricao;
    private String placa; // Adicionado para armazenar a placa do veículo

    // Construtor padrão
    public VeiculoDTO() {
    }

    // Construtor com todos os campos
    public VeiculoDTO(Long id, String tipo, String modelo, String marca, int ano, double valor, String descricao, String placa) {
        this.id = id;
        this.tipo = tipo;
        this.modelo = modelo;
        this.marca = marca;
        this.ano = ano;
        this.valor = valor;
        this.descricao = descricao;
        this.placa = placa; // Inicializa a placa
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

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
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

    public String getPlaca() {
        return placa; // Retorna a placa do veículo
    }

    public void setPlaca(String placa) {
        this.placa = placa; // Define a placa do veículo
    }

    @Override
    public String toString() {
        return "VeiculoDTO{" +
                "id=" + id +
                ", tipo='" + tipo + '\'' +
                ", modelo='" + modelo + '\'' +
                ", marca='" + marca + '\'' +
                ", ano=" + ano +
                ", valor=" + valor +
                ", descricao='" + descricao + '\'' +
                ", placa='" + placa + '\'' + // Inclui a placa na representação em string
                '}';
    }
}
