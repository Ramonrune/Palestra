<?php

class EstudanteDB {

    public $primeiro_nome = "";
    public $ultimo_nome = "";
    public $email = "";
    public $rua = "";
    public $cidade = "";
    public $estado = "";
    public $zip;
    public $telefone;
    public $data_de_nascimento = "";
    public $sexo = "";
    public $data_entrou = "";
    public $custo_lanche;
    public $id_estudante;

    function __construct($primeiro_nome, $ultimo_nome, $email, $rua, $cidade, $estado, $zip, $telefone, $data_de_nascimento, $sexo, $data_entrou, $custo_lanche, $id_estudante) {
        $this->primeiro_nome = $primeiro_nome;
        $this->ultimo_nome = $ultimo_nome;
        $this->email = $email;
        $this->rua = $rua;
        $this->cidade = $cidade;
        $this->estado = $estado;
        $this->zip = $zip;
        $this->telefone = $telefone;
        $this->data_de_nascimento = $data_de_nascimento;
        $this->sexo = $sexo;
        $this->data_entrou = $data_entrou;
        $this->custo_lanche = $custo_lanche;
        $this->id_estudante = $id_estudante;
    }

}
?>

