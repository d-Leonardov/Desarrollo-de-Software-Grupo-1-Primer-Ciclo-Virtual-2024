import java.util.Scanner;

public class Ejercicio10 {

	public static int operaciónAritmética(int número1, String operador, int número2) {
		int resultado = 0;
		switch (operador) {
		case "+":
			resultado = número1 + número2;
			break;
		case "-":
			resultado = número1 - número2;
			break;
		case "*":
			resultado = número1 * número2;
			break;
		case "/":
			resultado = número1 / número2;
			break;
		case "%":
			resultado = número1 % número2;
			break;
		case "**":
			resultado = (int) Math.pow(número1, número2);
			break;
		default:
        System.out.println("Operador inválido.");
		}
		return resultado;
	}
	
	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);

		System.out.println("Ingrese el primer número: ");
		int número1 = s.nextInt();
	
		System.out.println("Ingrese el operador: ");
		String operador = s.next();
		
		System.out.println("Ingrese el segundo número: ");
		int número2 = s.nextInt();

		System.out.printf("El resultado con el operador (%s) es: ", operador);
		System.out.print(operaciónAritmética(número1, operador, número2));
		
		 s.close();
	}

}
