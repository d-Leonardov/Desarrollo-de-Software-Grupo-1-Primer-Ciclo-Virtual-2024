import java.util.Scanner;

public class Ejercicio7 {

	public static void main(String[] args) {

		EjeCartesiano ec = new EjeCartesiano();
		Scanner s = new Scanner(System.in);
		
		System.out.println("Ingrese el valor del punto y2: ");
		ec.setY2(s.nextDouble());
		
		System.out.println("Ingrese el valor del punto y1: ");
		ec.setY1(s.nextDouble());
		
		System.out.println("Ingrese el valor del punto x2: ");
		ec.setX2(s.nextDouble());
		
		System.out.println("Ingrese el valor del punto x1: ");
		ec.setX1(s.nextDouble());
		System.out.println();
		
		System.out.printf("La distancia entre los puntos es: %.2f\n"
				+ "La pendiente de los puntos es: %.2f", 
				ec.calcularDistancia(ec.getY2(), ec.getY1(), ec.getX2(), ec.getX1())
				, ec.calcularPendiente(ec.getY2(), ec.getY1(), ec.getX2(), ec.getX1()));
		
		s.close();
	}

}

class EjeCartesiano {
	private double x1;
	private double x2;
	private double y1;
	private double y2;
	
	public double getX1() {
		return x1;
	}
	public void setX1(double x1) {
		this.x1 = x1;
	}
	public double getX2() {
		return x2;
	}
	public void setX2(double x2) {
		this.x2 = x2;
	}
	public double getY1() {
		return y1;
	}
	public void setY1(double y1) {
		this.y1 = y1;
	}
	public double getY2() {
		return y2;
	}
	public void setY2(double y2) {
		this.y2 = y2;
	}
	
	public double calcularDistancia (double y2, double y1, double x2, double x1) {
		return Math.sqrt(Math.pow((y2 - y1), 2) + Math.pow((x2 - x1), 2));
	}
	
	public double calcularPendiente (double y2, double y1, double x2, double x1) {
		return (y2 - y1) / (x2 - x1);
	}
}
