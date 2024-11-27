package CONTROL;

import java.util.ArrayList;
import java.util.List;

public class CARRITO {
    private static List<String> productos = new ArrayList<>();
    private static List<Double> precios = new ArrayList<>();

    // Método para agregar productos al carrito
    public static void agregarProducto(String producto, double precio) {
        productos.add(producto);
        precios.add(precio);
    }

    // Método para obtener la lista de productos
    public static List<String> obtenerProductos() {
        return productos;
    }

    // Método para obtener la lista de precios
    public static List<Double> obtenerPrecios() {
        return precios;
    }

    // Método para calcular el total
    public static double calcularTotal() {
        double total = 0.0;
        for (double precio : precios) {
            total += precio;
        }
        return total;
    }

    // Método para limpiar el carrito
    public static void limpiarCarrito() {
        productos.clear();
        precios.clear();
    }
}
