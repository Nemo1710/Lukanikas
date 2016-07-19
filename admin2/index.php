<!DOCTYPE html>
<html>
<?php
    
    include_once 'header.php';
    
?>
    <div id="wrapper">
        <nav class="navbar navbar-default navbar-cls-top " role="navigation" style="margin-bottom: 0">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".sidebar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                {{#link-to 'index' classNames='navbar-brand'}} Lukánikas {{/link-to}}
            </div>
  <div style="color: white;
padding: 15px 50px 5px 50px;
float: right;
font-size: 16px;">Hola <?php echo $_SESSION['carlos'] ?> <a href="http://lukanikas.intinnover.com/admin2/cerrar.php" class="btn btn-danger square-btn-adjust">Cerrar Sesión</a> </div>
        </nav>   
           <!-- /. NAV TOP  -->
                <nav class="navbar-default navbar-side" role="navigation">
            <div class="sidebar-collapse">
                <ul class="nav" id="main-menu">
				<li class="text-center">
                    <img src="assets/img/find_user.png" class="user-image img-responsive"/>
					</li>
				
					
                   
                    
                    <li>
                        {{#link-to 'index' classNames='active-menu'}}<i class="fa fa-dashboard fa-3x"></i> Escritorio{{/link-to}}
                    </li>
                     <li>
                        {{#link-to 'menu2' }}<i class="fa fa-desktop fa-3x"></i> General{{/link-to}}
                        
                    </li>
                    <li>
                        {{#link-to 'modulo1' }}<i class="fa fa-qrcode fa-3x"></i> Módulo 1{{/link-to}}
                        
                    </li>
	            <li>
                        {{#link-to 'modulo2' }}<i class="fa fa-bar-chart-o fa-3x"></i> Módulo 2{{/link-to}}
                        
                    </li>	
                    <li>
                        {{#link-to 'modulo3' }}<i class="fa fa-table fa-3x"></i> Módulo 3{{/link-to}}
                    </li>
                    <li>
                        {{#link-to 'modulo4' }}<i class="fa fa-table fa-3x"></i> Módulo 4{{/link-to}}
                    </li>
                    <li  >
                        <a  href="http://lukanikas.intinnover.com/admin2/index.php#/modulo3"><i class="fa fa-edit fa-3x"></i> Formularios </a>
                    </li>				
					
					                   
	
                </ul>
               
            </div>
            
        </nav>  
        <!-- /. NAV SIDE  -->
        <div id="page-wrapper" >
                {{outlet}}
             <!-- /. PAGE INNER  -->
            </div>
         <!-- /. PAGE WRAPPER  -->
        </div>



<?php
    include_once 'footer.php';
?>