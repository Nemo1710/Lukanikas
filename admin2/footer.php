    </script>

  <?php include_once 'pages/inicio.php' ?>
  <?php include_once 'pages/ui.php' ?>
  <?php include_once 'pages/modulo1.php' ?>
  <?php include_once 'pages/modulo2.php' ?>
  <?php include_once 'pages/modulo3.php' ?>
  <?php include_once 'pages/modulo4.php' ?>  
    <!-- JQUERY SCRIPTS -->
    <script src="assets/js/jquery-1.10.2.js"></script>
      <!-- BOOTSTRAP SCRIPTS -->
    <script src="assets/js/bootstrap.min.js"></script>
    <!-- METISMENU SCRIPTS -->
    <script src="assets/js/jquery.metisMenu.js"></script>
     <!-- MORRIS CHART SCRIPTS -->
     <script src="assets/js/morris/raphael-2.1.0.min.js"></script>
    <script src="assets/js/morris/morris.js"></script>
      <!-- CUSTOM SCRIPTS -->
    <script src="assets/js/custom.js"></script>
    <script language="javascript" src="js/AjaxUpload.2.0.min.js"></script>
    <script src="js/libs/jquery-1.10.2.js"></script>
    <script src="js/libs/handlebars-v2.0.0.js"></script>
    <script src="js/libs/ember-1.9.0.js"></script>
    <script src="js/app.js"></script>
    <script src="pages/ajax.js"></script>
    <script language="javascript">
    $(document).ready(function(){  
            var button = $('#upload_button'), interval;
            new AjaxUpload('#upload_button', {
                    action: 'upload.php', //Indicamos el archivo php que guardara el fichero si es correcto.
                    onSubmit : function(file , ext){
                            if (! (ext && /^(jpg|png)$/.test(ext))){ //Indicamos las extensiones que nos interesan, en este caso jpg
                                    alert('Error: Solo se permiten archivo de Imagen JPG.');
                                    //Cancelamos la subida
                                    return false;
                            } else {
                                    //Desabilitamos el boton una vez que el documento tiene la extension correcta
                                    this.disable();
                                    //En este paso podriamos mostrar un gif de cargando o un texto
                                    $("#contenedorImagen").html('<img class="center-block" src="loading.gif" />');
                            }
                    },
                    onComplete: function(file, response){   
                            button.hide();
                            //response: En este caso upload.php nos devuelve el nombre del fichero subido.
                            $("#contenedorImagen").html('<img class="center-block" src="' + response + '" />');
                            $("#upload_url").html('<p class="text-center"><small>'+response)+'</small></p>';
                    }   
            });
            var button1 = $('#upload_button1'), interval;
            new AjaxUpload('#upload_button1', {
                    action: 'upload.php', //Indicamos el archivo php que guardara el fichero si es correcto.
                    onSubmit : function(file , ext){
                            if (! (ext && /^(jpg|png)$/.test(ext))){ //Indicamos las extensiones que nos interesan, en este caso jpg
                                    alert('Error: Solo se permiten archivo de Imagen JPG.');
                                    //Cancelamos la subida
                                    return false;
                            } else {
                                    //Desabilitamos el boton una vez que el documento tiene la extension correcta
                                    this.disable();
                                    //En este paso podriamos mostrar un gif de cargando o un texto
                                    $("#contenedorImagen1").html('<img class="center-block" src="loading.gif" />');
                            }
                    },
                    onComplete: function(file, response){   
                            button1.hide();
                            //response: En este caso upload.php nos devuelve el nombre del fichero subido.
                            $("#contenedorImagen1").html('<img class="center-block" src="' + response + '" />');
                            $("#upload_url1").html('<p class="text-center"><small>'+response)+'</small></p>';
                    }   
            });
            var button2 = $('#upload_button2'), interval;
            new AjaxUpload('#upload_button2', {
                    action: 'upload.php', //Indicamos el archivo php que guardara el fichero si es correcto.
                    onSubmit : function(file , ext){
                            if (! (ext && /^(jpg)$/.test(ext))){ //Indicamos las extensiones que nos interesan, en este caso jpg
                                    alert('Error: Solo se permiten archivo de Imagen JPG.');
                                    //Cancelamos la subida
                                    return false;
                            } else {
                                    //Desabilitamos el boton una vez que el documento tiene la extension correcta
                                    this.disable();
                                    //En este paso podriamos mostrar un gif de cargando o un texto
                                    $("#contenedorImagen2").html('<img class="center-block" src="loading.gif" />');
                            }
                    },
                    onComplete: function(file, response){   
                            button2.hide();
                            //response: En este caso upload.php nos devuelve el nombre del fichero subido.
                            $("#contenedorImagen2").html('<img class="center-block" src="' + response + '" />');
                            $("#upload_url2").html('<p class="text-center"><small>'+response)+'</small></p>';
                    }   
            });
            var button3 = $('#upload_button3'), interval;
            new AjaxUpload('#upload_button3', {
                    action: 'upload.php', //Indicamos el archivo php que guardara el fichero si es correcto.
                    onSubmit : function(file , ext){
                            if (! (ext && /^(jpg)$/.test(ext))){ //Indicamos las extensiones que nos interesan, en este caso jpg
                                    alert('Error: Solo se permiten archivo de Imagen JPG.');
                                    //Cancelamos la subida
                                    return false;
                            } else {
                                    //Desabilitamos el boton una vez que el documento tiene la extension correcta
                                    this.disable();
                                    //En este paso podriamos mostrar un gif de cargando o un texto
                                    $("#contenedorImagen3").html('<img class="center-block" src="loading.gif" />');
                            }
                    },
                    onComplete: function(file, response){   
                            button3.hide();
                            //response: En este caso upload.php nos devuelve el nombre del fichero subido.
                            $("#contenedorImagen3").html('<img class="center-block" src="' + response + '" />');
                            $("#upload_url3").html('<p class="text-center"><small>'+response)+'</small></p>';
                    }   
            });
            
    });
    </script>
  
  <script src="tests/runner.js"></script>
</body>
</html>
