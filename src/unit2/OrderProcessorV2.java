import javax.swing.*;
import java.awt.*;

public class OrderProcessorV2 extends JFrame {

    JTextField txtClient = new JTextField(20);

    JTextField[] txtProdName = new JTextField[3];
    JTextField[] txtProdVUnit = new JTextField[3];
    JTextField[] txtProdCant = new JTextField[3];
    JTextField[] txtProdTotal = new JTextField[3];

    JTextField txtVTotal = new JTextField(10);
    JLabel lblResult = new JLabel();

    public OrderProcessorV2() {
        setSize(500, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel pMain = new JPanel();
        pMain.setLayout(new BoxLayout(pMain, BoxLayout.Y_AXIS));

        JPanel pClient = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JPanel pTable = new JPanel(new GridLayout(4, 4, 5, 5));
        JPanel pVTotal = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JPanel pCalc = new JPanel(new FlowLayout(FlowLayout.RIGHT));

        JLabel lblTitle = new JLabel("ORDEN DE COMPRA");
        JLabel lblClient = new JLabel("Cliente:");
        JLabel lblVTotal = new JLabel("Valor Total");

        JButton btnCalc = new JButton("Calcular");

        for (int i = 0; i < 3; i++) {
            txtProdName[i] = new JTextField(10);
            txtProdVUnit[i] = new JTextField(10);
            txtProdCant[i] = new JTextField(10);
            txtProdTotal[i] = new JTextField(10);

            txtProdTotal[i].setEnabled(false);
            txtProdTotal[i].setText("0");
        }

        txtVTotal.setEnabled(false);
        txtVTotal.setText("0");

        btnCalc.addActionListener(e -> calc());

        pClient.add(lblClient);
        pClient.add(txtClient);

        String[] headers = {"Producto", "Val. Unit.", "Cant.", "Total"};
        for (String h : headers) {
            pTable.add(new JLabel(h));
        }

        for (int i = 0; i < 3; i++) {
            pTable.add(txtProdName[i]);
            pTable.add(txtProdVUnit[i]);
            pTable.add(txtProdCant[i]);
            pTable.add(txtProdTotal[i]);
        }

        pVTotal.add(lblVTotal);
        pVTotal.add(txtVTotal);

        pCalc.add(btnCalc);

        pMain.add(lblTitle);
        pMain.add(pClient);
        pMain.add(pTable);
        pMain.add(pVTotal);
        pMain.add(lblResult);
        pMain.add(pCalc);

        add(pMain);
    }

    private void calc() {
        try {
            if (checkBlankFields()) {
                throw new Exception("No pueden haber campos vacíos");
            }

            int totalCompra = 0;

            for (int i = 0; i < 3; i++) {
                int vUnit = Integer.parseInt(txtProdVUnit[i].getText());
                int cant = Integer.parseInt(txtProdCant[i].getText());

                int total = vUnit * cant;
                txtProdTotal[i].setText(String.valueOf(total));

                totalCompra += total;
            }

            txtVTotal.setText(String.valueOf(totalCompra));
            lblResult.setText(txtClient.getText() + " el total es: $" + totalCompra);

        } catch (NumberFormatException e) {
            lblResult.setText("Ingrese solo números en valores y cantidades");
        } catch (Exception e) {
            lblResult.setText(e.getMessage());
        }
    }

    private boolean checkBlankFields() {
        if (txtClient.getText().isBlank()) return true;

        for (int i = 0; i < 3; i++) {
            if (txtProdName[i].getText().isBlank() || txtProdVUnit[i].getText().isBlank() || txtProdCant[i].getText().isBlank()) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        new OrderProcessorV2().setVisible(true);
    }
}