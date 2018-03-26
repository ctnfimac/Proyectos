package Interfaz.Componentes;

import Interfaz.Componentes.Pantalla;
import Matematica.Calculo.Calculo;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Teclado extends JPanel{
	private static int N_FILA = 5;
	private static int N_COLUMNA = 5;
	private static int TECLADO_ANCHO = 400;
	
	private String[] nombresFila1= {"7","8","9","DEL","AC"};
	private String[] nombresFila2= {"4","5","6","X",   "/"};
	private String[] nombresFila3= {"1","2","3","+",   "-"};
	private String[] nombresFila4= {"0",".","sqrt","^","="};


	private Pantalla pantallaSuperior;
	private Pantalla pantallaInferior;
	
	private Calculo calculo;

	public Teclado(Pantalla pantallaSuperior, Pantalla pantallaInferior){
		setLayout(null);
		setSize(400,420);
		agregarFilaDeBotones( nombresFila1, 90);
		agregarFilaDeBotones( nombresFila2, 175);
		agregarFilaDeBotones( nombresFila3, 260);
		agregarFilaDeBotones( nombresFila4, 345);

		this.pantallaSuperior = pantallaSuperior;
		this.pantallaInferior = pantallaInferior;

		calculo = new Calculo();
	}

	private void agregarFilaDeBotones( String[] teclas, int posY){
		Box fila = Box.createHorizontalBox();
		fila.setBounds(0,posY,TECLADO_ANCHO,85);

		JPanel lamina = new JPanel();
		lamina.setLayout(new GridLayout());
		lamina.setBounds(0,0,TECLADO_ANCHO,85);
		
		for(int i = 0 ; i < N_FILA ; i++){
			JButton boton = new JButton(teclas[i]);
			boton.addActionListener(new EventKey());
			lamina.add(boton);
		}

		fila.add(lamina);
		add(fila);
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