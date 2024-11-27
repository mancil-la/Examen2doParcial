package GUI;

import CONTROL.CARRITO;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class MAIN extends JFrame {
    private JTextArea areaCarrito;
    private JLabel lblTotal;

    public MAIN() {
        setTitle("POTRO RESTAURANTE");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        setLocationRelativeTo(null);

        // Botones para abrir las ventanas
        JButton btnDesayuno = new JButton("Desayuno");
        JButton btnComida = new JButton("Comida");
        JButton btnCena = new JButton("Cena");
        JButton btnPostres = new JButton("Postres");
        JButton btnBebidas = new JButton("Bebidas");
        JButton btnPagar = new JButton("Pagar");

        // Área de carrito
        areaCarrito = new JTextArea();
        areaCarrito.setEditable(false);
        JScrollPane scrollCarrito = new JScrollPane(areaCarrito);

        // Etiqueta de total
        lblTotal = new JLabel("Total: $0.0");

        // Posicionamiento de componentes
        btnDesayuno.setBounds(20, 20, 120, 30);
        btnComida.setBounds(160, 20, 120, 30);
        btnCena.setBounds(300, 20, 120, 30);
        btnPostres.setBounds(440, 20, 120, 30);
        btnBebidas.setBounds(20, 60, 120, 30);
        btnPagar.setBounds(440, 300, 120, 30);

        scrollCarrito.setBounds(20, 120, 540, 160);
        lblTotal.setBounds(20, 300, 200, 30);

        // Agregar componentes
        add(btnDesayuno);
        add(btnComida);
        add(btnCena);
        add(btnPostres);
        add(btnBebidas);
        add(btnPagar);
        add(scrollCarrito);
        add(lblTotal);

        // Acciones de botones
        btnDesayuno.addActionListener(e -> new VENTANADESAYUNO(this).setVisible(true));
        btnComida.addActionListener(e -> new VENTANACOMIDA(this).setVisible(true));
        btnCena.addActionListener(e -> new VENTANACENA(this).setVisible(true));
        btnPostres.addActionListener(e -> new VENTANAPOSTRES(this).setVisible(true));
        btnBebidas.addActionListener(e -> new VENTANABEBIDAS(this).setVisible(true));

        btnPagar.addActionListener(e -> generarTicket());
    }

    // Método para actualizar el área del carrito
    public void actualizarCarrito() {
        areaCarrito.setText("");
        for (String producto : CARRITO.obtenerProductos()) {
            areaCarrito.append(producto + "\n");
        }
        lblTotal.setText("Total: $" + CARRITO.calcularTotal());
    }

    // Método para generar el ticket
    private void generarTicket() {
        StringBuilder ticket = new StringBuilder();

        // Encabezado del ticket
        ticket.append("POTRO RESTAURANTE\n");
        ticket.append("Universidad Autónoma del Estado de México\n");
        ticket.append("Paraje el Tejocote, San Pedro Tlaltizapan,\n");
        ticket.append("52640 Santiago Tianguistenco, Méx.\n");
        ticket.append("Teléfono: 7222394894\n");
        ticket.append("-----------------------------\n");

        // Detalles de la compra
        for (int i = 0; i < CARRITO.obtenerProductos().size(); i++) {
            ticket.append(CARRITO.obtenerProductos().get(i)).append(" - $").append(CARRITO.obtenerPrecios().get(i)).append("\n");
        }

        // Total
        ticket.append("-----------------------------\n");
        ticket.append("TOTAL: $").append(CARRITO.calcularTotal()).append("\n");
        ticket.append("-----------------------------\n");

        // Agradecimiento y código de barras
        ticket.append("¡Gracias por su compra!\n");
        ticket.append("Código de barras: ").append(generarCodigoBarras()).append("\n");

        // Mostrar el ticket en un mensaje
        JOptionPane.showMessageDialog(this, ticket.toString(), "Ticket", JOptionPane.INFORMATION_MESSAGE);

        // Guardar el ticket como imagen
        guardarTicketComoImagen(ticket.toString());

        // Limpiar carrito
        CARRITO.limpiarCarrito();
        actualizarCarrito();
    }

    // Método para guardar el ticket como imagen
    private void guardarTicketComoImagen(String contenido) {
        int ancho = 400;
        int alto = 600;
        BufferedImage imagen = new BufferedImage(ancho, alto, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = imagen.createGraphics();

        // Fondo blanco
        g2d.setColor(Color.WHITE);
        g2d.fillRect(0, 0, ancho, alto);

        // Texto en negro
        g2d.setColor(Color.BLACK);
        g2d.setFont(new Font("Monospaced", Font.PLAIN, 14));

        // Dividir el contenido por líneas
        String[] lineas = contenido.split("\n");
        int y = 20; // Posición inicial en Y
        for (String linea : lineas) {
            g2d.drawString(linea, 10, y);
            y += 20; // Espaciado entre líneas
        }

        g2d.dispose();

        try {
            // Obtener la ruta del escritorio de forma segura
            String userHome = System.getProperty("user.home");
            String rutaEscritorio = userHome + File.separator + "Desktop" + File.separator;
            File archivo = new File(rutaEscritorio + "Ticket.jpg");

            // Guardar la imagen como JPG
            ImageIO.write(imagen, "jpg", archivo);

            JOptionPane.showMessageDialog(this, "El ticket se guardó en: " + archivo.getAbsolutePath());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al guardar el ticket: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Método para generar un código de barras aleatorio
    private String generarCodigoBarras() {
        StringBuilder codigoBarras = new StringBuilder();
        for (int i = 0; i < 12; i++) {
            codigoBarras.append((int) (Math.random() * 10));
        }
        return codigoBarras.toString();
    }

    public static void main(String[] args) {
        new MAIN().setVisible(true);
    }
}
