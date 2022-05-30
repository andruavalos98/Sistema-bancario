/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import Entidades.AccountManager;
import Entidades.Cuenta;
import Entidades.CuentaCorriente;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author andru
 */
public class CuentaCorrienteServicio {

    Scanner sc = new Scanner(System.in);

    AccountManager accountManager = new AccountManager();

    CuentaCorriente cuentaCorriente = new CuentaCorriente();

    public void depositoCtaCorriente(double deposito, Integer dni) {
        
       
        for(Map.Entry<Integer, CuentaCorriente> entry : accountManager.getCtasCorrientes().entrySet()){
            
            if(entry.getKey() == dni){
                cuentaCorriente.setSaldo( + entry.getValue().getSaldo());
            }

        }

//        accountManager.getCtasCorrientes().put(dni, deposito + cuentaCorriente.getSaldo());

    }

    public void retiroCtaCorriente() {

        if (cuentaCorriente.getSaldo() >= 0) {
            System.out.println("Ingrese el monto que deasea retirar");
            int retiro = sc.nextInt();

            cuentaCorriente.setSaldo(cuentaCorriente.getSaldo() - retiro);
        } else {
            System.out.println("No dispone de saldo en su cuenta");
        }

    }
}
