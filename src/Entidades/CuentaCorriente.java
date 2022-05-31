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

    private Double saldoDescubierto = 0.0;

    public CuentaCorriente() {
        super();
    }

    public CuentaCorriente(Integer nroCuenta, String titular, Double saldo) {
        super(nroCuenta, titular, saldo);
    }
    
    public CuentaCorriente(Integer nroCuenta, String titular, Double saldo, Double saldoDescubierto) {
        super(nroCuenta, titular, saldo);
        this.saldoDescubierto = saldoDescubierto;
    }
    
    

    public Double getSaldoDescubierto() {
        return saldoDescubierto;
    }

    public void setSaldoDescubierto(Double saldoDescubierto) {
        this.saldoDescubierto = saldoDescubierto;
    }
    
    @Override
    public String toString(){
        return super.toString() + "\nSaldo Descubierto: " + saldoDescubierto + "\nTipo de Cuenta: Cuenta Corriente\n-------------";
    }
    
}
