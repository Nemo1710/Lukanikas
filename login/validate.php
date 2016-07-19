<?php
//require_once '../rest/include/DbHandler.php';
require_once '../../rest/include/DbHandler.php';
$username= $_POST['username'];
$password= $_POST['password'];
if( empty($_POST['username']) && empty($_POST['password'])){
    $url="http://lukanikas.intinnover.com/login/"; 
    echo "<SCRIPT>window.location='$url';</SCRIPT>";


}else{
    
    $acceso=new DbHandler();
    $res=$acceso->checkLogin($username,$password);

    if(strcmp($res,"fail")==0){
        $url="http://lukanikas.intinnover.com/login/error.php"; 
        echo "<SCRIPT>window.location='$url';</SCRIPT>";
    }else{
        session_start();
        $_SESSION['carlos']=$res;
        $url="http://lukanikas.intinnover.com/admin2/"; 
        echo "<SCRIPT>window.location='$url';</SCRIPT>";
    }
    
}

