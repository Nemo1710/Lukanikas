<?php
    include_once 'include/Config.php';
    include_once 'include/DbHandler.php';

    
    $db = new DbHandler();
    
    $apiKey = 'AIzaSyBGIqjd9oVz7eo6mxk-Cy0_0sftdRUA0nA';
   
     $uno=   $db->getGcm();
     echo '<pre>';        
        print_r ($uno);
        echo  '</pre>';
        echo "listo";
        
   /* $registrationIDs = array( "APA91bENqKVT-tyyHyaOEg94L7LLH-HfjFcvqWvxkiibctNqPMrJUGcE2W3ipA5Fa4Zng2uENwQ-yMSGt4XMasnipE_knkx3tg4LbWQ-J-fkDmZsg51-hWM3f8JAweuYQXm1hU2jtJl-Cdl3MldhzrGBqAt_rH1GhpeqekutOv15-oGVO53kO34
","APA91bHUavaPr-vwBdGvK5_nxFivqts1HRyRvTJ0GlZo4DhByIHclRdw0fPrHKfZk4E_yWmyaFUz-vCJhWki6eIXOHr0ThECOAtgkd0Aow51ROP2_Wle_75WeOHX_ozYcCudf1HT3hpYT2Gu2TFQyVZqIgJ0y7EUFOBUYeaiTcHLqK6fx4tGPFg");
    */
    $registrationIDs=$uno;    

    
    $url = 'https://android.googleapis.com/gcm/send';
    $fields = array(
        'registration_ids' => $registrationIDs,
        'data' => array( "tipo" => "palabra",
                         "id" => "3",
                         
            
            ),
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
    echo $result;
    print_r($result);
      


		
		
    
?>