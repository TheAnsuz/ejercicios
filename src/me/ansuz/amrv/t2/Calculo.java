package me.ansuz.amrv.t2;

import java.util.Scanner;

public class Calculo {

	public static final Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		System.out.println("Escriba \"exit\" para cerrar");
		boolean primeraVez = true;
		
		while(true) {
			if (primeraVez) {
				System.out.print("Por favor introduzca la operaci�n a realizar (ejemplo: 2 + 4): ");
				primeraVez = false;
			} else
				System.out.print("\nPor favor introduzca la operaci�n a realizar: ");
			final String txt = scan.nextLine().replaceAll(" ", ""); // Elimiar los espacios en blanco
                
			// Comprobador para terminar el programa
			if (txt.equalsIgnoreCase("exit"))
				System.exit(0);
			
			byte operator = -1; //0-suma 1-resta 2-multi 3-divi 4-resto
			long n1 = 0;
			long n2 = 0;
			
			try {
				boolean primerNumero = true;
				for (char c : txt.toCharArray()) {
					if (Character.digit(c, 10) != -1) {
						if (primerNumero)
							n1 = n1 * 10 + Character.digit(c, 10);
						else
							n2 = n2 * 10 + Character.digit(c, 10);
					} else {
						primerNumero = false;
						if (operator > 0)
							throw new Exception("Ya hay una operacion seleccionada");
						
						switch (c) {
						case '+':
							operator = 0;
							break;
						case '-':
							operator = 1;
							break;
						case '*':
						case 'x':
							operator = 2;
							break;
						case '/':
							operator = 3;
							break;
						case '%':
							operator = 4;
							break;
						default:
							throw new Exception("Operación invalida");
						}
						
					}
				}
				
			} catch (Exception e) {
				System.err.println("La formula introducida no es valida");
				continue;
			}
			
			double resultado = 0;
			
			switch (operator) {
			case 0:
				resultado = n1 + n2;
				break;
			case 1:
				resultado = n1 - n2;
				break;
			case 2:
				resultado = n1 * n2;
				break;
			case 3:
				resultado = n1 / n2;
				break;
			case 4:
				resultado = n1 % n2;
				break;
			default:
				resultado = Double.MIN_VALUE;
			}
			
			System.out.println("Resultado = " + resultado);
		}
		
	}
	
}
