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
public class Cuenta {
    
    protected Double saldo = 0.0;
    protected Integer nroCuenta;
    protected String titular;
    protected boolean alta = true;

    public Cuenta() {
    }

    public Cuenta(Integer nroCuenta, String titular, Double saldo) {
        this.nroCuenta = nroCuenta;
        this.titular = titular;
        this.saldo = saldo;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public Integer getNroCuenta() {
        return nroCuenta;
    }

    public void setNroCuenta(Integer nroCuenta) {
        this.nroCuenta = nroCuenta;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
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
    
}
