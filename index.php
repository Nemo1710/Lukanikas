<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <meta charset="UTF-8">
        <title></title>
    </head>
    <body>
        <?php
        session_start();
        
        if(isset($_SESSION['carlos'])){
          
           
          $url="http://lukanikas.intinnover.com/admin2/index.php"; 
          echo "<SCRIPT>window.location='$url';</SCRIPT>"; 
        }else{
          
           $url="http://lukanikas.intinnover.com/login/index.php"; 
          echo "<SCRIPT>window.location='$url';</SCRIPT>"; 
        }
        ?>
    </body>
</html>
