package classes;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.*;
import javax.swing.*;

public class ManagerGui {

    private JFrame frame;
    private JPanel panel;
    private JLabel titleLabel;
    ServiceList serviceList = new ServiceList();
    Service currentService;
    ArrayList<String> providerNames = new ArrayList<String>();
    ArrayList<Integer> providerFees = new ArrayList<Integer>();
    ArrayList<Integer> providerConsults = new ArrayList<Integer>();
    ProviderRecord providerRecord;
    ProviderReport providerReport;
    ProviderDirectory providerDirectory = new ProviderDirectory();
    int totalFee = 0;
    ManagerController managerController = new ManagerController();

    public class MyGUI {
        MyGUI() {
            JFrame frame = new JFrame("My GUI");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            JTextField textField = new JTextField(20);
            JLabel label = new JLabel("Enter your name:");
            JPanel panel = new JPanel();
            panel.add(label);
            panel.add(textField);

            textField.addActionListener(e -> {
                String userInput = textField.getText();
                System.out.println("User entered: " + userInput);
                // You can use the user input here to perform some action, update the GUI, etc.
            });

            frame.getContentPane().add(panel, BorderLayout.CENTER);
            frame.pack();
            frame.setVisible(true);
        }
    }

    public ManagerGui() {
        frame = new JFrame();
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        panel = new JPanel();
        panel.setLayout(null);

        titleLabel = new JLabel("Manager Menu");
        titleLabel.setFont(new Font("Serif", Font.BOLD, 36));
        titleLabel.setBounds(280, 150, 400, 50);
        panel.add(titleLabel);

        JButton summaryReportBtn = new JButton("Summary Report");
        summaryReportBtn.setBounds(250, 250, 300, 50);
        summaryReportBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try{
                    WeeklyAccountingProcedure weeklyAccountingProcedure = new WeeklyAccountingProcedure();
                    SummaryReport summaryReport = weeklyAccountingProcedure.requestSummaryReport();
                    String summaryReportString = summaryReport.toString();
                    String[] summaryReportLines = summaryReportString.split("],");

                        StringBuilder sb = new StringBuilder();

                        for (String line : summaryReportLines) {
                            sb.append(line.trim()).append("\n");
                        }

                        String formattedSummaryReport = sb.toString();
                    System.out.println(summaryReport);
                    JTextArea textArea = new JTextArea();
                    textArea.setEditable(false);
                    JScrollPane scrollPane = new JScrollPane(textArea);
                    scrollPane.setPreferredSize(new Dimension(800, 600));
                    JFrame frame = new JFrame();
                    frame.setTitle("Summary Report");
                    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    frame.add(scrollPane, BorderLayout.CENTER);
                    frame.pack();
                    frame.setVisible(true);

                    textArea.append(formattedSummaryReport);

                } catch (Exception ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "An error occurred: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        panel.add(summaryReportBtn);

        JButton memberReportBtn = new JButton("Member Report");
        memberReportBtn.setBounds(250, 350, 300, 50);
        WeeklyAccountingProcedure weeklyAccountingProcedure = new WeeklyAccountingProcedure();
        ManagerController managerController = new ManagerController();
        memberReportBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    String memberNumber = JOptionPane.showInputDialog("Enter Member Number:");
                    MemberRecord memberRecord = managerController.getMemberRecordFromFile(memberNumber);
                    MemberReport thisMemberReport = managerController.requestSingleMemberReport(memberRecord);
                    JTextArea textArea = new JTextArea();
                    textArea.setEditable(false);
                    JScrollPane scrollPane = new JScrollPane(textArea);
                    scrollPane.setPreferredSize(new Dimension(800, 600));
                    JFrame frame = new JFrame();
                    frame.setTitle("Member Report");
                    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    frame.add(scrollPane, BorderLayout.CENTER);
                    frame.pack();
                    frame.setVisible(true);

                    // Append text to the text area
                    textArea.append(thisMemberReport.toString());

                } catch (Exception ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "An error occurred: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        panel.add(memberReportBtn);


        JButton providerReportBtn = new JButton("Provider Report");
        providerReportBtn.setBounds(250, 450, 300, 50);
        WeeklyAccountingProcedure weeklyAccountingProcedure2 = new WeeklyAccountingProcedure();
        ManagerController managerController2 = new ManagerController();
        providerReportBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    String providerNumber = JOptionPane.showInputDialog("Enter Provider Number:");
                    ProviderRecord providerRecord = managerController.getProviderRecordFromFile(providerNumber);
                    ProviderReport thisProviderReport = managerController.requestSingleProviderReport(providerRecord);
                    JTextArea textArea = new JTextArea();
                    textArea.setEditable(false);
                    JScrollPane scrollPane = new JScrollPane(textArea);
                    scrollPane.setPreferredSize(new Dimension(800, 600));
                    JFrame frame = new JFrame();
                    frame.setTitle("Provider Report");
                    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    frame.add(scrollPane, BorderLayout.CENTER);
                    frame.pack();
                    frame.setVisible(true);

                    // Append text to the text area
                    textArea.append(thisProviderReport.toString());

                } catch (Exception ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "An error occurred: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
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
