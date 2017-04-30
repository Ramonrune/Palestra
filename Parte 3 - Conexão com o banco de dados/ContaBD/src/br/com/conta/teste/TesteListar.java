/*
 * Direitos reservados a Ramon Lacava Gutierrez Gonçales
 * ramonrune@gmail.com
 */
package br.com.conta.teste;

import br.com.conta.dao.ContaDao;
import br.com.conta.modelo.Conta;
import java.util.List;

/**
 * @author Ramon Lacava Gutierrez Gonçales
 * @version 1.0.0
 * @date 08/10/2016 21:23:20
 */
public class TesteListar {
  
    public static void main(String args[]) {
        ContaDao dao = new ContaDao();
        List<Conta> contas = dao.getLista();
        for (Conta conta : contas) {
            System.out.println("Numero: " + conta.getNumero());
            System.out.println("Cliente: " + conta.getCliente());
            System.out.println("Saldo: " + conta.getSaldo());
           

        }

    }
}
