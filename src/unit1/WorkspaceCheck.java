package unit1;

import javax.swing.*;


public class WorkspaceCheck extends JFrame {
    int count = 0;

    public WorkspaceCheck() {
        setSize(300, 150);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        JLabel label = new JLabel("Etiqueta");
        JButton button = new JButton("Click para cambiar la etiqueta");

        button.addActionListener(ae -> {
            count = count + 1;
            label.setText("Se ha presionado el boton " + count + " veces.");
        });

        add(label);
        add(button);
    }

    public static void main(String[] args) {
        WorkspaceCheck workspaceCheck = new WorkspaceCheck();
        workspaceCheck.setVisible(true);
    }
}
