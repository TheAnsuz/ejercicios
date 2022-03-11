/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package me.ansuz.amrv.practicas.E2;

import java.time.LocalDate;

/**
 *
 * @author marruiad
 */
public class Plano {
    
    /**
     * Las plazas dentro del plano del garaje
     */
    private final Plaza plazas[][];

    public Plano(int plantas, int plazas) {
        this.plazas = new Plaza[plantas][plazas];
    }
    
    public Plaza getPlaza(Ubicacion ubi) {
        return getPlaza(ubi.getPlanta(),ubi.getPlaza());
    }
    
    public Plaza getPlaza(int planta, int plaza) {
        return plazas[planta][plaza];
    }
    
    public boolean setPlaza(Ubicacion ubi, String matricula, LocalDate fecha) {
        return setPlaza(ubi.getPlanta(),ubi.getPlaza(), new Plaza(matricula,fecha));
    }
    
    public boolean setPlaza(int planta, int plaza, String matricula, LocalDate fecha) {
        return setPlaza(planta,plaza, new Plaza(matricula,fecha));
    }
    
    public boolean setPlaza(Ubicacion ubi, String matricula) {
        return setPlaza(ubi.getPlanta(),ubi.getPlaza(), new Plaza(matricula,LocalDate.now()));
    }
    
    public boolean setPlaza(int planta, int plaza, String matricula) {
        return setPlaza(planta,plaza, new Plaza(matricula,LocalDate.now()));
    }
    
    public boolean setPlaza(Ubicacion ubi, Plaza dato) {
        return setPlaza(ubi.getPlanta(),ubi.getPlaza(), dato);
    }
    
    public boolean setPlaza(int planta, int plaza, Plaza dato) {
        if (isOcupada(planta, plaza))
            return false;
        plazas[planta][plaza] = dato;
        return true;
    }
    
    public boolean isOcupada(Ubicacion ubi) {
        return isOcupada(ubi.getPlanta(), ubi.getPlaza());
    }
    
    public boolean isOcupada(int planta, int plaza) {
        return plazas[planta][plaza] != null;
    }
    
}
