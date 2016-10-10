/*
 * Direitos reservados a Ramon Lacava Gutierrez Gonçales
 * ramonrune@gmail.com
 */
package br.com.webcrawler.src.classes;

import br.com.webcrawler.src.main.PesquisaPanel;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import javax.swing.JOptionPane;

/**
 * @author Ramon Lacava Gutierrez Gonçales
 * @version 1.0.0
 * @date 17/09/2016 11:28:52
 */
public class Aranha {

    /**
     *
     * Quantidade máxima de páginas que podem ser pesquisadas pelo Web Crawler
     */
    private static final int MAXIMO_DE_PAGINAS_PARA_PROCURAR = Integer.MAX_VALUE;
   
    /**
     * Páginas que já foram visitadas, sendo acumuladas por um HashSet
     */
    private Set<String> paginasVisitadas = new HashSet<String>();

    /**
     * Páginas que irão ser visitadas
     */
    private List<String> paginasParaVisitar = new LinkedList<String>();

    /**
     *
     * Método de pesquisa que faz uma requisição http e mostra a resposta
     *
     * @param url A página inicial que será pesquisada
     *
     * @param palavra A palavra que está sendo procurada
     */
    public void procurar(String url, String palavra) {//inicoProcurar
        if (!url.isEmpty()) {
            /**
             * Enquanto o tamanho das páginas for menor que o máximo de páginas
             * possiveis a serem pesquisadas
             */
            while (this.paginasVisitadas.size() < MAXIMO_DE_PAGINAS_PARA_PROCURAR) {//inicioWhile

                /**
                 * Variaveis da url atual.
                 */
              
                String urlAtual = null;

                /**
                 * Instancia/ cria uma nova perna da aranha.
                 */
                PernaDaAranha perna = new PernaDaAranha();

                /**
                 * Se as páginas para serem visitadas estiverem vazias
                 */
                if (this.paginasParaVisitar.isEmpty()) {

                    /**
                     * A url atual recebe a url passada
                     */
                    urlAtual = url;
                    
                    /**
                     * É adicionado a url a lista de páginas para visitar
                     */
                    this.paginasParaVisitar.add(url);
                }//caso contrário
                else if (!this.proximaUrl().toString().isEmpty()) {
                    urlAtual = this.proximaUrl();
                   
                }

                /**
                 * @see PernaDaAranha
                 */
                perna.andar(urlAtual);

                /**
                 *
                 * Pesquisa pela palavra
                 *
                 * @see PernaDaAranha
                 *
                 */
                boolean sucesso = perna.pesquisarPorPalavra(palavra);

                /**
                 * Se for bem sucedido
                 */
                if (sucesso) {
                    /**
                     * Mostra que a palavra foi encontrada e pausa
                     */
                    PesquisaPanel.setTexto((String.format("Sucesso - palavra %s foi encontrada em %s", palavra, urlAtual)));
                    PesquisaPanel.setEncontrado((String.format("Sucesso - palavra %s foi encontrada em %s", palavra, urlAtual)));
                    break;
                }

                /**
                 * Pega os links da perna da aranha e adiciona as páginas que
                 * devem ser visitadas.
                 */
                this.paginasParaVisitar.addAll(perna.getLinks());

            }//fimWhile

            PesquisaPanel.setTexto("\nPronto - Visitou " + this.paginasVisitadas.size() + " página(s) web");
        }
    }//fimProcurar

    /**
     *
     * Retorna a próxima url para visitar na ordem em que ela foi encontrada.
     * Esse método não retorna uma url que já foi visitada.
     *
     * @return a proxima url.
     */
    private String proximaUrl() {
        /**
         * Declara a proxima url.
         */
        String proximaUrl = null;

        /**
         * Obtem a proxima url das páginas para digitar.
         */
        try {
            do {

                proximaUrl = this.paginasParaVisitar.remove(0);

                /**
                 * Enquanto as páginas visitadas possuirem a proxima url.
                 */
            } while (this.paginasVisitadas.contains(proximaUrl));
            /**
             * Adiciona as páginas visitadas a próxima URL.
             */
            this.paginasVisitadas.add(proximaUrl);
        } catch (IndexOutOfBoundsException ie) {
            
        }

        /**
         * Retorna a próxima url.
         */
        return proximaUrl;
    }

}
