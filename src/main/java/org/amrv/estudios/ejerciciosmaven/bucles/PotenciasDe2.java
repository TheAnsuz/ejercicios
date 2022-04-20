package org.amrv.estudios.ejerciciosmaven.bucles;


public class PotenciasDe2 {

	public static void main(String[] args) {

		for (int i = 1; i <= 100; i++) {
			long num = Math.round(Math.pow(2,i));
			
			System.out.println(i + "> " + num);
		}
		
	}

}
