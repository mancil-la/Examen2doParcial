package GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginVentana extends JFrame {
    private JTextField txtUsuario;
    private JPasswordField txtContraseña;
    private JButton btnLogin;

    public LoginVentana() {
        setTitle("Login");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);

        JLabel lblUsuario = new JLabel("Usuario:");
        lblUsuario.setBounds(20, 20, 80, 25);
        txtUsuario = new JTextField();
        txtUsuario.setBounds(100, 20, 150, 25);

        JLabel lblContraseña = new JLabel("Contraseña:");
        lblContraseña.setBounds(20, 50, 80, 25);
        txtContraseña = new JPasswordField();
        txtContraseña.setBounds(100, 50, 150, 25);

        btnLogin = new JButton("Ingresar");
        btnLogin.setBounds(100, 80, 150, 25);

        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Aquí puedes agregar la lógica de autenticación.
                JOptionPane.showMessageDialog(null, "Inicio de sesión exitoso.");
                dispose(); // Cerrar la ventana después de iniciar sesión
            }
        });

        add(lblUsuario);
        add(txtUsuario);
        add(lblContraseña);
        add(txtContraseña);
        add(btnLogin);
    }
}
