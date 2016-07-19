<?php
	//Declaramos el directorio de las imagenes
	$uploaddir = 'img/';
	
	//Sino existe el directorio lo creamos
	if (!is_dir($uploaddir)) {
   		mkdir($uploaddir);
	}
	//Vamos a renombrar el fichero por uno aleatorio para que nunca se machaquen y se pierdan las imagenes
	$file =  md5(basename($_FILES['userfile']['name'])).strrchr($_FILES['userfile']['name'],".");
        $file = substr($file, -8);    // devuelve "ef"
	
	//Contruimos la ruta de la imagen
	$uploadfile = $uploaddir. "1" . $file;
        $fille="1" . $file;
	
	if (move_uploaded_file($_FILES['userfile']['tmp_name'], $uploadfile)) {				
             //Ruta de la original
                $rtOriginal=$uploadfile;
                //Crear variable de imagen a partir de la original
                $original = imagecreatefromjpeg($rtOriginal);
     
                //Definir tamaño máximo y mínimo
                $max_ancho = 170;
                $max_alto = 170;
 
                //Recoger ancho y alto de la original
                list($ancho,$alto)=getimagesize($rtOriginal);
 
                //Calcular proporción ancho y alto
                $x_ratio = $max_ancho / $ancho;
                $y_ratio = $max_alto / $alto;

                if( ($ancho <= $max_ancho) && ($alto <= $max_alto) ){
                //Si es más pequeña que el máximo no redimensionamos
                    $ancho_final = $ancho;
                    $alto_final = $alto;
                }
                //si no calculamos si es más alta o más ancha y redimensionamos
                elseif (($x_ratio * $alto) < $max_alto){
                    $alto_final = ceil($x_ratio * $alto);
                    $ancho_final = $max_ancho;
                }
                else{
                    $ancho_final = ceil($y_ratio * $ancho);
                    $alto_final = $max_alto;
                }
                //Crear lienzo en blanco con proporciones
                $lienzo=imagecreatetruecolor($ancho_final,$alto_final); 

                //Copiar $original sobre la imagen que acabamos de crear en blanco ($tmp)
                imagecopyresampled($lienzo,$original,0,0,0,0,$ancho_final, $alto_final,$ancho,$alto);

                //Limpiar memoria
                imagedestroy($original);

                //Definimos la calidad de la imagen final
                $cal=90;

                //Se crea la imagen final en el directorio indicado
                imagejpeg($lienzo,"img/"."1".$file,$cal);
            
            
            
            
            echo $uploadfile;//Devolvemos la ruta completa para poder visualizarla.
                        
               
                
                
                
                
                
                
                
                
	} else {
		echo "error";
	}
        

        
?>