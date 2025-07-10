import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VerProductosForm extends JFrame {
    private JPanel panelVerProducto;
    private JTextArea textArea1;
    private JButton volverButton;
    private RegistroForm registro;
    private MenuForm menu;


    public VerProductosForm(RegistroForm registro, MenuForm menu) {
        this.registro = registro;
        this.menu = menu;
        setTitle("Productos Registrados");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setContentPane(panelVerProducto);
        if (registro != null && registro.getCodigoGuardado() != null && !registro.getCodigoGuardado().isEmpty()) {
            String texto = "Código: " + registro.getCodigoGuardado() + "\n" +
                    "Nombre: " + registro.getNombreGuardado() + "\n" +
                    "Detalle: " + registro.getDetalleGuardado() + "\n" +
                    "Precio: $" + registro.getPrecioGuardado() + "\n" +
                    "Stock Actual: " + registro.getStockGuardado();
            textArea1.setText(texto);
        } else {
            textArea1.setText("No hay productos registrados.");
        }

        volverButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menu.setVisible(true);
                dispose();
            }
        });

        setVisible(true);
    }
}