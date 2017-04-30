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
 * @date 08/10/2016 21:35:37
 */
public class TestaExcluir {

    
    public static void main(String[] args) {
        
        ContaDao dao = new ContaDao();
        Conta conta = new Conta(10, "Ramon Lacava", 5000.00);
        dao.remove(conta);
    }
}
