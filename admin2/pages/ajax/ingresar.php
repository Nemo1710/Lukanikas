<?php

 require_once '../../../../rest/include/DbHandler.php';

    if(empty($_POST['valor1'])||
       empty($_POST['valor2'])||
       empty($_POST['valor3'])||
       empty($_POST['valor4'])||
       empty($_POST['valor5'])||
       empty($_POST['valor6'])||
       empty($_POST['valor7'])      
       ){
       echo "los valores estan mal ingresados";
       exit;
        
       }
    $db = new DbHandler();
    $res=$db->createWord(
            $_POST['valor1'],
            $_POST['valor2'],
            $_POST['valor3'],
            $_POST['valor4'],
            $_POST['valor5'],
            $_POST['valor6'],
            $_POST['valor7']
            
            
            );
    
    if($res){
        echo "Se agrego correctamente";
    }else{
        echo "algo no salió bien";
    }