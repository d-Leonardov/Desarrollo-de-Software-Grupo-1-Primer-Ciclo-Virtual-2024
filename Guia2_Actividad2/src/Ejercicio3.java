import java.util.Scanner;

public class Ejercicio3 {

	public static void main(String[] args) {
		Escalera escalera = new Escalera();
				
		Scanner s = new Scanner(System.in);
		
		System.out.println("Ingrese la altura: ");
		escalera.setAltura(s.nextDouble());
		
		System.out.println("Ingrese el ángulo: ");
		escalera.setÁngulo(s.nextDouble());
		
		double longitud = escalera.calcularLongitud(escalera.getAltura(), 
				escalera.getÁngulo());
		
		System.out.printf("La longitud de la escalera cuyo ángulo de inclinación: "
				+ "%.2f° y altura: %.2f es: %.2f" , escalera.getÁngulo(), 
				escalera.getAltura(), longitud);
		
		s.close();
	}
}

class Escalera {
	
	private double altura;
	private double ángulo;
	
	public double getAltura() {
		return altura;
	}
	public void setAltura(double altura) {
		this.altura = altura;
	}
	public double getÁngulo() {
		return ángulo;
	}
	public void setÁngulo(double ángulo) {
		this.ángulo = ángulo;
	}
	
	public double calcularLongitud (double altura, double ángulo) {
		double anguloRadianes = Math.toRadians(ángulo);
		double distanciaHorizontal = altura * Math.tan(anguloRadianes);
		return Math.sqrt(Math.pow(distanciaHorizontal, 2) + Math.pow(altura, 2));
	}
}

