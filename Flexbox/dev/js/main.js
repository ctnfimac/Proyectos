// (function(){
// 	function nombrar(nombre){
// 		return nombre;
// 	}
// 	function saludar(nombre){
// 		console.info(nombre, ', un saludo desde DO Podcast');
// 	}
// 	saludar(nombrar('Christian Ivan Peralta'));
// })();


(function(){
	var vectorFlexDirection = ['row','row-reverse','column','column-reverse'];
	var vectorFlexWrap = ['nowrap','wrap','wrap-reverse'];
	var vectorflexContent = ['flex-start','flex-end','center','space-between','space-around','space-evenly'];
	var vectorFlexAlignItems = ['_flex-start','_flex-end','_center','stretch','baseline'];

	for(i = 0 ; i < vectorFlexDirection.length ; i++ ){
		document.getElementById(""+vectorFlexDirection[i]).addEventListener('click',mifuncionFlexDirection);
	}	
	
	for(i = 0 ; i < vectorFlexWrap.length ; i++ ){
		document.getElementById(""+vectorFlexWrap[i]).addEventListener('click',mifuncionFlexWrap);
	}
	
	for(i = 0 ; i < vectorflexContent.length ; i++ ){ 
		document.getElementById(""+vectorflexContent[i]).addEventListener('click',mifuncionFlexContent);
	}

	for(i = 0 ; i < vectorFlexAlignItems.length ; i++ ){ 
		document.getElementById(""+vectorFlexAlignItems[i]).addEventListener('click',mifuncionFlexAlignItems);
	}

	//console.log(document.getElementById('vista--flex-wrap').childNodes);
})();


// FLEX DIRECTION
function mifuncionFlexDirection(){
	if(document.getElementById('row').checked) 
		verificaFlexDirection('row');
	else if(document.getElementById('row-reverse').checked) 
		verificaFlexDirection('row-reverse');
	if(document.getElementById('column').checked) 
		verificaFlexDirection('column');
	else if(document.getElementById('column-reverse').checked) 
		verificaFlexDirection('column-reverse');
}

function verificaFlexDirection(estado){
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

// FLEX WRAP
function mifuncionFlexWrap(){
	if(document.getElementById('nowrap').checked){
		console.log('hola');
		verificaFlexWrap('nowrap');
	}
	else if(document.getElementById('wrap').checked) 
		verificaFlexWrap('wrap');
	else if(document.getElementById('wrap-reverse').checked) 
		verificaFlexWrap('wrap-reverse');
}

function verificaFlexWrap(estado){
	switch(estado){
		case 'nowrap':
		    console.log(document.getElementById('vista--flex-wrap'));
			document.getElementById('vista--flex-wrap').style.flexWrap = 'nowrap';
			break;
		case 'wrap':
			document.getElementById('vista--flex-wrap').style.flexWrap = 'wrap';
			break;
		case 'wrap-reverse':
			document.getElementById('vista--flex-wrap').style.flexWrap = 'wrap-reverse';
			break;
		default:
			console.log('Error! flex-wrap opcion incorrecta');
			break;
	}
}



// FLEX CONTENT
function mifuncionFlexContent(){
	if(document.getElementById('flex-start').checked)
		verificaFlexContent('flex-start');
	else if(document.getElementById('flex-end').checked) 
		verificaFlexContent('flex-end');
	else if(document.getElementById('center').checked) 
		verificaFlexContent('center');
	else if(document.getElementById('space-between').checked) 
		verificaFlexContent('space-between');
	else if(document.getElementById('space-around').checked) 
		verificaFlexContent('space-around');
	else if(document.getElementById('space-evenly').checked) 
		verificaFlexContent('space-evenly');
}
//'flex-start','flex-end','center','space-between','space-around','space-everly'
function verificaFlexContent(estado){
	switch(estado){
		case 'flex-start':
			document.getElementById('vista--flex-content').style.justifyContent = 'flex-start';
			break;
		case 'flex-end':
			document.getElementById('vista--flex-content').style.justifyContent = 'flex-end';
			break;
		case 'center':
			document.getElementById('vista--flex-content').style.justifyContent = 'center';
			break;
		case 'space-between':
			document.getElementById('vista--flex-content').style.justifyContent = 'space-between';
			break;
		case 'space-around':
			document.getElementById('vista--flex-content').style.justifyContent = 'space-around';
			break;
		case 'space-evenly':
			document.getElementById('vista--flex-content').style.justifyContent = 'space-evenly';
			console.log('hola');
			break;
		default:
			console.log('Error! flex-content opcion incorrecta');
			break;
	}
}


// FLEX ALIGN ITEMS
function mifuncionFlexAlignItems(){
	console.log('hola');
	if(document.getElementById('_flex-start').checked)
		verificaFlexAlignItems('_flex-start');
	else if(document.getElementById('_flex-end').checked) 
		verificaFlexAlignItems('_flex-end');
	else if(document.getElementById('_center').checked) 
		verificaFlexAlignItems('_center');
	else if(document.getElementById('stretch').checked) 
		verificaFlexAlignItems('stretch');
	else if(document.getElementById('baseline').checked) 
		verificaFlexAlignItems('baseline');
}

function verificaFlexAlignItems(estado){
	switch(estado){
		case '_flex-start':
			document.getElementById('vista--flex-alignItems').style.alignItems = 'flex-start';
			break;
		case '_flex-end':
			document.getElementById('vista--flex-alignItems').style.alignItems = 'flex-end';
			break;
		case '_center':
			document.getElementById('vista--flex-alignItems').style.alignItems = 'center';
			break;
		case 'stretch':
			document.getElementById('vista--flex-alignItems').style.alignItems = 'stretch';
			break;
		case 'baseline':
			document.getElementById('vista--flex-alignItems').style.alignItems = 'baseline';
			break;
		default:
			console.log('Error! flex-wrap opcion incorrecta');
			break;
	}
}