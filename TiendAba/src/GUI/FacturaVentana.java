package GUI;

import javax.swing.*;

public class FacturaVentana extends JFrame {
    private JTextArea txtFactura;
    private JButton btnCerrar;

    public FacturaVentana() {
        setTitle("Factura");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);

        txtFactura = new JTextArea("Factura:\nProducto A - $10\nProducto B - $20\nTotal: $30");
        txtFactura.setBounds(20, 20, 350, 200);
        txtFactura.setEditable(false);

        btnCerrar = new JButton("Cerrar");
        btnCerrar.setBounds(150, 230, 100, 25);
        
        btnCerrar.addActionListener(e -> dispose());

        add(txtFactura);
        add(btnCerrar);
    }
}
