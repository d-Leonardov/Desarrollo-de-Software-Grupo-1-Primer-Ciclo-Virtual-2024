import java.util.Scanner;

public class Ejercicio6 {

	public static double calcularÁreaRectangulo (double base, double altura) {
		return base * altura;
	}
	
	public static double calcularHipotenusa (double base, double altura) {
		return Math.sqrt(Math.pow(base, 2) + Math.pow(altura, 2));
	}
	
	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		
		System.out.println("Ingrese el valor de A: ");
		double A = s.nextDouble(); 
		
		System.out.println("Ingrese el valor de B: "); 
		double B = s.nextDouble();
		
		System.out.println("Ingrese el valor de C: ");
		double C = s.nextDouble();
		
		double alturaTriangulo = A - C;
		double áreaTriangulo = (B * alturaTriangulo) / 2;
		double áreaRectangulo = calcularÁreaRectangulo(B, C);
		double hipotenusa = calcularHipotenusa(B, alturaTriangulo);
		double perimetroTerreno = A + B + C + hipotenusa;
				
		System.out.printf("El área del terreno es: %.2f\nEl perímetro "
				+ "del terreno es: %.2f",  áreaTriangulo + áreaRectangulo, perimetroTerreno);
		
		s.close();
	}
}
