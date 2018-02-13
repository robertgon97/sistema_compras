package sistema.empresario;
import java.util.ArrayList;

public class Lista {
    private ArrayList<Cliente> ListaClientes = new ArrayList<Cliente>();
    
    public Lista(ArrayList<Cliente> ListaClientes) {
        this.ListaClientes = ListaClientes;
    }
    public Lista() {

    }
    
    public ArrayList<Cliente> getListadoClientes() {
        return ListaClientes;
    }
    
    public void setListadoClientes(ArrayList<Cliente> ListaClientes) {
        this.ListaClientes = ListaClientes;
    }
    
    public void IncluirCliente(Cliente nuevocliente) {
        this.ListaClientes.add(nuevocliente);
    }
    
    public void imprimir (){
        if (ListaClientes.size() != 0) {
            System.out.println("Cantidad de Clientes que compraron en la empresa: " + ListaClientes.size());
                for (Cliente opc : ListaClientes) {
                    System.out.println("--------------------------------------");
                    System.out.println("Cliente: " + opc.obtenerNombre() + ", V-" + opc.obtenerCedula());
                    System.out.println("Productos: ");
                    System.out.println(opc.obtenerArticulo1());
                    System.out.println(opc.obtenerArticulo2());
                    System.out.println(opc.obtenerArticulo3());
                }
                System.out.println("--------------------------------------");
            }
        else {
            System.out.println("No hay Clientes para mostrar");
        }
    }
    
    public void promedioVenta () {
        double promedio = 0;
        if (ListaClientes.size() != 0) {
            for (Cliente cliente : ListaClientes) {
                promedio = promedio + cliente.obtenerTOTAL();
            }
            promedio = promedio / ListaClientes.size();
            System.out.println("El promedio de Ventas es de: " + promedio + " Bs");
        }
        else {
            System.out.println("El Promedio de ventas es de 0 ya que ningun cliente ha comprado en esta tienda");
        }
    }
}
