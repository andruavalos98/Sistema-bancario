/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

/**
 *
 * @author andru
 */
public class CajaDeAhorro extends Cuenta {

    public CajaDeAhorro() {
        super();
    }
    
    public CajaDeAhorro(Integer nroCuenta, String titular, Double saldo) {
        super(nroCuenta, titular, saldo);
    }
   
    @Override
    public String toString(){
        return super.toString() + "\nTipo de Cuenta: Caja de Ahorro\n-------------";
    }
    
    @Override
    public boolean retirarDinero(int cantidad) {
        if(this.saldo < cantidad) {
            return false;
        }
        
        this.saldo -= cantidad;
        
        return true;
    }
    
}
