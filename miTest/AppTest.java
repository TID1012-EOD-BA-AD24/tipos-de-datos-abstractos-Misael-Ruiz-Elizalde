package miTest;

import miPrincipal.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.BeforeAll;

class AppTest {
    
    static Rational r;
    static Rational a;
    static Rational b;
    static Rational c;

    static Matriz m1;

    static Conjunto c1;
    static Conjunto c2;
    static Conjunto c3;

    static Numerote n1;
    static Numerote n2;
    static Numerote n3;

    static Fecha f1;
    static Fecha f2;
    static Fecha f3;

    static Cadena cadena;

    static Punto punto;
    static Punto punto1;
    static Punto punto2;

    static Triangulo triangulo;
    static Punto v1;
    static Punto v2;
    static Punto v3;

    static Poligono poligono;

    static Persona p1;

    static Cuenta_Cheques cuenta;


    @BeforeAll public static void setUp() {
        r = new Rational();

        n3 = new Numerote();

        f3 = new Fecha();

        cadena = new Cadena();

        
        
    }
    
    @Test public void testRationalAdd() throws Exception {
        a = new Rational(7,5);
        b = new Rational(2,3);
        r=r.add(a,b);

        assertTrue(r.getNumerador()==31);
        assertTrue(r.getDenominador()==15);  
        
        r=a.add(b);
        assertTrue(r.getNumerador()==31);
        assertTrue(r.getDenominador()==15);
       
    }
    
    @Test public void testRationalMult() throws Exception  {
        a = new Rational(7,5);
        b = new Rational(2,3);
        r=r.mult(a,b);

        assertTrue(r.getNumerador()==14);
        assertTrue(r.getDenominador()==15);  
        
        r=a.mult(b);
        assertTrue(r.getNumerador()==14);
        assertTrue(r.getDenominador()==15);

    }

    @Test public void testRationalEqual() throws Exception {
        a = new Rational(2,5);
        b = new Rational(4,10);

        assertTrue(r.equal(a,b));
        assertTrue(a.equal(b));

        c = new Rational(6,5);
        assertFalse(a.equals(c));
    }

    @Test public void testMatriz(){
        try {
            m1 = new Matriz(3,3);
            m1.asignarMatriz(0,0,1);
            m1.asignarMatriz(0,1,2);
            m1.asignarMatriz(0,2,3);
            m1.asignarMatriz(1,0,4);
            m1.asignarMatriz(1,1,5);
            m1.asignarMatriz(1,2,6);
            m1.asignarMatriz(2,0,7);
            m1.asignarMatriz(2,1,8);
            m1.asignarMatriz(2,2,9);
            assertTrue(m1.infoMat(0,0)==1);
            assertTrue(m1.infoMat(0,1)==2);
            assertTrue(m1.infoMat(0,2)==3);
            assertTrue(m1.infoMat(1,0)==4);
            assertTrue(m1.infoMat(1,1)==5);
            assertTrue(m1.infoMat(1,2)==6);
            assertTrue(m1.infoMat(2,0)==7);
            assertTrue(m1.infoMat(2,1)==8);
            assertTrue(m1.infoMat(2,2)==9);
            
            assertTrue(m1.filasMat()==3);
            assertTrue(m1.columnasMat()==3);

            assertTrue(m1.infoMat(2,2)==9);


        } catch (Exception e) {
            fail("Se lanzó una excepción al crear la matriz");
        }

    }

    @Test public void testConjuntoAñadir() {
        c1 = new Conjunto();
        c2 = new Conjunto();
        c3 = new Conjunto();

        c1.añadir(1);
        c1.añadir(2);
        c1.añadir(3);

        c2.añadir(3);
        c2.añadir(4);
        c2.añadir(5);
        c3=c1.union(c2);
        assertTrue(c3.cardinal()==5);
    }

    @Test public void testConjuntoRetirar() {
        c1 = new Conjunto();
        
        c1.añadir(1);
        c1.añadir(2);
        c1.añadir(3);

        c1.retirar(2);    
        assertTrue(c1.cardinal()==2);
    }

    @Test public void testConjuntoPertenece() {
        c1 = new Conjunto();
        
        c1.añadir(1);
        c1.añadir(2);
        c1.añadir(3);

        assertTrue(c1.pertenece(2));
        assertFalse(c1.pertenece(4));
    }

    

