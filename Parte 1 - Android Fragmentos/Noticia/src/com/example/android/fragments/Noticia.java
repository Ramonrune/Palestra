package com.example.android.fragments;

/**
 * 
 * @author Ramon Lacava Gutierrez Gon�ales
 *
 *
 * Classe que possui as noticias que ser�o postadas.
 * Possui um cabe�alho e um artigo
 */
public class Noticia {

	/**
	 * T�tulo da noticia
	 */
    static String[] CABECALHO = {
        "Desenvolvimento IoT com Java 8 e Raspberry Pi",
        "Introdu��o aos Default Methods do Java 8"
    };

    /**
     * Artigo
     */
    static String[] ARTIGO = {
        "Desenvolvimento IoT com Java 8 e Raspberry Pi\n\nA Internet das Coisas � hoje uma das �reas mais estudadas por entusiastas de tecnologia da informa��o. Assim, al�m de estar presente em v�rios artigos, tem despertado o interesse de v�rias empresas do setor de tecnologia, como Google, Oracle, Qualcomm e Microsoft.",
        "Introdu��o aos Default Methods do Java 8\n\nNa Programa��o Orientada a Objetos em Java, quando utilizamos interfaces, � obrigat�rio adicionar os m�todos da mesma em cada classe que a implemente. Mesmo que um deles n�o precise executar nada, � necess�rio manter ao menos a sua assinatura na classe. Respeitando o contrato, chega um momento em que os m�todos implementados da interface em v�rias classes tornam-se id�nticos e repetitivos, levando o desenvolvedor a copiar e colar c�digo para ganhar tempo de codifica��o, replicando os m�todos iguais de uma classe para outra."
    };
}
