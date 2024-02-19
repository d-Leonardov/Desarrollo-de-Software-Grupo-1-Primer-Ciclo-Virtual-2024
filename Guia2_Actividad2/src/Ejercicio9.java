import java.util.Scanner;

public class Ejercicio9 {

	public static void enteroMayor(int número1, int número2) {
		if (número1 > número2) {
			System.out.printf("El primer número (%d) es el número mayor", número1);
		} else if (número2 > número1) {
			System.out.printf("El segundo número (%d) es el número mayor", número2);
		} 
	}
		
	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);

		System.out.println("Ingrese el primer número: ");
		int número1 = s.nextInt();
		
		System.out.println("Ingrese el segundo número: ");
		int número2 = s.nextInt();
		
		enteroMayor(número1, número2);
		s.close();
	}

}
