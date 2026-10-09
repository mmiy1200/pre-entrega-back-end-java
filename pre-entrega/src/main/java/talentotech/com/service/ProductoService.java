package talentotech.com.service;

import java.util.ArrayList;
import java.util.List;

import talentotech.com.exception.ProductoNoEncontradoException;
import talentotech.com.model.Producto;
import talentotech.com.util.Validador;

public class ProductoService {
    
    private List<Producto> productos = new ArrayList<>();

    private static int contadorId = 1;

    //CRUD
    
    //CREATE 

    public Producto guardar (Producto p){

        Validador.validarNombre(p.getNombre());
        Validador.validarPrecio(p.getPrecio());
        Validador.validarStock(p.getStock());
        Validador.validarCategoria(p.getCategoria());

        p.setId(contadorId);
        contadorId++;

        productos.add(p);

        return p;


    }

    //READ


    // lista completa de productos

    public List<Producto> listarTodos(){

        return productos;
    }

    //Buscar por ID 
    public Producto obtenerPorId(int id){

        for(Producto p : productos){

            if (p.getId() == id ){

                return p;

            }
        }

        throw new ProductoNoEncontradoException("No esta el producto con el id " + id);

    }

    //UPDATE

    public Producto actualizar(int id, Producto datos){

        Producto p = obtenerPorId(id);

        Validador.validarNombre(datos.getNombre());
        Validador.validarPrecio(datos.getPrecio());
        Validador.validarStock(datos.getStock());
        Validador.validarCategoria(datos.getCategoria());

        //Modificacion del producto

        p.setNombre(datos.getNombre());
        p.setPrecio(datos.getPrecio());
        p.setStock(datos.getStock());
        p.setCategoria(datos.getCategoria());

        return p;

    }

    //DELETE

    public void eliminar(int id){

        Producto p = obtenerPorId(id);

        productos.remove(p);

    }


    

}
