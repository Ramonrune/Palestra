package br.com.webservices;

import java.io.InputStream;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import java.util.List;

/**
 * 
 * @author Ramon Lacava
 * 
 * Classe criada com o intuito de compreender a leitura de um arquivo XML
 */
public class LeitorXML {

    /**
     * 
     * @param inputStream
     * @return os elementos que foram mudados de XML para uma lista de estudantes.
     */
    public List<Estudante> carrega(InputStream inputStream) {

        XStream stream = new XStream(new DomDriver());
        
        stream.alias("estudante", Estudante.class);
        
        return (List<Estudante>) stream.fromXML(inputStream);
    }

}
