/*
  @description: Calculadora 
  @author: Christian Peralta
  @fecha: 26-07-2017
*/

import java.util.Scanner;
import javax.swing.*;

import Interfaz.Calculadora.Calculadora;
import Interfaz.Componentes.Pantalla;
import Matematica.Calculo.Calculo;
import Interfaz.Componentes.Teclado;
class Aplicacion{

	public static void main(String[] args){
		Calculadora calculadora = new Calculadora();
		calculadora.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}