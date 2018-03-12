
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Marco extends JFrame{
	
	public Marco(){
		setTitle("Calculadora");
		setBounds(800,200,405,430);
		setResizable(false);
		Lamina lamina = new Lamina();
		add(lamina);
		setVisible(true);
	}
}

class Lamina extends JPanel{
	private JButton b7, b8, b9, bdel, bac;
	private JButton b4, b5, b6, bmul, bdiv;
	private JButton b1, b2, b3, bsum, bres;
	private JButton b0, bpunto, braiz, bpot, bigual;
	private JTextField lcd;
	private String buffer;
	private int bufferInt, operacion;
	private boolean enoperacion = false;

	public Lamina(){
		buffer = "";
		bufferInt = 0;
		operacion = 0;
		setLayout(null);

		lcd = new JTextField();
		lcd.setBounds(0,0,400,60);
		lcd.setText("0");

		JPanel botonera = new JPanel();
		botonera.setBounds(0,60,400,340);
		botonera.setLayout(new GridLayout());

		Box fila1 = Box.createHorizontalBox();
		JPanel lamfila1 = new JPanel();
		fila1.setBounds(0,60,400,85);
		lamfila1.setLayout(new GridLayout());
		lamfila1.setBounds(0,0,400,85);
		fila1.add(lamfila1);

		Box fila2 = Box.createHorizontalBox();
		JPanel lamfila2 = new JPanel();
		fila2.setBounds(0,145,400,85);
		lamfila2.setLayout(new GridLayout());
		lamfila2.setBounds(0,0,400,85);
		fila2.add(lamfila2);

		Box fila3 = Box.createHorizontalBox();
		JPanel lamfila3 = new JPanel();
		fila3.setBounds(0,230,400,85);
		lamfila3.setLayout(new GridLayout());
		lamfila3.setBounds(0,0,400,85);
		fila3.add(lamfila3);

		Box fila4 = Box.createHorizontalBox();
		JPanel lamfila4 = new JPanel();
		fila4.setBounds(0,315,400,85);
		lamfila4.setLayout(new GridLayout());
		lamfila4.setBounds(0,0,400,85);
		fila4.add(lamfila4);

		// instancio los botones
		b7 = new JButton("7");
		b8 = new JButton("8");
		b9 = new JButton("9");
		bdel = new JButton("DEL");
		bac = new JButton("AC");

		b4 = new JButton("4");
		b5 = new JButton("5");
		b6 = new JButton("6");
		bmul = new JButton("x");
		bdiv = new JButton("/");

		b1 = new JButton("1");
		b2 = new JButton("2");
		b3 = new JButton("3");
		bsum = new JButton("+");
		bres = new JButton("-");

		b0 = new JButton("0");
		bpunto = new JButton(".");
		braiz = new JButton("sqrt");
		bpot = new JButton("^");
		bigual = new JButton("=");

		// pongo los botones a la escucha del evento
		b7.addActionListener(new EventKey());
		b8.addActionListener(new EventKey());
		b9.addActionListener(new EventKey());
		bdel.addActionListener(new EventKey());
		bac.addActionListener(new EventKey());
		
		b4.addActionListener(new EventKey());
		b5.addActionListener(new EventKey());
		b6.addActionListener(new EventKey());
		bmul.addActionListener(new EventKey());
		bdiv.addActionListener(new EventKey());
		
		b1.addActionListener(new EventKey());
		b2.addActionListener(new EventKey());
		b3.addActionListener(new EventKey());
		bsum.addActionListener(new EventKey());
		bres.addActionListener(new EventKey());

		b0.addActionListener(new EventKey());
		bpunto.addActionListener(new EventKey());
		braiz.addActionListener(new EventKey());
		bpot.addActionListener(new EventKey());
		bigual.addActionListener(new EventKey());


	    
	    // agrego los botones a las distintas laminas
		lamfila1.add(b7);
		lamfila1.add(b8);
		lamfila1.add(b9);
		lamfila1.add(bdel);
		lamfila1.add(bac);

		lamfila2.add(b4);
		lamfila2.add(b5);
		lamfila2.add(b6);
		lamfila2.add(bmul);
		lamfila2.add(bdiv);

		lamfila3.add(b1);
		lamfila3.add(b2);
		lamfila3.add(b3);
		lamfila3.add(bsum);
		lamfila3.add(bres);

		lamfila4.add(b0);
		lamfila4.add(bpunto);
		lamfila4.add(braiz);
		lamfila4.add(bpot);
		lamfila4.add(bigual);


		add(lcd);
		add(fila1);
		add(fila2);
		add(fila3);
		add(fila4);
	}

