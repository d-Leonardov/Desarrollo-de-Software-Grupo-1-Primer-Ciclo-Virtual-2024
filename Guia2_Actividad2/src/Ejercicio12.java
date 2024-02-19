import java.util.Scanner;

public class Ejercicio12 {

	public static String obtenerDiaMañana(String dia) {
		switch (dia) {
		case "domingo":
			dia = "Lunes";
			System.out.println("El dia de mañana es " + dia);
			break;
		case "lunes":
			dia = "Martes";
			System.out.println("El dia de mañana es " + dia);
			break;
		case "martes":
			dia = "Miércoles";
			System.out.println("El dia de mañana es " + dia);
			break;
		case "miércoles":
			dia = "Jueves";
			System.out.println("El dia de mañana es " + dia);
			break;
		case "jueves":
			dia = "Viernes";
			System.out.println("El dia de mañana es " + dia);
			break;	
		case "viernes":
			dia = "Sábado";
			System.out.println("El dia de mañana es " + dia);
			break;
		case "sábado":
			dia = "Domingo";
			System.out.println("El dia de mañana es " + dia);
			break;
		default:
			System.err.println(dia + " no es un día válido");;
			break;
		}
		return dia;
	}
	
	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		
        System.out.println("Ingrese un día de la semana");
        String dia = s.next().trim().toLowerCase();
		
        obtenerDiaMañana(dia);
        
        s.close();
 	}

}
