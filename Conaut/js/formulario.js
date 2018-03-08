function validacion(){
    var email    = document.getElementById("email").value,
        mensaje  = document.getElementById("mensaje").value,
        mensaje2 = document.getElementById("mensaje2"),
        mensaje3 = document.getElementById("mensaje3");
    
    var msj = "";
    var error = 0;   
    var regexemail =  /^[0-9a-zA-Z._.-]+\@[0-9a-zA-Z._.-]+\.[0-9a-zA-Z]+$/;
    //console.log(nombre,apellido,password,rpassword);
    document.getElementById("resultado").innerHTML = "" ;
    mensaje2.style.display = "none";
    mensaje3.style.display = "none";
    
    if(email == ""){
        mensaje2.style.display = "block";
        error++;
    }
    
    if(email != "" && !regexemail.test(email)){
        mensaje2.style.display = "block";
        error++;

    }
    if(mensaje == ""){
        mensaje3.style.display = "block";
        error++;
    }
 
    if(error > 0){
        document.getElementById("resultado").innerHTML = msj ;
        return false
    }else{
       enviarPorAjax(email,mensaje); 
    } 

}



var enviarPorAjax = function(email,mensaje){
      var respuesta = document.getElementById("resultado");
      var form = 'email='+ email + '&mensaje=' + mensaje;
      var connect = window.XMLHttpRequest ? new XMLHttpRequest() : new ActiveXObject('Microsoft.XMLHTTP');
          connect.onreadystatechange = function(){

            if ( connect.readyState == 4 && connect.status == 200 ){
               if(connect.responseText == 1){
                 respuesta.innerHTML = '<p class='+"correcto"+'>Mensaje Enviado Correctamente</p>';
                 redireccionar();
               }else{
                 respuesta.innerHTML = connect.responseText;
               }
            }else if( connect.readyState != 4 ){
              respuesta.innerHTML = '<p class='+"procesando"+'>Estamos procesando tú mensaje</p>';
            }
          }

       connect.open('POST','formularioConsulta.php',true);
       connect.setRequestHeader('Content-Type','application/x-www-form-urlencoded');
       connect.send(form);
}

