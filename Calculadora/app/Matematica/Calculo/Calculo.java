package Matematica.Calculo;

import java.awt.List;

public class Calculo{
	public final int RESET = 0;
	public final int SUMA = 1;
	private List lista;
	private Integer operacion;
	private String buffer = "0";
	private String[] vector;

	public Calculo(){
		lista = new List();
		operacion = RESET;
	} 

	public void tipoDeOperacion(int operacion){
		this.operacion = operacion;
		//System.out.println("tipoDeOperacion6");
	}

	public void guardarValor(String valor){
		//lista.add(valor);
		//System.out.println("valor guardado : " + lista.getItem(0));	
		switch(this.operacion){
			case RESET:
				buffer = valor;
				break;
			case SUMA:
				if(valor.equals("") == true) valor = "0";
				buffer = getSuma(buffer , valor);
				break;
			default: 
				break;
		}
		
	}

	public String realizarOperacion(){
		String resultado = "";
		return resultado;
	}


	public String getBuffer(){
		return this.buffer;
	}

	public String getSuma(String valor1 , String valor2){
		if(valor2 == "") valor2 = "0";
		Double aux1 = Double.parseDouble(valor1);
		Double aux2 = Double.parseDouble(valor2);
		Double suma = aux1 + aux2;
		String aux3 = String.valueOf(suma);
		return aux3;
	}

	public Double getResta(String valor1 , String valor2){
		Double aux1 = Double.parseDouble(valor1);
		Double aux2 = Double.parseDouble(valor2);

		return aux1 - aux2;
	}

	public Double getMultiplicacion(String valor1 , String valor2){
		Double aux1 = Double.parseDouble(valor1);
		Double aux2 = Double.parseDouble(valor2);

		return aux1 * aux2;
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

	/*public static void main(String[] args){
		Calculo calculo = new Calculo();
		System.out.println("suma:" + calculo.getSuma("3","4"));
		System.out.println("resta:" + calculo.getResta("3","4"));
		System.out.println("Multiplicacion:" + calculo.getMultiplicacion("3","4"));
		System.out.println("division:" + calculo.getDivision("30","4"));
		System.out.println("potencia:" + calculo.getPotencia("3","4"));
		System.out.println("raiz:" + calculo.getRaiz("81","2"));
	}*/

}

