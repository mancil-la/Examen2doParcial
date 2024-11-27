package GUI;

import CONTROL.CARRITO;

import javax.swing.*;

public class VENTANACENA extends JFrame {
    private MAIN main;

    public VENTANACENA(MAIN main) {
        this.main = main;
        setTitle("Menú - Cena");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        // Productos con precios
        String producto1 = "Tacos al Pastor";
        double precio1 = 60.00;

        String producto2 = "Hamburguesa Especial";
        double precio2 = 90.00;

        // Etiquetas de productos
        JLabel lblProducto1 = new JLabel(producto1 + " - $" + precio1);
        JLabel lblProducto2 = new JLabel(producto2 + " - $" + precio2);

        // Botones para agregar al carrito
        JButton btnAgregar1 = new JButton("Agregar");
        JButton btnAgregar2 = new JButton("Agregar");

        // Posicionamiento
        lblProducto1.setBounds(20, 20, 200, 20);
        lblProducto2.setBounds(20, 60, 200, 20);
        btnAgregar1.setBounds(220, 20, 80, 20);
        btnAgregar2.setBounds(220, 60, 80, 20);

        // Agregar componentes
        add(lblProducto1);
        add(lblProducto2);
        add(btnAgregar1);
        add(btnAgregar2);

        // Eventos para agregar productos al carrito
        btnAgregar1.addActionListener(e -> {
            CARRITO.agregarProducto(producto1, precio1);
            main.actualizarCarrito();
        });

        btnAgregar2.addActionListener(e -> {
            CARRITO.agregarProducto(producto2, precio2);
            main.actualizarCarrito();
        });
    }
}
