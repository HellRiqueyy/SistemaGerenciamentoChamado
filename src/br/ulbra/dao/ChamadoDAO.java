/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ulbra.dao;

import br.ulbra.model.Chamado;
import java.util.List;

/**
 *
 * @author Henrique
 */
public interface ChamadoDAO {

    void salvar(Chamado chamado);

    List<Chamado> listar();

    Chamado buscarPorId(Long id);

    void atualizar(Chamado chamado);

    void deletar(Long id);
}
