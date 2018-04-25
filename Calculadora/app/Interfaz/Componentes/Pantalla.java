package Interfaz.Componentes;

import javax.swing.*;
import java.awt.Font;

public class Pantalla extends JPanel{
	private JTextField pantalla;
	private boolean editable;

	public Pantalla(Boolean editable, int height, int posY){
		setLayout(null);
		setBounds(0,posY,400,height);

		this.editable = editable;	
		pantalla = new JTextField(4);
		pantalla.setEditable(editable);
		pantalla.setBounds(0,0,400,height);
		pantalla.setText("");
		pantalla.setFont(new Font("Arial", Font.PLAIN, 18));
		pantalla.setBorder(null);
		if(this.editable == false){
			pantalla.setHorizontalAlignment(JTextField.RIGHT);
			pantalla.setFont(new Font("Arial", Font.PLAIN, 38));
			this.setPantalla("0");
		}
		add(pantalla);
	}

	public void setPantalla(String cadena){
		//System.out.println("cadena = "+ cadena);
		if(getEditable()){
			if(cadena == "" ){
				this.pantalla.setText("");
			}else this.pantalla.setText(getPantalla()+cadena);
		}else{
			this.pantalla.setText(cadena);
		}
	}

	public String getPantalla(){
		String valor =  this.pantalla.getText();
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

	public boolean getEditable(){
		return this.editable;
	}
}