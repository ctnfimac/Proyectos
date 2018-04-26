package Interfaz.Componentes;

import Interfaz.Componentes.Pantalla;
import Matematica.Calculo.Calculo;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Teclado extends JPanel{
	public final int RESET = 0;
	public final int SUMA  = 1;
	public final int RESTA = 2;
	public final int MULTIPLICACION = 3;
	public final int DIVISION = 4;
	public final int POTENCIA = 5;
	public final int RAIZ = 6;

	private static int N_FILA = 4;
	private static int N_COLUMNA = 5;
	private static int TECLADO_ANCHO = 390;
	private static int TECLADO_ALTO = 320;

	private int operacion = RESET;

	//private boolean flagPrimerValorIngresado = false;
	private int flagListoParaOperar = 0;   // 0 - cuando estoy ingresando el valor 1
										   // 1 - cuando ingrese la operacion
										   // 2 - cuando ingrese la operacion =
	private String valor1;
	private String valor2;
	
	private int valor1Length;
						
	private String[][] matrizDeLetras = {{"7","8","9","DEL","AC"},
										 {"4","5","6","x","/"},
										 {"1","2","3","+","-"},
										 {"0",".","\u221A","^","="}};

	private GridLayout matrizDeBotones ;
	private Pantalla pantallaSuperior;
	private Pantalla pantallaInferior;
	

	public Teclado(Pantalla pantallaSuperior, Pantalla pantallaInferior){
		setLayout(null);
		setSize(400,420);

		this.pantallaSuperior = pantallaSuperior;
		this.pantallaInferior = pantallaInferior;
		matrizDeBotones = new GridLayout(N_FILA, N_COLUMNA , 5 , 5);
		agregarBotones();
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
				setEstilosDelBoton(boton, matrizDeLetras[i][j]);
				lamina.add(boton);
			}
		}
		add(lamina);
	}

	
	 
	/**
	 * le doy estilos al boton
	 */
	private void setEstilosDelBoton(JButton button, String letra){
		if(letra == "="){
			button.setBackground(new Color(34,139,34));
			button.setBorderPainted(false);
		}
		else if(letra == "+" || letra == "-" || letra == "x" || letra == "/" || letra == "\u221A" || 
		        letra == "^" || letra == "DEL" || letra == "AC"){
			button.setBackground(new Color(220,220,220));
			button.setForeground(new Color(70,130,180));
			button.setBorderPainted(false);
		}else{
			button.setBackground(new Color(230,230,250));
			button.setForeground(new Color(44,44,44));
		}
		
		button.setFont(new Font("Sans-serif", Font.PLAIN, 20));
			if(letra == "r"|| letra == "DEL" || letra == "AC"){
		}
	}

	private void controlDelTeclado(String teclaPresionada ){
		if(teclaPresionada.equals("="))		   this.controlIgual();
		else if(teclaPresionada.equals("AC"))  this.controlAC();
		else if(teclaPresionada.equals("DEL")) this.controlDEL();
		else if(teclaPresionada.equals("+"))   this.controlSuma(teclaPresionada);
		else if(teclaPresionada.equals("-"))   this.controlResta(teclaPresionada);
		else if(teclaPresionada.equals("x"))   this.controlMultiplicacion(teclaPresionada);
		else if(teclaPresionada.equals("/"))   this.controlDivision(teclaPresionada);
		else if(teclaPresionada.equals("^"))   this.controlPotencia(teclaPresionada);
		else if(teclaPresionada.equals("\u221A"))  this.controlRaiz(teclaPresionada);
		else this.controlNumerico(teclaPresionada);
	}
	
	
	private void controlNumerico(String teclaPresionada){
		if(flagListoParaOperar == 2){
			pantallaSuperior.setPantalla("");
			flagListoParaOperar = 0;
		}
		pantallaSuperior.setPantalla(teclaPresionada);
		if(flagListoParaOperar == 1){
			valor2 = pantallaSuperior.getPantalla();
			valor1Length = valor1.length() + 1; // valor para eliminar el valor 1 y el signo de la operacion
			String subString = valor2.substring(valor1Length);
			valor2 = subString;
		}
	}

	private void controlSuma(String teclaPresionada){
		if(flagListoParaOperar == 0){
			operacion = SUMA;
			valor1 = pantallaSuperior.getPantalla();
			valor1Length = valor1.length();
			pantallaSuperior.setPantalla(teclaPresionada);
			flagListoParaOperar = 1;
		}else{
			System.out.println("tiene que ingresar un número antes");
		}
	}

	
	private void controlIgual(){
			Long resultadoL = 0L;
				try{
					switch(operacion){
						case SUMA:
							resultadoL = Long.parseLong(valor1) + Long.parseLong(valor2);
							break;
						case RESTA:
							resultadoL = Long.parseLong(valor1) - Long.parseLong(valor2);
							break;
						case MULTIPLICACION:
							resultadoL = Long.parseLong(valor1) * Long.parseLong(valor2);
							break;
						case POTENCIA:
							resultadoL =(long) Math.pow(Double.parseDouble(valor1), Double.parseDouble(valor2)) ;
							break;
						case DIVISION:
							resultadoL = Long.parseLong(valor1) / Long.parseLong(valor2);
							break;
						case RAIZ:
							double raiz = Double.parseDouble(valor1);
							double prueba = 0;
							boolean flag = false;
							long i;
							for( i = 0 ; prueba < Double.parseDouble(valor2); i++){
								prueba = Math.pow(i, raiz);
								if(prueba == Double.parseDouble(valor2)) flag = true;
							}
							if(flag) resultadoL = i - 1;
							else resultadoL = 999999999999999999L;
							break;
						default:
							break;
					}
					
					if(resultadoL > 999999999999999998L){
						pantallaInferior.setPantalla("Math Error!");
					}else {
						pantallaInferior.setPantalla(String.valueOf(resultadoL));
					}
				}catch(NumberFormatException e){
					pantallaInferior.setPantalla("Exp Math Error!");
				}
				flagListoParaOperar = 2;
				valor1 = valor2 = "";
				operacion = RESET;
		
	}
	

	

	private void controlAC(){
			 pantallaSuperior.clearPantalla();
			 pantallaInferior.clearPantalla();
			 pantallaInferior.setPantalla("0");
			 operacion = RESET;
			 flagListoParaOperar = 0;
			 valor1 = valor2 = "";
	}

	private void controlDEL(){
			pantallaSuperior.eliminaCaracter();
	}

	

	private void controlResta(String teclaPresionada){
			if(flagListoParaOperar == 0){
				operacion = RESTA;
				valor1 = pantallaSuperior.getPantalla();
				valor1Length = valor1.length();
				pantallaSuperior.setPantalla(teclaPresionada);
				flagListoParaOperar = 1;
			}else{
				System.out.println("tiene que ingresar un número antes");
			}
	}

	private void controlMultiplicacion(String teclaPresionada){
			if(flagListoParaOperar == 0){
				operacion = MULTIPLICACION;
				valor1 = pantallaSuperior.getPantalla();
				valor1Length = valor1.length();
				pantallaSuperior.setPantalla(teclaPresionada);
				flagListoParaOperar = 1;
			}else{
				System.out.println("tiene que ingresar un número antes");
			}
	}

	private void controlDivision(String teclaPresionada){
			if(flagListoParaOperar == 0){
				operacion = DIVISION;
				valor1 = pantallaSuperior.getPantalla();
				valor1Length = valor1.length();
				pantallaSuperior.setPantalla(teclaPresionada);
				flagListoParaOperar = 1;
			}else{
				System.out.println("tiene que ingresar un número antes");
			}

	}

	private void controlPotencia(String teclaPresionada){
		if(flagListoParaOperar == 0){
			operacion = POTENCIA;
			valor1 = pantallaSuperior.getPantalla();
			valor1Length = valor1.length();
			pantallaSuperior.setPantalla(teclaPresionada);
			flagListoParaOperar = 1;
		}else{
			System.out.println("tiene que ingresar un número antes");
		}
	}

	private void controlRaiz(String teclaPresionada){
		if(flagListoParaOperar == 0){
			operacion = RAIZ;
			valor1 = pantallaSuperior.getPantalla();
			valor1Length = valor1.length();
			pantallaSuperior.setPantalla(teclaPresionada);
			flagListoParaOperar = 1;
		}else{
			System.out.println("tiene que ingresar un número antes");
		}
	}

	private class EventKey implements ActionListener{
		public void actionPerformed(ActionEvent e){
			String teclaPresionada = e.getActionCommand();
			controlDelTeclado(teclaPresionada);
		}
	}
}