<?php

 require_once '../../../../rest/include/DbHandler.php';

    if(empty($_POST['valor1'])||
       empty($_POST['valor2'])||
       empty($_POST['valor3'])      
       ){
       echo "los valores estan mal ingresados";
       exit;
        
       }
    $db = new DbHandler();
    $res=$db->createPrototype(
            $_POST['valor1'],
            $_POST['valor2'],
            $_POST['valor3']        
            
            );
    
    if($res){
        echo "Se agrego correctamente";
    }else{
        echo "algo no salió bien";
    }