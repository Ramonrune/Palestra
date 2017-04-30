package br.com.conta.dao;

/*
 * Direitos reservados a Ramon Lacava Gutierrez Gonçales
 * ramonrune@gmail.com
 */
import br.com.conta.factory.ConnectionFactory;
import br.com.conta.modelo.Conta;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Ramon Lacava Gutierrez Gonçales
 * @version 1.0.0
 * @date 08/10/2016 21:02:24
 */
public class ContaDao {
// a conexão com o banco de dados

    private Connection connection;

    public ContaDao() {
        this.connection = new ConnectionFactory().getConnection();
    }

    public void adiciona(Conta conta) {
        String sql = "insert into conta values (?, ?, ?)";
        try {
            // prepared statement para inserção
            PreparedStatement stm = connection.prepareStatement(sql);

            // seta os valores
            stm.setInt(1, conta.getNumero());
            stm.setString(2, conta.getCliente());
            stm.setDouble(3, conta.getSaldo());

            // executa
            stm.execute();
            stm.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Conta> getLista() {
        try {
            List<Conta> contas = new ArrayList<Conta>();
            PreparedStatement stmt = this.connection.
                    prepareStatement("select * from conta");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                // criando o objeto Contato
                Conta conta = new Conta();
                conta.setNumero(rs.getInt("numero"));
                conta.setCliente(rs.getString("cliente"));
                conta.setSaldo(Double.parseDouble(rs.getString("saldo")));

                // adicionando o objeto à lista
                contas.add(conta);
            }
            rs.close();
            stmt.close();
            return contas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void altera(Conta conta) {
        String sql = "update conta set cliente=?, saldo=? where numero=?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, conta.getCliente());
            stmt.setDouble(2, conta.getSaldo());
            stmt.setInt(3, conta.getNumero());

            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void remove(Conta conta) {
        try {
            PreparedStatement stmt = connection.prepareStatement("delete "
                    + "from conta where numero=?");
            stmt.setInt(1, conta.getNumero());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void tranferir(Conta origem, Conta destino, double valor){

        if (origem.getSaldo() >= valor) {

            try {
                connection.setAutoCommit(false);

                
                /* SAQUE */
                origem.setSaldo(origem.getSaldo() - valor);
                altera(origem);

                /* DEPÓSITO */
                destino.setSaldo(destino.getSaldo() + valor);
                
                altera(destino);

                connection.commit();
            } catch (Exception e) {
                try {
                    connection.rollback();
                } catch (SQLException ex) {
                    System.err.println("Algo ocorreu errado");
                }
            }
        }

    }
}
