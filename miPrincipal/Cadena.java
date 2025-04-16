package miPrincipal;


public class Cadena  {
    private char cadena[] = new char[80];
    private int tamanio = 0;
    private final int TOPE=80;

    public Cadena(){
        tamanio=0;
    }
    public Cadena(char[] cadena) {
        this.cadena = cadena;
    }
    public void borrarInicio(){
       //coloca código faltante

    }
    public void agregarFinal(char c) throws PosicionIlegalException{
        if (tamanio>=TOPE)
        {
            throw new PosicionIlegalException(); 
        }
        boolean esLetraMinuscula = (c>='a' && c<='z');
        boolean esLeltraMayuscula = (c>='A' && c<='Z');
        boolean esDigito = (c>='0' && c<='9');
        
        if (!(esLetraMinuscula || esLeltraMayuscula || esDigito))
        {
            //lanza una excepción
            //coloca código faltante
        }

        // asigna c al arreglo e incrementa tamanio
        //coloca código faltante
        

        
        
    }
    public boolean vacia(){
        return (tamanio==0);
    
    }
    public boolean llena(){
        //coloca código faltante
    }
    
    public Cadena invertir() throws PosicionIlegalException{
       //coloca código faltante

    }
    

    public char[] getCadena() {
        return cadena;
    }
    public int tamanio(){
       
        return tamanio;
    }
    
    @Override
    public String toString() {
        String cadenita="";
        
        for (int i=0;i<=tamanio;i++)
        {
            cadenita = cadenita+cadena[i];
        }
        return cadenita;
        
    }
    
   
    
}
