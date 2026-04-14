/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ulbra.service;

import br.ulbra.dao.ChamadoDAO;
import br.ulbra.model.Chamado;
import java.util.List;

/**
 *
 * @author Henrique
 */
public class ChamadoService {

    private ChamadoDAO dao;

    public ChamadoService(ChamadoDAO dao) {
        this.dao = dao;
    }

    public void cadastrar(Chamado chamado) {
        dao.salvar(chamado);
    }

    public List<Chamado> listar() {
        return dao.listar();
    }

    public void atualizar(Chamado chamado) {
        dao.atualizar(chamado);
    }

    public void deletar(Long id) {
        dao.deletar(id);
    }

    public Chamado buscar(Long id) {
        return dao.buscarPorId(id);
    }

}
