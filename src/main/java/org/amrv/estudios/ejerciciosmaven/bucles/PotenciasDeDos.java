package org.amrv.estudios.ejerciciosmaven.bucles;


public class PotenciasDeDos {

	public static void main(String[] args) {

		// Esto se puede hacer si cambio el segundo bucle for por un while para
		// terminarlo cuando se encuentre la potencia sin necesiad de un break;
		int max = 100;

		for (int i = 0; i <= max; i++) {

			boolean esPotencia = false;
			for (int elev = 1; elev < Math.sqrt(max); elev++) {
				if (i == Math.pow(2, elev)) {
					// El numero seria una potencia de dos
					System.out.println("El numero " + i + " es una potencia de dos");
				}
			}

		}

	}

}
