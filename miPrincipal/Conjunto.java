package miPrincipal;

public class Conjunto {
    static int M = 20; // Aumento de la capacidad
    private Object cto[];
    private int cardinal;
    private int capacidad;

    // Constructor
    public Conjunto() {
        cto = new Object[M];
        cardinal = 0;
        capacidad = M;
    }

    // Determina si el conjunto está vacío
    public boolean esVacio() {
        return (cardinal == 0);
    }

    // Añade un elemento si no está en el conjunto
    public Conjunto añadir(Object elemento) {
        if (!pertenece(elemento)) {
            if (cardinal >= capacidad) {
                aumentarCapacidad();
            }
            cto[cardinal++] = elemento; // Añadir el elemento y aumentar el cardinal
        }
        return this; // Retornar el conjunto actual
    }

    // Quita el elemento del conjunto
    public Conjunto retirar(Object elemento) {
        for (int i = 0; i < cardinal; i++) {
            if (cto[i].equals(elemento)) {
                // Desplazar los elementos hacia la izquierda
                for (int j = i; j < cardinal - 1; j++) {
                    cto[j] = cto[j + 1];
                }
                cto[--cardinal] = null; // Limpiar la última posición
                break;
            }
        }
        return this; // Retornar el conjunto actual
    }

    // Busca si un elemento pertenece al conjunto
    public boolean pertenece(Object elemento) {
        for (int i = 0; i < cardinal; i++) {
            if (cto[i].equals(elemento)) {
                return true; // El elemento pertenece al conjunto
            }
        }
        return false; // El elemento no pertenece
    }

    // Devuelve el número de elementos
    public int cardinal() {
        return this.cardinal;
    }

    // Operación unión de dos conjuntos
    public Conjunto union(Conjunto c2) {
        Conjunto u = new Conjunto();
        // Primero copia el primer operando de la unión
        for (int k = 0; k < cardinal; k++)
            u.cto[k] = cto[k];
        u.cardinal = cardinal;
        // Añade los elementos de c2 no incluidos
        for (int k = 0; k < c2.cardinal; k++)
            u.añadir(c2.cto[k]);
        return u;
    }

    public Object elemento(int n) throws Exception {
        if (n <= cardinal)
            return cto[--n];
        else
            throw new Exception("Fuera de rango");
    }

    public String toString() {
        StringBuilder s = new StringBuilder("{");
        for (int k = 0; k < cardinal; k++)
            s.append(cto[k].toString()).append(",");
        if (cardinal > 0)
            s.setLength(s.length() - 1); // Eliminar la última coma
        s.append("}");
        return s.toString();
    }

    // Método para aumentar la capacidad del conjunto
    private void aumentarCapacidad() {
        int nuevaCapacidad = capacidad + M; // Aumentar la capacidad en M
        Object[] nuevaCto = new Object[nuevaCapacidad];
        System.arraycopy(cto, 0, nuevaCto, 0, cardinal); // Copiar los elementos existentes
        cto = nuevaCto; // Reemplazar el arreglo antiguo por el nuevo
        capacidad = nuevaCapacidad; // Actualizar la capacidad
    }
}