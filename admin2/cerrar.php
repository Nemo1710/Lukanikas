<?php
session_start();
session_unset();

session_destroy();
 
 
$url="http://lukanikas.intinnover.com/"; 
echo "<SCRIPT>window.location='$url';</SCRIPT>";
