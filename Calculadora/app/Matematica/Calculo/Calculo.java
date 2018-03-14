package Matematica.Calculo;

public class Calculo{

	public Double getSuma(String valor1 , String valor2){
		Double aux1 = Double.parseDouble(valor1);
		Double aux2 = Double.parseDouble(valor2);

		return aux1 + aux2;
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

