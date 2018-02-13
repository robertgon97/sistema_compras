package sistema.empresario;
public class Usuario {
    
    private String usuario;
    private int contrasena;
 
    //Constructor
    public Usuario(String user, int pass) {
        usuario = user;
        contrasena = pass;
    }
    
    //Métodos - getters&setters
 
    public void insertarUsuario(String user) {
        usuario = user;
    }
 
    public String obtenerUsuario() {
        return usuario;
    }
 
    public void insertarContrasena(int pass) {
        contrasena = pass;
    }
 
    public int obtenerPass() {
        return contrasena;
    }
}