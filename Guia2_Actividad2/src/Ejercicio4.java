import java.util.Scanner;

public class Ejercicio4 {

	public static double calcularArriendo (double sueldo) {
		return sueldo * 0.40;
	}
	
	public static double calcularComida (double sueldo) {
		return sueldo * 0.15;
	}
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		System.out.println("Ingrese el sueldo de Pedro: ");
		double sueldo = s.nextDouble();
		
		double gastoArriendo = calcularArriendo(sueldo);
		double gastoComida = calcularComida(sueldo);
		//Dinero después del pago del arriendo y la comida.
		double saldo = sueldo - (gastoArriendo + gastoComida);
		
		System.out.printf("A Pedro con un sueldo de $%.2f y luego de pagar $%.2f"
				+ " de arriendo y \n$%.2f de comida le queda: "
				+ "$%.2f", sueldo, gastoArriendo, gastoComida, saldo);
		
		s.close();		
	}

}
