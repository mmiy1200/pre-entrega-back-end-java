package talentotech.com.model;

public class Producto {

    // ATRIBUTOS

    private int id;
    private String nombre;
    private double precio;
    private int stock;
    private String categoria;

    public Producto(String nombre, double precio, int stock, String categoria) {
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
        this.categoria = categoria;
    }

    
    public Producto(){

    }

    // ID

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // NOMBRE

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // PRECIO

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    // STOCK

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    // CATEGORIA

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return " ID: " + id +
                " | " + nombre +
                " | $" + precio +
                " | Stock:" + stock +
                " | Categoria:" + categoria;
    }

}
