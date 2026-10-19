package com.pegasus.agendamento.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity 
public class Agendamento {

    @Id @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String servico;
    private String profissional;
    private LocalDateTime dataHora;
    private String cliente;
    private LocalDateTime dataCriacao = LocalDateTime.now();
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getServico() {
        return servico;
    }
    public void setServico(String servico) {
        this.servico = servico;
    }
    public String getProfissional() {
        return profissional;
    }
    public void setProfissional(String profissional) {
        this.profissional = profissional;
    }
    public LocalDateTime getDataHora() {
        return dataHora;
    }
    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }
    public String getCliente() {
        return cliente;
    }
    public void setCliente(String cliente) {
        this.cliente = cliente;
    }
    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }
    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    
}
