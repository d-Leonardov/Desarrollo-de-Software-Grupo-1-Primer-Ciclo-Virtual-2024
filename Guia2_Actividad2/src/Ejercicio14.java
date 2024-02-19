import java.util.Scanner;

public class Ejercicio14 {

	public static String nombreHermanoMayor(String nombre1, int edad1, 
			String nombre2, int edad2, String nombre3, int edad3) {
        if (edad1 > edad2 && edad1 > edad3) {
        	return nombre1 + " es el hermano mayor.";
        } else if (edad2 > edad1 && edad2 > edad3) {
        	return nombre2 + " es el hermano mayor.";
        } else if (edad3 > edad1 && edad3 > edad2) {
        	return nombre3 + " es el hermano mayor.";
        } else if (edad1 == edad2 && edad1 != edad3) {
        	return nombre1 + " y " + nombre2 + " tienen la misma edad.";
        } else if (edad1 == edad3 && edad1 != edad2) {
        	return nombre1 + " y " + nombre3 + " tienen la misma edad.";
        } else if (edad2 == edad3 && edad2 != edad1) {
        	return nombre2 + " y " + nombre3 + " tienen la misma edad.";
        } else {
        	return "Los tres hermanos tienen la misma edad.";
        }
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Ingrese el nombre del primer hermano:");
		String nombre1 = scanner.next();
		System.out.println("Ingrese la edad del primer hermano:");
		int edad1 = scanner.nextInt();

		System.out.println("Ingrese el nombre del segundo hermano:");
		String nombre2 = scanner.next();
		System.out.println("Ingrese la edad del segundo hermano:");
		int edad2 = scanner.nextInt();

		System.out.println("Ingrese el nombre del tercer hermano:");
		String nombre3 = scanner.next();
		System.out.println("Ingrese la edad del tercer hermano:");
		int edad3 = scanner.nextInt();

		String hermanoMayor = nombreHermanoMayor(nombre1, edad1, 
				nombre2, edad2, nombre3, edad3);
		System.out.println(hermanoMayor.substring(0, 1).toUpperCase() + hermanoMayor.substring(1).toLowerCase());
		
		scanner.close();
	}
}
