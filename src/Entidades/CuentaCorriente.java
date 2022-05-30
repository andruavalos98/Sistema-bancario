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
public class CuentaCorriente extends Cuenta {

    
    Double saldoDescubierto = 0.0;

    public CuentaCorriente() {
    }

    public CuentaCorriente(Integer nroCuenta, String titular, boolean alta) {
        super(nroCuenta, titular, alta);
    }

    public Double getSaldoDescubierto() {
        return saldoDescubierto;
    }

    public void setSaldoDescubierto(Double saldoDescubierto) {
        this.saldoDescubierto = saldoDescubierto;
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

    public String getTipoCuenta() {
        return tipoCuenta;
    }

    public void setTipoCuenta(String tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }

    public boolean isAlta() {
        return alta;
    }

    public void setAlta(boolean alta) {
        this.alta = alta;
    }

   
   

  

}
