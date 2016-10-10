<?php
header('Content-type: text/xml');

if (isset($_GET['q'])) {


    require_once('mysqli_connect.php');

    if (mysqli_connect_errno()) {
        printf("Conexão falhou: %s\n", mysqli_connect_error());

        exit();
    }

    $query = "SELECT * FROM estudante WHERE id_estudante = ". $_GET['q'];

    $estudante_array = array();
    $xml = new SimpleXMLElement('<list/>');
    if ($resultado = $dbc->query($query)) {

        while ($obj = $resultado->fetch_object()) {

            $support = $xml->addChild('estudante');
            $support->addChild('primeiro_nome', $obj->primeiro_nome);
            $support->addChild('ultimo_nome', $obj->ultimo_nome);
            $support->addChild('email', $obj->email);
            $support->addChild('cidade', $obj->cidade);
            $support->addChild('estado', $obj->estado);
            $support->addChild('id', $obj->id_estudante);
        }
    }


    print($xml->asXML());
}

else{
    require_once('mysqli_connect.php');

    if (mysqli_connect_errno()) {
        printf("Conexão falhou: %s\n", mysqli_connect_error());

        exit();
    }

    $query = "SELECT * FROM estudante";

    $estudante_array = array();
    $xml = new SimpleXMLElement('<list/>');
    if ($resultado = $dbc->query($query)) {

        while ($obj = $resultado->fetch_object()) {

           $support = $xml->addChild('estudante');
            $support->addChild('primeiro_nome', $obj->primeiro_nome);
            $support->addChild('ultimo_nome', $obj->ultimo_nome);
            $support->addChild('email', $obj->email);
            $support->addChild('cidade', $obj->cidade);
            $support->addChild('estado', $obj->estado);
            $support->addChild('id', $obj->id_estudante);
            
        }
    }


    print($xml->asXML());
}
?>