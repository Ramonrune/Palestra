<?php

header('Content-Type: application/json');

if (isset($_GET['q'])) {

    require 'EstudanteDB.php';
    require_once('mysqli_connect.php');

    if (mysqli_connect_errno()) {
        printf("Conexão falhou: %s\n", mysqli_connect_error());

        exit();
    }

    $query = "SELECT * FROM estudante WHERE id_estudante = ". $_GET['q'];

    
    $estudante_array = array();
 
    if ($resultado = $dbc->query($query)) {

        while ($obj = $resultado->fetch_object()) {   
            
            /*
               printf("%s %s %s %s %s %s %s %s %s %s %s %s %s <br />",
		$obj->primeiro_nome, $obj->ultimo_nome, $obj->email,
		$obj->rua, $obj->cidade, $obj->estado, $obj->zip,
		$obj->telefone, $obj->data_nascimento, $obj->sexo, 
		$obj->data_entrou, $obj->custo_lanche, $obj->id_estudante);
		*/
		$estudante_temporario = new EstudanteDB($obj->primeiro_nome, 
		$obj->ultimo_nome, $obj->email, $obj->rua,
		$obj->cidade, $obj->estado, $obj->zip, $obj->telefone, 
		$obj->data_nascimento, $obj->sexo, $obj->data_entrou, 
		$obj->custo_lanche, $obj->id_estudante);
		
		$estudante_array[] = $estudante_temporario;
	
           
        }
    }


	echo '{"estudantes":[';
	
	
	$dados = json_encode($estudante_array[0]);
	echo $dados;
	
	
	
	echo ']};';

	$resultado->close();
	$dbc->close();
}


?>