/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import Entidades.CajaDeAhorro;
import java.util.Scanner;

/**
 *
 * @author andru
 */
public class CajaDeAhorroServicio {

    Scanner sc = new Scanner(System.in);
    CajaDeAhorro cajaDeAhorro = new CajaDeAhorro();

    public void depositoCajaDeAhorro(double deposito) {
        System.out.println("Ingrese la cantidad que va a depositar");
        deposito = sc.nextInt();

        deposito = cajaDeAh                                           orro.getSaldo() + deposito;

        cajaDeAhorro.setSaldo(deposito);

    }
                                                                                                                                                                                                                                                     
}
