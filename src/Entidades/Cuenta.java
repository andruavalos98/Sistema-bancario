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
    protected double porcentajeCargoExtra;
    
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

    public double getPorcentajeCargoExtra() {
        return porcentajeCargoExtra;
    }

    public void setPorcentajeCargoExtra(double porcentajeCargoExtra) {
        this.porcentajeCargoExtra = porcentajeCargoExtra;
    }
    
    

    @Override
    public String toString() {
        return "Titular: " + titular + "\nN° Cuenta: " + nroCuenta + "\nSaldo: " + saldo;
    }
    
    public abstract boolean depositarDinero(double cantidad);
    public abstract boolean retirarDinero(double cantidad);
    
    public boolean transferirDinero(Cuenta cuenta, double cantidad) {
        // Falla si la cuenta a transferir es nula o alguna de las cuentas esta inhabilitada
        if(
            cuenta == null ||
            !this.isAlta() ||
            !cuenta.isAlta()
        ) {
            return false;
        }
        
        double cantidadARetirar = cantidad;
        
        // Comparo el tipo y el titular de la cuenta a la que recibirá dinero
        // con la cuenta que lo emitira. Si son distintos tipos y distintos titulares, agrego el cargo extra
        // NOTA: Por convención, supongo que dos cuentas tienen el mismo titular, si están al mismo nombre
        if(
            cuenta.getClass() != this.getClass() &&
            !cuenta.getTitular().equals(this.titular)
        ) {
            cantidadARetirar = cantidad * (1 + this.porcentajeCargoExtra);
                        System.out.println("Cargo aplicado: " + cantidad*(1+cuenta.getPorcentajeCargoExtra()) + " (" +"%" + 100*cuenta.getPorcentajeCargoExtra() + ")" );

        }
        
        // Realizo la transferencia, retorna false si algo falla
        return this.retirarDinero(cantidadARetirar) && cuenta.depositarDinero(cantidad);
    }
}
