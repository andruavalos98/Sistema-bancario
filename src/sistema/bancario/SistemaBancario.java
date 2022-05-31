/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.bancario;

//import Servicios.AccountManagerService;
import Entidades.AccountManager;
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
        AccountManager accountManager = new AccountManager();

        // Pruebo el polimorfismo
        Cuenta unaCajaDeAhorroDeJuan = new CajaDeAhorro(4, "Juan Pablo Pepe!");
        CajaDeAhorro otraCajaDeAhorro = new CajaDeAhorro(2, "Ivancho Carancho Cara de Chancho");
        CuentaCorriente cuentaCorriente = new CuentaCorriente(3, "Andrea Arevalo de los valles Calchaquies");
        //CUENTA INHABILITADA
        Cuenta cuentaInhabilitada = new CajaDeAhorro(5, "Maria de las Rosas");
        cuentaInhabilitada.setAlta(false);
        //UNA CUENTA CORRIENTE VACIA TOTALMENTE
        Cuenta unaCuentaCorrienteDeJuan = new CuentaCorriente(6, "Juan Pablo Pepe!");
        //UNA CUENTA CORRIENTE QUE SOLO TIENE SALDO DESCUBIERTO
        CuentaCorriente unaCuentaCorrienteDePedro = new CuentaCorriente(7, "Pedro Apaza de las comarcas");

        accountManager.getCuentas().add(unaCajaDeAhorroDeJuan);
        accountManager.getCuentas().add(otraCajaDeAhorro);
        accountManager.getCuentas().add(cuentaCorriente);
        accountManager.getCuentas().add(cuentaInhabilitada);
        accountManager.getCuentas().add(unaCuentaCorrienteDeJuan);
        accountManager.getCuentas().add(unaCuentaCorrienteDePedro);

//        PROBANDO CREAR CUENTAS
        System.out.println("++++++++++++++++++PROBANDO CREAR CUENTAS++++++++++++++++++\n");
        System.out.println(unaCajaDeAhorroDeJuan);
        System.out.println(otraCajaDeAhorro);
        System.out.println(cuentaCorriente);
        System.out.println(cuentaInhabilitada);
        System.out.println(unaCuentaCorrienteDeJuan);

//  ----------------------------------------------------------------------
        System.out.println("\n\n++++++++++++++++++PROBANDO DEPOSITOS++++++++++++++++++\n");
//
        System.out.println("\t A UNA CAJA DE AHORRO");
        TestCuenta.pruebaDeposito(unaCajaDeAhorroDeJuan, 100000);
        System.out.println("\t A LA MISMA CUENTA PARA VER QUE SE SUMEN");
        TestCuenta.pruebaDeposito(unaCajaDeAhorroDeJuan, 50000);
        System.out.println("\t A UNA CUENTA CORRIENTE");
        TestCuenta.pruebaDeposito(cuentaCorriente, 500000);
        System.out.println("\t AL SALDO DESCUBUERTO DE UNA CUENTA CORRIENTE");
        TestCuenta.pruebaDepositoSaldoDescubierto(cuentaCorriente, 50000);
        System.out.println("\t A UNA CUENTA INHABILITADA");
        TestCuenta.pruebaDeposito(cuentaInhabilitada, 50000);
        System.out.println("\t INTENTO DEPOSITAR SALDO NEGATIVO");
        TestCuenta.pruebaDeposito(otraCajaDeAhorro, -500);
        System.out.println("\t SOLO DEPOSITO DE SALDO DESCUBIERTO");
        TestCuenta.pruebaDepositoSaldoDescubierto(unaCuentaCorrienteDePedro, 50000);
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
        System.out.println("\n\n++++++++++++++++++LISTA DE CUENTAS APTAS PARA PRESTAMO++++++++++++++++++\n");

        accountManager
                .obtenerTitularesAptosParaPrestamo()
                .forEach(cuenta -> System.out.println(cuenta.getTitular().toUpperCase()));

        System.out.print("\nHAY CUENTAS HACKEABLES? ");
        System.out.println(accountManager.algunaCuentaPuedeSerHackeada());

    }

}
