/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import Entidades.AccountManager;
import Entidades.CajaDeAhorro;
import Entidades.Cuenta;
import Entidades.CuentaCorriente;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author andru
 */
public class AccountManagerService extends Cuenta {

    Scanner sc = new Scanner(System.in);

    AccountManager accountManager = new AccountManager();
    OperacionesServicio operacionesServicio = new OperacionesServicio();

    CuentaCorrienteServicio cuentaCorrienteServicio = new CuentaCorrienteServicio();
    CuentaCorriente cuentaCorriente = new CuentaCorriente();

    public void ingresar(Integer dni) {

//        contorolo que el dni este asociado a alguna cuenta
        if (tieneCuentaCorriente(dni) || tieneCajaDeAhorro(dni)) {

            //Se debe de poder retirar, depositar, hacer transferencias a otras cuentas
            System.out.println("Sobre que cuenta desea operar?");

            System.out.println("1. Caja de ahorro");
            System.out.println("2. Cuenta corriente");

            int opcuenta = sc.nextInt();

            switch (opcuenta) {
                case 1:
                    System.out.println("Cuenta: CAJA DE AHORRO");
                    operacionesServicio.operacionesCajaDeAhorro();

                    break;

                case 2:
                    System.out.println("Cuenta: CUENTA CORRIENTE");
                    operacionesServicio.operacionesCtaCorriente(dni);
                    break;
            }

        } else {

            System.out.println("El titular no tiene cuenta en este banco, por favor cree una");

        }

    }

    public void crearCuenta(String titular, Integer dni) {

        System.out.println("Que tipo de cuenta desea crear?");
        System.out.println("1. Caja de ahorro");
        System.out.println("2. Cuenta corriente");

        int op = sc.nextInt();

        switch (op) {

//            En caso de Caja de ahorro
            case 1:
                
                
                CajaDeAhorro cajaDeAhorro = new CajaDeAhorro();

                if (accountManager.getCajasDeAhorro().containsKey(dni))  {
                    System.out.println("La cuenta ya existe");
                } else {
                    cajaDeAhorro.setTitular(titular);
                    cajaDeAhorro.setNroCuenta((int) (Math.random() * 1000));
                    cajaDeAhorro.setTipoCuenta("Caja de ahorro");

                    accountManager.getCajasDeAhorro().put(dni,cajaDeAhorro);
                }
               
                break;

//                En caso de Cuenta Corriente 
            case 2:
                
                 CuentaCorriente cuentaCorriente = new CuentaCorriente();

                if (accountManager.getCtasCorrientes().containsKey(dni)) {
                    System.out.println("La cuenta ya existe, intente de nuevo");
                } else {

                    cuentaCorriente.setTitular(titular);
                    cuentaCorriente.setNroCuenta((int) (Math.random() * 1000));
                    cuentaCorriente.setTipoCuenta("Cuenta Corriente");

                    accountManager.getCtasCorrientes().put(dni, cuentaCorriente);

                }
                
                break;
        }

    }

//    Lista todas las cuentas, arreglar para que se pueda elegir cuales mostrar
    public void listarCuentas() {
        for (Map.Entry<Integer, CuentaCorriente> entry : accountManager.getCtasCorrientes().entrySet()) {
            System.out.println("DNI: " + entry.getKey() + "\n" + entry.getValue());
        }

        for (Map.Entry<Integer, CajaDeAhorro> entry : accountManager.getCajasDeAhorro().entrySet()) {
            System.out.println("DNI: " + entry.getKey() + "\n" + entry.getValue());
        }
    }

    public boolean tieneCuenta(int dni) {

        return tieneCuentaCorriente(dni) || tieneCajaDeAhorro(dni);

    }

    public boolean tieneCuentaCorriente(int dni) {
        return accountManager.getCtasCorrientes().containsKey(dni);
    }

    public boolean tieneCajaDeAhorro(int dni) {
        return accountManager.getCajasDeAhorro().containsKey(dni);
    }

}
