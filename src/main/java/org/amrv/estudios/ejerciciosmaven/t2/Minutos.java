package org.amrv.estudios.ejerciciosmaven.t2;

import java.util.Scanner;

public class Minutos {

	public static final Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
	
		System.out.println("Escribe \"exit\" para salir");
		long s = 0;
		
		while(true) {
			final String text = scan.nextLine();
						
			if (text.equalsIgnoreCase("exit"))
				System.exit(0);
			
			try {
				s = Long.parseLong(text);
//				
//				if (s >= 214748364700l)
//					if (s >= 2147483647000l)
//						System.out.println("Ese numero es muy grande y tardar� bastante");
//					else
//					System.out.println("Ese numero es grande, puede tardar un poco");
			} catch (Exception e) {
				System.err.println("El valor introducido no es valido");
				continue;
			}
			
			// Se podr�a hacer mucho mas rapido usando % pero no es necesario para este programa
			int m = 0, h = 0, d = 0, y = 0;
                        m = (int) s / 60;
                        s = s % 60;
                        h = (int) m / 60;
                        m = m % 60;
                        d = (int) h / 24;
                        h = h % 24;
                        y = (int) d / 365;
                        d = d % 365;

			System.out.println("Tiempo: " + y + " años  "+ d + "d " + h + ":" + m + ":" + s);
			
		}
		
	}
	
}
