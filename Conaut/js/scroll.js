
var getScrollInicial = function(){
    return window.scrollY | document.body.scrollTop | document.documentElement.scrollTop;
}


var getScrollFinal = function(elemento){
  return Math.floor(elemento.getBoundingClientRect().top + getScrollInicial()); 
}


var animatedScrollTo = function(targetElement,time,originElement){
    var posicionInicial = getScrollInicial();
    var posicionFinal = getScrollFinal(targetElement);
    var distanciaScroll = posicionFinal - posicionInicial;
    var scrollFragment = distanciaScroll / time;
    animatedScroll(scrollFragment,posicionFinal);  
}

/*
var animatedScroll = function(scrollFragment,posicionFinal){
    var y = 0;
    var actual = 0; // variable que sirve para saber si el scrollY vale dos o mas veces lo mismo(ocurre en el caso que la pantalla es muy ancha y el scrollY no llega a bajar lo suficiente para superar la posicion final , lo cual provocaba un bug en el cual siempre iba a querer estar bajando - esto ocurre en la seccion del contacto)
    var animatedScroll = setInterval(function(){
        y =+ scrollFragment;
        //console.log('valor:',originElement.hash)
        //console.log('tamaño del documento:',document.body.scrollHeight,'posicion final:',posicionFinal,'scroll actual:',window.scrollY);
       // console.log('scroll actual:',window.scrollY);
       // console.log('posicion final:',posicionFinal);
        if(scrollFragment > 0){
            window.scrollBy(0,y);
            if(window.scrollY >= (posicionFinal - scrollFragment / 2) || window.scrollY == actual) {
                clearInterval(animatedScroll);
                actual = 0;
            }else actual = window.scrollY;
        }else{
            window.scrollBy(0,y);
            if(window.scrollY <= (posicionFinal - scrollFragment / 2)) clearInterval(animatedScroll);
        }
    },1);
}*/

var animatedScroll = function(scrollFragment,posicionFinal){
    var y = 0;
    var actual = 0; 
   // var valorcrollInicial = getScrollInicial();
    var animatedScroll = setInterval(function(){
        y =+ scrollFragment;
        if(scrollFragment > 0){
            window.scrollBy(0,y);
            if(getScrollInicial() >= (posicionFinal - scrollFragment / 2) || getScrollInicial() == actual) {
                clearInterval(animatedScroll);
                actual = 0;
            }else actual = getScrollInicial();
        }else{
            window.scrollBy(0,y);
            if(getScrollInicial() <= (posicionFinal - scrollFragment / 2)) clearInterval(animatedScroll);
        }
    },1);
}

var animatedScrollEvent = function(originElement,time){
     
    if(originElement.tagName === 'A' && originElement.hash !== ''){
        var targetElement = document.getElementById(originElement.hash.slice(1));
        originElement.addEventListener('click',function(e){
            e.preventDefault();
            animatedScrollTo(targetElement,time);
        });
    }
}

var animatedScrollAllLinks = function(time){
   var links = document.links;

   var i = 0;
   for( i ; i < links.length ; i++){
       animatedScrollEvent(links[i],time);
   }
  /* for(var link of links){
        animatedScrollEvent(link,time);
  }*/
}

animatedScrollAllLinks(200);


/* 
 * boton arriba
 *
**/
var botonArriba = document.getElementById('flechaArriba');

document.addEventListener('scroll',function(){
    
    if(getScrollInicial()>500){
       botonArriba.style.display = 'block';
    }else{
         botonArriba.style.display = 'none'; 
    }
});
 
