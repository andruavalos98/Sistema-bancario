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

/**
 *
 * @author andru
 */
public class SistemaBancario {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        AccountManager manager = new AccountManager();
        
//        manager.getCuentas().add(new CajaDeAhorro(1, "Juan"));
//        manager.getCuentas().add(new CajaDeAhorro(2, "Pedro"));
//        manager.getCuentas().add(new CajaDeAhorro(3, "Jorge"));
//        manager.getCuentas().add(new CuentaCorriente(4, "Andrea"));
//        manager.getCuentas().add(new CuentaCorriente(5, "Maria"));
//        manager.getCuentas().add(new CuentaCorriente(6, "Ana"));

        Cuenta cuenta = new CajaDeAhorro(1, "Juan");
        CajaDeAhorro unaCuenta = new CajaDeAhorro(2, "Ivan");
        CuentaCorriente otraCuenta = new CuentaCorriente(3, "Andrea");

        
        System.out.println(cuenta);
        System.out.println(otraCuenta);
        
        System.out.println("---------------------------------------------------------------------------");
        
        cuenta.depositarDinero(200);
        otraCuenta.depositarDinero(200);
        otraCuenta.depositarDineroEnSaldoDescubierto(300);
        
        unaCuenta.setAlta(false);
        
        // Debería fallar
        if(unaCuenta.depositarDinero(300)){
            System.out.println("Deposito Exitoso");
        } else {
            System.out.println("Deposito Fallido");
        }

        System.out.println(cuenta);
        System.out.println(otraCuenta);
        
        System.out.println("---------------------------------------------------------------------------");

        // Debería realizarse correctamente
        if(cuenta.retirarDinero(200)) {
            System.out.println("Se retiro dinero correctamente de la cuenta N° " + cuenta.getNroCuenta());
            System.out.println("Fondos Actuales: $" + cuenta.getSaldo());
        } else {    
            System.out.println("Fondos insuficientes");
        }
        
        // Debería fallar
        if(cuenta.retirarDinero(200)) {
            System.out.println("Se retiro dinero correctamente de la cuenta N° " + cuenta.getNroCuenta());
            System.out.println("Fondos Actuales: $" + cuenta.getSaldo());
        } else {    
            System.out.println("Fondos insuficientes");
        }

        // Debería realizarse correctamente
        if(otraCuenta.retirarDinero(200)) {
            System.out.println("Se retiro dinero correctamente de la cuenta N° " + otraCuenta.getNroCuenta());
            System.out.println("Fondos Actuales: $" + otraCuenta.getSaldo());
            System.out.println("Saldo Descubierto: $" + otraCuenta.getSaldoDescubierto());
        } else {    
            System.out.println("Fondos insuficientes");
        }
        
        // Debería realizarse correctamente, con un mensaje extra
        if(otraCuenta.retirarDinero(200)) {
            System.out.println("Se retiro dinero correctamente de la cuenta N° " + otraCuenta.getNroCuenta());
            System.out.println("Fondos Actuales: $" + otraCuenta.getSaldo());
            System.out.println("Saldo Descubierto: $" + otraCuenta.getSaldoDescubierto());
        } else {    
            System.out.println("Fondos insuficientes");
        }
        
        // Debería fallar
        if(otraCuenta.retirarDinero(200)) {
            System.out.println("Se retiro dinero correctamente de la cuenta N° " + otraCuenta.getNroCuenta());
            System.out.println("Fondos Actuales: $" + otraCuenta.getSaldo());
            System.out.println("Saldo Descubierto: $" + otraCuenta.getSaldoDescubierto());
        } else {    
            System.out.println("Fondos insuficientes");
        }
        
        System.out.println("---------------------------------------------------------------------------");
        
        cuenta.depositarDinero(500);

        System.out.println(cuenta);
        System.out.println(otraCuenta);
        
        // Deberia realizarse exitosamente
        if(cuenta.transferirDinero(otraCuenta, 200)) {
            System.out.println("Transferencia exitosa!");
        } else {    
            System.out.println("Fondos insuficientes");
        }
        System.out.println(cuenta);
        System.out.println(otraCuenta);
        
        // Deberia fallar
        if(cuenta.transferirDinero(otraCuenta, 600)) {
            System.out.println("Transferencia exitosa!");
        } else {    
            System.out.println("Fondos insuficientes");
        }
        System.out.println(cuenta);
        System.out.println(otraCuenta);
        
        // Deberia realizarse exitosamente
        if(otraCuenta.transferirDinero(cuenta, 200)) {
            System.out.println("Transferencia exitosa!");
        } else {    
            System.out.println("Fondos insuficientes");
        }
        System.out.println(cuenta);
        System.out.println(otraCuenta);
            
        Cuenta siguienteCuenta = new CajaDeAhorro(5, "Maria");
        
        // Deberia realizarse exitosamente
        if(cuenta.transferirDinero(siguienteCuenta, 200)) {
            System.out.println("\n \n Transferencia exitosa! entre: ");
        } else {    
            System.out.println("Fondos insuficientes");
        }
        System.out.println(cuenta);
        System.out.println(siguienteCuenta);
        
        // Deberia Fallar
        if(cuenta.transferirDinero(unaCuenta, 200)) {
            System.out.println("\n \n Transferencia exitosa! entre: ");
        } else {    
            System.out.println("Transferencia fallida");
        }
        System.out.println(cuenta);
        System.out.println(unaCuenta);


        Cuenta cuentaDelMismoTitular = new CuentaCorriente(6, "Juan");
        
        // No debería añadir un cargo
        if(cuenta.transferirDinero(cuentaDelMismoTitular, 200)) {
            System.out.println("\n \n Transferencia exitosa! entre: ");
        } else {    
            System.out.println("Transferencia fallida");
        }
        System.out.println(cuenta);
        System.out.println(cuentaDelMismoTitular);
        

//        int op;
//        String titular;
//        Integer dni;
//
//        do {
//            System.out.println("\n ------ Bienvenido al Sistema Bancario! ------ \n");
//            System.out.println("Que desea hacer? \n");
//
//            System.out.println("1. Acceder");
//            System.out.println("2. Crear una cuenta nueva");
//            System.out.println("3. Listar todas las cuenatas");
//            System.out.println("4. Salir \n");
//
//            op = sc.nextInt();
//
//            switch (op) {
//                case 1:
//                    sc.nextLine();
//
//                    System.out.print("Ingrese el DNI del titular");
//                    dni = sc.nextInt();
//
//                    ams.ingresar(dni);
//
//                    break;
//
//                case 2:
//                    sc.nextLine();
//                    System.out.print("Ingrese el nombre del titular de la cuenta: ");
//                    titular = sc.nextLine();
//
//                    System.out.print("Ingrese el DNI del titular: ");
//                    dni = sc.nextInt();
//
//                    ams.crearCuenta(titular, dni);
//
//                    break;
//
//                case 3:
//                    ams.listarCuentas();
//                    break;
//                    
//                case 4: 
//                    break;
//
//                default:
//                    System.out.println("Opcion no valida. Intente de Nuevo");
//
//            }
//        } while (op != 4);

    }

}
