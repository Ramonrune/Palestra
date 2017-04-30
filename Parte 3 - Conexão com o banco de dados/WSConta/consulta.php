<?php
header('Content-type: text/xml');

if (isset($_GET['q'])) {
    

    require_once('mysqli_connect.php');

    if (mysqli_connect_errno()) {
        printf("Conexão falhou: %s\n", mysqli_connect_error());

        exit();
    }

    $query = "SELECT * FROM conta WHERE numero = ". $_GET['q'];

    $xml = new SimpleXMLElement('<list/>');
    if ($resultado = $dbc->query($query)) {

        while ($obj = $resultado->fetch_object()) {

            $support = $xml->addChild('conta');
            $support->addChild('numero', $obj->numero);
            $support->addChild('cliente', $obj->cliente);
            $support->addChild('saldo', $obj->saldo);
            
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

    $query = "SELECT * FROM conta";

   
    $xml = new SimpleXMLElement('<list/>');
    if ($resultado = $dbc->query($query)) {

        while ($obj = $resultado->fetch_object()) {

            $support = $xml->addChild('conta');
            $support->addChild('numero', $obj->numero);
            $support->addChild('cliente', $obj->cliente);
            $support->addChild('saldo', $obj->saldo);
            
        }
    }


    print($xml->asXML());
}
?>