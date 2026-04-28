package br.ulbra.dao;

import br.ulbra.model.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.mindrot.jbcrypt.BCrypt;

public class UsuarioDAOImpl implements UsuarioDAO {

    public void salvar(Usuario usuario) {
        String sql = "INSERT INTO usuario (nome, cargo, email, senha) VALUES (?, ?, ?, ?)";

        try (Connection conn = ConnectionFactory.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getCargo());
            stmt.setString(3, usuario.getEmail());
            String senhaCriptografada = BCrypt.hashpw(usuario.getSenha(), BCrypt.gensalt());
            stmt.setString(4, senhaCriptografada);

            stmt.executeUpdate();

        } catch (Exception e) {
            throw new RuntimeException("ERRO AO SALVAR!\n" + e);
        }
    }

    /**
     *
     * @return
     */
    @Override
    public List<Usuario> listar() {
        String sql = "SELECT * FROM usuario";
        List<Usuario> lista = new ArrayList<>();

        try (Connection conn = ConnectionFactory.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Usuario u = new Usuario(
                        rs.getLong("id"),
                        rs.getString("nome"),
                        rs.getString("cargo"),
                        rs.getString("email"),
                        rs.getString("senha")
                );
                lista.add(u);
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return lista;
    }

    @Override
    public Usuario buscarPorId(Long id) {
        String sql = "SELECT * FROM usuario WHERE id = ?";

        try (Connection conn = ConnectionFactory.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new Usuario(
                        rs.getLong("id"),
                        rs.getString("nome"),
                        rs.getString("cargo"),
                        rs.getString("email"),
                        rs.getString("senha")
                );
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return null;
    }

    @Override
    public void atualizar(Usuario usuario) {
        String sql = "UPDATE usuario SET nome = ?, cargo = ?, email = ?, senha= ? WHERE id = ?";

        try (Connection conn = ConnectionFactory.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getCargo());
            stmt.setString(3, usuario.getEmail());
            stmt.setString(4, usuario.getSenha());
            stmt.setLong(5, usuario.getId());
            stmt.executeUpdate();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deletar(Long id) {
        String sql = "DELETE FROM usuario WHERE id = ?";

        try (Connection conn = ConnectionFactory.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setLong(1, id);
            stmt.executeUpdate();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Usuario logar(String email, String senhaDigitada) {
        // Buscamos apenas pelo e-mail, pois não podemos comparar o hash no SQL
        String sql = "SELECT * FROM usuario WHERE email = ?";

        try (Connection conn = ConnectionFactory.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, email);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    String senhaBanco = rs.getString("senha");

                    // COMPARAÇÃO SEGURA:
                    // O BCrypt verifica se a senha digitada bate com o hash salvo
                    if (BCrypt.checkpw(senhaDigitada, senhaBanco)) {
                        Usuario u = new Usuario();
                        u.setId(rs.getLong("id"));
                        u.setNome(rs.getString("nome"));
                        u.setEmail(rs.getString("email"));
                        return u;
                    }
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("Erro no login: " + e.getMessage());
        }
        return null; // Login falhou
    }

}
