package miPrincipal;

public class Numerote {
    
    private int numeros[];
    private int tamanio;

    public Numerote() {
        numeros = new int[1];
        tamanio = 0;
    }
    
    public Numerote(int[] n) {
        this.numeros = n;
        tamanio = numeros.length;
    }
    
    public Numerote(int n) {
        String cadenaValor = String.valueOf(n);
        // Convertir la cadena a un array de dígitos
        this.numeros = new int[cadenaValor.length()];
        for (int i = 0; i < cadenaValor.length(); i++) {
            this.numeros[i] = Character.getNumericValue(cadenaValor.charAt(i));
        }
        tamanio = this.numeros.length;
    }
    
    public Numerote(String n) {
        // Convertir la cadena a un array de dígitos
        this.numeros = new int[n.length()];
        for (int i = 0; i < n.length(); i++) {
            this.numeros[i] = Character.getNumericValue(n.charAt(i));
        }
        tamanio = this.numeros.length;
    }
    
    public int getTamanio() {
        return tamanio;
    }
    
    public int[] getNumero() {
        return numeros;
    }
    
    public Numerote suma(Numerote b) {
        // Crear un array para almacenar el resultado de la suma
        int[] c = new int[Math.max(numeros.length, b.numeros.length) + 1];
        int acarreo = 0;

        for (int i = numeros.length - 1, j = b.numeros.length - 1, k = c.length - 1; i >= 0 || j >= 0; i--, j--, k--) {
            int op1 = (i >= 0 ? numeros[i] : 0);
            int op2 = (j >= 0 ? b.numeros[j] : 0);
            int suma = op1 + op2 + acarreo;
            c[k] = suma % 10;
            acarreo = suma / 10;
        }

        if (acarreo > 0) {
            c[0] = acarreo;
        }

        c = eliminarCerosIzquierda(c);
        return new Numerote(c);
    }
    
    public Numerote resta(Numerote b) {
        int[] r = new int[Math.max(numeros.length, b.numeros.length)];
        int prestamo = 0;

        for (int i = numeros.length - 1, j = b.numeros.length - 1, k = r.length - 1; i >= 0 || j >= 0; i--, j--, k--) {
            int resta = (i >= 0 ? numeros[i] : 0) - (j >= 0 ? b.numeros[j] : 0) - prestamo;
            if (resta < 0) {
                resta += 10;
                prestamo = 1;
            } else {
                prestamo = 0;
            }
            r[k] = resta;
        }

        r = eliminarCerosIzquierda(r);
        return new Numerote(r);
    }
    
    private int[] eliminarCerosIzquierda(int[] r) {
        StringBuilder nuevaCadena = new StringBuilder();
        int j = 0;

        // Encontrar el primer dígito no cero
        while (j < r.length && r[j] == 0) {
            j++;
        }

        // Si todos son ceros, devolver un array con un solo cero
        if (j == r.length) {
            return new int[]{0};
        }

        for (int i = j; i < r.length; i++) {
            nuevaCadena.append(r[i]);
        }

        String nCadena = nuevaCadena.toString();
        int[] numerosInt = new int[nCadena.length()];

        for (int i = 0; i < nCadena.length(); i++) {
            numerosInt[i] = Character.getNumericValue(nCadena.charAt(i));
        }

        return numerosInt;
    }
   
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (int numero : numeros) {
            builder.append(numero);
        }
        return builder.toString();
    }
}

