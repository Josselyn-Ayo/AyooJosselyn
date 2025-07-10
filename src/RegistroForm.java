import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegistroForm extends JFrame {
    private JPanel panelRegistro;
    private JButton guardarButton;
    private JTextField CodigoField;
    private JTextField NombreField;
    private JTextField DetalleField;
    private JTextField PrecioField;
    private JTextField StockField;
    private JButton limpiarButton;
    private JButton volverButton;

    private String codigoGuardado;
    private String nombreGuardado;
    private String detalleGuardado;
    private double precioGuardado;
    private int stockGuardado;
    private MenuForm menu;

    public String getCodigoGuardado(){
        return codigoGuardado;
    }
    public String getNombreGuardado(){
        return nombreGuardado;
    }
    public String getDetalleGuardado(){
        return detalleGuardado;
    }
    public double getPrecioGuardado(){
        return precioGuardado;
    }
    public int getStockGuardado(){
        return stockGuardado;
    }
    public void setStockGuardado(int stockGuardado) {
        this.stockGuardado = stockGuardado;
    }
    public RegistroForm(String usuario, MenuForm menu) {
        this.menu = menu;
        setTitle("Registros");
        setContentPane(panelRegistro);
        setSize(300,300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

        limpiarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CodigoField.setText("");
                NombreField.setText("");
                DetalleField.setText("");
                PrecioField.setText("");
                StockField.setText("");
            }
        });
        volverButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menu.volverMenu();
                RegistroForm.this.setVisible(false);
            }
        });
        guardarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String codigo = CodigoField.getText().trim();
                String nombre = NombreField.getText().trim();
                String detalle = DetalleField.getText().trim();
                String precio = PrecioField.getText().trim();
                String stock = StockField.getText().trim();
                if (codigo.isEmpty() || nombre.isEmpty()||detalle.isEmpty()|| precio.isEmpty()||stock.isEmpty()){
                    JOptionPane.showMessageDialog(null,"Por favor llenar los campos");
                    return;
                }
                try {
                    double precioD= Double.parseDouble(precio);
                    int stockD = Integer.parseInt(stock);
                    if (precioD > 9999){
                        JOptionPane.showMessageDialog(null,"Precio maximo de 4 cifras");
                        return;
                    }
                    if (stockD > 999) {
                        JOptionPane.showMessageDialog(null, "Stock maximo de 3 cifras");
                        return;
                    }
                    codigoGuardado = codigo;
                    nombreGuardado = nombre;
                    detalleGuardado = detalle;
                    precioGuardado = precioD;
                    stockGuardado = stockD;

                    JOptionPane.showMessageDialog(null,"GUARDADO CORRECTAMENTE");

                    CodigoField.setText("");
                    NombreField.setText("");
                    DetalleField.setText("");
                    PrecioField.setText("");
                    StockField.setText("");



                }catch (NumberFormatException ex){
                    JOptionPane.showMessageDialog(null,"Precio y Stock deben ser numeros validos");
                }
            }
        });
    }
}




