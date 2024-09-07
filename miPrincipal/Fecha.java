package miPrincipal;

public class Fecha {
    private int dia;
    private int mes;
    private int anio;

    // Retorna la fecha expresada en días
    public int fechaToDias() {
        return anio * 360 + mes * 30 + dia;
    }

    // Asignar la fecha expresada en días a los atributos
    public Fecha diasToFecha(int i) {
        // Dividimos por 360 y obtenemos el año
        anio = i / 360;
        // El resto o residuo de la división anterior
        int resto = i % 360;
        // El mes del resto lo dividimos entre 30
        mes = resto / 30;
        // El resto de la división anterior son los días
        dia = resto % 30;

        // Ajustar por si el día es cero
        if (dia == 0) {
            dia = 30;
            mes--;
        }
        // Ajustar por si el mes quedó en cero
        if (mes == 0) {
            mes = 12;
            anio--;
        }

        return new Fecha(dia, mes, anio);
    }

    public Fecha addDias(int d) {
        // Convertir la fecha a días y le sumamos d
        int suma = fechaToDias() + d;
        // La fecha resultante se separa en día, mes y año
        return diasToFecha(suma);
    }

    // Constructores
    public Fecha() {
        // Constructor por defecto
    }

    public Fecha(String s) {
        // Buscamos la primera ocurrencia de '/'
        int pos1 = s.indexOf('/');
        // Buscamos la última ocurrencia de '/'
        int pos2 = s.lastIndexOf('/');
        // Procesa el día
        String sDia = s.substring(0, pos1);
        dia = Integer.parseInt(sDia);
        // Procesamos el mes
        String sMes = s.substring(pos1 + 1, pos2);
        mes = Integer.parseInt(sMes);
        // Procesamos el año
        String sAnio = s.substring(pos2 + 1);
        anio = Integer.parseInt(sAnio);
    }

    public Fecha(int d, int m, int a) {
        dia = d;
        mes = m;
        anio = a;
    }

    // Sobrescribimos el método toString (lo heredamos de Object)
    public String toString() {
        return dia + "/" + mes + "/" + anio;
    }

    // Sobrescribimos el método equals que heredamos de Object
    public boolean equals(Object o) {
        if (o instanceof Fecha) {
            Fecha otra = (Fecha) o;
            return (dia == otra.dia) && (mes == otra.mes) && (anio == otra.anio);
        }
        return false;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }
}
