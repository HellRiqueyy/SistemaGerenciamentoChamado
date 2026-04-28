/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ulbra.dao;

import br.ulbra.model.Chamado;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Henrique
 */
public class ChamadoDAOImpl implements ChamadoDAO {

    public void salvar(Chamado chamado) {
        String sql = "INSERT INTO chamado_tecnico (id_usuario, id_equipamento,"
                + "problema_relatado, diagnostico_tecnico, prioridade,"
                + "status, data_abertura) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = ConnectionFactory.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setLong(1, chamado.getId_usuario());
            stmt.setLong(2, chamado.getId_equipamento());
            stmt.setString(3, chamado.getProblemaRelatado());
            stmt.setString(4, chamado.getDiagnosticoTecnico());
            stmt.setString(5, chamado.getPrioridade());
            stmt.setString(6, chamado.getStatus());
            stmt.setDate(7, (Date) chamado.getDataAbertura());

            stmt.executeUpdate();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     *
     * @return
     */
    @Override
    public List<Chamado> listar() {
        String sql = "SELECT * FROM chamado_tecnico";
        List<Chamado> lista = new ArrayList<>();

        try (Connection conn = ConnectionFactory.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Chamado u = new Chamado(
                        rs.getLong("id"),
                        rs.getLong("id_usuario"),
                        rs.getLong("id_equipamento"),
                        rs.getString("problema_relatado"),
                        rs.getString("diagnostico_tecnico"),
                        rs.getString("prioridade"),
                        rs.getString("status"),
                        rs.getDate("data_abertura")
                );
                lista.add(u);
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return lista;
    }

    @Override
    public Chamado buscarPorId(Long id) {
        String sql = "SELECT * FROM chamado_tecnico WHERE id = ?";

        try (Connection conn = ConnectionFactory.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new Chamado(
                        rs.getLong("id"),
                        rs.getLong("id_usuario"),
                        rs.getLong("id_equipamento"),
                        rs.getString("problema_relatado"),
                        rs.getString("diagnostico_tecnico"),
                        rs.getString("prioridade"),
                        rs.getString("status"),
                        rs.getDate("data_abertura")
                );
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return null;
    }

    @Override
    public void atualizar(Chamado chamado) {
        String sql = "UPDATE chamado_tecnico SET id_usuario = ?, id_equipamento = ?, "
                + "problema_relatado = ?,"
                + "diagnostico_tecnico = ?, prioridade = ?,"
                + "status = ?, data_abertura = ? WHERE id = ?";

        try (Connection conn = ConnectionFactory.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setLong(1, chamado.getId_usuario());
            stmt.setLong(2, chamado.getId_equipamento());
            stmt.setString(3, chamado.getProblemaRelatado());
            stmt.setString(4, chamado.getDiagnosticoTecnico());
            stmt.setString(5, chamado.getPrioridade());
            stmt.setString(6, chamado.getStatus());
            stmt.setDate(7, (Date) chamado.getDataAbertura());
            stmt.setLong(8, chamado.getId());
            stmt.executeUpdate();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deletar(Long id) {
        String sql = "DELETE FROM chamado_tecnico WHERE id = ?";

        try (Connection conn = ConnectionFactory.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setLong(1, id);
            stmt.executeUpdate();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
