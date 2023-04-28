/**
 * @author: Harsh Kathiriya
 * {@summary: This class implements the main terminal GUI. The operator menu, provider menu and manager menu can be accessed through this terminal GUI.
 */
package classes;
import java.awt.*;
import java.awt.event.*;
//import java.io.IOException;

import javax.swing.*;

/**
 * @summary Creates an instance of the Terminal class and initializes the GUI.
 */
public class Terminal {

    private JFrame frame;
    private JPanel panel;
    private JButton providerButton;
    private JButton operatorButton;
    private JButton managerButton;
    private JLabel titleLabel;

    public Terminal() {
        frame = new JFrame();
        frame.setSize(1800, 1000);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel();
        panel.setLayout(null);

        titleLabel = new JLabel("ChocAn");
        titleLabel.setFont(new Font("Serif", Font.BOLD, 36));
        titleLabel.setBounds(850, 50, 250, 50);
        panel.add(titleLabel);

        providerButton = new JButton("Provider Menu");
        providerButton.setBounds(700, 200, 400, 50);
        providerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new verificationGui();
            }
        });
        panel.add(providerButton);

        managerButton = new JButton("Manager Menu");
        managerButton.setBounds(700, 300, 400, 50);
        managerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new verificationGui();
            }
        });
        panel.add(managerButton);

        operatorButton = new JButton("Operator Menu");
        operatorButton.setBounds(700, 400, 400, 50);
        operatorButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new verificationGui();
            }
        });
        panel.add(operatorButton);

        frame.add(panel);
        frame.setVisible(true);
    }
    public static void main(String[] args) {
       Terminal gui = new Terminal();
    }
}
        