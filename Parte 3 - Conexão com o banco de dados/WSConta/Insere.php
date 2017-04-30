<?php
if (isset($_GET['numero']) && isset($_GET['cliente']) && isset($_GET['saldo']) ) {
    
    echo $_GET['numero'];
    echo $_GET['cliente'];
    echo $_GET['saldo'];

    require_once('mysqli_connect.php');

    if (mysqli_connect_errno()) {
        printf("Conexão falhou: %s\n", mysqli_connect_error());

        exit();
    }

    $query = "INSERT INTO conta values (". $_GET['numero']  . ", '" . $_GET['cliente'] . "', ". $_GET['saldo'] . ")"; 
    
    mysqli_query($dbc, $query) or die(mysqli_error($dbc));
    
   

       

}

