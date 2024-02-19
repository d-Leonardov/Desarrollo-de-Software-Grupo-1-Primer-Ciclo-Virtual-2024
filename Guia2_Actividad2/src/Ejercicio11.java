import java.util.Scanner;

public class Ejercicio11 {

	public static int calcularDecenas (int número) {
		return número / 10;
	}
	
	public static int calcularUnidades (int número) {
		return número % 10;
	}
	
	public static String romanoUnidades(int número) {
        switch (número) {
            case 1:
                return "I";
            case 2:
                return "II";
            case 3:
                return "III";
            case 4:
                return "IV";
            case 5:
                return "V";
            case 6:
                return "VI";
            case 7:
                return "VII";
            case 8:
                return "VIII";
            case 9:
                return "IX";
            default:
                return "";
        }
    }
	
	public static String romanoDecenas(int número) {
        switch (número) {
            case 1:
                return "X";
            case 2:
                return "XX";
            case 3:
                return "XXX";
            case 4:
                return "XL";
            case 5:
                return "L";
            case 6:
                return "LX";
            case 7:
                return "LXX";
            case 8:
                return "LXXX";
            case 9:
                return "XC";
            default:
                return "";
        }
    }
	
	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		
        System.out.println("Ingrese un número entero entre 1 y 99:");
        int número = s.nextInt();

        if (número < 1 || número > 99) {
            System.err.print("El número debe estar entre 1 y 99.");
        } else {
            String decenas = romanoDecenas(calcularDecenas(número));
            String unidades = romanoUnidades(calcularUnidades(número));
            System.out.println("El número " + número + " en romano es: " + decenas + unidades);
        }
        
        s.close();
    }
}

