<?php
 require_once '../../../../rest/include/DbHandler.php';

    
    $db = new DbHandler();
    $apiKey = 'AIzaSyBGIqjd9oVz7eo6mxk-Cy0_0sftdRUA0nA';
    $uno=   $db->getGcm();
    /*
    echo '<pre>';        
    print_r ($uno);
    echo  '</pre>';
    */
    if(empty($_POST['valorCaja1'])){
        echo "Ingresa valores correctos";
        exit;
    }
    $id = $_POST['valorCaja1'];
    
    $sql = explode(",",$id);  
    
    
    $registrationIDs=$uno;    
    $url = 'https://android.googleapis.com/gcm/send';
    $fields = array(
        'registration_ids' => $registrationIDs,
        'data' => array( "tipo" => "prototipo",
                         "id" => $id
                        )
                    );
    $headers = array(
        'Authorization: key=' . $apiKey,
        'Content-Type: application/json'
                    );
    $ch = curl_init();
    curl_setopt( $ch, CURLOPT_URL, $url);
    curl_setopt( $ch, CURLOPT_POST, true);
    curl_setopt( $ch, CURLOPT_HTTPHEADER, $headers);
    curl_setopt( $ch, CURLOPT_RETURNTRANSFER, true);
    curl_setopt( $ch, CURLOPT_POSTFIELDS, json_encode( $fields));
    curl_setopt( $ch, CURLOPT_SSL_VERIFYHOST, false);
    curl_setopt( $ch, CURLOPT_SSL_VERIFYPEER, false);
    $result = curl_exec($ch);
    curl_close($ch);
    //echo $result;
    $obj = json_decode($result);
    $total=$obj->{'success'}; // 12345
    //print_r($result);
    if(sizeof($uno)==$total){
       echo "Se envió correctamente las palabras: total ".sizeof($sql); 
    }else{
       echo "No se envió a todos los dispositivos"; 
    }
      
     
    /*$resultado = $_POST['valorCaja1'];
    echo $resultado;
    */
?>
