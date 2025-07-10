import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuForm extends JFrame {
    private JPanel panelMenu;
    private JButton registrosButton;
    private JButton ventasButton;
    private JButton verProductosButton;

    public MenuForm(String usuario){
        setTitle("Menu de opciones");
        setContentPane(panelMenu);
        setSize(300,300);
        setLocationRelativeTo(null);
        setVisible(true);

        registrosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new RegistroForm(usuario).setVisible(true);
                dispose();

            }
        });
        ventasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new VentasForm().setVisible(true);
                dispose();

            }
        });
        verProductosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new VerProductosForm().setVisible(true);
                dispose();

            }
        });
    }
}
