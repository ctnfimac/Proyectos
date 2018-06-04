(function(){
	function nombrar(nombre){
		return nombre;
	}

	function saludar(nombre){
		console.info(nombre, ', un saludo desde DO Podcast');
	}

	saludar(nombrar('Christian Ivan Peralta'));
	//alert('hola Programadora');
})();


(function(){
	var vector = ['row','row-reverse','column','column-reverse'];
	for(i = 0 ; i < vector.length ; i++ ){
		//console.log(vector[i]);
		document.getElementById(""+vector[i]).addEventListener('click',mifuncion);
	}		
})();


function mifuncion(){
	// console.log(document.getElementById('row').checked);
	// console.log(document.getElementById('row-reverse').checked);
	// console.log(document.getElementById('column').checked);
	// console.log(document.getElementById('column-reverse').checked);

	if(document.getElementById('row').checked) 
		verifica('row');
	else if(document.getElementById('row-reverse').checked) 
		verifica('row-reverse');
	if(document.getElementById('column').checked) 
		verifica('column');
	else if(document.getElementById('column-reverse').checked) 
		verifica('column-reverse');
}

function verifica(estado){
	switch(estado){
		case 'row':
			document.getElementById('vista--flex-direction').style.flexDirection = 'row';
			break;
		case 'row-reverse':
			document.getElementById('vista--flex-direction').style.flexDirection = 'row-reverse';
			break;
		case 'column':
			document.getElementById('vista--flex-direction').style.flexDirection = 'column';
			break;
		case 'column-reverse':
			document.getElementById('vista--flex-direction').style.flexDirection = 'column-reverse';
			break;
		default:
			console.log('Error! flex-direction opcion incorrecta');
			break;
	}
}