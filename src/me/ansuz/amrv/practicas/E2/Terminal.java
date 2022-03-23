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
        if (maquina.getPlano().hasLibre())
            System.err.println(">>> No hay espacio");
        else {
            String matricula;
            do {
                matricula = Input.getMatricula("Matricula del vehiculo (0000-XXX):");
                if (maquina.hasMatricula(matricula))
                    System.err.println("Ya existe un vehiculo con esa matricula en el parking");
            } while (maquina.hasMatricula(matricula));
            final Ticket resultado = maquina.getPlano().estacionar(matricula, maquina.getPlano().getLibre());
            System.out.println("Generando ticket...");
            Terminal.pause(500);
            maquina.addTicket(resultado);
            System.out.println(resultado);
            System.out.println();
        }
        mostrarPlano();

    }

    public void sacarVehiculo() {
        int id = 0;
        do {
        id = Input.getInt("Introduce la ID del ticket:", 1, maquina.getPlano().getPisos() * maquina.getPlano().getPlazas());
        if (!maquina.hasTicketID(id))
                System.err.println("Ticket no reconocido");
        
        } while (!maquina.hasTicketID(id));
        final Ticket ticket = maquina.getTicket(id);
        final double coste = maquina.getCoste(ticket);
        System.out.println("Total a pagar: " + coste);
        
        // Aqui es donde el usuario debe de introducir el cambio y toda la pesca
        
        maquina.removeTicket(ticket);
    }

    public void mostrarPlano() {
        System.out.println(maquina.getPlano().toString());
    }

    private static void pause(long milis) {
        try {
            Thread.sleep(milis);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
}
