package talentotech.com;

import java.util.Scanner;

import talentotech.com.exception.ProductoNoEncontradoException;
import talentotech.com.exception.StockInsuficienteException;
import talentotech.com.model.Producto;
import talentotech.com.service.ProductoService;
import talentotech.com.ui.MenuProducto;
import talentotech.com.util.Validador;

public class Main {
    public static void main(String[] args) {

        ProductoService service = new ProductoService();

        Scanner sc = new Scanner(System.in);

        MenuProducto menu = new MenuProducto(sc, service);

        cargarDatosDePrueba(service);

        int opcion;

        do{

            menu.mostrarMenu();

            opcion = Validador.leerEntero(sc, "Elegir una opcion: ");

            try {

                switch (opcion) {
                    case 1: menu.agregarProducto();
                    break;

                    case 2: menu.listarProductos();
                    break;

                    case 3: menu.buscarProducto();
                    break;

                    case 4: menu.actualizarProducto();
                    break;

                    case 5: menu.eliminarProducto();
                    break;

                    case 6: System.out.println("Nos vemos");
                    break;

                    default: System.out.println("Error. Seleccionar un numero del 1 al 6. ");
                    break;

                }
                
            } catch (ProductoNoEncontradoException | StockInsuficienteException e) {

                System.out.println(e.getMessage());
               
            } catch (IllegalArgumentException e){

                System.out.println(e.getMessage());

            } 
        
        } while (opcion != 6);

        sc.close();

   
    }

    private static void cargarDatosDePrueba(ProductoService service){

        service.guardar(new Producto("Cafe molido 500g ", 4500, 30, "Bebidas"));

        service.guardar(new Producto("Yerba mate 1kg ", 3200, 50, "Bebidas"));

        service.guardar(new Producto("Galletitas dulces ", 1850, 100, "Almacen"));

        service.guardar(new Producto("Aceite de oliva 500ml  ", 6700, 20, "Almacen"));

        service.guardar(new Producto("Chocolate Amargo 70% ", 2900, 15, "Dulces"));

        System.out.println("Se cargaron 5 productos de prueba.\n");

    }


}













