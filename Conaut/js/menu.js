var menuVisible = false;

document.getElementById('header__boton').addEventListener('click',function(){
    //document.getElementById('header__nav').style.display = (menuVisible == false) ? 'block':'none';
    //menuVisible =!menuVisible;
    if(!menuVisible) document.getElementById('header__nav').style.display = 'block';
    else  document.getElementById('header__nav').style.display = 'none';
    menuVisible =!menuVisible;
});


  