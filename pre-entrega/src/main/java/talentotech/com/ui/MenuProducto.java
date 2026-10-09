package talentotech.com.ui;

import java.util.List;
import java.util.Scanner;

import talentotech.com.model.Producto;
import talentotech.com.service.ProductoService;
import talentotech.com.util.Validador;

public class MenuProducto {

    private final Scanner sc;
    private final ProductoService service;

    public MenuProducto(Scanner sc, ProductoService service) {

        this.sc = sc;
        this.service = service;

    }

    // MENU

    public void mostrarMenu() {

        System.out.println("- Gestion de Productos -");

        System.out.println("1) AGREGAR PRODUCTO");
        System.out.println("2) LISTAR PRODUCTOS");
        System.out.println("3) BUSCAR PRODUCTOS POR ID");
        System.out.println("4) ACTUALIZAR PRODUCTO");
        System.out.println("5) ELIMINAR PRODUCTO");
        System.out.println("");
        System.out.println("-----");

    }

    // CRUD

    public void agregarProducto() {

        System.out.println("Nuevo producto.");

        String nombre = Validador.leerTexto(sc, "Nombre: ");
        double precio = Validador.leerDouble(sc, "Precio: ");
        int stock = Validador.leerEntero(sc, "Stock: ");
        String categoria = Validador.leerTexto(sc, "Categoria: ");

        Producto p = new Producto(nombre, precio, stock, categoria);

        Producto guardado = service.guardar(p);

        System.out.println("Se agrego el Producto con el id: " + guardado.getId());

    }

    public void listarProductos() {

        List<Producto> lista = service.listarTodos();

        if (lista.isEmpty()) {

            System.out.println("No hay productos cargados.");
            return;

        }

        System.out.println(" Catalogo");

        for (Producto p : lista) {

            System.out.println(p);

        }

    }

    public void buscarProducto() {

        int id = Validador.leerEntero(sc, "Ingresar el id del producto: ");

        Producto p = service.obtenerPorId(id);

        System.out.println("Se encontro el producto" + p);

    }

    public void actualizarProducto() {

        int id = Validador.leerEntero(sc, "Ingresar el id del producto a actualizar");

        Producto actual = service.obtenerPorId(id);

        System.out.println("Datos actuales: " + actual);

        System.out.println("Ingresar los nuevos datos ");

        String nombre = Validador.leerTexto(sc, "Nombre: ");
        double precio = Validador.leerDouble(sc, "Precio: ");
        int stock = Validador.leerEntero(sc, "Stock: ");
        String categoria = Validador.leerTexto(sc, "Categoria: ");

        Producto datos = new Producto(nombre, precio, stock, categoria);

        Producto actualizado = service.actualizar(id, datos);

        System.out.println("Producto actualizado" + actualizado);

    }

    public void eliminarProducto() {

        int id = Validador.leerEntero(sc, "Ingresar el id del producto a eliminar: ");

        service.eliminar(id);

        System.out.println("El producto fue eliminado.");
    }

}
