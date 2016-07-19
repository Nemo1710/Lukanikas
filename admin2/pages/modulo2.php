<?php echo '<script type="text/x-handlebars" id="modulo2">' ?>
               
                <div id="page-inner">
                <div class="row">
                    <div class="col-md-12">
                     <h2>Módulo 2</h2>   
                        
                    </div>
                </div>              

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
                                                <th>Palabra 1</th>
                                                <th>Palabra 2</th>
                                                <th>Palabra 3</th>
                                                 
                                            </tr>
                                        </thead>
                                        <?php
                                        $b='<tbody>';
                                        for($i=0;$i<sizeof($a);$i++){
                                            $b .='<tr>'.
                                                    '<td>'.$a[$i]['id']. '</td>'.
                                                    '<td>'.$a[$i]['palabra1']. '</td>'.
                                                    '<td>'.$a[$i]['palabra2']. '</td>'.
                                                    '<td>'.$a[$i]['palabra3']. '</td>'.
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
                    <div class="col-md-12 col-sm-12 col-xs-12 center-block">
                        <!-- Text input-->
                            <div class="form-group">
                                
                              <p class="text-center">¿Ingresa la frase con la que identificará el niño?</p>

                              <input id="textin" name="textinput" type="text" placeholder="Ingresa la frase" class="form-control input-md">
                              
                              
                            </div>
                    </div>
                    
                </div>
                <div class="row">
                    <div class="col-md-3 col-sm-12 col-xs-12 center-block">
                        <div>
                            <div id="contenedorImagen"></div>
                            <div id="upload_button">
                                <p class="text-center">Imagen 1</p>
                                    <button class="btn btn-primary btn-lg center-block" id="profile_image_upload" >
                                            Selecciona la imagen

                                    </button>
                                
                            </div>
                            <div id="upload_url">

                            </div>
                            <div class="radio">
                                  <label>
                                    <input type="radio" name="opciones" id="opciones_1" value="1" >
                                    Da clic si es la correcta
                                  </label>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-3 col-sm-12 col-xs-12 center-block">
                        <div>
                            <div id="contenedorImagen1"></div>
                            <div id="upload_button1">
                                <p class="text-center">Imagen 2</p>
                                    <button class="btn btn-primary btn-lg center-block" id="profile_image_upload1" >
                                            Selecciona la imagen

                                    </button>
                                

                            </div>
                            <div id="upload_url1">

                            </div>
                            <div class="radio">
                                  <label>
                                    <input type="radio" name="opciones" id="opciones_2" value="2" checked>
                                    Da clic si es la correcta
                                  </label>
                                </div>
                        </div>
                    </div>
                    <div class="col-md-3 col-sm-12 col-xs-12 center-block">
                        <div>
                            <div id="contenedorImagen2"></div>
                            <div id="upload_button2">
                                <p class="text-center">Imagen 3</p>
                                    <button class="btn btn-primary btn-lg center-block" id="profile_image_upload2" >
                                            Selecciona la imagen

                                    </button>
                                

                            </div>
                            <div id="upload_url2">

                            </div>
                            <div class="radio">
                                  <label>
                                    <input type="radio" name="opciones" id="opciones_3" value="3" >
                                    Da click si es la correcta
                                  </label>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-3 col-sm-12 col-xs-12 center-block">
                        <div>
                            <div id="contenedorImagen3"></div>
                            <div id="upload_button3">
                                <p class="text-center">Imagen 4</p>
                                    <button class="btn btn-primary btn-lg center-block" id="profile_image_upload3" >
                                            Selecciona la imagen

                                    </button>
                                

                            </div>
                            <div id="upload_url3">

                            </div>
                            <div class="radio">
                                  <label>
                                    <input type="radio" name="opciones" id="opciones_4" value="4">
                                    Da clic si es la correcta
                                  </label>
                            </div>
                        </div>
                    </div>
                </div>
                <hr />
                <div class="row">
                    <div class="col-md-12 col-sm-12 col-xs-12 center-block">
                    <button class="btn btn-primary btn-lg " id="enviadatmod2" >
                                            Envia los datos

                    </button> 
                    <button class="btn btn-primary btn-lg " id="limpiatodomod2" >
                                            Sube imagenes de nuevo

                    </button> 
                    </div>
                </div>

                <hr />
		 <div class="row">
                    
                    <div class="col-md-6 col-sm-12 col-xs-12">      
				<div class="panel panel-default">
                        <div class="panel-heading">
                            <p>Selecciona las palabras a enviar por ID</p>
                            <form role="form">
                                <div class="form-group">
                                  <label for="usr">Separa los id's por coma:</label>
                                  <input type="text" class="form-control" id="usr">
                                  Resultado: <span id="resultado">0</span>
                                  
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
                                                    <button type="button" onclick="realizaProceso($('#usr').val());" data-dismiss="modal"  class="btn btn-primary">Aceptar</button>
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
                              <div>
                                        <div id="contenedorImagen"></div>
                                        <div id="upload_button">
                                                <button class="btn btn-default" id="profile_image_upload" >
                                                        Selecciona la imagen (JPG)
                                                        
                                                </button>
                                        </div>
                                        <div id="upload_url">
                                                
                                        </div>
                              </div>
                        </div>
                       
                    </div>
	        </div>	
                
                <div class="row">
                    
                    <div class="col-md-6 col-sm-12 col-xs-12">      
				<div class="panel panel-default">
                                    
                        <div class="panel-heading">
                            <p>Ingresa una nueva palabra al sistema (Solo dos sílabas)</p>
                            
                            <form role="form">
                                <div class="form-group">                                  
                                 Palabra 1  
                                  <input type="text" class="form-control" id="palabra1">
                                  Palabra 2
                                  <input type="text" class="form-control" id="palabra2">
                                  Palabra 3
                                  <input type="text" class="form-control" id="palabra3">
                                  Sílaba 1
                                  <input type="text" class="form-control" id="silaba1">
                                  Sílaba 2
                                  <input type="text" class="form-control" id="silaba2">
                                  Sílaba 3
                                  <input type="text" class="form-control" id="silaba3">
                                  Sílaba 4
                                  <input type="text" class="form-control" id="silaba4">
                                  <span id="retorno">0</span>
                                  
                                </div>
                                
                             </form>
                            <div class="panel-body">
                                    <button class="btn btn-primary btn-lg" onclick="ingresa(
                                                $('#palabra1').val(),
                                                $('#palabra2').val(),
                                                $('#palabra3').val(),
                                                $('#silaba1').val(),
                                                $('#silaba2').val(),
                                                $('#silaba3').val(),
                                                $('#silaba4').val()
                                                
                                                
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
                                 Palabra 1  
                                  <input type="text" class="form-control" id="palabra11">
                                  Palabra 2
                                  <input type="text" class="form-control" id="palabra22">
                                  Palabra 3
                                  <input type="text" class="form-control" id="palabra33">
                                  Sílaba 1
                                  <input type="text" class="form-control" id="silaba11">
                                  Sílaba 2
                                  <input type="text" class="form-control" id="silaba22">
                                  Sílaba 3
                                  <input type="text" class="form-control" id="silaba33">
                                  Sílaba 4
                                  <input type="text" class="form-control" id="silaba44">
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
                                      <button class="btn btn-danger" onclick="updateDb('hola');"><i class="fa fa-pencil"></i> Comenzemos</button>  
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
