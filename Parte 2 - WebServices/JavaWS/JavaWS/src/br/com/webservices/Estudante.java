package br.com.webservices;
/**
 * @author Ramon Lacava Gutierrez Gonçales
 * @version 1.0.0
 * @date 07/10/2016 15:28:40
 * 
 * Classe feita para a obtenção de dados do estudante, juntamente
 * a manipulação dos mesmos.
 */
public class Estudante {
    private String primeiro_nome;
    private String ultimo_nome;
    private String email;
    private String estado;
    private String cidade; 
    private int id;
 
    /**
     * Construtor da classe
     * 
     * @param primeiro_nome
     * @param ultimo_nome
     * @param email
     * @param estado
     * @param cidade
     * @param id 
     */
    public Estudante(String primeiro_nome, String ultimo_nome,
            String email, String estado, String cidade, int id) {
        this.primeiro_nome = primeiro_nome;
        this.ultimo_nome = ultimo_nome;
        this.email = email;
        this.estado = estado;
        this.cidade = cidade;
        this.id = id;     
    }

    /**
     * @return o primeiro nome do estudante
     */
    public String getNome() {
        return primeiro_nome;
    }
    /**
     * @return o ultimo nome do estudante
     */
    public String getUltimo_nome() {
        return ultimo_nome;
    }
    /** 
     * @return o email do estudante 
     */
    public String getEmail() {
        return email;
    }
    /**
     * @return o estado 
     */
    public String getEstado() {
        return estado;
    }
    /**
     * @return a cidade
     */
    public String getCidade() {
        return cidade;
    }
    /**@return a id
     */
    public int getId() {
        return id;
    }
}
