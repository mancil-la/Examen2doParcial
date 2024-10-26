package GUI;

import javax.swing.*;

public class ClienteVentana extends JFrame {
    private JTextField txtNombre;
    private JTextField txtDireccion;
    private JTextField txtTelefono;
    private JButton btnGuardar;

    public ClienteVentana() {
        setTitle("Cliente");
        setSize(350, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);

        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setBounds(20, 20, 80, 25);
        txtNombre = new JTextField();
        txtNombre.setBounds(100, 20, 200, 25);

        JLabel lblDireccion = new JLabel("Dirección:");
        lblDireccion.setBounds(20, 50, 80, 25);
        txtDireccion = new JTextField();
        txtDireccion.setBounds(100, 50, 200, 25);

        JLabel lblTelefono = new JLabel("Teléfono:");
        lblTelefono.setBounds(20, 80, 80, 25);
        txtTelefono = new JTextField();
        txtTelefono.setBounds(100, 80, 200, 25);

        btnGuardar = new JButton("Guardar");
        btnGuardar.setBounds(100, 110, 100, 25);

        btnGuardar.addActionListener(e -> {
            JOptionPane.showMessageDialog(null, "Cliente guardado: " + txtNombre.getText());
            dispose(); // Cerrar la ventana después de guardar
        });

        add(lblNombre);
        add(txtNombre);
        add(lblDireccion);
        add(txtDireccion);
        add(lblTelefono);
        add(txtTelefono);
        add(btnGuardar);
    }
}
