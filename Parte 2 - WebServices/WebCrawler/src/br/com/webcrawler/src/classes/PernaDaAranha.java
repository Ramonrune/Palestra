/*
 * Direitos reservados a Ramon Lacava Gutierrez Gonçales
 * ramonrune@gmail.com
 */
package br.com.webcrawler.src.classes;

import br.com.webcrawler.src.main.PesquisaPanel;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

/**
 * @author Ramon Lacava Gutierrez Gonçales
 * @version 1.0.0
 * @date 17/09/2016 12:05:16
 */
public class PernaDaAranha {

    /**
     * Faz o servidor web pensar que o robo é um navegador comum
     */
    private static final String USUARIO = "Mozilla/5.0 (Windows NT 6.1; WOW64) "
            + "AppleWebKit/535.1 (KHTML, like Gecko) Chrome/13.0.782.112 Safari/535.1";

    /**
     * Lista de Links
     */
    private List<String> links = new LinkedList<String>();
    /**
     * Representa o documento HTML
     */
    private Document documentoHTML;

    public boolean testaConexao(String url) {

        /**
         * Tenta se conectar com as páginas.
         */
        try {

            /**
             * Cria a conexão com a página usando a url e o agente USUARIO.
             */
            Connection connection
                    = Jsoup.connect(url).userAgent(USUARIO);

            /**
             * Obtem o documento HTML pela conexão.
             */
            Document documentoHTML = connection.get();

            /**
             * O documento atual da página recebe o documento obtido.
             */
            this.documentoHTML = documentoHTML;

            /**
             * Se a resposta do código de status for igual a 200, o que
             * significa que tudo está bem, será mostrado que a página está
             * sendo recebida.
             */
            if (connection.response().statusCode() == 200) {
                return true;
            } else {
                return false;
            }

        } /**
         * Pega as exceções de input output lançadas.
         */
        catch (IOException ioe) {
            /**
             * Retorna falso.
             */
            return false;
        } catch (IllegalArgumentException e) {
            return false;
        } catch (IndexOutOfBoundsException ioobe) {
            return false;
        }

    }

    /**
     *
     * Método que faz a requisição HTTP, checa a resposta e pega todos os links
     * das páginas Faz a pesquisa da palavra depois de andar com sucesso.
     *
     * @param url A url que será visitada
     * @return Se o andar foi bem sucedido
     */
    public boolean andar(String url) {//iniciaAndar

        /**
         * Tenta se conectar com as páginas.
         */
        try {

            /**
             * Cria a conexão com a página usando a url e o agente USUARIO.
             */
            Connection connection
                    = Jsoup.connect(url).userAgent(USUARIO);

            /**
             * Obtem o documento HTML pela conexão.
             */
            Document documentoHTML = connection.get();

            /**
             * O documento atual da página recebe o documento obtido.
             */
            this.documentoHTML = documentoHTML;

            /**
             * Se a resposta do código de status for igual a 200, o que
             * significa que tudo está bem, será mostrado que a página está
             * sendo recebida.
             */
            if (connection.response().statusCode() == 200) {
                PesquisaPanel.setTexto("\n\nVisitando - Recebendo a página em " + url);
            }

            /**
             * Se o tipo do conteudo for diferente de text/html Ocorrerá uma
             * falha e será retornado falso ao método.
             *
             */
            if (!connection.response().contentType().contains("text/html")) {
                PesquisaPanel.setTexto("Falha - Recebeu algo alem de HTML");
                return false;
            }

            /**
             * Seleciona os elementos com a tag de <a>Links</a>.
             *
             */
            Elements linksNaPagina = documentoHTML.select("a[href]");

            /**
             * Mostra quantos links foram encontrados na página.
             */
            //linksNaPagina.forEach(i -> PesquisaPanel.setTexto(i.text()));
            PesquisaPanel.setTexto("Encontrou " + linksNaPagina.size() + " links");

            /**
             * Adiciona a url a lista e links utilizando a expressão lambda a
             * partir da versão do java 1.8.
             *
             * @since 1.8
             */
            linksNaPagina.forEach(i -> this.links.add(i.absUrl("href")));

            /**
             * Retorna verdadeiro
             */
            return true;

        } /**
         * Pega as exceções de input output lançadas.
         */
        catch (IOException ioe) {
            /**
             * Retorna falso.
             */
            return false;
        } catch (IllegalArgumentException e) {
            return false;
        } catch (IndexOutOfBoundsException ioobe) {
            return false;
        }
    }//fimAndar

    /**
     *
     * Faz a pesquisa pelo corpo do documento HTML que é recebido. Esse método
     * será chamado apenas depois que o método andar seja recebido com sucesso.
     *
     *
     * @param palavraASerPesquisada A palavra que será pesquisada.
     * @return se a palavra foi ou não encontrada.
     */
    public boolean pesquisarPorPalavra(String palavraASerPesquisada) {
        try {
            /**
             * Codigo que deve ser apenas usado depois do método andar() ter
             * sido executado com sucesso.
             */
            if (this.documentoHTML == null) {

                PesquisaPanel.setTexto("Erro - Chame andar() antes de fazer a análise do documento.");

                return false;
            }

            /**
             * Informa que a palavra está sendo pesquisada
             */
            PesquisaPanel.setTexto("Procurando pela palavra " + palavraASerPesquisada + " .");

            /**
             * Obtem o corpo do documento html
             */
            String corpoTexto = this.documentoHTML.body().text();

            /**
             * Retorna se o corpo do texto contem a palavra a ser pesquisada.
             * Obs: O corpo do texto e a palavra a ser pesquisada são
             * transformados em letras minusculas.
             */
            return corpoTexto.toLowerCase().contains(palavraASerPesquisada.toLowerCase());
        } catch (java.lang.NullPointerException e) {
            return false;
        }
    }

    /**
     * Retorna a lista de Links.
     *
     * @return A lista de Links.
     */
    public List<String> getLinks() {
        return this.links;
    }

}
