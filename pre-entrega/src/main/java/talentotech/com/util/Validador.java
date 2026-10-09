package talentotech.com.util;

import java.util.InputMismatchException;
import java.util.Scanner;

import talentotech.com.exception.StockInsuficienteException;

public class Validador {

    public static void validarNombre(String nombre) {

        if (nombre == null || nombre.isBlank()) {

            throw new IllegalArgumentException("El nombre no puede estar vacio");
        }

    }

    public static void validarPrecio(double precio) {

        if (precio < 0) {
            throw new IllegalArgumentException("El precio no debe ser negativo");
        }

    }

    public static void validarStock(int stock) {
        if (stock < 0) {
            throw new StockInsuficienteException("El stock no debe ser negativo");
        }
    }

    public static void validarCategoria(String categoria) {

        if (categoria == null || categoria.isBlank()) {

            throw new IllegalArgumentException("La categoria no puede estar vacia");
        }

    }

    // CONSOLA

    public static int leerEntero(Scanner sc, String mensaje) {

        while (true) {

            System.err.println(mensaje);

            try {

                int valor = sc.nextInt();
                sc.nextLine();
                return valor;

            } catch (InputMismatchException e) {

                System.out.println("Se debe ingresar un numero entero. Intenta de nuevo");
                sc.nextLine();

            }

        }

    }

    public static double leerDouble(Scanner sc, String mensaje) {
        while (true) {
            System.out.println(mensaje);

            try {

                double valor = sc.nextDouble();
                sc.nextLine();
                return valor;

            } catch (Exception e) {

                System.out.println("Ingresar un numero decimal ( coma / punto)");
                sc.nextLine();
            }

        }
    }

    public static String leerTexto(Scanner sc, String mensaje) {

        System.out.println(mensaje);
        return sc.nextLine();

    }

}
