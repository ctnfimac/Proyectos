package Interfaz.Componentes;

import javax.swing.*;
import java.awt.Font;

public class Pantalla extends JPanel{
	private JTextField pantalla;

	public Pantalla(Boolean editable, int height, int posY){
		setLayout(null);
		//setSize(400,60);
		setBounds(0,posY,400,height);

		pantalla = new JTextField(4);
		pantalla.setEditable(editable);
		pantalla.setBounds(0,0,400,height);
		pantalla.setText("");
		if(editable == false){
			pantalla.setHorizontalAlignment(JTextField.RIGHT);
			pantalla.setFont(new Font("Agency FB", Font.BOLD, 32));
			this.setPantalla("0");
		}
		add(pantalla);
	}

	public void setPantalla(String cadena){
		this.pantalla.setText(getPantalla()+cadena);
	}

	public String getPantalla(){
		String valor = "0";
		valor =  this.pantalla.getText();
		return valor;
	}

	public void clearPantalla(){
		this.pantalla.setText("");
	}

	public void eliminaCaracter(){
		String palabraDePantalla = this.pantalla.getText();
		int tamanioPalabraDePantalla = palabraDePantalla.length();
		
		if(tamanioPalabraDePantalla > 0){
			String palabraNueva = palabraDePantalla.substring(0,tamanioPalabraDePantalla-1);
			this.clearPantalla();
			this.pantalla.setText(palabraNueva);
		}
	}
}