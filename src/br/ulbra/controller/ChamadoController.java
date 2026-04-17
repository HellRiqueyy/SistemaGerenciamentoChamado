/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ulbra.controller;

import br.ulbra.dao.ChamadoDAOImpl;
import br.ulbra.model.Chamado;
import br.ulbra.service.ChamadoService;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Henrique
 */
public class ChamadoController {

    private ChamadoService service;

    public ChamadoController() {
        this.service = new ChamadoService(new ChamadoDAOImpl());
    }

    public String cadastrar(Long id_usuario, Long id_equipamento,
            String problema_relatado, String diagnostico_tecnico, String prioridade,
            String status, Date data_abertura) {
        try {
            Chamado chamado = new Chamado();
            chamado.setId_usuario(id_usuario);
            chamado.setId_equipamento(id_equipamento);
            chamado.setProblemaRelatado(problema_relatado);
            chamado.setDiagnosticoTecnico(diagnostico_tecnico);
            chamado.setPrioridade(prioridade);
            chamado.setStatus(status);
            chamado.setDataAbertura(data_abertura);

            service.cadastrar(chamado);
            return "Chamado cadastrado com sucesso";

        } catch (Exception e) {
            return "Erro: " + e.getMessage();
        }
    }

    public List<Chamado> listar() {
        return service.listar();
    }

    public String atualizar(Long id, Long id_usuario, Long id_equipamento,
            String problema_relatado, String diagnostico_tecnico, String prioridade,
            String status, Date data_abertura) {
        try {
            Chamado chamado = new Chamado(id, id_usuario, id_equipamento,
                    problema_relatado, diagnostico_tecnico, prioridade,
                    status, data_abertura);
            service.atualizar(chamado);
            return "Atualizado com sucesso";
        } catch (Exception e) {
            return "Erro: " + e.getMessage();
        }
    }

    public String deletar(Long id) {
        try {
            service.deletar(id);
            return "Deletado com sucesso";
        } catch (Exception e) {
            return "Erro: " + e.getMessage();
        }
    }

}
