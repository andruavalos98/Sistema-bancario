/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.util.ArrayList;

/**
 *
 * @author andru
 */
public class AccountManager {

    private final ArrayList<Cuenta> _cuentas = new ArrayList();

    public ArrayList<Cuenta> getCuentas() {
        return _cuentas;
    }

    public Cuenta obtenerCuentaPorNroCuenta(int numero) {
        return _cuentas.stream()
                .filter(cuenta -> cuenta.getNroCuenta().equals(numero))
                .findFirst()
                .get();
    }

}
