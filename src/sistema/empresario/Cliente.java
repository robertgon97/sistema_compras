package sistema.empresario;
public class Cliente {
    private int cedula;
    private double Descuento, IVA, Totalcompra;
    private String Nombre;
    private String Articulo1, Articulo2, Articulo3;
    private int cant1, cant2, cant3;
    
    //Constructor
    public Cliente(int ci, String nombre) {
        cedula = ci;
        Nombre = nombre;
        Articulo1 = "Vacio";
        cant1 = 0;
        Articulo2 = "Vacio";
        cant2 = 0;
        Articulo3 = "Vacio";
        cant3 = 0;
        Descuento = 0;
        IVA = 0;
        Totalcompra = 0;
    }
    
    //Métodos - getters&setters
    
    public void insertarCedula(int ci) {
        cedula = ci;
    }
 
    public int obtenerCedula() {
        return cedula;
    }
    
    public void insertarNombre(String nombre) {
        Nombre = nombre;
    }
    
    public String obtenerNombre() {
        return Nombre;
    }
    
    public void insertarArticulo1(String articulo, int cantidad) {
        Articulo1 = articulo;
        cant1 = cantidad;
    }
    
    public String obtenerArticulo1() {
        String mensaje = Articulo1 + ", " + cant1 + " Articulos comprados";
        return mensaje;
    }
    
    public void insertarArticulo2(String articulo, int cantidad) {
        Articulo2 = articulo;
        cant2 = cantidad;
    }
    
    public String obtenerArticulo2() {
        String mensaje = Articulo2 + ", " + cant2 + " Articulos comprados";
        return mensaje;
    }
    
    public void insertarArticulo3(String articulo, int cantidad) {
        Articulo3 = articulo;
        cant3 = cantidad;
    }
    
    public String obtenerArticulo3() {
        String mensaje = Articulo3 + ", " + cant3 + " Articulos comprados";
        return mensaje;
    }
    public void insertarDescuento(double valor) {
        Descuento = valor;
    }
    public double obtenerDescuento() {
        return Descuento;
    }
    public void insertarIva(double valor) {
        IVA = valor;
    }
    public double obtenerIVA() {
        return IVA;
    }
    public void insertarTotal(double valor) {
        Totalcompra = valor;
    }
    public double obtenerTOTAL() {
        return Totalcompra;
    }
}
