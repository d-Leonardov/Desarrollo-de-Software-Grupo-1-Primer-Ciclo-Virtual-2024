import java.util.Scanner;

public class Ejercicio1 {

	public static double valorfuncion(double x, double y) {
	   return Math.pow(x, 2) + 2 * x * y + Math.pow(y, 2);
	}
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		System.out.println("Ingrese el valor de x: ");
		double x = s.nextDouble();
		
		System.out.println("Ingrese el valor de y: ");
		double y = s.nextDouble();
		
		double resultado = valorfuncion(x, y);
			
		System.out.printf("El resultado de la funciòn f(x,y)= x^2 + 2xy + y^2 con los "
				+ "valores x:%.2f, y:%.2f es: %.2f", x, y, resultado);
		
		s.close();
	}
}
