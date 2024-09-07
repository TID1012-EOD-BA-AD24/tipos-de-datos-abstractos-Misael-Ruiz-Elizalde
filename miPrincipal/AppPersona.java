package miPrincipal;
public class AppPersona{
    public static void menu() {
        System.out.println("==================================");
		System.out.println("    Operaciones con Personas      ");
        System.out.println("==================================");
        Persona p1 = new Persona("AELL777711","Misael Ruiz",new Fecha("17/05/2005"));
        System.out.println(p1.getDni());
        System.out.println(p1.getNombre());
        System.out.println(p1.getFechaNacimiento());


        
    }
}