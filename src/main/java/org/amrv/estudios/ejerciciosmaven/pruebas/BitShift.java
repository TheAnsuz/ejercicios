package org.amrv.estudios.ejerciciosmaven.pruebas;

import java.util.Scanner;

/**
 *
 * @author marruiad
 */
public class BitShift {

    private static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {

        long a = 0;
        long b = 0x0000;

        System.out.println("No se va a hacer verificacion de entrada de datos");
        System.out.println("Introduce el primer numero");
        a = scan.nextLong();
        System.out.println("Introduce el segundo numero");
        b = scan.nextLong();
        AND(a, b);
        OR(a, b);
        XOR(a, b);
        INVERT(a,b);

    }

    public static void AND(long a, long b) {
        long num = (a & b);
        show("AND", a, b, num);
    }

    public static void OR(long a, long b) {
        long num = (a | b);
        show("OR", a, b, num);
    }

    public static void XOR(long a, long b) {
        long num = (a ^ b);
        show("NOR", a, b, num);
    }

    public static void INVERT(long a, long b) {
        long num = ~a;
        show("INVERT", a, null, num);
    }

    public static void show(String operation, Long a, Long b, Long res) {
        byte[] nums = new byte[6];
        if (a == null) {
            nums[0] = 0;
            nums[3] = 0;
        } else {
            nums[0] = (byte) Long.toBinaryString(a).length();
            nums[3] = (byte) Long.toString(a).length();
        }
        if (b == null) {
            nums[1] = 0;
            nums[4] = 0;
        } else {
            nums[1] = (byte) Long.toBinaryString(b).length();
            nums[4] = (byte) Long.toString(b).length();
        }
        if (res == null) {
            nums[2] = 0;
            nums[5] = 0;
        } else {
            nums[2] = (byte) Long.toBinaryString(res).length();
            nums[5] = (byte) Long.toString(res).length();
        }

        String text = "";
        int bytes = (nums[0] > nums[1])
                ? (nums[0] > nums[2]) ? nums[0] : nums[2]
                : (nums[1] > nums[2]) ? nums[1] : nums[2];
        int num = (nums[3] > nums[4])
                ? (nums[3] > nums[5]) ? nums[3] : nums[5]
                : (nums[4] > nums[5]) ? nums[4] : nums[5];

        text += "====" + operation.toUpperCase() + "====================\n";
        if (a != null)
        text += "> " + shiftNumbers(num, a) + "(" + shiftBytes(bytes, a) + ")\n";

        if (b != null)
        text += "> " + shiftNumbers(num, b) + "(" + shiftBytes(bytes, b) + ")\n";

        if (res != null)
        text += "= " + shiftNumbers(num, res) + "(" + shiftBytes(bytes, res) + ")\n";

        text += "====";
        for (char c : operation.toCharArray())
            text += "=";
        text += "====================" + '\n';
        System.out.println(text);
    }

    // 0000 0000 0010 0110
    private static String shiftBytes(int bytes, long number) {
        while (bytes % 4 != 0)
            bytes++;
        String text = Long.toBinaryString(number);
        for (int size = Long.toBinaryString(number).length(); size < bytes; size++)
            text = '0' + text;
        return text.replaceAll("(.{4})", "$1 ").trim();
    }

    private static String shiftNumbers(int size, long number) {
        String text = Long.toString(number);
        for (int i = Long.toString(number).length(); i < size; i++)
            text += ' ';
        return text + ' ';
    }

}
