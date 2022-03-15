/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package me.ansuz.amrv.practicas.E2;

/**
 *
 * @author marruiad
 */
public enum Moneda {

    CENTIMO_5(.05f, "cinco centimos", 0),
    CENTIMO_10(.1f, "diez centimos", 0),
    CENTIMO_20(.2f, "veinte centimos", 0),
    CENTIMO_50(.5f, "cincuenta centimos", 0),
    EURO_1(1f, "un euro", 1),
    EURO_2(2f, "dos euros", 1),
    EURO_5(5f, "cinco euros", 2),
    EURO_10(10f, "diez euros", 2),
    EURO_20(20f, "veinte euros", 2);

    public boolean isCentimo() {
        return tipo == 0;
    }

    public boolean isBillete() {
        return tipo == 2;
    }

    final float VALUE;
    final String DISPLAY;
    private final int tipo; // 0 centimo, 1 moneda euro, 2 billete

    private Moneda(float value, String texto, int tipo) {
        this.VALUE = value;
        this.DISPLAY = texto;
        this.tipo = tipo;
    }

    public static float getSum(Moneda moneda, int amount) {
        return moneda.VALUE * amount;
    }

    public static String getDisplay(Moneda moneda, int amount) {
        return amount + " " + (moneda.isBillete() ? "billete" : "moneda")
                + (amount > 1 || amount < 1 ? "s" : "") + " de " + moneda.DISPLAY;
    }

    public static Moneda valueOf(float value) {
        for (Moneda moneda : Moneda.values()) {
            if (moneda.VALUE == value)
                return moneda;
        }
        throw new IllegalArgumentException(value + " is not a 'Moneda' enumrator");
    }
}
