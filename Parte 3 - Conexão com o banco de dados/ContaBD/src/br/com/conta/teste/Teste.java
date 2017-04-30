package br.com.conta.teste;

/*
 * Direitos reservados a Ramon Lacava Gutierrez Gonçales
 * ramonrune@gmail.com
 */



import br.com.conta.factory.ConnectionFactory;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author Ramon Lacava Gutierrez Gonçales
 * @version 1.0.0
 * @date 08/10/2016 20:58:51
 */
public class Teste {

    public static void main(String[] args) throws SQLException {
        Connection connection = new ConnectionFactory().getConnection();
        System.out.println("Conexão aberta!");
        connection.close();
    }
}