    @Test public void testNumeroteSuma() {
        n1 = new Numerote("987654321543216789123");
        n2 = new Numerote("123456789123456789123");
       
        n3=n1.suma(n2);
        
       
        assertTrue(n3.toString().equals("1111111110666673578246"));
      
    }
    @Test public void testNumeroteResta() {
        n1 = new Numerote("987654321543216789123");
        n2 = new Numerote("123456789123456789123");
        
        n3=n1.resta(n2);
       
        assertTrue(n3.toString().equals("864197532419760000000"));
  
    }
    @Test public void testFechaEquals(){
        f2 = new Fecha(2,11,1970);
        f1 = new Fecha("2/11/1970");

        assertTrue(f1.equals(f2));
    }
    @Test public void testFechaAddDias(){
        f1 = new Fecha(2,11,1970);
        
        f2 = f1.addDias(360+30+1);

        f3=new Fecha("3/12/1971");

        assertTrue(f1.equals(f3));
      
    }
    @Test public void testFechafechaToDias(){
        
        f1 = new Fecha("2/11/1970");
        
        assertTrue(f1.fechaToDias()==709532);   

    }
    @Test public void testFechaDiasToFecha(){
        f1 = new Fecha("2/11/1970"); 
        int dias = f1.fechaToDias();
        f1.diasToFecha(dias+360);
        
        f3 = new Fecha("2/11/1971");
        assertTrue(f1.equals(f3));

    }

    @Test public void testCadenaAgregarBorrar() throws Exception {
        cadena = new Cadena();
        assertTrue(cadena.vacia());
        cadena.agregarFinal('M');
        cadena.agregarFinal('E');
        cadena.agregarFinal('X');
        cadena.agregarFinal('I');
        cadena.agregarFinal('C');
        cadena.agregarFinal('O');
        cadena.borrarInicio();
        assertTrue(cadena.getCadena()[0]=='E');

        assertTrue(cadena.tamanio()==5);

    }

    @Test public void testCadenaLlenar() throws Exception {
        cadena = new Cadena();
        for (int i=0;i<80;i++)
        {
            cadena.agregarFinal('A');
        }
        assertTrue(cadena.llena());
        // Verificar que se lanza una excepción al intentar agregar más de 80 caracteres
        try {
            cadena.agregarFinal('B');
            fail("Se esperaba una excepción al agregar más de 80 caracteres");
        } catch (Exception e) {
            // Se lanzó la excepción esperada
        }
    
    }

    @Test public void testCadenaInvertir() throws Exception {
        cadena = new Cadena();
        cadena.agregarFinal('a');
        cadena.agregarFinal('e');
        cadena.agregarFinal('i');
        cadena.agregarFinal('o');
        cadena.agregarFinal('u');
        Cadena invertida = cadena.invertir();
        assertTrue(invertida.getCadena()[0]=='u');
        assertTrue(invertida.getCadena()[1]=='o');
        assertTrue(invertida.getCadena()[2]=='i');
        assertTrue(invertida.getCadena()[3]=='e');
        assertTrue(invertida.getCadena()[4]=='a');


    }

    @Test public void testPunto(){
        punto = new Punto(1,2);
        assertTrue(punto.getX()==1);
        assertTrue(punto.getY()==2);

    }

    @Test public void testPuntoDistancia(){
        punto1 = new Punto(1,1);
        punto2 = new Punto(4,5);
        assertTrue(punto1.distancia(punto2)==5.0);

    }

    @Test public void testTriangulo(){
        v1 = new Punto(1,1);
        v2 = new Punto(1,4);
        v3 = new Punto(3,4);
        triangulo = new Triangulo(v1,v2,v3);
        assertTrue(triangulo.longuitudes()[0]==3.0);
        assertTrue(triangulo.longuitudes()[1]==2.0);
        assertTrue(triangulo.longuitudes()[2]==Math.sqrt(9+4));
        
    }

    @Test public void testPoligonoCalcularPerimetro(){
        
        
        Punto v1 = new Punto(1,1);
        Punto v2 = new Punto(1,4);
        Punto v3 = new Punto(3,4);
        Punto v4 = new Punto(4,3);
        Punto v5 = new Punto(3,1);
        Punto arreglo[] = new Punto[6];
        arreglo[0]=v1;
        arreglo[1]=v2;
        arreglo[2]=v3;
        arreglo[3]=v4;
        arreglo[4]=v5;
        arreglo[5]=v1;
       
        Poligono poligono = new Poligono(arreglo);
        
        assertTrue(poligono.calcularPerimetro()==10.650281539872886);

    }


    @Test public void testPersona(){
        p1 = new Persona("AELL777711","Misael Ruiz",new Fecha("17/05/2005"));
        f1 = new Fecha(17,05,2005);
        assertTrue(p1.getDni().equals("AELL777711"));
        assertTrue(p1.getNombre().equals("Misael Ruiz"));
        assertTrue(p1.getFechaNacimiento().equals(f1));
        assertNotNull(p1);
    }

    @Test public void testCuentaCheques(){
        cuenta = new Cuenta_Cheques("ahorro","Misael Ruiz","Imala"); 
        assertTrue(cuenta.muestra_saldo()==0);
        cuenta.deposito(750);
        assertTrue(cuenta.muestra_saldo()==750);
        cuenta.retiro(200);
        assertTrue(cuenta.muestra_saldo()==550);
    }


    
}