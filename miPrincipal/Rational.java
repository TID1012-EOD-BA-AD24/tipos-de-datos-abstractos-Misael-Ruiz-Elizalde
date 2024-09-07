package miPrincipal;
public class Rational{

    private int r[] = new int[2];

    public Rational(){
        this.r[0] = 1;
        this.r[1] = 1;
    }

    public Rational(int a,int b) throws PosicionIlegalException{
        if (b<=0){
            throw new PosicionIlegalException();
        }
        this.r[0] = a;
        this.r[1] = b;
    }
    
    public int getNumerador(){
        return r[0];
    }
    public int getDenominador(){
        return r[1];
    }
    public void setNumerador(int a){
        r[0]=a;
    }
    public void setDenominador(int a){
        r[1]=a;
    }

    
    public Rational add(Rational a, Rational b){
        Rational x = new Rational();
        x.setNumerador(a.getDenominador() * b.getNumerador() + b.getDenominador()* a.getNumerador());
        x.setDenominador(a.getDenominador() * b.getDenominador());
        return x;
    }
    public Rational add(Rational a){
        Rational x = new Rational();
        x.setNumerador(this.getNumerador()*a.getDenominador()+this.getDenominador()*a.getNumerador());
        x.setDenominador(this.getDenominador()*a.getDenominador());
        return x;
    }

    public Rational mult(Rational a, Rational b){
        Rational x = new Rational();
        x.setNumerador(a.getNumerador() * b.getNumerador());
        x.setDenominador(a.getDenominador() * b.getDenominador());
        return x;
    }
    public Rational mult(Rational a){
       //coloca aquí el código faltante
       Rational x = new Rational();
       x.setNumerador(this.getNumerador()*a.getNumerador());
       x.setDenominador(this.getDenominador()*a.getDenominador());
       return x;
    }
    public boolean equal(Rational a,Rational b){

        return a.getDenominador()*b.getNumerador() == b.getDenominador()*a.getNumerador();
    }
    public boolean equal(Rational a){
        //coloca aquí el código faltante
        return (this.getDenominador()*a.getNumerador() == 
               a.getDenominador()*this.getNumerador());
    }
    @Override
    public String toString() {
        //coloca aquí el código faltante
        return r[0] + "/" +r[1];

    }

}
