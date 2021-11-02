package me.ansuz.amrv.bucles;

public class SumaPosMenores100 {

	/*
	 * usando en todos los ejercicios un bucle for 
	 * 
	 * 1. programa que sume los números
	 * positivos menores o iguales que 100.
	 */
	public static void main(String[] args) {

		long suma = 0;
		for (int i = 0; i <= 100; i++) {
			
			suma+=i;
			
		}
		
		System.out.println("La suma de los numeros entre 1-100 es " + suma);
		
	}

}
