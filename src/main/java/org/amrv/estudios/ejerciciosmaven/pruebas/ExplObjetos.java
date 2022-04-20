package org.amrv.estudios.ejerciciosmaven.pruebas;

/**
 *
 * @author marruiad
 */
public class ExplObjetos {
    
    public static void main(String[] args) {
        Coche c = new Coche("renault");
        String coche = c.toString();
        c.setColor(coche);
        System.out.println(coche);
    }
    
}
class Coche {
    
    private String modelo = "rinol";
    private String color = "negro";
    
    public Coche(String modelo) {
        this.modelo = modelo;
    }
    
    public String getModelo() {
        return modelo;
    }

    public String getColor() {
    return color;
    }
    
    /**
     * Cambia el color del coche
     * 
     * @param color el color que va a tener el coche
     */
    public void setColor(String color) {
        this.color = color;
    }
    
    @Override
    public String toString() {
        return "Coche(modelo: " + modelo + ", color: " + color+  ")"; 
    }
    
}