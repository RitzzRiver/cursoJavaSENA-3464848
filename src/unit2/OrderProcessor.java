package unit1;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class OrderProcessor extends JFrame {

    JTextField txtClient = new JTextField(20);
    JTextField txtProdName1 = new JTextField(20);
    JTextField txtProdName2 = new JTextField(20);
    JTextField txtProdName3 = new JTextField(20);
    JTextField txtProdVUnit1 = new JTextField(20);
    JTextField txtProdVUnit2 = new JTextField(20);
    JTextField txtProdVUnit3 = new JTextField(20);
    JTextField txtProdCant1 = new JTextField(20);
    JTextField txtProdCant2 = new JTextField(20);
    JTextField txtProdCant3 = new JTextField(20);
    JTextField txtProdTotal1 = new JTextField(20);
    JTextField txtProdTotal2 = new JTextField(20);
    JTextField txtProdTotal3 = new JTextField(20);
    JTextField txtVTotal = new JTextField(10);
    JTextField[] txtProd = {
            txtProdName1, txtProdVUnit1, txtProdCant1, txtProdTotal1,
            txtProdName2, txtProdVUnit2, txtProdCant2, txtProdTotal2,
            txtProdName3, txtProdVUnit3, txtProdCant3, txtProdTotal3,
    };

    public OrderProcessor() {
        setSize(500, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Panels
        JPanel pMain = new JPanel();
        JPanel pClient = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JPanel pTable = new JPanel(new GridLayout(4, 4, 5, 5));
        JPanel pVTotal = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JPanel pCalc = new JPanel(new FlowLayout(FlowLayout.RIGHT));

        // Labels
        JLabel lblTitle = new JLabel("orden de compra".toUpperCase());
        JLabel lblClient = new JLabel("Cliente:");
        JLabel lblVTotal = new JLabel("Valor Total");
        JLabel lblResult = new JLabel();
        String[] tableHeaders = {"Producto", "Val. Unit.", "Cant.", "Total"};

        // Buttons
        JButton btnCalc = new JButton("Calcular");

        // Layout Config
        pMain.setLayout(new BoxLayout(pMain, BoxLayout.Y_AXIS));
        txtProdTotal1.setText("0");
        txtProdTotal2.setText("0");
        txtProdTotal3.setText("0");
        txtVTotal.setText("0");
        txtProdTotal1.setEnabled(false);
        txtProdTotal2.setEnabled(false);
        txtProdTotal3.setEnabled(false);
        txtVTotal.setEnabled(false);

        btnCalc.addActionListener(ae -> {
            int vUnit = 0;
            int cant = 0;
            int productTotal = 0;
            int totalPurchase = 0;

            try {
                if (checkBlankFields()) {
                    throw new RuntimeException("No pueden haber espacios en blanco");
                }

                JTextField[] vUnitFields = {txtProdVUnit1, txtProdVUnit2, txtProdVUnit3};
                JTextField[] cantFields = {txtProdCant1, txtProdCant2, txtProdCant3};
                JTextField[] totalFields = {txtProdTotal1, txtProdTotal2, txtProdTotal3};

                for (int i = 0; i < 3; i++) {
                    vUnit = Integer.parseInt(vUnitFields[i].getText());
                    cant = Integer.parseInt(cantFields[i].getText());
                    productTotal = vUnit * cant;
                    totalFields[i].setText(String.valueOf(productTotal));
                    totalPurchase += productTotal;
                }
            } catch (RuntimeException re) {
                if (re.getClass() == NumberFormatException.class) {
                    lblResult.setText("no se puede sumar ese valor");
                } else {
                    lblResult.setText(re.getMessage());
                }
                txtVTotal.setText(String.valueOf(totalPurchase));
                lblResult.setText(txtClient.getText() + " el total de su compra es: $" + totalPurchase);
            }
        });

        packApp(pClient, lblClient, txtClient, tableHeaders, pTable, txtProd, pVTotal, lblVTotal, txtVTotal, pCalc, btnCalc, pMain, lblTitle, lblResult);
    }

    private void packApp(JPanel pClient, JLabel lblClient, JTextField txtClient, String[] tableHeaders, JPanel pTable, JTextField[] txtProd, JPanel pVTotal, JLabel lblVTotal, JTextField txtVTotal, JPanel pCalc, JButton btnCalc, JPanel pMain, JLabel lblTitle, JLabel lblResult) {
        pClient.add(lblClient);
        pClient.add(txtClient);

        for (String header : tableHeaders) {
            pTable.add(new JLabel(header));
        }
        for (JTextField prodField : txtProd) {
            pTable.add(prodField);
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

    private boolean checkBlankFields() {
        List<JTextField> fields = new ArrayList<>();
        fields.add(txtClient);
        for (JTextField productField : txtProd) {
            fields.add(productField);
        }

        for (JTextField field : fields) {
            if (field.getText().isBlank()) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        OrderProcessor orderProcessor = new OrderProcessor();
        orderProcessor.setVisible(true);
    }
}
