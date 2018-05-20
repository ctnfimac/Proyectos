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


		//-  var opcionesFlexDirection = ['row','row-reverse','column','column-reverse'] 
		
		//- each aux in opcionesFlexDirection	
		//- label #{aux}
		//- input(type="radio", name="flexDirection" value=`${aux}`)

		//- section.flexbox
		//- 	.container
		//- 		h2.opciones--titulo FLEX-DIRECTION
		//- 		.flex__opciones
		//- 			.flex__opciones--item
		//- 				label rows
		//- 				input(type="radio", name="flexDirection" value="row")
		//- 			.flex__opciones--item
		//- 				label row-reverse
		//- 				input(type="radio", name="flexDirection" value="row-reverse")
		//- 			.flex__opciones--item
		//- 				label column
		//- 				input(type="radio", name="flexDirection" value="column")
		//- 			.flex__opciones--item
		//- 				label column-reverse
		//- 				input(type="radio", name="flexDirection" value="column-reverse")
				
		//- 		 .flex__salida
				//- 	each box in [1, 2, 3, 4, 5, 6, 7]
				//- 		div.box #{box}
					