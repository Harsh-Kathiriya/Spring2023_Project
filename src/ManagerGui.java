import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.*;
import javax.swing.*;

public class ManagerGui {

    private JFrame frame;
    private JPanel panel;
    private JLabel titleLabel;
    private JFrame reportFrame;
    private JPanel reportPanel;
    private JLabel reportTitleLable;
    public ManagerGui() {
        frame = new JFrame();
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        panel = new JPanel();
        panel.setLayout(null);

        titleLabel = new JLabel("Manager Menu");
        titleLabel.setFont(new Font("Serif", Font.BOLD, 36));
        titleLabel.setBounds(280, 50, 400, 50);
        panel.add(titleLabel);

        JButton summaryReportBtn = new JButton("Summary Report");
        summaryReportBtn.setBounds(250, 150, 300, 50);
        summaryReportBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                SummaryReport summaryReport = ManagerController.RequestSummaryReport();
                //JOptionPane.showMessageDialog(frame,);
            }
        });
        panel.add(summaryReportBtn);

        JButton eftReportBtn = new JButton("EFT Report");
        eftReportBtn.setBounds(250, 250, 300, 50);
        eftReportBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
            }
        });
        panel.add(eftReportBtn);

        JButton memberReportBtn = new JButton("Member Report");
        memberReportBtn.setBounds(250, 350, 300, 50);
        memberReportBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    MemberReport memberReport = ManagerController.RequestMemberReport();
                }
                catch(Exception E) {
                    System.out.println("Error");
                }
            }
        });
        panel.add(memberReportBtn);
        JButton providerReportBtn = new JButton("Provider Report");
        providerReportBtn.setBounds(250, 450, 300, 50);
        providerReportBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    ProviderReport providerReport = ManagerController.RequestProviderReport();
                    ManagerController.RequestProviderReport();
                }
                catch(IOException E) {
                    System.out.println("Error");
                }
            }
        });
        panel.add(providerReportBtn);
        frame.add(panel);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        ManagerGui managerGui = new ManagerGui();
    }

}
