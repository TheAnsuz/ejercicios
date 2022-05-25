package org.amrv.estudios.ejerciciosmaven.entornos.mvc.model;

/**
 *
 * @author Adrian MRV. aka AMRV || Ansuz (org.amrv)
 */
public class Sintomas {

    private int fiebre = 0;
    private int tos = 0;
    private int diarrea = 0;
    private int dolor_muscular = 0;
    private int olfato = 0;

    public int getFiebre() {
        return fiebre;
    }

    public void addFiebre(int amount) {
        this.fiebre += amount;
    }

    public void setFiebre(int fiebre) {
        this.fiebre = fiebre;
    }

    public void addTos(int amount) {
        this.tos += amount;
    }

    public int getTos() {
        return tos;
    }

    public void setTos(int tos) {
        this.tos = tos;
    }

    public void addDiarrea(int amount) {
        this.diarrea += amount;
    }

    public int getDiarrea() {
        return diarrea;
    }

    public void setDiarrea(int diarrea) {
        this.diarrea = diarrea;
    }

    public void addDolor_muscular(int amount) {
        this.dolor_muscular += amount;
    }

    public int getDolor_muscular() {
        return dolor_muscular;
    }

    public void setDolor_muscular(int dolor_muscular) {
        this.dolor_muscular = dolor_muscular;
    }

    public int getOlfato() {
        return olfato;
    }

    public void addOlfato(int amount) {
        this.olfato += amount;
    }

    public void setOlfato(int olfato) {
        this.olfato = olfato;
    }

}
