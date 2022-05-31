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

    public static void pruebaTransferencia(Cuenta cuenta, Cuenta otraCuenta, double cantidad) {
        if(cuenta == null || otraCuenta == null){
            System.out.println("ERROR. Ingreso de cuenta nula");
            return;
        }
        
        if(cuenta.isAlta() == false || otraCuenta.isAlta() == false){
            System.out.println("ERROR. Una de las cuentas esta inhabilitada");
            return;
        }
        
        if(cantidad < 0){
            System.out.println("ERROR. Monto incorrecto");
            return;
        }

        if (cuenta.transferirDinero(otraCuenta, cantidad)) {
            System.out.println("Transferencia EXITOSA!");
            System.out.println(cuenta);
            System.out.println(otraCuenta);
            
            System.out.println("Se hizo una transferencia de " + cantidad);
            
            System.out.println("CUENTA DESTINO:");
            System.out.println("Titular: "+otraCuenta.getTitular() + " - nro de cuenta: " + otraCuenta.getNroCuenta() + " - Tipo de cuenta: " + otraCuenta.getClass());
            System.out.println("CUENTA ORIGEN");
            System.out.println("Titular: " + cuenta.getTitular() + " - nro de cuenta: " + cuenta.getNroCuenta() + " - Tipo de cuenta: " + cuenta.getClass());
            
            

        } else {
            System.out.println("Fondos insuficientes");
        }

    }

    public static void pruebaDeposito(Cuenta cuenta, double cantidad) {

        System.out.println("Cuenta a la que se va a depositar:\n ");
        System.out.println(cuenta);

        if (cuenta.depositarDinero(cantidad)) {
            System.out.println("La operacion tuvo EXITO");
        } else {
            System.out.println("La operacion FALLO");
        }
        System.out.println("Estado actual de la cuenta:\n ");
        System.out.println(cuenta);

    }

    public static void pruebaDepositoSaldoDescubierto(CuentaCorriente cuenta, double cantidad) {

        System.out.println("Cuenta a la que se va a depositar:\n");
        System.out.println(cuenta);

        if (cuenta.depositarDineroEnSaldoDescubierto(cantidad)) {
            System.out.println("La operacion tuvo EXITO");
        } else {
            System.out.println("La operacion FALLO");
        }
        System.out.println("Estado actual de la cuenta:\n ");
        System.out.println(cuenta);

    }

    public static void pruebaRetiro(Cuenta cuenta, double cantidad) {

        System.out.println("Cuenta de la que se va a retirar:\n");

        System.out.println(cuenta);

        System.out.println("Se van a retirar: " + cantidad);

        if (cuenta.isAlta() == false) {
            System.out.println("ERROR. La cuenta esta inhabilitada");
        }

        if (cantidad <= 0) {
            System.out.println("Monto incorrecto");
        }

        if (cantidad > cuenta.getSaldo()) {
            System.out.println("Fondos insuficientes\n");
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
            System.out.println("ERROR. La cuenta esta inhabilitada");
        }

        if (cantidad <= 0) {
            System.out.println("Monto incorrecto");
        }

        if (cantidad > cuenta.getSaldo()) {
            System.out.println("Fondos insuficientes\n");
        }

        if (cuenta.retirarDinero(cantidad)) {
            System.out.println("Se retiro dinero correctamente de la cuenta N° " + cuenta.getNroCuenta());
            System.out.println("Fondos Actuales: $" + cuenta.getSaldo());
            System.out.println("Saldo descubierto actual: " + cuenta.getSaldoDescubierto() + "\n");
        }

    }

}