	private class EventKey implements ActionListener{
		public void actionPerformed(ActionEvent e){
			// String tecla = e.getActionCommand(); 
			// if( tecla == "0" || tecla == "1" || tecla == "2" || tecla == "3" ||
			// 	tecla == "4" || tecla == "5" || tecla == "6" || tecla == "7" ||
			// 	tecla == "8" || tecla == "9" ){
			// 	if(enoperacion == false){
			// 		buffer = ""; 
			// 		enoperacion = true;   
			// 	}
			// 	  buffer = buffer.concat(tecla);
			// 	  lcd.setText(buffer);
			// }
			// if( tecla == "AC"){
			// 	//System.out.println("Tecla AC");
			// 	buffer = "";
			// 	bufferInt = 0;
			// 	operacion = 0;
			// 	lcd.setText("0");
			// }
			// if( tecla == "+"){
			// 	//System.out.println("Tecla +");
			// 	if(buffer!=""){
			// 		bufferInt = Integer.parseInt(buffer);
			// 		buffer = "";
			// 		//lcd.setText("0");
			// 		operacion = 1;
					
			// 	}	
			// }
			
			// if( tecla == "-"){
			// 	//System.out.println("Tecla -");
			// 	if(buffer!=""){
			// 		bufferInt = Integer.parseInt(buffer);
			// 		buffer = "";
			// 		//lcd.setText("0");
			// 		operacion = 2;
					
			// 	}
			// }

			// if( tecla == "x"){
			// 	//System.out.println("Tecla -");
			// 	if(buffer!=""){
			// 		bufferInt = Integer.parseInt(buffer);
			// 		buffer = "";
			// 		//lcd.setText("0");
			// 		operacion = 3;
					
			// 	}
			// }
			// if( tecla == "/"){
			// 	//System.out.println("Tecla -");
			// 	if(buffer!=""){
			// 		bufferInt = Integer.parseInt(buffer);
			// 		buffer = "";
			// 		//lcd.setText("0");
			// 		operacion = 4;
					
			// 	}
			// }
			// /*
			// if( tecla == "^"){
			// 	System.out.println("Tecla ^");
			// }

			// if( tecla == "DEL"){
			// 	System.out.println("Tecla DEL");
			// }*/
			
			// if( tecla == "="){
			// 	//System.out.println("Tecla =");
			// 	switch(operacion){
			// 		case 0:// igual
			// 			if(buffer=="") lcd.setText("0");
			// 			else{
			// 				bufferInt =  Integer.parseInt(buffer);
			// 				lcd.setText(Integer.toString(bufferInt));
			// 				System.out.println("valor: "+Integer.toString(bufferInt));
			// 				buffer = Integer.toString(bufferInt);
			// 				//buffer="";
			// 			}
			// 			break;
			// 		case 1: //si se sumo
			// 		    int buffer2  =  Integer.parseInt(buffer);
			// 		    System.out.println("buffer2:"+buffer2+",bufferint: "+bufferInt);
			// 		    buffer2 = buffer2 + bufferInt;
			// 		    lcd.setText(Integer.toString(buffer2));
			// 		    buffer = Integer.toString(buffer2);
			// 		    buffer2 = 0;
			// 		    operacion = 0;
			// 		    enoperacion = false;
			// 			break;
			// 		case 2:
			// 		 	buffer2  =  Integer.parseInt(buffer);
			// 		    System.out.println("buffer2:"+buffer2+",bufferint: "+bufferInt);
			// 		    buffer2 = bufferInt - buffer2;
			// 		    lcd.setText(Integer.toString(buffer2));
			// 		    buffer = Integer.toString(buffer2);
			// 		    buffer2 = 0;
			// 		    operacion = 0;
			// 		    enoperacion = false;
			// 			break;
			// 		case 3:
			// 			buffer2  =  Integer.parseInt(buffer);
			// 		    System.out.println("buffer2:"+buffer2+",bufferint: "+bufferInt);
			// 		    buffer2 = bufferInt * buffer2;
			// 		    lcd.setText(Integer.toString(buffer2));
			// 		    buffer = Integer.toString(buffer2);
			// 		    buffer2 = 0;
			// 		    operacion = 0;
			// 		    enoperacion = false;
			// 			break;
			// 		case 4:
			// 			buffer2  =  Integer.parseInt(buffer);
			// 		    System.out.println("buffer2:"+buffer2+",bufferint: "+bufferInt);
			// 		    buffer2 = bufferInt / buffer2;
			// 		    lcd.setText(Integer.toString(buffer2));
			// 		    buffer = Integer.toString(buffer2);
			// 		    buffer2 = 0;
			// 		    operacion = 0;
			// 		    enoperacion = false;
			// 			break;
			// 	}
			// }
			
			System.out.println("Boton presionado");
		}
	}
}