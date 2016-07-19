<?php echo '<script type="text/x-handlebars" id="modulo4">' ?>
               
                <div id="page-inner">
                <div class="row">
                    <div class="col-md-12">
                     <h2>Módulo 4</h2>   
                        
                    </div>
                </div> 
                
                <hr />        

                    
               
                <div class="row"> 
                    <div class="col-md-12 col-sm-12 col-xs-12 center-block">

                    </div>     
                </div>
                <hr />
                 <!-- /. ROW  -->
                 <?php
                                
                                $a = $db->getAllPrototipos();
                               
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
                                                <th>Pregunta</th>
                                                <th>Respuesta</th>
                                                <th>URL</th>
                                                
                                                 
                                            </tr>
                                        </thead>
                                        <?php
                                        $b='<tbody>';
                                        for($i=0;$i<sizeof($a);$i++){
                                            $b .='<tr>'.
                                                    '<td>'.$a[$i]['id']. '</td>'.
                                                    '<td>'.$a[$i]['pregunta']. '</td>'.
                                                    '<td>'.$a[$i]['respuesta']. '</td>'.
                                                    '<td><a href="'.$a[$i]['url'].'">'.$a[$i]['url']. '</a></td>'.
                                                    
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
                <div class="row">
                    
                    <div class="col-md-6 col-sm-12 col-xs-12">      
				<div class="panel panel-default">
                                    
                        <div class="panel-heading">
                            <p>Ingresa una nueva combinación</p>
                            
                            <form role="form">
                                <div class="form-group">                                  
                                  Pregunta  
                                  <input type="text" class="form-control" id="palabra1">
                                  Respuesta
                                  <input type="text" class="form-control" id="palabra2">
                                  URL
                                  <input type="text" class="form-control" id="palabra3">
                                  
                                  <span id="retornoss">0</span>
                                  
                                </div>
                                
                             </form>
                            <div class="panel-body">
                                    <button class="btn btn-primary btn-lg" onclick="insertaprototipo(
                                                $('#palabra1').val(),
                                                $('#palabra2').val(),
                                                $('#palabra3').val()                                                
                                                
                                                );">
                                      Agregar
                                      
                                    </button>
                                    <button class="btn btn-primary btn-lg" id="boton">
                                      Limpiar
                                      
                                    </button>
                                    
                                   
                                </div>
                                
                            
                        </div>
                        
                        </div>
                    </div>
                    <div class="col-md-6 col-sm-12 col-xs-12">      
				<div class="panel panel-default">
                                    
                        <div class="panel-heading">
                            <p>Edita una palabra <select class="combobox" id="comboedit" onchange="javascript:obtiene(this.value);">
                                  <option>Elige id</option>
                                  <?php
                                  $j=$i;
                                  $text='';
                                  for($i=1;$i<=$j;$i++){
                                      $text.='<option value='.$i.'>'.$i.'</option>';
                                  }
                                  echo $text;
                                  ?>
                                  
                                </select>
                            </p>
                            <form role="form">
                                <div class="form-group">                                  
                                 Pregunta  
                                  <input type="text" class="form-control" id="palabra11">
                                  Respuesta
                                  <input type="text" class="form-control" id="palabra22">
                                  URL
                                  <input type="text" class="form-control" id="palabra33">
                                  
                                  <span id="retorno1">0</span>
                                  
                                </div>
                                
                             </form>
                            <div class="panel-body">
                                    <button class="btn btn-primary btn-lg" onclick="actualiza(
                                                $( '#comboedit option:selected' ).text(),
                                                $('#palabra11').val(),
                                                $('#palabra22').val(),
                                                $('#palabra33').val(),
                                                $('#silaba11').val(),
                                                $('#silaba22').val(),
                                                $('#silaba33').val(),
                                                $('#silaba44').val()
                                                
                                                
                                                );">
                                      Agregar
                                      
                                    </button>
                                    <button class="btn btn-primary btn-lg" id="botones">
                                      Limpiar
                                      
                                    </button>
                                    
                                   
                                </div>
                                
                            
                        </div>
                        
                        </div>
                    </div>
                   
		</div>
                 <hr /> 
		 <div class="row">
                    
                    <div class="col-md-6 col-sm-12 col-xs-12">      
				<div class="panel panel-default">
                        <div class="panel-heading">
                            <p>Selecciona los prototipos a enviar por ID</p>
                            <form role="form">
                                <div class="form-group">
                                  <label for="usr">Separa los id's por coma:</label>
                                  <input type="text" class="form-control" id="usrr">
                                  Resultado: <span id="retorno8">0</span>
                                  
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
                                                    <button type="button" onclick="realizass($('#usrr').val());" data-dismiss="modal"  class="btn btn-primary">Aceptar</button>
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