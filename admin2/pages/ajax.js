function realizaProceso(valorCaja1){
        var parametros = {
                "valorCaja1" : valorCaja1,
                
        };
        $.ajax({
                data:  parametros,
                url:   'pages/ajax/ejemplo.php',
                type:  'post',
                beforeSend: function () {
                        $("#resultado").html("Procesando, espere por favor...");
                },
                success:  function (response) {
                        $("#resultado").html(response);
                }
        });
}
function realizaProces(valorCaja1){
        var parametros = {
                "valorCaja1" : valorCaja1,
                
        };
        $.ajax({
                data:  parametros,
                url:   'pages/ajax/ejemplo2.php',
                type:  'post',
                beforeSend: function () {
                        $("#retorno7").html("Procesando, espere por favor...");
                },
                success:  function (response) {
                        $("#retorno7").html(response);
                }
        });
}
function realizass(valorCaja1){
        var parametros = {
                "valorCaja1" : valorCaja1,
                
        };
        $.ajax({
                data:  parametros,
                url:   'pages/ajax/ejemplo3.php',
                type:  'post',
                beforeSend: function () {
                        $("#retorno8").html("Procesando, espere por favor...");
                },
                success:  function (response) {
                        $("#retorno8").html(response);
                }
        });
}
function ingresa(valor1,valor2,valor3,valor4,valor5,valor6,valor7){
        var parametros = {
                "valor1" : valor1,
                "valor2" : valor2,
                "valor3" : valor3,                
                "valor4" : valor4,
                "valor5" : valor5,
                "valor6" : valor6,
                "valor7" : valor7,
                
        };
        $.ajax({
                data:  parametros,
                url:   'pages/ajax/ingresar.php',
                type:  'post',
                beforeSend: function () {
                        $("#retorno").html("Procesando, espere por favor...");
                },
                success:  function (response) {
                        $("#retorno").html(response);
                     

                        
                }
        });
}
function insertaprototipo(valor1,valor2,valor3){
        var parametros = {
                "valor1" : valor1,
                "valor2" : valor2,
                "valor3" : valor3
                
        };
        $.ajax({
                data:  parametros,
                url:   'pages/ajax/ingresarr.php',
                type:  'post',
                beforeSend: function () {
                        $("#retornoss").html("Procesando, espere por favor...");
                },
                success:  function (response) {
                        $("#retornoss").html(response);
                     

                        
                }
        });
}
function obtiene(valor1){
        var parametros = {
                "valor1" : valor1
                                
        };
        $.ajax({
                data:  parametros,
                url:   'pages/ajax/actualizar.php',
                type:  'post',
                beforeSend: function () {
                        $("#retorno1").html("Procesando, espere por favor...");
                },
                success:  function (response) {
                        var nombres = response.split(",");
                        $("#retorno1").html("Actualiza la palabra");
                        $("#palabra11").val(nombres[0]);
                        $("#palabra22").val(nombres[1]);
                        $("#palabra33").val(nombres[2]);
                        $("#silaba11").val(nombres[3]);
                        $("#silaba22").val(nombres[4]);
                        $("#silaba33").val(nombres[5]);
                        $("#silaba44").val(nombres[6]);
                     

                        
                }
        });
}
function actualiza(id,valor1,valor2,valor3,valor4,valor5,valor6,valor7){
        var parametros = {
                "id" : id,
                "valor1" : valor1,
                "valor2" : valor2,
                "valor3" : valor3,                
                "valor4" : valor4,
                "valor5" : valor5,
                "valor6" : valor6,
                "valor7" : valor7,
                                
        };
        $.ajax({
                data:  parametros,
                url:   'pages/ajax/actualizar2.php',
                type:  'post',
                beforeSend: function () {
                        $("#retorno1").html("Procesando, espere por favor...");
                },
                success:  function (response) {

                        $("#retorno1").html(response);
                
                     

                        
                }
        });
}
function updateDb(valorCaja1){
        var parametros = {
                "valorCaja1" : valorCaja1,
                
        };
        $.ajax({
                data:  parametros,
                url:   'pages/ajax/dbupdate.php',
                type:  'post',
                beforeSend: function () {
                        $("#retorno3").html("Procesando, espere por favor...");
                },
                success:  function (response) {
                        $("#retorno3").html(response);
                        alert("Ahora mismo se actualizará la base de datos");
                }
        });
}
function updateDb1(valorCaja1){
        var parametros = {
                "valorCaja1" : valorCaja1,
                
        };
        $.ajax({
                data:  parametros,
                url:   'pages/ajax/dbupdate1.php',
                type:  'post',
                beforeSend: function () {
                        $("#retorno3").html("Procesando, espere por favor...");
                },
                success:  function (response) {
                        $("#retorno3").html(response);
                        alert("Ahora mismo se actualizará la base de datos");
                }
        });
}
function agregarTarea(id,valor1,valor2,valor3,valor4,valor5,valor6,valor7){
        var parametros = {
                "id" : id,
                "valor1" : valor1,
                "valor2" : valor2,
                "valor3" : valor3,                
                "valor4" : valor4,
                "valor5" : valor5,
                "valor6" : valor6,
                "valor7" : valor7,
                                
        };
        $.ajax({
                data:  parametros,
                url:   'pages/ajax/actualizar2.php',
                type:  'post',
                beforeSend: function () {
                        $("#retorno1").html("Procesando, espere por favor...");
                },
                success:  function (response) {

                        $("#retorno1").html(response);
                
                     

                        
                }
        });
}
$(document).ready(function(){ 
    $("#limpiatodomod2").click(function(){
       var button = $('#upload_button'), interval;
       var button1 = $('#upload_button1'), interval;
       var button2 = $('#upload_button2'), interval;
       var button3 = $('#upload_button3'), interval;
       var cont1   = $('#contenedorImagen'),interval;
       var cont2   = $('#contenedorImagen1'),interval;
       var cont3   = $('#contenedorImagen2'),interval;
       var cont4   = $('#contenedorImagen3'),interval;
       button.show();
       button1.show();
       button2.show();
       button3.show();
       cont1.hide();
       cont2.hide();
       cont3.hide();
       cont4.hide();
        
       
    });
    $("#bot1").click(function(){
        var parametros = {
                "id" : "uno"                               
        };
        var num=$("#btn1").val();
        if(num==0){
            $("#bot1").html("<button type='button' id='bott1' class='btn btn-success btn-circle center-block'><i class='fa fa-heart'></i></button>");
            $("#btn1").val("1");
            $("#btn10").val("0");
        }else if (num==1){
            $("#bot1").html("<button type='button' class='btn btn-danger btn-circle center-block'><i class='fa fa-heart'</i></button>");
            $("#btn1").val("0");
            $("#btn10").val("1");
            
        }   
        
    });
    $("#bot2").click(function(){
        var num=$("#btn2").val();
        if(num==0){
            $("#bot2").html("<button type='button' id='bott1' class='btn btn-success btn-circle center-block'><i class='fa fa-heart'></i></button>");
            $("#btn2").val("1");
            $("#btn11").val("0");
        }else if (num==1){
            $("#bot2").html("<button type='button' class='btn btn-danger btn-circle center-block'><i class='fa fa-heart'</i></button>");
            $("#btn2").val("0");
            $("#btn11").val("1");
            
        }   
        
    });
    $("#bot3").click(function(){
        var num=$("#btn3").val();
        if(num==0){
            $("#bot3").html("<button type='button' id='bott1' class='btn btn-success btn-circle center-block'><i class='fa fa-heart'></i></button>");
            $("#btn3").val("1");
            $("#btn12").val("0");
        }else if (num==1){
            $("#bot3").html("<button type='button' class='btn btn-danger btn-circle center-block'><i class='fa fa-heart'</i></button>");
            $("#btn3").val("0");
            $("#btn12").val("1");
            
        }   
        
    });
    $("#bot4").click(function(){
        var num=$("#btn4").val();
        if(num==0){
            $("#bot4").html("<button type='button' id='bott1' class='btn btn-success btn-circle center-block'><i class='fa fa-heart'></i></button>");
            $("#btn4").val("1");
            $("#btn13").val("0");
        }else if (num==1){
            $("#bot4").html("<button type='button' class='btn btn-danger btn-circle center-block'><i class='fa fa-heart'</i></button>");
            $("#btn4").val("0");
            $("#btn13").val("1");
            
        }   
        
    });
    $("#bot5").click(function(){
        var num=$("#btn5").val();
        if(num==0){
            $("#bot5").html("<button type='button' id='bott1' class='btn btn-success btn-circle center-block'><i class='fa fa-heart'></i></button>");
            $("#btn5").val("1");
            $("#btn14").val("0");
        }else if (num==1){
            $("#bot5").html("<button type='button' class='btn btn-danger btn-circle center-block'><i class='fa fa-heart'</i></button>");
            $("#btn5").val("0");
            $("#btn14").val("1");
            
        }   
        
    });
    $("#bot6").click(function(){
        var num=$("#btn6").val();
        if(num==0){
            $("#bot6").html("<button type='button' id='bott1' class='btn btn-success btn-circle center-block'><i class='fa fa-heart'></i></button>");
            $("#btn6").val("1");
            $("#btn15").val("0");
        }else if (num==1){
            $("#bot6").html("<button type='button' class='btn btn-danger btn-circle center-block'><i class='fa fa-heart'</i></button>");
            $("#btn6").val("0");
            $("#btn15").val("1");
            
        }   
        
    });  
    $("#bot7").click(function(){
        var num=$("#btn7").val();
        if(num==0){
            $("#bot7").html("<button type='button' id='bott1' class='btn btn-success btn-circle center-block'><i class='fa fa-heart'></i></button>");
            $("#btn7").val("1");
            $("#btn16").val("0");
        }else if (num==1){
            $("#bot7").html("<button type='button' class='btn btn-danger btn-circle center-block'><i class='fa fa-heart'</i></button>");
            $("#btn7").val("0");
            $("#btn16").val("1");
            
        }   
        
    }); 
    $("#bot8").click(function(){
        var num=$("#btn8").val();
        if(num==0){
            $("#bot8").html("<button type='button' id='bott1' class='btn btn-success btn-circle center-block'><i class='fa fa-heart'></i></button>");
            $("#btn8").val("1");
            $("#btn17").val("0");
        }else if (num==1){
            $("#bot8").html("<button type='button' class='btn btn-danger btn-circle center-block'><i class='fa fa-heart'</i></button>");
            $("#btn8").val("0");
            $("#btn17").val("1");
            
        }   
        
    });
    $("#bot9").click(function(){
        var num=$("#btn9").val();
        if(num==0){
            $("#bot9").html("<button type='button' id='bott1' class='btn btn-success btn-circle center-block'><i class='fa fa-heart'></i></button>");
            $("#btn9").val("1");
            $("#btn18").val("0");
        }else if (num==1){
            $("#bot9").html("<button type='button' class='btn btn-danger btn-circle center-block'><i class='fa fa-heart'</i></button>");
            $("#btn9").val("0");
            $("#btn18").val("1");
            
        }   
        
    });
    $("#limpiars").click(function(){
        $("#btn1").val("0");
        $("#btn2").val("0");
        $("#btn3").val("0");
        $("#btn4").val("0");
        $("#btn5").val("0");
        $("#btn6").val("0");
        $("#btn7").val("0");
        $("#btn8").val("0");
        $("#btn9").val("0");
        $("#btn10").val("0");
        $("#btn11").val("0");
        $("#btn12").val("0");
        $("#btn13").val("0");
        $("#btn14").val("0");
        $("#btn15").val("0");
        $("#btn16").val("0");
        $("#btn17").val("0");
        $("#btn18").val("0");
        $("#bot1").html("<button type='button' class='btn btn-default btn-circle center-block'><i class='fa fa-check'></i></button>");
        $("#bot2").html("<button type='button' class='btn btn-default btn-circle center-block'><i class='fa fa-check'></i></button>");
        $("#bot3").html("<button type='button' class='btn btn-default btn-circle center-block'><i class='fa fa-check'></i></button>");
        $("#bot4").html("<button type='button' class='btn btn-default btn-circle center-block'><i class='fa fa-check'></i></button>");
        $("#bot5").html("<button type='button' class='btn btn-default btn-circle center-block'><i class='fa fa-check'></i></button>");
        $("#bot6").html("<button type='button' class='btn btn-default btn-circle center-block'><i class='fa fa-check'></i></button>");
        $("#bot7").html("<button type='button' class='btn btn-default btn-circle center-block'><i class='fa fa-check'></i></button>");
        $("#bot8").html("<button type='button' class='btn btn-default btn-circle center-block'><i class='fa fa-check'></i></button>");
        $("#bot9").html("<button type='button' class='btn btn-default btn-circle center-block'><i class='fa fa-check'></i></button>");
        $("#bot10").html("<button type='button' class='btn btn-default btn-circle center-block'><i class='fa fa-check'></i></button>");
        $("#bot11").html("<button type='button' class='btn btn-default btn-circle center-block'><i class='fa fa-check'></i></button>");
        $("#bot12").html("<button type='button' class='btn btn-default btn-circle center-block'><i class='fa fa-check'></i></button>");
        $("#bot13").html("<button type='button' class='btn btn-default btn-circle center-block'><i class='fa fa-check'></i></button>");
        $("#bot14").html("<button type='button' class='btn btn-default btn-circle center-block'><i class='fa fa-check'></i></button>");
        $("#bot15").html("<button type='button' class='btn btn-default btn-circle center-block'><i class='fa fa-check'></i></button>");
        $("#bot16").html("<button type='button' class='btn btn-default btn-circle center-block'><i class='fa fa-check'></i></button>");
        $("#bot17").html("<button type='button' class='btn btn-default btn-circle center-block'><i class='fa fa-check'></i></button>");
        $("#bot18").html("<button type='button' class='btn btn-default btn-circle center-block'><i class='fa fa-check'></i></button>");
        
        
        
        
    });
    
    $("#enviars").click(function(){
       
       var num1=$("#btn1").val();
       var num2=$("#btn2").val();
       var num3=$("#btn3").val();
       var num4=$("#btn4").val();
       var num5=$("#btn5").val();
       var num6=$("#btn6").val();
       var num7=$("#btn7").val();
       var num8=$("#btn8").val();
       var num9=$("#btn9").val();
       var num10=$("#btn10").val();
       var num11=$("#btn11").val();
       var num12=$("#btn12").val();
       var num13=$("#btn13").val();
       var num14=$("#btn14").val();
       var num15=$("#btn15").val();
       var num16=$("#btn16").val();
       var num17=$("#btn17").val();
       var num18=$("#btn18").val();
       var total=num1+""+num2+""+num3+""+num4+""+num5+""+num6+""+num7+""+num8+""+num9+""+num10+""+num11+""+num12+""+num13+""+num14+""+num15+""+num16+""+num17+""+num18;
       alert(total);
       var parametros = {
                            "mensaje" : total                                             
                            
                    };
       $.ajax({
                data:  parametros,
                url:   'pages/ajax/subir.php',
                type:  'post',
                beforeSend: function () {
                        $("#retorno6").html("Procesando, espere por favor...");
                },
                success:  function (response) {

                        $("#retorno6").html(response);
                
                     

                        
                }
            });
       
        
    });
    $("#enviadatmod2").click(function () {
                        var parametros = {
                            "mensaje" : $("#textin").val(),
                            "valor1" : $("#upload_url").val(),
                            "valor2" : $("#upload_url1").val(),
                            "valor3" : $("#upload_url2").val(),
                            "valor4" : $("#upload_url3").val(),
                            "numero" : $('input:radio[name=opciones]:checked').val()                          
                            
                    };
                    alert("dsaddsad");
            $.ajax({
                data:  parametros,
                url:   'pages/ajax/actualizar2.php',
                type:  'post',
                beforeSend: function () {
                        $("#retorno1").html("Procesando, espere por favor...");
                },
                success:  function (response) {

                        $("#retorno1").html(response);
                
                     

                        
                }
            });
			
			
			
    
    });
});

$(document).ready(inicio);

function inicio(){
    $("#botones").click(limpEdit);
    $("#boton").click(limpCreate);

}
function limpEdit(){
    $("#palabra11").val("");
    $("#palabra22").val("");
    $("#palabra33").val("");
    $("#silaba11").val("");
    $("#silaba22").val("");
    $("#silaba33").val("");
    $("#silaba44").val("");
}
function limpCreate(){
    $("#palabra1").val("");
    $("#palabra2").val("");
    $("#palabra3").val("");
    $("#silaba1").val("");
    $("#silaba2").val("");
    $("#silaba3").val("");
    $("#silaba4").val("");
}

function limpiar(caja){
        document.getElementById(caja).value="";
        $("#palabra1").val("");
        $("#palabra2").html("");
        $("#palabra3").html("");
        $("#silaba1").html("");
        $("#silaba2").html("");
        $("#silaba3").html("");
        $("#silaba4").html("");
        
}
