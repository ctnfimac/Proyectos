/*document.getElementById("modalAbrir").addEventListener('click',abrirModal(){
         document.getElementById("modal").style.display='block';                                              
})*/

function abrirModal(){
    
    if(window.innerWidth > 900){
         var modal = document.getElementById("modal");
        modal.style.display = "block";
    }
    
   
}


function cerrarModal(){
    if(window.innerWidth > 900){
        var modal = document.getElementById("modal");
        modal.style.display = "none";
    }
}

var botonAbrir = document.getElementById("modalAbrir");
var botonCerrar = document.getElementById("modalCerrar");

botonAbrir.addEventListener('click',abrirModal);
botonCerrar.addEventListener('click',cerrarModal);