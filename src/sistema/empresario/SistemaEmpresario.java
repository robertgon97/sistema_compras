package sistema.empresario;
import java.util.Scanner;
public class SistemaEmpresario {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        Usuario user = new Usuario("user", 123456789);
        Usuario admin = new Usuario("admin", 1234);
        Lista listaClientes = new Lista();
        ListaArticulos listaArticulos = new ListaArticulos();
        listaArticulos.crearArticulosAleatorios();
        int menuPrincipal = 0;
        do {
            System.out.println("Bienvenido al Sistema");
            System.out.println("Usted es: ");
            int number;
            do {
                System.out.println("1) USUARIO ADMIN");
                System.out.println("2) USUARIO COMPRADOR");
                while (!teclado.hasNextInt()) {
                    System.out.println("1) USUARIO ADMIN");
                    System.out.println("2) USUARIO COMPRADOR");
                    teclado.next(); // this is important!
                }
                number = teclado.nextInt();
            } while (number != 1 && number != 2);
            if (number == 1) {
                if (login(user, admin)) {
                    while(!menu(listaClientes, listaArticulos)) {
                        menu(listaClientes, listaArticulos);
                    }
                    //listaClientes.imprimir();
                    //listaArticulos.imprimir();
                } else {
                    System.out.println("Ha cometido tres errores, se le saco del sistema");
                }
                // LOGIN, menu
                
            } else if (number == 2) {
                String texto = teclado.nextLine();
                while (!siestexto(texto)) {
                    System.out.println("Ingresa tus Nombres");
                    texto = teclado.nextLine();
                }
                do {
                    System.out.println("Ingresa tu Cedula");
                    while(!teclado.hasNextInt()) {
                        System.out.println("Ingresa tu Cedula");
                        teclado.next(); // this is important!
                    }
                    number = teclado.nextInt();
                } while (number < 0);
                Cliente objetoCliente = new Cliente(number, texto);
                System.out.println("Hola! " + objetoCliente.obtenerNombre() + " V-" + objetoCliente.obtenerCedula());
                System.out.println("A continuacion se le mostrara el lista de articulos y debera escoger segun el numero el articulo a comprar");
                listaArticulos.imprimir();
                listaClientes.IncluirCliente(comprarArticulos(listaClientes, listaArticulos, objetoCliente));
                System.out.println("Gracias Por comprar nuestros articulos!");
            }
            // do {
            //    System.out.println("El Programa ha finalizado, Desea reiniciar?");
            //    System.out.println("0) NO SALIR");
            //    System.out.println("1) TERMINE DE USAR EL PROGRAMA");
            //    while (!teclado.hasNextInt()) {
            //        System.out.println("0) NO SALIR");
            //        System.out.println("1) TERMINE DE USAR EL PROGRAMA");
            //        teclado.next(); // this is important!
            //    }
            //    menuPrincipal = teclado.nextInt();
            //} while (menuPrincipal != 0 && menuPrincipal != 1);
        } while (menuPrincipal == 0);
        System.out.println("Hasta Luego");
    }
    public static boolean siestexto(String s) {
        return s.matches("[a-z A-Z]+");
    }
    public static boolean login (Usuario user, Usuario admin) {
        Scanner teclado = new Scanner(System.in);
        boolean paso = false;
        int contrasena = 0;
        String usuario;
        for (int intentos = 0; intentos <= 2; intentos++) {
            System.out.println("Ingresa tu usuario");
            usuario = teclado.nextLine();
            while (!siestexto(usuario)) {
                System.out.println("Ingresa tu usuario correctamente");
                usuario = teclado.nextLine();
            }
            do {
                System.out.println("Ingrese su Contraseña");
                while(!teclado.hasNextInt()) {
                    System.out.println("Son solo numeros");
                    teclado.next(); // this is important!
                }
                contrasena = teclado.nextInt();
            } while (contrasena < 0);
            System.out.println("Verificando...");
            if (user.obtenerUsuario().equals(usuario)) {
                if (user.obtenerPass() == contrasena) {
                    paso = true;
                    break;
                } else {
                    paso = false;
                    usuario = null;
                    contrasena = 0;
                }
            } else if (admin.obtenerUsuario().equals(usuario)) {
                if (admin.obtenerPass() == contrasena) {
                    paso = true;
                    break;
                } else {
                    paso = false;
                    usuario = null;
                    contrasena = 0;
                }
            }
            System.out.println("Autenticacion Invalida");
        }
        return paso;
    }
    public static boolean menu (Lista clientes, ListaArticulos articulos) {
        Scanner teclado = new Scanner(System.in);
        boolean salir = false;
        int menuopcion = 0;
        System.out.println("Bienvenido, Que desea hacer?");
        System.out.println("0) Cerrar Sesion");
        System.out.println("1) Ver lista de Articulos");
        System.out.println("2) Registar Articulos");
        System.out.println("3) Ver lista de Clientes que compraron productos");
        System.out.println("4) Ver Promedio de Ventas");
        do {
            System.out.println("Ingrese su Opcion");
            while(!teclado.hasNextInt()) {
                System.out.println("Son solo numeros");
                teclado.next(); // this is important!
            }
            menuopcion = teclado.nextInt();
        } while (menuopcion < 0);
        switch (menuopcion) {
            case 0:
                System.out.println("Cerrastes Sesion.");
                salir = true;
                break;
            case 1:
                articulos.imprimir();
                break;
            case 2:
                String nombreArticulo = null;
                int precio;
                System.out.println("Ingrese el Nombre del Articulo");
                nombreArticulo = teclado.nextLine();
                while (!siestexto(nombreArticulo)) {
                    System.out.println("Ingrese el Nombre del Articulo");
                    nombreArticulo = teclado.nextLine();
                }
                do {
                    System.out.println("Ingrese el precio del articulo");
                    while(!teclado.hasNextInt()) {
                        System.out.println("Son solo numeros");
                        teclado.next(); // this is important!
                    }
                    precio = teclado.nextInt();
                } while (precio < 0);
                Articulo nuevo = new Articulo(nombreArticulo, precio);
                articulos.IncluirArticulo(nuevo);
                break;
            case 3:
                clientes.imprimir();
                break;
            case 4:
                clientes.promedioVenta();
                break;
            default:
                System.out.println("Opcion Invalida");
                break;
        }
        return salir;
    }
    public static Cliente comprarArticulos (Lista clientes, ListaArticulos articulos, Cliente clienteActual) {
        Scanner teclado = new Scanner(System.in);
        int producto1, cantidad1, producto2, cantidad2, producto3, cantidad3;
        do {
            System.out.println("Ingrese el articulo a comprar");
            while(!teclado.hasNextInt()) {
                System.out.println("Son solo numeros");
                teclado.next(); // this is important!
            }
            producto1 = teclado.nextInt();
        } while (producto1 > articulos.cantidadArticulos() - 1);
        do {
            System.out.println("Ingrese la cantidad de articulos a comprar");
            while(!teclado.hasNextInt()) {
                System.out.println("Son solo numeros");
                teclado.next(); // this is important!
            }
            cantidad1 = teclado.nextInt();
        } while (cantidad1 < 0);
        System.out.println("----------------");
        System.out.println("Ha escogido "+cantidad1+" articulos " + articulos.getListadoArticulos().get(producto1).obtenerNombre() + ", de precio: " + articulos.getListadoArticulos().get(producto1).obtenerPrecio());
        clienteActual.insertarArticulo1(articulos.getListadoArticulos().get(producto1).obtenerNombre(), cantidad1);
        clienteActual.insertarTotal(clienteActual.obtenerTOTAL() + (articulos.getListadoArticulos().get(producto1).obtenerPrecio() * cantidad1));
        System.out.println("Total hasta ahora " + clienteActual.obtenerTOTAL());
        System.out.println("----------------");
        System.out.println("Ahora escoja el segundo articulo a comprar");
        articulos.imprimir();
        do {
            System.out.println("Ingrese el articulo a comprar");
            while(!teclado.hasNextInt()) {
                System.out.println("Son solo numeros");
                teclado.next(); // this is important!
            }
            producto2 = teclado.nextInt();
        } while (producto2 > articulos.cantidadArticulos() - 1);
        do {
            System.out.println("Ingrese la cantidad de articulos a comprar");
            while(!teclado.hasNextInt()) {
                System.out.println("Son solo numeros");
                teclado.next(); // this is important!
            }
            cantidad2 = teclado.nextInt();
        } while (cantidad2 < 0);
        System.out.println("----------------");
        System.out.println("Ha escogido "+cantidad2+" articulos " + articulos.getListadoArticulos().get(producto2).obtenerNombre() + ", de precio: " + articulos.getListadoArticulos().get(producto2).obtenerPrecio());
        clienteActual.insertarArticulo2(articulos.getListadoArticulos().get(producto2).obtenerNombre(), cantidad2);
        clienteActual.insertarTotal(clienteActual.obtenerTOTAL() + (articulos.getListadoArticulos().get(producto2).obtenerPrecio() * cantidad2));
        System.out.println("Total hasta ahora " + clienteActual.obtenerTOTAL());
        System.out.println("----------------");
        System.out.println("Ahora escoja el tercer articulo a comprar");
        articulos.imprimir();
        do {
            System.out.println("Ingrese el articulo a comprar");
            while(!teclado.hasNextInt()) {
                System.out.println("Son solo numeros");
                teclado.next(); // this is important!
            }
            producto3 = teclado.nextInt();
        } while (producto3 > articulos.cantidadArticulos() - 1);
        do {
            System.out.println("Ingrese la cantidad de articulos a comprar");
            while(!teclado.hasNextInt()) {
                System.out.println("Son solo numeros");
                teclado.next(); // this is important!
            }
            cantidad3 = teclado.nextInt();
        } while (cantidad3 < 0);
        System.out.println("----------------");
        System.out.println("Ha escogido "+cantidad3+" articulos " + articulos.getListadoArticulos().get(producto3).obtenerNombre() + ", de precio: " + articulos.getListadoArticulos().get(producto3).obtenerPrecio());
        clienteActual.insertarArticulo3(articulos.getListadoArticulos().get(producto3).obtenerNombre(), cantidad3);
        clienteActual.insertarTotal(clienteActual.obtenerTOTAL() + (articulos.getListadoArticulos().get(producto3).obtenerPrecio() * cantidad3));
        System.out.println("Total hasta ahora " + clienteActual.obtenerTOTAL());
        System.out.println("----------------");
        System.out.println("Espere un momento, estamos procesando sus compras");
        // Proceso de Compras
        if (cantidad1 > 10) {
            //clienteActual.insertarDescuento(clienteActual.obtenerTOTAL()*0.10);
            clienteActual.insertarDescuento(10);
            System.out.println("Se le aplico un descuento del 10%");
        }
        if (cantidad2 > cantidad1 && cantidad2 <= 20) {
            //clienteActual.insertarDescuento(clienteActual.obtenerTOTAL()*0.20);
            clienteActual.insertarDescuento(clienteActual.obtenerDescuento() + 20);
            System.out.println("Se le aplico un descuento del 20%");
        }
        if (cantidad3 >= 20 && cantidad3 != cantidad1 && cantidad3 != cantidad2) {
            clienteActual.insertarDescuento(30);
            //clienteActual.insertarDescuento(clienteActual.obtenerTOTAL()*0.30);
            System.out.println("Se le aplico un descuento del 30%");
        } 
        if (clienteActual.obtenerDescuento() == 0) {
            System.out.println("no se le aplico un descuento");
        }
        // Sacamos el descuento
        clienteActual.insertarDescuento((clienteActual.obtenerTOTAL() * clienteActual.obtenerDescuento()) / 100);
        // Restamos el total de las compras con el descuento procesado
        clienteActual.insertarTotal(clienteActual.obtenerTOTAL() - clienteActual.obtenerDescuento());
        // Sacamos el 12 % del total restante quitado del descuento
        clienteActual.insertarIva((clienteActual.obtenerTOTAL() * 12) / 100);
        // clienteActual.insertarTotal(clienteActual.obtenerTOTAL() - clienteActual.obtenerIVA());
        System.out.println("--------------------------------------------");
        System.out.println("                   Factura");
        System.out.println("--------------------------------------------");
        System.out.println("Cliente " + clienteActual.obtenerNombre() + " V-" + clienteActual.obtenerCedula());
        System.out.println("--------------------------------------------");
        System.out.println("Compro los siguientes articulos: ");
        System.out.println(clienteActual.obtenerArticulo1());
        System.out.println(clienteActual.obtenerArticulo2());
        System.out.println(clienteActual.obtenerArticulo3());
        System.out.println("--------------------------------------------");
        System.out.println("Descuento: " + clienteActual.obtenerDescuento());
        System.out.println("IVA: " + clienteActual.obtenerIVA());
        System.out.println("--------------------------------------------");
        System.out.println("TOTAL: " + clienteActual.obtenerTOTAL());
        System.out.println("--------------------------------------------");
        return clienteActual;
    }
}
