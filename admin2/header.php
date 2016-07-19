<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
      <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Lukánikas - Panel de administración</title>
	<!-- BOOTSTRAP STYLES-->
    <link href="assets/css/bootstrap.css" rel="stylesheet" />
     <!-- FONTAWESOME STYLES-->
    <link href="assets/css/font-awesome.css" rel="stylesheet" />
     <!-- MORRIS CHART STYLES-->
    <link href="assets/js/morris/morris-0.4.3.min.css" rel="stylesheet" />
        <!-- CUSTOM STYLES-->
    <link href="assets/css/custom.css" rel="stylesheet" />
     <!-- GOOGLE FONTS-->
   <link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css' />
   
</head>
<body>
    <?php
    session_start();
    if(isset($_SESSION['carlos'])){
        require_once '../../rest/include/DbHandler.php';
                                $db=new DbHandler();
    }else{
        
        
        echo '<div class="container">
          <div class="jumbotron">
            <h1>Debes autenticarte para ingresar aquí</h1> 
            <a href="http://lukanikas.intinnover.com/">Inicia sesión</a>
          </div>

          <p>Carlos Venegas</p> 
          <p>Richard Córdova</p> 
        </div>';
        exit;
    }
    ?>
    <script type="text/x-handlebars">
     