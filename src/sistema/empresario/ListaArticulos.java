package sistema.empresario;
import java.util.ArrayList;
public class ListaArticulos {
    private ArrayList<Articulo> ListaArticulos = new ArrayList<Articulo>();
    
    public ListaArticulos(ArrayList<Articulo> ListaArticulos) {
        this.ListaArticulos = ListaArticulos;
    }
    public ListaArticulos() {

    }
    
    public ArrayList<Articulo> getListadoArticulos() {
        return ListaArticulos;
    }
    
    public void setListadoArticulos(ArrayList<Articulo> ListadoArticulos) {
        this.ListaArticulos = ListadoArticulos;
    }
    
    public void IncluirArticulo(Articulo nuevoarticulo) {
        this.ListaArticulos.add(nuevoarticulo);
    }
    
    public void imprimir (){
        int contador = 0;
          if (ListaArticulos.size() != 0) {
              System.out.println("Cantidad de Articulos disponibles en la empresa: " + ListaArticulos.size());
            for (Articulo opc : ListaArticulos) {
                System.out.println("--------------------------------------");
                System.out.println("Articulo "+ contador + ") " + opc.obtenerNombre() + ", Precio: " + opc.obtenerPrecio());
                contador++;
            }
            System.out.println("--------------------------------------");
            }
        else {
            System.out.println("No hay Articulos para mostrar");
        }
    }
    
    public int cantidadArticulos () {
        return ListaArticulos.size();
    }
    
    public void crearArticulosAleatorios () {
        Articulo[] articulos = new Articulo [10];
        String[] articulo = new String[11];
        int[] precio = new int[11];
        articulo[0] = "Zapatos";
        precio[0] = 2000;
        articulo[1] = "Cartera";
        precio[1] = 3000;
        articulo[2] = "Radio";
        precio[2] = 5000;
        articulo[3] = "Lapiz";
        precio[3] = 30;
        articulo[4] = "Mouse";
        precio[4] = 400;
        articulo[5] = "Teclado";
        precio[5] = 600;
        articulo[6] = "Monitor";
        precio[6] = 4000;
        articulo[7] = "MAC";
        precio[7] = 30000;
        articulo[8] = "Carro";
        precio[8] = 50000;
        articulo[9] = "Hojas Blancas";
        precio[9] = 10;
        articulo[10] = "Borrador";
        precio[10] = 20;
        for (int a = 0; a < articulos.length; a++) {
            articulos[a] = new Articulo (articulo[a], precio[a]);
            IncluirArticulo(articulos[a]);
        }
    }
}
