package org.amrv.estudios.ejerciciosmaven.entornos.facade;

/**
 *
 * @author Adrian MRV. aka AMRV || Ansuz (org.amrv)
 */
public class Cliente {

    public static void main(String[] args) {
        Facade f = new Facade();
        
        f.conectarWifi("Benjamin FrankLAN");
        f.desconectarWifi();
        f.obtenerPosicion();
    }

}
