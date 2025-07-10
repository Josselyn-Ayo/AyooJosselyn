import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentasForm extends JFrame {
    private JPanel panelVenta;
    private JTextField CodigoField;
    private JTextField NombreField;
    private JTextField PrecioField;
    private JTextField CantidadField;
    private JTextField SubtotalField;
    private JTextField IVAField;
    private JTextField totalField;
    private JButton calcularButton;
    private JButton volverButton;

    private String codigoGuardado;
    private String nombreGuardado;
    private double precioGuardado;
    private int stockGuardado;
    private MenuForm menu;
    private RegistroForm registro;

    public VentasForm(String usuario ,RegistroForm registro, MenuForm menu) {
        this.menu = menu;
        this.registro = registro;
        setTitle("Ventas");
        setSize(400, 350);
        setContentPane(panelVenta);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        if (registro != null) {
            this.codigoGuardado = registro.getCodigoGuardado();
            this.nombreGuardado = registro.getNombreGuardado();
            this.precioGuardado = registro.getPrecioGuardado();
            this.stockGuardado = registro.getStockGuardado();
        } else {
            this.codigoGuardado = "";
            this.nombreGuardado = "";
            this.precioGuardado = 0.0;
            this.stockGuardado = 0;
        }

        NombreField.setEditable(false);
        PrecioField.setEditable(false);
        SubtotalField.setEditable(false);
        IVAField.setEditable(false);
        totalField.setEditable(false);

        CodigoField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String codigoIngresado = CodigoField.getText().trim();
                if (codigoIngresado.equals(codigoGuardado)) {
                    NombreField.setText(nombreGuardado);
                    PrecioField.setText(String.valueOf(precioGuardado));

                } else {
                    NombreField.setText("");
                    PrecioField.setText("");
                    JOptionPane.showMessageDialog(null, "Código no encontrado");
                }
            }
        });

        calcularButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String codigoIngresado = CodigoField.getText().trim();
                if (!codigoIngresado.equals(codigoGuardado)) {
                    JOptionPane.showMessageDialog(null, "Código no encontrado, por favor ingrese un código válido.");
                    return;
                }
                String cantidadStr = CantidadField.getText().trim();
                if (cantidadStr.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Ingrese la cantidad a comprar.");
                    return;
                }
                try {
                    int cantidad = Integer.parseInt(cantidadStr);
                    if (cantidad <= 0) {
                        JOptionPane.showMessageDialog(null, "La cantidad debe ser positiva.");
                        return;
                    }
                    if (cantidad > stockGuardado) {
                        JOptionPane.showMessageDialog(null, "Cantidad supera el stock disponible (" + stockGuardado + ").");
                        return;
                    }

                    double subtotal = cantidad * precioGuardado;
                    double iva = subtotal * 0.12;
                    double total = subtotal + iva;

                    SubtotalField.setText(String.format("%.2f", subtotal));
                    IVAField.setText(String.format("%.2f", iva));
                    totalField.setText(String.format("%.2f", total));

                    stockGuardado -= cantidad;
                    registro.setStockGuardado(stockGuardado);

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Cantidad debe ser un número válido.");
                }
            }
        });

        volverButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MenuForm(usuario).setVisible(true);
                dispose();
            }
        });

        setVisible(true);
    }
}




