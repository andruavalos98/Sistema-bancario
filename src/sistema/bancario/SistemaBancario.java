/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.bancario;

//import Servicios.AccountManagerService;
import Entidades.CajaDeAhorro;
import Entidades.CuentaCorriente;
import Entidades.Cuenta;
import Test.TestCuenta;

/**
 *
 * @author andru
 */
public class SistemaBancario {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        TestCuenta testCuenta = new TestCuenta();

        // Pruebo el polimorfismo
        Cuenta unaCajaDeAhorroDeJuan = new CajaDeAhorro(1, "Juan");
        CajaDeAhorro otraCajaDeAhorro = new CajaDeAhorro(2, "Ivan");
        CuentaCorriente cuentaCorriente = new CuentaCorriente(3, "Andrea");
        //CUENTA INHABILITADA
        Cuenta cuentaInhabilitada = new CajaDeAhorro(5, "Maria");
        cuentaInhabilitada.setAlta(false);
         //UNA CUENTA CORRIENTE VACIA TOTALMENTE
        Cuenta unaCuentaCorrienteDeJuan = new CuentaCorriente(6, "Juan");
        //UNA CUENTA CORRIENTE QUE SOLO TIENE SALDO DESCUBIERTO
        CuentaCorriente unaCuentaCorrienteDePedro = new CuentaCorriente(7, "Pedro");
       
        

//        PROBANDO CREAR CUENTAS
        System.out.println("++++++++++++++++++PROBANDO CREAR CUENTAS++++++++++++++++++\n");
        System.out.println(unaCajaDeAhorroDeJuan);
        System.out.println(otraCajaDeAhorro);
        System.out.println(cuentaCorriente);
        System.out.println(cuentaInhabilitada);
        System.out.println(unaCuentaCorrienteDeJuan);

//  ----------------------------------------------------------------------
        System.out.println("\n\n++++++++++++++++++PROBANDO DEPOSITOS++++++++++++++++++\n");

        System.out.println("\t A UNA CAJA DE AHORRO");
        TestCuenta.pruebaDeposito(unaCajaDeAhorroDeJuan, 10000);
        System.out.println("\t A LA MISMA CUENTA PARA VER QUE SE SUMEN");
        TestCuenta.pruebaDeposito(unaCajaDeAhorroDeJuan, 500);
        System.out.println("\t A UNA CUENTA CORRIENTE");
        TestCuenta.pruebaDeposito(cuentaCorriente, 5000);
        System.out.println("\t AL SALDO DESCUBUERTO DE UNA CUENTA CORRIENTE");
        TestCuenta.pruebaDepositoSaldoDescubierto(cuentaCorriente, 500);
        System.out.println("\t A UNA CUENTA INHABILITADA");
        TestCuenta.pruebaDeposito(cuentaInhabilitada, 500);
        System.out.println("\t INTENTO DEPOSITAR SALDO NEGATIVO");
        TestCuenta.pruebaDeposito(otraCajaDeAhorro, -500);
        System.out.println("\t SOLO DEPOSITO DE SALDO DESCUBIERTO");
        TestCuenta.pruebaDepositoSaldoDescubierto(unaCuentaCorrienteDePedro, 500);
//----------------------------------------------------------------------------
        System.out.println("\n\n++++++++++++++++++PROBANDO RETIROS DE DINERO++++++++++++++++++\n");

        System.out.println("\t A UNA CAJA DE AHORRO CON SUFICIENTE SALDO");
        TestCuenta.pruebaRetiro(unaCajaDeAhorroDeJuan, 200);
        System.out.println("\t A UNA CAJA DE AHORRO CON SALDO INSUFICIENTE");
        TestCuenta.pruebaRetiro(otraCajaDeAhorro, 800);
        System.out.println("\t A UNA CUENTA CORRIENTE CON SALDO SUFICIENTE");
        TestCuenta.pruebaRetiroCtaCorriente(cuentaCorriente, 100);
        System.out.println("\t A UNA CUENTA CORRIENTE CON SALDO INSUFICIENTE PERO CON SALDO DESCUBIERTO SUFUCIENTE");
        TestCuenta.pruebaRetiroCtaCorriente(unaCuentaCorrienteDePedro, 300);
        System.out.println("\t A UNA CUENTA CORRIENTE VACIA TOTALMENTE");
        TestCuenta.pruebaRetiro(unaCuentaCorrienteDeJuan, 900);
        System.out.println("\t A UNA CUENTA INHABILITADA");
        TestCuenta.pruebaRetiro(cuentaInhabilitada, 700);
        System.out.println("\t INTENTO RETIRAR UN MONTO NEGATIVO");
        TestCuenta.pruebaRetiro(otraCajaDeAhorro, -100);
        TestCuenta.pruebaRetiro(cuentaCorriente, -100);
        
        
        System.out.println("\n\n++++++++++++++++++PROBANDO TRANSFERENCIAS DE DINERO++++++++++++++++++\n");
        
        System.out.println("\t TRANFERENCIAS A CUENTAS DE DISTINTO TIPO Y DE DISTINTO TITULAR (caja de ahorro a cuenta corriente)");
        TestCuenta.pruebaTransferencia(unaCajaDeAhorroDeJuan, unaCuentaCorrienteDePedro, 600);
        System.out.println("\t\n TRANFERENCIAS A CUENTAS DE DISTINTO TIPO Y DE DISTINTO TITULAR (cuenta corriente a caja de ahorro)");
        TestCuenta.pruebaTransferencia(cuentaCorriente, otraCajaDeAhorro, 20);
        
        System.out.println("\t\n TRANFERENCIAS A CUENTAS DE IGUAL TIPO Y DE DISTINTO TITULAR ");
        TestCuenta.pruebaTransferencia(unaCajaDeAhorroDeJuan, otraCajaDeAhorro, 100);
        
        System.out.println("\t\n TRANFERENCIAS A CUENTAS DE DISTINTO TIPO Y DE IGUAL TITULAR ");
        TestCuenta.pruebaTransferencia(unaCajaDeAhorroDeJuan, unaCuentaCorrienteDeJuan, 300);

        System.out.println("\t\n TRANFERENCIAS A CUENTA INHABILITADA A CUENTA HABILITADA");
        TestCuenta.pruebaTransferencia(cuentaInhabilitada, cuentaCorriente, 100);
        
        System.out.println("\t\n TRANFERENCIAS DE CUENTA HABILITADA A CUENTA INHABILITADA");
        TestCuenta.pruebaTransferencia(cuentaCorriente, cuentaInhabilitada, 100);
        
        System.out.println("\t\n TRANFERENCIAS DE UN MONTO NEGATIVO");
        TestCuenta.pruebaTransferencia(cuentaCorriente, unaCajaDeAhorroDeJuan, -100);
        
        System.out.println("\t\n TRANFERENCIAS DESDE UNA CUENTA CON MONTO INSUFICIENTE");
        TestCuenta.pruebaTransferencia(unaCuentaCorrienteDeJuan, unaCuentaCorrienteDePedro, 1000);
        
        System.out.println("\t\n TRANFERENCIAS DESDE UNA CUENTA CORRIENTE SIN SALDO PERO CON SALDO DESCUBIERTO SUFICIENTE");
        TestCuenta.pruebaTransferencia(unaCuentaCorrienteDePedro, unaCuentaCorrienteDeJuan, 100);
        
        
        System.out.println("\t\n TRANFERENCIAS DESDE UNA CUENTA A OTRA CUENTA NULA");
        TestCuenta.pruebaTransferencia(cuentaCorriente, null, 0);
        

    }

}
