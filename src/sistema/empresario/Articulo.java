package sistema.empresario;
public class Articulo {
    private String Nombre;
    private int Precio;
    
    //Constructor
    public Articulo(String nombre, int precio) {
        Nombre = nombre;
        Precio = precio;
    }
    
    //Métodos - getters&setters
    
    public void insertarNombre(String nombre) {
        Nombre = nombre;
    }
 
    public String obtenerNombre() {
        return Nombre;
    }
    
    public void insertarPrecio(int precio) {
        Precio = precio;
    }
 
    public int obtenerPrecio() {
        return Precio;
    }
}
