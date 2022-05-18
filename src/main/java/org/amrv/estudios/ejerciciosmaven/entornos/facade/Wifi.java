package org.amrv.estudios.ejerciciosmaven.entornos.facade;

/**
 *
 * @author Adrian MRV. aka AMRV || Ansuz (org.amrv)
 */
public class Wifi {

    private String wifi;

    public void encender() {
        System.out.println("WiFi encendido");
    }

    public void apagar() {
        System.out.println("WiFi apagado");
    }

    public void conectar(String ssid) {
        this.wifi = ssid;
        System.out.println("WiFi conectado a '" + ssid + "'");
    }

    public void desconectar() {
        System.out.println("WiFi desconectado (" + wifi + ")");
    }

    public String getWifi() {
        return wifi;
    }

    public void setWifi(String wifi) {
        this.wifi = wifi;
    }

}
