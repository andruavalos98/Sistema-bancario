/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author andru
 */
public class AccountManager {
    HashMap<Integer, CuentaCorriente> ctasCorrientes = new HashMap();
    HashMap<Integer, CajaDeAhorro> cajasDeAhorro = new HashMap();

    public HashMap<Integer, CuentaCorriente> getCtasCorrientes() {
        return ctasCorrientes;
    }

    public void setCtasCorrientes(HashMap<Integer, CuentaCorriente> ctasCorrientes) {
        this.ctasCorrientes = ctasCorrientes;
    }

    public HashMap<Integer, CajaDeAhorro> getCajasDeAhorro() {
        return cajasDeAhorro;
    }

    public void setCajasDeAhorro(HashMap<Integer, CajaDeAhorro> cajasDeAhorro) {
        this.cajasDeAhorro = cajasDeAhorro;
    }
    
    

   
    
    
    
   
    
}
