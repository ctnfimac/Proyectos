
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
	private static int N_FILA = 5;
	private static int N_COLUMNA = 5;
	private static int TECLADO_ANCHO = 400;

	private JTextField lcd;
	
	private String[] nombresFila1= {"7","8","9","DEL","AC"};
	private String[] nombresFila2= {"4","5","6","X",   "/"};
	private String[] nombresFila3= {"1","2","3","+",   "-"};
	private String[] nombresFila4= {"0",".","sqrt","^","="};

	

	public Lamina(){
		setLayout(null);

		//agrego la pantalla superior
		lcd = new JTextField();
		lcd.setBounds(0,0,400,60);
		lcd.setText("0");

		agregarFilaDeBotones( nombresFila1, 60);
		agregarFilaDeBotones( nombresFila2, 145);
		agregarFilaDeBotones( nombresFila3, 230);
		agregarFilaDeBotones( nombresFila4, 315);

		add(lcd);
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

	private class EventKey implements ActionListener{
		public void actionPerformed(ActionEvent e){
			System.out.println("Boton presionado");
		}
	}
}