package miPrincipal;
import java.util.Scanner;
public class Poligono {
	private int N;
	private Punto arreglo[];
	
	public Poligono(int N) {
		this.N = N;
		this.arreglo = new Punto[N+1];
	}
	public Poligono(Punto a[]){
		this.N = a.length;
		this.arreglo = a;
	}
	public void LeerDatos() {
		try (Scanner entrada = new Scanner(System.in)) {
			for (int i=0;i<this.arreglo.length-1;i++) {
				System.out.print("Dame coordenada(x) de vertice"+(i+1)+":");
				int valorX=entrada.nextInt();
				System.out.print("Dame coordenada(y) de vertice"+(i+1)+":");
				int valorY=entrada.nextInt();
				Punto punto = new Punto(valorX,valorY);
				this.arreglo[i]=punto;
			}
		}
		this.arreglo[N]=this.arreglo[0];	
	}
	public void DesplegarArreglo() {
		for (int i=0;i<this.arreglo.length-1;i++) {
			System.out.print("Vertice"+(i+1)+" x ="+
		            this.arreglo[i].getX()+"   ");
			System.out.println(" y ="+
		            this.arreglo[i].getY());
			
		}
	}
	public double calcularPerimetro() {
		double perimetro = 0.0;
		for (int i = 0; i < this.arreglo.length - 1; i++) {
			int x1 = this.arreglo[i].getX();
			int y1 = this.arreglo[i].getY();
			int x2 = this.arreglo[i + 1].getX();
			int y2 = this.arreglo[i + 1].getY();
			
			// Calcular la distancia entre los puntos
			perimetro += Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
		}
		return perimetro;
	}
	
	public double calcularPerimetro(Poligono a) {
		double perimetro = 0.0;
		Punto[] vertices = a.arreglo;
		for (int i = 0; i < vertices.length - 1; i++) {
			int x1 = vertices[i].getX();
			int y1 = vertices[i].getY();
			int x2 = vertices[i + 1].getX();
			int y2 = vertices[i + 1].getY();
			
			// Calcular la distancia entre los puntos
			perimetro += Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
		}
		return perimetro;
	}

}
