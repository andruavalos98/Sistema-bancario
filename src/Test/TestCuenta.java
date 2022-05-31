/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import Entidades.Cuenta;
import Entidades.CuentaCorriente;

/**
 *
 * @author andru
 */
public class TestCuenta {

    static String ANSI_RED = "\u001B[31m";
    static String ANSI_GREEN = "\u001B[32m";
    static String ANSI_YELLOW = "\u001B[33m";

    public static void pruebaTransferencia(Cuenta cuenta, Cuenta otraCuenta, double cantidad) {
        if (cuenta == null || otraCuenta == null) {
            System.out.println(ANSI_RED + "ERROR. Ingreso de cuenta nula" + ANSI_RED);
            return;
        }

        if (cuenta.isAlta() == false || otraCuenta.isAlta() == false) {
            System.out.println(ANSI_RED + "ERROR. Una de las cuentas esta inhabilitada" + ANSI_RED);
            return;
        }

        if (cantidad < 0) {
            System.out.println(ANSI_RED + "ERROR. Monto incorrecto" + ANSI_RED);
            return;
        }

        if (cuenta.transferirDinero(otraCuenta, cantidad)) {
            System.out.println(ANSI_GREEN + "Transferencia EXITOSA!" + ANSI_GREEN);
            System.out.println(cuenta);
            System.out.println(otraCuenta);

            System.out.println("Se hizo una transferencia de " + cantidad);

            System.out.println("CUENTA DESTINO:");
            System.out.println("Titular: " + otraCuenta.getTitular() + " - nro de cuenta: " + otraCuenta.getNroCuenta() + " - Tipo de cuenta: " + otraCuenta.getClass());
            System.out.println("CUENTA ORIGEN");
            System.out.println("Titular: " + cuenta.getTitular() + " - nro de cuenta: " + cuenta.getNroCuenta() + " - Tipo de cuenta: " + cuenta.getClass());

        } else {
            System.out.println(ANSI_YELLOW + "Fondos insuficientes" + ANSI_YELLOW);
        }

    }

    public static void pruebaDeposito(Cuenta cuenta, double cantidad) {

        System.out.println("Cuenta a la que se va a depositar:\n ");
        System.out.println(cuenta);

        if (cuenta.depositarDinero(cantidad)) {
            System.out.println(ANSI_GREEN + "La operacion tuvo EXITO" + ANSI_GREEN);
        } else {
            System.out.println(ANSI_RED + "La operacion FALLO" + ANSI_RED);
        }
        System.out.println("Estado actual de la cuenta:\n ");
        System.out.println(cuenta);

    }

    public static void pruebaDepositoSaldoDescubierto(CuentaCorriente cuenta, double cantidad) {

        System.out.println("Cuenta a la que se va a depositar:\n");
        System.out.println(cuenta);

        if (cuenta.depositarDineroEnSaldoDescubierto(cantidad)) {
            System.out.println(ANSI_GREEN + "La operacion tuvo EXITO" + ANSI_GREEN);
        } else {
            System.out.println(ANSI_RED + "La operacion FALLO" + ANSI_RED);
        }
        System.out.println("Estado actual de la cuenta:\n ");
        System.out.println(cuenta);

    }

    public static void pruebaRetiro(Cuenta cuenta, double cantidad) {

        System.out.println("Cuenta de la que se va a retirar:\n");

        System.out.println(cuenta);

        System.out.println("Se van a retirar: " + cantidad);

        if (cuenta.isAlta() == false) {
            System.out.println(ANSI_RED + "ERROR. La cuenta esta inhabilitada" + ANSI_RED);
        }

        if (cantidad <= 0) {
            System.out.println(ANSI_YELLOW + "Monto incorrecto" + ANSI_YELLOW);
        }

        if (cantidad > cuenta.getSaldo()) {
            System.out.println(ANSI_YELLOW +"Fondos insuficientes\n" + ANSI_YELLOW);
        }

        if (cuenta.retirarDinero(cantidad)) {
            System.out.println("Se retiro dinero correctamente de la cuenta N° " + cuenta.getNroCuenta());
            System.out.println("Fondos Actuales: $" + cuenta.getSaldo() + "\n");

        }

    }

    public static void pruebaRetiroCtaCorriente(CuentaCorriente cuenta, double cantidad) {

        System.out.println("Cuenta de la que se va a retirar:\n");

        System.out.println(cuenta);

        System.out.println("Se van a retirar: " + cantidad);

        if (cuenta.isAlta() == false) {
            System.out.println(ANSI_RED + "ERROR. La cuenta esta inhabilitada" + ANSI_RED);
        }

        if (cantidad <= 0) {
            System.out.println(ANSI_YELLOW + "Monto incorrecto" + ANSI_YELLOW);
        }

        if (cantidad > cuenta.getSaldo()) {
            System.out.println(ANSI_YELLOW + "Fondos insuficientes\n" + ANSI_YELLOW);
        }

        if (cuenta.retirarDinero(cantidad)) {
            System.out.println("Se retiro dinero correctamente de la cuenta N° " + cuenta.getNroCuenta());
            System.out.println("Fondos Actuales: $" + cuenta.getSaldo());
            System.out.println("Saldo descubierto actual: " + cuenta.getSaldoDescubierto() + "\n");
        }

    }

}
