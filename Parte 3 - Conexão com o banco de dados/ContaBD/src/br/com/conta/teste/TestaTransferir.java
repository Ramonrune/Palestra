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
 * @date 08/10/2016 21:40:12
 */
public class TestaTransferir {

    
    public static void main(String[] args) {
        
        
        ContaDao dao = new ContaDao();
        Conta conta1 = new Conta(20, "Pessoa 11111", 2000.00);
        Conta conta2 = new Conta(40, "Pessoa 22222", 100.00);
        dao.adiciona(conta1);
        dao.adiciona(conta2);
        
        
        System.out.println("===============Antes da transferência===========");
        List<Conta> contas = dao.getLista();
        for (Conta conta : contas) {
            System.out.println("Numero: " + conta.getNumero());
            System.out.println("Cliente: " + conta.getCliente());
            System.out.println("Saldo: " + conta.getSaldo());
           

        }
        
        dao.tranferir(conta1, conta2, 500);
        System.out.println("===============Depois da transferência===========");
       
        List<Conta> contas1 = dao.getLista();
        for (Conta conta : contas1) {
            System.out.println("Numero: " + conta.getNumero());
            System.out.println("Cliente: " + conta.getCliente());
            System.out.println("Saldo: " + conta.getSaldo());
           

        }
    }
}
