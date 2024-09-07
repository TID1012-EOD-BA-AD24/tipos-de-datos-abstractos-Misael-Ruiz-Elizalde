package miPrincipal;

import java.util.Scanner;

public class AppCuenta_Cheques{
    public static void menu() throws Exception {
        try (Scanner scanner = new Scanner(System.in)) {
            Cuenta_Cheques cuenta = new Cuenta_Cheques("Cuenta1", 
                    "Cliente1", "Sucursal1");

            System.out.println("==================================");
            System.out.println("    Operaciones con Cuenta Cheques");
            System.out.println("==================================");

            boolean salir = false;
            while (!salir) {
                System.out.println("Seleccione una opción:");
                System.out.println("1. Mostrar saldo");
                System.out.println("2. Depositar");
                System.out.println("3. Retirar");
                System.out.println("4. Salir");

                int opcion = scanner.nextInt();
                switch (opcion) {
                    case 1:
                        System.out.println("Saldo actual: " + cuenta.muestra_saldo());
                        break;
                    case 2:
                        System.out.print("Ingrese cantidad a depositar: ");
                        float deposito = scanner.nextFloat();
                        cuenta.deposito(deposito);
                        System.out.println("Saldo después del depósito: " + cuenta.muestra_saldo());
                        break;
                    case 3:
                        System.out.print("Ingrese cantidad a retirar: ");
                        float retiro = scanner.nextFloat();
                        cuenta.retiro(retiro);
                        System.out.println("Saldo después del retiro: " + cuenta.muestra_saldo());
                        break;
                    case 4:
                        salir = true;
                        break;
                    default:
                        System.out.println("Opción no válida");
                }
            }
        }
        
    }
  
    
}
