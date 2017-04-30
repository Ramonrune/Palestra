/*
 * Direitos reservados a Ramon Lacava Gutierrez Gonçales
 * ramonrune@gmail.com
 */
package br.com.conta.teste;

import br.com.conta.dao.ContaDao;
import br.com.conta.modelo.Conta;

/**
 * @author Ramon Lacava Gutierrez Gonçales
 * @version 1.0.0
 * @date 08/10/2016 21:12:40
 */
public class TestaAdicionar {

    public static void main(String[] args) {
        Conta conta = new Conta(10, "Ramon", 2000.00);
        ContaDao dao = new ContaDao();

        dao.adiciona(conta);

        System.out.println("Gravado!");

    }
}
