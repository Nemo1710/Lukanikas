<?php
require_once '../../../../rest/include/DbHandler.php';

    if(empty($_POST['mensaje']))      
       {
       echo "los valores estan mal ingresados";
       exit;
        
       }
    $db = new DbHandler();
    $res=$db->createSecuence($_POST['mensaje']);
    if($res==true){
        echo "tu secuencia se inserto correctamente";
    }else{
        echo "BBB Bale Berga la Bida";
    }
    

   