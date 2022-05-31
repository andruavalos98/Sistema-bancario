/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import Entidades.CuentaCorriente;

/**
 *
 * @author andru
 */
public class AccountManager {

    private ArrayList<Cuenta> _cuentas = new ArrayList();

    public ArrayList<Cuenta> getCuentas() {
        return _cuentas;
    }

    public Cuenta obtenerCuentaPorNroCuenta(int numero) {
        return _cuentas.stream()
                .filter(cuenta -> cuenta.getNroCuenta().equals(numero))
                .findFirst()
                .get();
    }
    

    public List<Cuenta> obtenerTitularesAptosParaPrestamo() {

        return _cuentas
                .stream()
                .filter(s -> {
                    CuentaCorriente cuenta = null;
                    
                    if(s instanceof CuentaCorriente) {
                        cuenta = (CuentaCorriente) s;
                    }
                    
                    if(cuenta != null) {
                        return cuenta.isAlta() &&
                            cuenta.getSaldoDescubierto() + cuenta.getSaldo() > 10000;
                    }
                    return s.isAlta() &&
                            s.getSaldo() >= 10000;
                    })
                .collect(Collectors.toList());

    }
    
    public boolean algunaCuentaPuedeSerHackeada() {
        return _cuentas.stream()
                .anyMatch(cuenta -> 
                        cuenta.getNroCuenta() % 2 == 0 &&
                        cuenta.getSaldo() > 50000 &&
                        cuenta.getTitular().length() > 15
                );
    }
}
