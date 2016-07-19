<?php
require_once '../../../../rest/include/DbHandler.php';

    if(empty($_POST['valor1']))      
       {
       echo "los valores estan mal ingresados";
       exit;
        
       }
    $db = new DbHandler();
    $res=$db->getWord($_POST['valor1']);
    $valor1='';
    foreach ($res as $valor) {
    $valor1 .= $valor .',';
        //echo $valor;
    }
    echo $valor1;
   
   
    
    