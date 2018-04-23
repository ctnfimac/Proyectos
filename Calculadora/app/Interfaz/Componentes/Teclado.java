package Interfaz.Componentes;

import Interfaz.Componentes.Pantalla;
import Matematica.Calculo.Calculo;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Teclado extends JPanel{
	private static int N_FILA = 4;
	private static int N_COLUMNA = 5;
	private static int TECLADO_ANCHO = 390;
	private static int TECLADO_ALTO = 320;

	private String[][] matrizDeLetras = {{"7","8","9","DEL","AC"},
										 {"4","5","6","X","/"},
										 {"1","2","3","+","-"},
										 {"0",".","sqrt","^","="}};

	private GridLayout matrizDeBotones ;
	private Pantalla pantallaSuperior;
	private Pantalla pantallaInferior;
	
	private Calculo calculo;

	public Teclado(Pantalla pantallaSuperior, Pantalla pantallaInferior){
		setLayout(null);
		setSize(400,420);

		this.pantallaSuperior = pantallaSuperior;
		this.pantallaInferior = pantallaInferior;
		matrizDeBotones = new GridLayout(N_FILA, N_COLUMNA , 5 , 5);
		agregarBotones();

		calculo = new Calculo();
	}

	public void agregarBotones(){
		JPanel lamina = new JPanel();
		lamina.setLayout(matrizDeBotones);
		lamina.setBounds(5,95,TECLADO_ANCHO,TECLADO_ALTO);

		for( int i = 0 ; i < N_FILA ; i++){
			for( int j = 0 ; j < N_COLUMNA ; j++){
				JButton boton = new JButton(matrizDeLetras[i][j]);
				boton.setForeground(Color.WHITE);
				boton.setFont(new Font("Sans-serif", Font.PLAIN, 30));
				boton.addActionListener(new EventKey());

				// ------   le doy estilos a los botones  -------
				if(matrizDeLetras[i][j]=="="){
					boton.setBackground(new Color(34,139,34));
					boton.setBorderPainted(false);
				}
				else if(matrizDeLetras[i][j]=="+" || matrizDeLetras[i][j]=="-" || matrizDeLetras[i][j]=="X" 
						|| matrizDeLetras[i][j]=="/" || matrizDeLetras[i][j]=="sqrt" || matrizDeLetras[i][j]=="^"
						|| matrizDeLetras[i][j]=="DEL" || matrizDeLetras[i][j]=="AC"){
					boton.setBackground(new Color(220,220,220));
					boton.setForeground(new Color(70,130,180));
					boton.setBorderPainted(false);
				}else{
					boton.setBackground(new Color(230,230,250));
					boton.setForeground(new Color(44,44,44));
				}
				
				if(matrizDeLetras[i][j]=="sqrt"|| matrizDeLetras[i][j]=="DEL" || matrizDeLetras[i][j]=="AC"){
					boton.setFont(new Font("Sans-serif", Font.PLAIN, 20));
				}
				// ------  fin de estilos de botones  --------

				lamina.add(boton);
			}
		}
		add(lamina);
	}

	private void controlDelTeclado(String teclaPresionada ){
		if(teclaPresionada.equals("="))		   this.controlIgual();
		else if(teclaPresionada.equals("AC"))  this.controlAC();
		else if(teclaPresionada.equals("DEL")) this.controlDEL();
		else if(teclaPresionada.equals("+"))   this.controlSuma();
		else if(teclaPresionada.equals("-"))   this.controlResta();
		else if(teclaPresionada.equals("X"))   this.controlMultiplicacion();
		else if(teclaPresionada.equals("/"))   this.controlDivision();
		else  pantallaSuperior.setPantalla(teclaPresionada);
		
	}

	private void controlIgual(){
		    calculo.guardarValor(pantallaSuperior.getPantalla());
			pantallaInferior.clearPantalla();

			if(pantallaSuperior.getPantalla().equals("") != true ) pantallaInferior.setPantalla(calculo.getBuffer());
			else pantallaInferior.setPantalla("0");

			pantallaSuperior.clearPantalla();
			calculo.tipoDeOperacion(calculo.RESET);
	}

	private void controlAC(){
			calculo.tipoDeOperacion(calculo.RESET);
			calculo.guardarValor("0");
			pantallaSuperior.clearPantalla();
			pantallaInferior.clearPantalla();
			pantallaInferior.setPantalla("0");
	}

	private void controlDEL(){
			pantallaSuperior.eliminaCaracter();
	}

	private void controlSuma(){
			calculo.tipoDeOperacion(calculo.SUMA);
			calculo.guardarValor(pantallaSuperior.getPantalla());
			pantallaSuperior.clearPantalla();
			pantallaInferior.clearPantalla();
			pantallaInferior.setPantalla(calculo.getBuffer());
	}

	private void controlResta(){
			calculo.tipoDeOperacion(calculo.RESTA);
			calculo.guardarValor(pantallaSuperior.getPantalla());
			pantallaSuperior.clearPantalla();
			pantallaInferior.clearPantalla();
			pantallaInferior.setPantalla(calculo.getBuffer());
	}

	private void controlMultiplicacion(){
			calculo.tipoDeOperacion(calculo.MULTIPLICACION);
			calculo.guardarValor(pantallaSuperior.getPantalla());
			pantallaSuperior.clearPantalla();
			pantallaInferior.clearPantalla();
			pantallaInferior.setPantalla(calculo.getBuffer());
	}

	private void controlDivision(){
			calculo.tipoDeOperacion(calculo.DIVISION);
			calculo.guardarValor(pantallaSuperior.getPantalla());
			pantallaSuperior.clearPantalla();
			pantallaInferior.clearPantalla();
			pantallaInferior.setPantalla(calculo.getBuffer());
	}

	private class EventKey implements ActionListener{
		public void actionPerformed(ActionEvent e){
			String teclaPresionada = e.getActionCommand();
			controlDelTeclado(teclaPresionada);
		}
	}
}