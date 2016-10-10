package com.example.android.fragments;

/**
 * 
 * @author Ramon Lacava Gutierrez Gonçales
 *
 *
 * Classe que possui as noticias que serão postadas.
 * Possui um cabeçalho e um artigo
 */
public class Noticia {

	/**
	 * Título da noticia
	 */
    static String[] CABECALHO = {
        "Desenvolvimento IoT com Java 8 e Raspberry Pi",
        "Introdução aos Default Methods do Java 8"
    };

    /**
     * Artigo
     */
    static String[] ARTIGO = {
        "Desenvolvimento IoT com Java 8 e Raspberry Pi\n\nA Internet das Coisas é hoje uma das áreas mais estudadas por entusiastas de tecnologia da informação. Assim, além de estar presente em vários artigos, tem despertado o interesse de várias empresas do setor de tecnologia, como Google, Oracle, Qualcomm e Microsoft.",
        "Introdução aos Default Methods do Java 8\n\nNa Programação Orientada a Objetos em Java, quando utilizamos interfaces, é obrigatório adicionar os métodos da mesma em cada classe que a implemente. Mesmo que um deles não precise executar nada, é necessário manter ao menos a sua assinatura na classe. Respeitando o contrato, chega um momento em que os métodos implementados da interface em várias classes tornam-se idênticos e repetitivos, levando o desenvolvedor a copiar e colar código para ganhar tempo de codificação, replicando os métodos iguais de uma classe para outra."
    };
}
