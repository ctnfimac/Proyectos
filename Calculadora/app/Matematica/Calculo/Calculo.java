package Matematica.Calculo;

import java.awt.List;

public class Calculo{
	public final int RESET = 0;
	public final int SUMA  = 1;
	public final int RESTA = 2;
	public final int MULTIPLICACION = 3;
	private List lista;
	private Integer operacion;
	private String buffer = "0";
	private String[] vector;

	private boolean primerResta = true;
	private boolean primerMultiplicacion = true;

	public Calculo(){
		lista = new List();
		operacion = RESET;
	} 

	public void tipoDeOperacion(int operacion){
		this.operacion = operacion;
	}

	public void guardarValor(String valor){
		switch(this.operacion){
			case RESET:
				buffer = valor;
				primerResta = true;
				primerMultiplicacion = true;
				break;
			case SUMA:
			    if(valor.equals("") == true) valor = "0";
				buffer = getSuma(buffer , valor);
				break;
			case RESTA:
			    if(valor.equals("") == true) valor = "0";
				buffer = getResta(buffer , valor);
				break;
			case MULTIPLICACION:
				if(valor.equals("") == true) valor = "1";
				buffer = getMultiplicacion(buffer , valor);
				break;
			default: 
				break;
		}
		
	}


	public String getBuffer(){
		return this.buffer;
	}

	public String getSuma(String valor1 , String valor2){
		Double aux1 = Double.parseDouble(valor1);
		Double aux2 = Double.parseDouble(valor2);
		Double suma = aux1 + aux2;
		String aux3 = String.valueOf(suma);
		return aux3;
	}

	public String getResta(String valor1 , String valor2){
		Double aux1 = Double.parseDouble(valor1);
		Double aux2 = Double.parseDouble(valor2);
		if(this.primerResta == true && aux2 > 0){
			aux2 = 0 - aux2;
			this.primerResta = false;
		}
		Double resta = aux1 - aux2;
		String aux3 = String.valueOf(resta);
		return aux3;
	}

	public String getMultiplicacion(String valor1 , String valor2){
		if(this.primerMultiplicacion == true){
			valor1 = "1";
			this.primerMultiplicacion = false;
		}	
		Double aux1 = Double.parseDouble(valor1);
		Double aux2 = Double.parseDouble(valor2);
		
		Double multiplicacion = aux1 * aux2;
		String aux3 = String.valueOf(multiplicacion);
		return aux3;
	}

	public Double getDivision(String valor1 , String valor2){
		Double aux1 = Double.parseDouble(valor1);
		Double aux2 = Double.parseDouble(valor2);

		return aux1 / aux2;
	}

	public Double getPotencia(String base , String exponente){
		Double aux1 = Double.parseDouble(base);
		Integer aux2 = Integer.valueOf(exponente);

		return  Math.pow(aux1, aux2);
	}


	public Double getRaiz(String base , String raiz){
		Double aux1 = Double.parseDouble(base);
		Double aux2 = Double.parseDouble(raiz);

		return  Math.pow(aux1, 1/aux2);
	}

}

