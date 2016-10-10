/*
 * Direitos reservados a Ramon Lacava Gutierrez Gonçales
 * ramonrune@gmail.com
 */

package br.com.webcrawler.src.classes;

import javax.swing.JPanel;

/**
 * @author Ramon Lacava Gutierrez Gonçales
 * @version 1.0.0
 * @date 17/09/2016 13:46:07
 */
public interface Janela {
    public static void chamaPanelConteudo(JPanel auxPanel, JPanel remove) {
       
        remove.removeAll();
        javax.swing.GroupLayout painelPrincipalLayout = new javax.swing.GroupLayout(remove);
        remove.setLayout(painelPrincipalLayout);
        painelPrincipalLayout.setHorizontalGroup(
                painelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(auxPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        painelPrincipalLayout.setVerticalGroup(
                painelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(auxPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

    }
}
