import java.util.Scanner;

public class Ejercicio5 {
	
	public static void main(String[] args) {
		Circulo circulo = new Circulo();
		
		Scanner s = new Scanner(System.in);
		
		System.out.println("Ingrese el valor del radio pequeño: ");
		circulo.setRadioPequeño(s.nextDouble());
		
		System.out.println("Ingrese el valor del radio grande: ");
		circulo.setRadioGrande(s.nextDouble());
		
		System.out.printf("El área de la corona circular es: %.2f \n", 
				circulo.calcularÁreaCorona(circulo.getRadioPequeño(), 
				circulo.getRadioGrande()));
		
		s.close();
	}
}

class Circulo {
	
	private double radioGrande;
	private double radioPequeño;
	
	public double calcularÁreaCirculoGrande (double radio) {
		return Math.pow(radioGrande, 2) * Math.PI;
	}
	
	public double calcularÁreaCorona (double radioPequeño, double radioGrande ) {
		double áreaCirculoPequeño = Math.pow(radioPequeño, 2) * Math.PI;
		return calcularÁreaCirculoGrande(radioGrande) - áreaCirculoPequeño;
	}

	public double getRadioGrande() {
		return radioGrande;
	}

	public void setRadioGrande(double radioGrande) {
		this.radioGrande = radioGrande;
	}

	public double getRadioPequeño() {
		return radioPequeño;
	}

	public void setRadioPequeño(double radioPequeño) {
		this.radioPequeño = radioPequeño;
	}
}