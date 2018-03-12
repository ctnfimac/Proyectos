/*
  @description: Calculadora 
  @author: Christian Peralta
  @fecha: 26-07-2017
*/

import java.util.Scanner;
import javax.swing.*;

class Aplicacion{

	public static void main(String[] args){
		Marco marco = new Marco();
		marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void print(String s){
		System.out.print(s);
	}

	public static void println(String s){
		System.out.println(s);
	}
}