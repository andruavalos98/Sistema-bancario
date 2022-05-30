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
    protected String titular, tipoCuenta;
    protected boolean alta = true;

    public Cuenta() {
    }

    public Cuenta(Integer nroCuenta, String titular, boolean alta) {
        this.nroCuenta = nroCuenta;
        this.titular = titular;
        this.alta = alta;
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
        System.out.println("-------------");
        return "Titular: " + titular + "\nnroCuenta: " + nroCuenta + "\nSaldo :" + saldo + "\nalta :" + alta + "\n-------------";
    }
    
    
    
}
