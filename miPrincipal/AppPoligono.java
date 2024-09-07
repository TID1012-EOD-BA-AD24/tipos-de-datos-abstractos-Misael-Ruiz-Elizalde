package miPrincipal;

import java.util.Scanner;

public class AppPoligono {
    public static void menu(){
        System.out.println("==================================");
        System.out.println("   Operaciones con Polígonos      ");
        System.out.println("==================================");
        
        try (Scanner entrada = new Scanner(System.in)) {
            System.out.print("Dame lados del Poligono:");
            int N=entrada.nextInt();
            Poligono poligono = new Poligono(N);
            poligono.LeerDatos();
            poligono.DesplegarArreglo();
            System.out.println("Perimetro = "+poligono.calcularPerimetro());
        }
        
    }

}
