import java.util.Scanner;

public class Ejercicio8 {

	public static int totalSalones(int totalEstudiantes, int capacidadSalón) {
		return (int) Math.ceil((double) totalEstudiantes / capacidadSalón);
	}
	
	public static int númeroPisos(int totalSalones, int SalonesPiso) {
		return (int) Math.ceil((double)totalSalones / SalonesPiso);
	}
	
	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);

		System.out.println("Ingrese el número de estudiantes que tiene "
				+ "la universidad: ");
		int totalEstudiantes = s.nextInt();
		
		System.out.println("Ingrese la capacidad de estudiantes por salón: ");
		int capacidadSalón = s.nextInt();
		
		System.out.println("Ingrese el número de salones que tendrá un piso: ");
		int SalonesPiso = s.nextInt();
		
		System.out.print("El número de salones del nuevo edificio es: ");
		System.out.println(totalSalones(totalEstudiantes, capacidadSalón));
		
		System.out.print("El número de pisos del nuevo edificio es: ");
		System.out.println(númeroPisos(totalSalones(totalEstudiantes, capacidadSalón), SalonesPiso));
		
		s.close();		
	}
}
