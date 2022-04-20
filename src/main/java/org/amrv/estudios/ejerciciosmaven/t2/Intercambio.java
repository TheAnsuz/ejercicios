package org.amrv.estudios.ejerciciosmaven.t2;

public class Intercambio {

	public static void main(String[] args) {
		
		// Crear variables fijas
		int a = 6, b = 9;
		
		System.out.println("Antes de intercambiarse: " + a + " " + b);
		
		final int temp = a;
		a = b;
		b = temp;
		
		System.out.println("Despues de intercambiarse: " + a + " " + b);
		
	}
	
}
