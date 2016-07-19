<?php echo '<script type="text/x-handlebars" id="modulo3">' ?>
               
                <div id="page-inner">
                <div class="row">
                    <div class="col-md-12">
                     <h2>Módulo 3</h2>   
                        
                    </div>
                </div> 
                <div class="col-md-12">
                     <p class="text-center">Ingrese la secuencia que desee</p>   
                        
                </div> 
                <hr />        
                <div class="row">
                    <div class="col-md-4 col-sm-4 col-xs-4 center-block">
                        <div id="bot1">
                        <button type="button" id="bott1" class="btn btn-default btn-circle center-block"><i class="fa fa-check"></i>
                        
                        </button>
                        </div>    
                    </div>
                    <div class="col-md-4 col-sm-4 col-xs-4 center-block">
                        <div id="bot2">
                        <button type="button" class="btn btn-default btn-circle center-block"><i class="fa fa-check"></i>
                        
                        </button>
                        </div> 
                    </div>
                    <div class="col-md-4 col-sm-4 col-xs-4 center-block">
                        <div id="bot3">
                        <button type="button" class="btn btn-default btn-circle center-block"><i class="fa fa-check"></i>
                        
                        </button>
                        </div> 
                    </div>
                </div>    
                    <hr />
                <div class="row">   
                    <div class="col-md-4 col-sm-4 col-xs-4 center-block">
                        <div id="bot4">
                        <button type="button" class="btn btn-default btn-circle center-block"><i class="fa fa-check"></i>
                        
                        </button>
                        </div> 
                    </div>
                    <div class="col-md-4 col-sm-4 col-xs-4 center-block">
                        <div id="bot5">
                        <button type="button" class="btn btn-default btn-circle center-block"><i class="fa fa-check"></i>
                        
                        </button>
                        </div> 
                    </div>
                    <div class="col-md-4 col-sm-4 col-xs-4 center-block">
                        <div id="bot6">
                        <button type="button" class="btn btn-default btn-circle center-block"><i class="fa fa-check"></i>
                        
                        </button>
                        </div> 
                    </div> 
                </div> 
                    <hr />
                <div class="row">   
                    <div class="col-md-4 col-sm-4 col-xs-4 center-block">
                        <div id="bot7">
                        <button type="button" class="btn btn-default btn-circle center-block"><i class="fa fa-check"></i>
                        
                        </button>
                        </div> 
                    </div>
                    <div class="col-md-4 col-sm-4 col-xs-4 center-block">
                        <div id="bot8">
                        <button type="button" class="btn btn-default btn-circle center-block"><i class="fa fa-check"></i>
                        
                        </button>
                        </div> 
                    </div>
                    <div class="col-md-4 col-sm-4 col-xs-4 center-block">
                        <div id="bot9">
                        <button type="button" class="btn btn-default btn-circle center-block"><i class="fa fa-check"></i>
                        
                        </button>
                        </div> 
                    </div> 
                </div>
                    
                <hr />
                <div class="row"> 
                    <div class="col-md-12 col-sm-12 col-xs-12 center-block">
                        <div class="btn-group center-block">
                         <button type="button" id="enviars" class="btn btn-success btn-lg">Enviar</button>
                         <button type="button" id="limpiars" class="btn btn-success btn-lg">Limpiar</button>
                         <span id="retorno6"></span>
                            
                        <input type="hidden" name="country" id="btn1" value="0">
                        <input type="hidden" name="country" id="btn2" value="0">
                        <input type="hidden" name="country" id="btn3" value="0">
                        <input type="hidden" name="country" id="btn4" value="0">
                        <input type="hidden" name="country" id="btn5" value="0">
                        <input type="hidden" name="country" id="btn6" value="0">
                        <input type="hidden" name="country" id="btn7" value="0">
                        <input type="hidden" name="country" id="btn8" value="0">
                        <input type="hidden" name="country" id="btn9" value="0">
                        <input type="hidden" name="country" id="btn10" value="0">
                        <input type="hidden" name="country" id="btn11" value="0">
                        <input type="hidden" name="country" id="btn12" value="0">
                        <input type="hidden" name="country" id="btn13" value="0">
                        <input type="hidden" name="country" id="btn14" value="0">
                        <input type="hidden" name="country" id="btn15" value="0">
                        <input type="hidden" name="country" id="btn16" value="0">
                        <input type="hidden" name="country" id="btn17" value="0">
                        <input type="hidden" name="country" id="btn18" value="0">
                        
                        
                        
                      </div>
                    </div>     
                </div>
                <hr />
                 <!-- /. ROW  -->
                 <?php
                                
                                $a = $db->getAllSecuences();
                               
                                ?>
                <div class="row">
                    <div class="col-md-12 col-sm-12 col-xs-12">
                   
                    <div class="chat-panel panel panel-default chat-boder chat-panel-head" >
                        <div class="panel-heading">
                            <i class="fa fa-comments fa-fw"></i>
                            Palabras en el Sistema

                        </div>

                            <div class="panel-body">
                                <div class="table-responsive">
                                    <table class="table table-striped table-bordered table-hover">
                                        <thead>
                                            <tr>
                                                <th>id</th>
                                                <th>Secuencia codificada</th>
                                                
                                                 
                                            </tr>
                                        </thead>
                                        <?php
                                        $b='<tbody>';
                                        for($i=0;$i<sizeof($a);$i++){
                                            $b .='<tr>'.
                                                    '<td>'.$a[$i]['id']. '</td>'.
                                                    '<td>'.$a[$i]['palabra1']. '</td>'.
                                                    
                                                  '</tr>';
                                            
                                            
                                        }
                                        $b.='</tbody>';
                                        echo $b;
                                        ?>
                                        
                                    </table>
                                </div>
                            </div>

                        

                    </div>
                    
                </div>

                </div>      
                
                 <!-- /. ROW  -->
                <hr /> 

                 <hr /> 
		 <div class="row">
                    
                    <div class="col-md-6 col-sm-12 col-xs-12">      
				<div class="panel panel-default">
                        <div class="panel-heading">
                            <p>Selecciona las palabras a enviar por ID</p>
                            <form role="form">
                                <div class="form-group">
                                  <label for="usr">Separa los id's por coma:</label>
                                  <input type="text" class="form-control" id="usrr">
                                  Resultado: <span id="retorno7">0</span>
                                  
                                </div>
                                
                             </form>
                            <div class="panel-body">
                                    <button class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModall" >
                                      Envíar
                                      
                                    </button>
                                    
                                    <div class="modal fade" id="myModall" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                                        <div class="modal-dialog">
                                            <div class="modal-content">
                                                <div class="modal-header">
                                                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                                    <h4 class="modal-title" id="myModalLabel">Confirma</h4>
                                                </div>
                                                <div class="modal-body">
                                                   Las siguientes palabras en enviaran a la aplicacion para el entrenamiento correspondiente 
                                                </div>
                                                <div class="modal-footer">
                                                    <button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
                                                    <button type="button" onclick="realizaProces($('#usrr').val());" data-dismiss="modal"  class="btn btn-primary">Aceptar</button>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                
                            
                        </div>
                        
                        </div>
                    </div>
                    <div class="col-md-6 col-sm-12 col-xs-12">
                        <div class="panel back-dash">
                               <i class="fa fa-dashboard fa-3x"></i><strong> &nbsp; Recuerda</strong>
                             <p class="text-muted">Las palabras que envies mediante esta plataforma llegará directamente a la aplicación
                             móvil para el entrenamiento del niño. En el caso que exista algún problema por favor contacta a soporte técnico
                             <br>
                             Intinnover<br>
                             Gracias por su comprensión
                          
                             </p>
                        </div>
                       
                    </div>
	        </div>

                <div class="row">
                    <div class="col-md-6 col-sm-12 col-xs-12 ">
                        <div class="panel ">
                          <div class="main-temp-back">
                            <div class="panel-body">
                              <div class="row">
                                <div class="col-xs-6"> 
                                    <i class="fa fa-cloud fa-3x"></i> Bases de datos
                                    <br>
                                    <i class="fa fa-cloud fa-3x"></i> SQLite y MySQL
                                
                                
                                </div>
                                <div class="col-xs-6">
                                    <h3> Debes actualizar la base de datos cuando ingreses palabras </h3>
                                </div>
                              </div>
                            </div>
                          </div>

                        </div>
                        </div>
                        <div class="col-md-6 col-sm-12 col-xs-12 ">
                             <div class="panel panel-back noti-box">
                                <span class="icon-box bg-color-green set-icon">
                                    <i class="fa fa-desktop"></i>
                                </span>
                                <div class="text-box" >
                                    <p class="main-text">Da click y actualiza!!</p>
                                    <p class="text-muted">
                                      <button class="btn btn-danger" onclick="updateDb1('hola');"><i class="fa fa-pencil"></i> Comenzemos</button>  
                                    </p>
                                    <span id="retorno3"></span>
                                </div>
                             </div>
                        </div>

                     
                </div>

                 <!-- /. ROW  -->

                 <!-- /. ROW  -->
 
                 <!-- /. ROW  -->
    
                 <!-- /. ROW  --> 
 <?php echo '</script>'; ?>