import java.util.Scanner;

public class Ejercicio13 {
	
	public static double valorAumento(double sueldo) {
		if (sueldo <= 800000) {
			return sueldo * 0.10;
		} else if (sueldo > 800000 && sueldo <= 1200000) {
			return sueldo * 0.08;
		} else {
			return sueldo * 0.05;
		}
	}
	
	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		
		System.out.println("Ingrese el sueldo del empleado:");
		double sueldo = s.nextDouble();
		
		double aumento = valorAumento(sueldo);		
		double nuevoSueldo = aumento + sueldo;
		
        System.out.printf("El nuevo salario para el empleado es: %.2f%n", nuevoSueldo);
        
        s.close();
	}
}

