package miPrincipal;

public class Cuenta_Cheques {
   
    private String nombrecuenta;
    private String nombreCliente;
    private String sucursal;
    private float saldo;

   public Cuenta_Cheques(){
      this.nombrecuenta = "";
      this.nombreCliente = "";
      this.sucursal = "";
      this.saldo = 0;
   }
   public Cuenta_Cheques(String nombrecuenta, String nombreCliente, String sucursal) {
      this.nombrecuenta = nombrecuenta;
      this.nombreCliente = nombreCliente;
      this.sucursal = sucursal;
      
   }
   public Cuenta_Cheques(String nombrecuenta, String nombreCliente, String sucursal, float saldo) {
      this.nombrecuenta = nombrecuenta;
      this.nombreCliente = nombreCliente;
      this.sucursal = sucursal;
      this.saldo = saldo;
   }

   public String getNombrecuenta() {
      return nombrecuenta;
   }

   public void setNombrecuenta(String nombrecuenta) {
      this.nombrecuenta = nombrecuenta;
   }

   public String getNombreCliente() {
      return nombreCliente;
   }

   public void setNombreCliente(String nombreCliente) {
      this.nombreCliente = nombreCliente;
   }

   public String getSucursal() {
      return sucursal;
   }

   public void setSucursal(String sucursal) {
      this.sucursal = sucursal;
   }

   public float getSaldo() {
      return saldo;
   }

   public void setSaldo(float saldo) {
      this.saldo = saldo;
   }
   
   public float deposito(float valor){

 this.saldo= this.saldo + valor;
   return saldo;
   }
   public float retiro(float valor){

   this.saldo= this.saldo - valor;
   return saldo;
   }

   public  float muestra_saldo(){
      
      return saldo;
   }


}