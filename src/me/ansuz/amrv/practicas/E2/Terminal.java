/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package me.ansuz.amrv.practicas.E2;

/**
 *
 * @author marruiad
 */
public final class Terminal {

    private final Maquina maquina;

    public Terminal(Maquina maquina) {
        this.maquina = maquina;
        showMenu();
    }

    public Maquina getMaquina() {
        return maquina;
    }

    public void showMenu() {
        int longitud = Math.max("Estacionar vehiculo".length(),
                Math.max("Sacar vehiculo".length(), maquina.getNombre().length() + 2));
        while (true) {
            System.out.println(Formateador.textoCentrado(">>> ", ' ' + maquina.getNombre() + ' ', " <<<", longitud, '-'));
            System.out.println("> 1 " + "Estacionar vehiculo");
            System.out.println("> 2 " + "Sacar vehiculo");
            switch (Input.getInt(">>>>>", 1, 2)) {
                case 1:
                    estacionarVehiculo();
                    break;
                case 2:
                    sacarVehiculo();
            }
        }
    }

    public void estacionarVehiculo() {
        if (!maquina.getPlano().hasLibre())
            System.err.println(">>> No hay espacio");
        mostrarPlano();
        
    }

    public void sacarVehiculo() {
        System.out.println("Vehiculo sacado");

    }

    public void mostrarPlano() {
        System.out.println(maquina.getPlano().toString());
    }
    
    private static void pausa(long milis) {
        try {
            Thread.sleep(milis);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
}
