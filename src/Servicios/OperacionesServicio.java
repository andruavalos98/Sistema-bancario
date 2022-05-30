/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import Entidades.CajaDeAhorro;
import Entidades.Cuenta;
import Entidades.CuentaCorriente;
import java.util.Scanner;

/**
 *
 * @author andru
 */
public class OperacionesServicio {

    Scanner sc = new Scanner(System.in);
    CuentaCorrienteServicio cuentaCorrienteServicio = new CuentaCorrienteServicio();
    CuentaCorriente cuentaCorriente = new CuentaCorriente();
    CajaDeAhorro cajaDeAhorro = new CajaDeAhorro();
    


    public void operacionesCtaCorriente(Integer dni) {

        System.out.println("Elija alguna de las siguientes operaciones");
        System.out.println("1. Depositar dinero");
        System.out.println("2. Retirar dinero");
        System.out.println("3. Dar de baja la cuenta");
        System.out.println("4. Salir");

        int op = sc.nextInt();

        switch (op) {
            case 1:
                System.out.println("Ingrese la cantidad a depositar");
                sc.nextInt();
                double deposito = sc.nextInt();
                cuentaCorrienteServicio.depositoCtaCorriente(deposito, dni);
                break;

            case 2:
                cuentaCorrienteServicio.retiroCtaCorriente();
                break;
        }

    }

    public void operacionesCajaDeAhorro() {

        System.out.println("Elija alguna de las siguientes operaciones");
        System.out.println("1. Depositar dinero");
        System.out.println("2. Retirar dinero");
        System.out.println("3. Dar de baja la cuenta");
        System.out.println("4. Salir");

        int op = sc.nextInt();

        switch (op) {
            case 1:
//                cuentaCorrienteServicio.depositoCtaCorriente(cajaDeAhorro.getSaldo());
                break;

            case 2:
                cuentaCorrienteServicio.retiroCtaCorriente();
                break;
        }

    }

}
