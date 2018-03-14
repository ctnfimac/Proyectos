package Interfaz.Calculadora;

import javax.swing.JFrame;
import javax.swing.JPanel;

import Interfaz.Componentes.Pantalla;
import Interfaz.Componentes.Teclado;

public class Calculadora extends JFrame{
	
	public Calculadora(){
		setTitle("Calculadora");
		setBounds(800,200,405,450);
		setResizable(false);
		LaminaCalculadora laminaCalculadora = new LaminaCalculadora();
		add(laminaCalculadora);
		setVisible(true);
	}
}

class LaminaCalculadora extends JPanel{	
	Pantalla pantallaSuperior;
	Pantalla pantallaInferior;

	public LaminaCalculadora(){
		setLayout(null);

		pantallaSuperior = new Pantalla(true,30,0);
		pantallaInferior = new Pantalla(false,60,29);
		Teclado teclado = new Teclado(pantallaSuperior,pantallaInferior);

		add(pantallaSuperior);
		add(pantallaInferior);
		add(teclado);
	}
	
}

