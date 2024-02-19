import java.util.Scanner;

public class Ejercicio2 {

	public static int calcularBuses(int sillas, int estudianesGordos,
			int estudiantesFlacos) {
		
		int totalEstudiantes = (estudianesGordos * 2) + estudiantesFlacos;
		return (int)Math.ceil((double) totalEstudiantes / sillas);
	}
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		System.out.println("Ingrese la cantidad de sillas: ");
		int sillasBus = s.nextInt();
		
		System.out.println("Ingrese la cantidad de estudiantes gordos: ");
		int estudianesGordos = s.nextInt();
		
		System.out.println("Ingrese la cantidad de estudiantes flacos: ");
		int estudiantesFlacos = s.nextInt();
		
		int busesNecesarios = calcularBuses(sillasBus, estudianesGordos, estudiantesFlacos);
		
		System.out.printf("Se necesitan %d buses para transportar %d estudiantes."
			,busesNecesarios, estudianesGordos + estudiantesFlacos);
		
		s.close();
	}
}
