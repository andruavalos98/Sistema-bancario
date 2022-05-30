/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.bancario;

import Servicios.AccountManagerService;
import java.util.Scanner;

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

        Scanner sc = new Scanner(System.in);
        AccountManagerService ams = new AccountManagerService();

        int op;
        String titular;
        Integer dni;

        do {
            System.out.println("\n ------ Bienvenido al Sistema Bancario! ------ \n");
            System.out.println("Que desea hacer? \n");

            System.out.println("1. Acceder");
            System.out.println("2. Crear una cuenta nueva");
            System.out.println("3. Listar todas las cuenatas");
            System.out.println("4. Salir \n");

            op = sc.nextInt();

            switch (op) {
                case 1:
                    sc.nextLine();

                    System.out.print("Ingrese el DNI del titular");
                    dni = sc.nextInt();

                    ams.ingresar(dni);

                    break;

                case 2:
                    sc.nextLine();
                    System.out.print("Ingrese el nombre del titular de la cuenta: ");
                    titular = sc.nextLine();

                    System.out.print("Ingrese el DNI del titular: ");
                    dni = sc.nextInt();

                    ams.crearCuenta(titular, dni);

                    break;

                case 3:
                    ams.listarCuentas();
                    break;
                    
                case 4: 
                    break;

                default:
                    System.out.println("Opcion no valida. Intente de Nuevo");

            }
        } while (op != 4);

    }

}
