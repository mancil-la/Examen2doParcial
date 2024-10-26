package GUI;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JFrame mainFrame = new JFrame("Sistema Abarrotes");
        mainFrame.setSize(400, 200);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setLayout(null);

        JButton btnLogin = new JButton("Abrir Login");
        btnLogin.setBounds(50, 30, 300, 30);
        btnLogin.addActionListener(e -> {
            LoginVentana loginVentana = new LoginVentana();
            loginVentana.setVisible(true);
        });

        JButton btnCliente = new JButton("Abrir Cliente");
        btnCliente.setBounds(50, 70, 300, 30);
        btnCliente.addActionListener(e -> {
            ClienteVentana clienteVentana = new ClienteVentana();
            clienteVentana.setVisible(true);
        });

        JButton btnFactura = new JButton("Abrir Factura");
        btnFactura.setBounds(50, 110, 300, 30);
        btnFactura.addActionListener(e -> {
            FacturaVentana facturaVentana = new FacturaVentana();
            facturaVentana.setVisible(true);
        });

        mainFrame.add(btnLogin);
        mainFrame.add(btnCliente);
        mainFrame.add(btnFactura);

        mainFrame.setVisible(true);
    }
}
