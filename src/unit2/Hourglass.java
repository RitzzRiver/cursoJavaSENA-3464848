package unit1;

import javax.swing.*;
import java.awt.*;

public class Hourglass extends JFrame {
    JButton btnCalc = new JButton("CALCULAR");

    JLabel[] lblTime = new JLabel[3];

    JLabel lblTitle = new JLabel("Horas - Minutos y Segundos");
    JLabel lblQuantity = new JLabel("Ingrese la cantidad de días: ");
    JLabel lblResult = new JLabel();

    JSpinner spnDays = new JSpinner(new SpinnerNumberModel(0, 0, 9999999, 1));

    String[] timeData = {"Horas: ", "Minutos: ", "Segundos: "};

    public Hourglass() {
        setSize(400, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(5, 1, 5, 5));
        JPanel pDays = new JPanel(new FlowLayout());
        JPanel pTimer = new JPanel(new GridLayout(3, 1, 5, 5));

        pDays.add(lblQuantity);
        pDays.add(spnDays);

        btnCalc.addActionListener(actionEvent -> calc());

        for (int i = 0; i < 3; i++) {
            lblTime[i] = new JLabel(timeData[i]);
            pTimer.add(lblTime[i]);
        }

        add(lblTitle);
        add(pDays);
        add(btnCalc);
        add(pTimer);
        add(lblResult);
    }

    private void calc() {
        long days = (long) (int) spnDays.getValue();

        long[] timeCalc = {(long) days * 24, (long) days * 1440, (long) days * 86400};

        for (int i = 0; i < 3; i++) {
            lblTime[i].setText(timeData[i] + timeCalc[i]);
        }

        lblResult.setText(days + " días tienen " + timeCalc[0] + " horas, " + timeCalc[1] + " minutos, " + timeCalc[2] + " segundos.");
    }

    public static void main(String[] args) {
        new Hourglass().setVisible(true);
    }
}
