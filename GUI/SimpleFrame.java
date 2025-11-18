package GUI;

import javax.swing.*;

public class SimpleFrame {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("SimpleFrame");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(400, 250);         
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}
