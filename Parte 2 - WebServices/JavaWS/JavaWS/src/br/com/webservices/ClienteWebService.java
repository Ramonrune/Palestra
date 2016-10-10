package br.com.webservices;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;

import java.net.URL;
import java.util.List;

/**
 * @author Ramon Lacava Gutierrez Gonçales
 * @version 1.0.0
 * @date 07/10/2016 15:27:16
 */
public class ClienteWebService {

    private static final String CONSULTA_UM
            = "http://localhost/WebServices/XML/consulta.php?q=1";
    private static final String CONSULTA_VARIOS
            = "http://localhost/WebServices/XML/consulta.php";

    public List<Estudante> consulta(String URL_WEBSERVICE) {
        return getEstudantes(URL_WEBSERVICE);
    }

    public List<Estudante> getEstudantes(String URL_WEBSERVICE) {

        HttpURLConnection connection = null;

        try {
            URL url = new URL(URL_WEBSERVICE);

            connection = (HttpURLConnection) url.openConnection();

            InputStream content = connection.getInputStream();

            return new LeitorXML().carrega(content);

        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            connection.disconnect();
        }
    }

    public static void main(String args[]) {

        System.out.println("Lista de estudantes do Web Service:");
        List<Estudante> estudantes = new ClienteWebService().consulta(CONSULTA_VARIOS);

        for (Estudante estudante : estudantes) {
            System.out.println(estudante.getNome() + " - " + estudante.getUltimo_nome() + " - " + estudante.getEmail());
        }

        System.out.println("\n\nUm estudante do Web Service:");
        List<Estudante> umEstudante = new ClienteWebService().consulta(CONSULTA_UM);

        for (Estudante estudante : umEstudante) {
            System.out.println(estudante.getNome() + " - " + estudante.getUltimo_nome() + " - " + estudante.getEmail());
        }

    }
}
