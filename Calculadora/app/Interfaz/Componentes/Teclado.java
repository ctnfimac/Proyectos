package Interfaz.Componentes;

import Interfaz.Componentes.Pantalla;
import javax.swing.*;
import java.awt.event.*;

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
	
	public Teclado(Pantalla pantallaSuperior, Pantalla pantallaInferior){
		setLayout(null);
		setSize(400,420);
		agregarFilaDeBotones( nombresFila1, 90);
		agregarFilaDeBotones( nombresFila2, 175);
		agregarFilaDeBotones( nombresFila3, 260);
		agregarFilaDeBotones( nombresFila4, 345);

		this.pantallaSuperior = pantallaSuperior;
		this.pantallaInferior = pantallaInferior;
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

	public void controlDelTeclado(String teclaPresionada ){
		if(teclaPresionada.equals("=")){
		
			pantallaInferior.clearPantalla();
			if(pantallaSuperior.getPantalla().equals("") == false )
					pantallaInferior.setPantalla(pantallaSuperior.getPantalla());
			else pantallaInferior.setPantalla("0");
			pantallaSuperior.clearPantalla();
		
		}else if(teclaPresionada.equals("AC")){
		
			pantallaSuperior.clearPantalla();
			//pantallaSuperior.clearBuffer();
			pantallaInferior.clearPantalla();
			pantallaInferior.setPantalla("0");
		
		}else if(teclaPresionada.equals("DEL")){
			pantallaSuperior.eliminaCaracter();
		}else{
				pantallaSuperior.setPantalla(teclaPresionada);
		}
	}

	private class EventKey implements ActionListener{
		public void actionPerformed(ActionEvent e){
			String teclaPresionada = e.getActionCommand();
			controlDelTeclado(teclaPresionada);
		}
	}
}