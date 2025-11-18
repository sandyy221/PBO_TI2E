package GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class Buttons {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Buttons Example");
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        JButton btnHello = new JButton("Say Hello");
        JButton btnExit = new JButton("Exit");

        btnHello.addActionListener((ActionEvent e) -> {
            JOptionPane.showMessageDialog(frame, "Halo!", "Pesan", JOptionPane.INFORMATION_MESSAGE);
        });

        btnExit.addActionListener((ActionEvent e) -> {
            frame.dispose(); 
        });
        panel.add(btnHello);
        panel.add(btnExit);
        frame.add(panel);
        frame.setVisible(true);
    }
}
