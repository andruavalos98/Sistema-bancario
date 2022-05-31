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
public abstract class Cuenta {
    
    protected Double saldo = 0.0;
    protected Integer nroCuenta;
    protected String titular;
    protected boolean alta = true;

    public Cuenta() {
    }

    public Cuenta(Integer nroCuenta, String titular) {
        this.nroCuenta = nroCuenta;
        this.titular = titular;
    }

    public Double getSaldo() {
        return saldo;
    }

    public Integer getNroCuenta() {
        return nroCuenta;
    }

    public String getTitular() {
        return titular;
    }

    public boolean isAlta() {
        return alta;
    }

    public void setAlta(boolean alta) {
        this.alta = alta;
    }

    @Override
    public String toString() {
        return "-------------\nTitular: " + titular + "\nN° Cuenta: " + nroCuenta + "\nSaldo: " + saldo;
    }
    
    public abstract boolean depositarDinero(double cantidad);
    public abstract boolean retirarDinero(double cantidad);

}
