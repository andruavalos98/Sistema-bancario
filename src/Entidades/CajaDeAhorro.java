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
        this.porcentajeCargoExtra = 0.015;
    }
    
    public CajaDeAhorro(Integer nroCuenta, String titular) {
        super(nroCuenta, titular);
        this.porcentajeCargoExtra = 0.015;
    }
   
    @Override
    public String toString(){
        return super.toString() + "\nTipo de Cuenta: Caja de Ahorro\n-------------";
    }
    
    @Override
    public boolean depositarDinero(double cantidad) {
        if(!this.alta || cantidad <= 0) {
            return false;
        }
        
        this.saldo += cantidad;
        
        return true;
    }
    
    @Override
    public boolean retirarDinero(double cantidad) {
        if(!this.alta || this.saldo < cantidad) {
            return false;
        }
        
        this.saldo -= cantidad;
        
        return true;
    }
    
}
