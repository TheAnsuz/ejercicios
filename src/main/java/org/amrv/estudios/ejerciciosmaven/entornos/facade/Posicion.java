package org.amrv.estudios.ejerciciosmaven.entornos.facade;

/**
 *
 * @author Adrian MRV. aka AMRV || Ansuz (org.amrv)
 */
public class Posicion {

    private String latitud;
    private String longitud;
    private String altura;
    private String fecha;

    public String getLatitud() {
        return latitud;
    }

    public void setLatitud(String latitud) {
        this.latitud = latitud;
    }

    public String getLongitud() {
        return longitud;
    }

    public void setLongitud(String longitud) {
        this.longitud = longitud;
    }

    public String getAltura() {
        return altura;
    }

    public void setAltura(String altura) {
        this.altura = altura;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "Posicion{" + "latitud=" + latitud + ", longitud=" + longitud + ", altura=" + altura + ", fecha=" + fecha + '}';
    }

}
