/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ulbra.model;

import java.util.Date;

/**
 *
 * @author Henrique
 */
public class Chamado {

    private Long id;
    private Long id_usuario;
    private Long id_equipamento;
    private String problemaRelatado;
    private String diagnosticoTecnico;
    private String prioridade;
    private String status;
    private Date dataAbertura;

    public Chamado() {
    }

    public Chamado(Long id, Long id_usuario, Long id_equipamento, String problemaRelatado, String diagnosticoTecnico, String prioridade, String status, Date dataAbertura) {
        this.id = id;
        this.id_usuario = id_usuario;
        this.id_equipamento = id_equipamento;
        this.problemaRelatado = problemaRelatado;
        this.diagnosticoTecnico = diagnosticoTecnico;
        this.prioridade = prioridade;
        this.status = status;
        this.dataAbertura = dataAbertura;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Long id_usuario) {
        this.id_usuario = id_usuario;
    }

    public Long getId_equipamento() {
        return id_equipamento;
    }

    public void setId_equipamento(Long id_equipamento) {
        this.id_equipamento = id_equipamento;
    }

    public String getProblemaRelatado() {
        return problemaRelatado;
    }

    public void setProblemaRelatado(String problemaRelatado) {
        this.problemaRelatado = problemaRelatado;
    }

    public String getDiagnosticoTecnico() {
        return diagnosticoTecnico;
    }

    public void setDiagnosticoTecnico(String diagnosticoTecnico) {
        this.diagnosticoTecnico = diagnosticoTecnico;
    }

    public String getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(String prioridade) {
        this.prioridade = prioridade;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(Date dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    @Override
    public String toString() {
        return "Chamado{" + "id=" + id + ", id_usuario=" + id_usuario + ", id_equipamento=" + id_equipamento + ", problemaRelatado=" + problemaRelatado + ", diagnosticoTecnico=" + diagnosticoTecnico + ", prioridade=" + prioridade + ", status=" + status + ", dataAbertura=" + dataAbertura + '}';
    }

}
