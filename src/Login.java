import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame {
    private JPanel panel1;
    private JButton accesoButton;
    private JButton limpiarButton;
    private JTextField usuarioField;
    private JPasswordField passwordField1;

    public Login() {
        setTitle("Login");
        setSize(300,300);
        setContentPane(panel1);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        accesoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String usuario = usuarioField.getText();
                String password = new String(passwordField1.getPassword());
                if (usuario.isEmpty()|| password.isEmpty()){
                    JOptionPane.showMessageDialog(null,"Por favor llenar los campos vacios :)");
                    return;
                }
                if (usuario.equals("Josselyn") && password.equals("clave123")){
                    JOptionPane.showMessageDialog(null,"Bienvenidos al Menú de opciones");
                    new MenuForm(usuario).setVisible(true);
                    dispose();
                }else {
                    JOptionPane.showMessageDialog(null, "Credenciales incorrectas :(");

                }

            }
        });
        limpiarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                usuarioField.setText("");
                passwordField1.setText("");

            }
        });
    }
}
