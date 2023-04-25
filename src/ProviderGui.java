import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

import javax.swing.*;

public class ProviderGui {

    private JFrame frame;
    private JPanel panel;
    private JLabel titleLabel;

    public ProviderGui() {
        frame = new JFrame();
        frame.setSize(800, 700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel();
        panel.setLayout(null);

        titleLabel = new JLabel("Provider Menu");
        titleLabel.setFont(new Font("Serif", Font.BOLD, 36));
        titleLabel.setBounds(280, 50, 400, 50);
        panel.add(titleLabel);

        JButton billChocAn = new JButton("Bill ChocAn");
        billChocAn.setBounds(250, 150, 300, 50);
        billChocAn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
            }
        });
        panel.add(billChocAn);

        JButton validateMember = new JButton("Validate member");
        validateMember.setBounds(250, 250, 300, 50);
        validateMember.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
            }
        });
        panel.add(validateMember);

        JButton serviceLoopUP = new JButton("Service lookup");
        serviceLoopUP.setBounds(250, 350, 300, 50);
        serviceLoopUP.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
            }
        });
        panel.add(serviceLoopUP);
        JButton feesLoopUp = new JButton("Fees lookup");
        feesLoopUp.setBounds(250, 450, 300, 50);
        feesLoopUp.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               
            }
        });
        panel.add(feesLoopUp);

        JButton ReqProviderDir = new JButton("Request Provider Directory");
        ReqProviderDir.setBounds(250, 550, 300, 50);
        ReqProviderDir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               
            }
        });
        panel.add(ReqProviderDir);

        frame.add(panel);
        frame.setVisible(true);
    }
        public static void main(String[] args) {
            ProviderGui gui = new ProviderGui();
        }
}
        
