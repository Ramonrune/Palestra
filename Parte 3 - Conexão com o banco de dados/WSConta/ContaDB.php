<?php

class ContaDB {

    public $numero = "";
    public $cliente = "";
    public $saldo = "";
    
    function __construct($numero, $cliente, $saldo) {
        $this->numero = $numero;
        $this->cliente = $cliente;
        $this->saldo = $saldo;
    }



}
?>

