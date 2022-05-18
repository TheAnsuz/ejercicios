package org.amrv.estudios.ejerciciosmaven.entornos.facade;

/**
 *
 * @author Adrian MRV. aka AMRV || Ansuz (org.amrv)
 */
public class GPS {
    
    public void encender() {
        System.out.println("GPS encendido");
    }
    
    public void fijarPoisicion() {
        System.out.println("Posicion fijada");
    }
    
    public Posicion ultimaPosicion() {
        Posicion p = new Posicion();
        p.setLatitud("5.4");
        p.setLongitud("-0.5");
        p.setAltura("800");
        p.setFecha("2021--04-02 20:00");
        return p;
    }
    
    public void apagar() {
        System.out.println("GPS apagado");
    }
    
}
