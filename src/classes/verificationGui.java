package classes;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

import javax.swing.*;

public class verificationGui {

    private JFrame frame;
    private JPanel panel;
    private JLabel titleLabel;
    private String id;
   

    public verificationGui() {
        frame = new JFrame();
        frame.setSize(800, 800);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setResizable(false);

        panel = new JPanel();
        panel.setLayout(null);

        titleLabel = new JLabel("Verification");
        titleLabel.setFont(new Font("Serif", Font.BOLD, 36));
        titleLabel.setBounds(300, 50, 400, 50);
        panel.add(titleLabel);

        JLabel idLabel = new JLabel("ID Number:");
            idLabel.setBounds(100, 200, 100, 30);
            panel.add(idLabel);
    
            JTextField idField = new JTextField();
            idField.setBounds(200, 200, 400, 30);
            panel.add(idField);

        JButton submit = new JButton("Submit");
        submit.setBounds(350, 300, 100, 50);
        submit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                id = idField.getText();
                if (id.matches("\\d{9}")) {
                    int a = Verification.userVerification(Integer.valueOf(id));
                    if(a==-1){
                        JOptionPane.showMessageDialog(frame, "Invalid ID. Try again");
                    }
                    else if(a==0){
                        frame.dispose();
                        new ManagerGui();
                        
                    }
                    else if(a==1){
                        frame.dispose();
                        ProviderGui proGui = new ProviderGui();
                        proGui.setId(id);
                        
                    }
                    else if(a==2){
                        frame.dispose();
                        new OperatorGui();
                        
                    }
                    
                } else {
                    JOptionPane.showMessageDialog(frame, "Please enter a valid 9-digit ID!");
                }
    }});
    panel.add(submit);
frame.setLocationRelativeTo(null);
frame.add(panel);
frame.setVisible(true);
    }
   

    
    public String getId(){
        return id;
    }
   
}