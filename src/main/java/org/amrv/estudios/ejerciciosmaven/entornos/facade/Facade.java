package org.amrv.estudios.ejerciciosmaven.entornos.facade;

/**
 *
 * @author Adrian MRV. aka AMRV || Ansuz (org.amrv)
 */
public class Facade {
    
    private GPS gps;
    private Wifi wifi;
    
    public Facade() {
        this.gps = new GPS();
        this.wifi = new Wifi();
    }
    
    public void conectarWifi(String ssid) {
        wifi.encender();
        wifi.conectar(ssid);
    } 
    
    public void desconectarWifi() {
        wifi.desconectar();
        wifi.apagar();
    }
    
    public void obtenerPosicion() {
        gps.encender();
        gps.fijarPoisicion();
        System.out.println(gps.ultimaPosicion().toString());
        gps.apagar();
    }
    
}
