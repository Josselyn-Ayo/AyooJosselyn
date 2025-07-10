import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuForm extends JFrame {
    private JPanel panelMenu;
    private JButton registrosButton;
    private JButton ventasButton;
    private JButton verProductosButton;
    private RegistroForm registroForm = null;

    public MenuForm(String usuario) {
        setTitle("Menú de opciones");
        setContentPane(panelMenu);
        setSize(300, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

        registrosButton.addActionListener(e -> {
            if (registroForm == null) {
                registroForm = new RegistroForm(usuario, this);
            } else {
                registroForm.setVisible(true);
            }
            this.setVisible(false);
        });

        ventasButton.addActionListener(e -> {
            if (registroForm == null || registroForm.getCodigoGuardado() == null) {
                JOptionPane.showMessageDialog(null, "Primero registra un producto.");
                return;
            }
            new VentasForm(usuario, registroForm, this);
            this.setVisible(false);
        });

        verProductosButton.addActionListener(e -> {
            if (registroForm == null || registroForm.getCodigoGuardado() == null || registroForm.getCodigoGuardado().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Primero registra un producto.");
                return;
            }
            new VerProductosForm(registroForm, this).setVisible(true);
            this.setVisible(false);
        });



    }

    public void volverMenu() {
        this.setVisible(true);
    }
}



