package org.amrv.estudios.ejerciciosmaven.bucles;


public class PotenciasMenores100 {

	public static void main(String[] args) {

		boolean terminado =  false;
		for (int i = 0; i <= 100 || !terminado; i++) {
			long num = Math.round(Math.pow(2, i));
			if (num <= 100 ) {
				System.out.println("> " + num);
			} else
				terminado = true;
		}
		
	}

}
