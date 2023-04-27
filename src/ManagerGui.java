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

    public SummaryReport requestSummaryReport() {
        // for every provider - # num of consults, total fee then total num of
        // providers, total num of consultations, and total fee
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

        try {
            for (int i = 0; i < serviceList.getSize(); i++) {
                currentService = serviceList.serviceAt(i);
                providerReport = ManagerController
                        .getProviderRecordFromFile(Integer.toString(currentService.getProviderNum()));
                int serviceFee = providerDirectory.feeLookup(currentService.getServiceCode());
                totalFee += serviceFee;
                if (providerNames.contains(providerReport.getProviderName())) {
                    int currentIndex = providerNames.indexOf(providerReport.getProviderName());
                    providerFees.set(currentIndex, providerFees.get(currentIndex) + serviceFee);
                    providerConsults.set(currentIndex, providerConsults.get(currentIndex) + 1);
                } else {
                    providerNames.add(providerReport.getProviderName());
                    providerFees.add(serviceFee);
                    providerConsults.add(1);
                }
            }
            SummaryReport summaryReport = new SummaryReport(providerNames, providerConsults, providerFees,
                    providerNames.size(), serviceList.getSize(), totalFee);

            // Create a new JFrame to display the summary report
            JFrame frame = new JFrame();
            frame.setTitle("Summary Report");
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.setLayout(new BorderLayout());

            // Create a JTextArea to display the summary report information
            JTextArea textArea = new JTextArea();
            textArea.setEditable(false);
            textArea.setLineWrap(true);
            textArea.setWrapStyleWord(true);

            // Append the summary report information to the text area
            textArea.append("Total number of providers: " + summaryReport.getAmountOfProviders() + "\n");
            textArea.append("Total number of consultations: " + summaryReport.getAmountOfConsults() + "\n");
            textArea.append("Total fee: $" + summaryReport.getTotalFee() + "\n\n");
            textArea.append("Provider\tConsultations\tFee\n");
            for (int i = 0; i < summaryReport.getAmountOfProviders(); i++) {
                textArea.append(
                        summaryReport.getProviderNames().get(i) + "\t\t" + summaryReport.getProviderConsultNums().get(i)
                                + "\t\t$" + summaryReport.getProviderTotalFees().get(i) + "\n");
            }

            // Add the JTextArea to a JScrollPane and add it to the JFrame
            JScrollPane scrollPane = new JScrollPane(textArea);
            frame.add(scrollPane, BorderLayout.CENTER);

            // Set the size and visibility of the JFrame
            frame.setSize(800, 600);
            frame.setVisible(true);

            return summaryReport;
        } catch (IOException e) {
            System.out.println("Error");
        }
        return null;
    }

    public class MyGUI {
        public static void main(String[] args) {
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
                SummaryReport summaryReport = ManagerController.RequestSummaryReport();
                // JOptionPane.showMessageDialog(frame,);
            }
        });
        panel.add(summaryReportBtn);

        JButton memberReportBtn = new JButton("Member Report");
        memberReportBtn.setBounds(250, 350, 300, 50);
        memberReportBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    String memberNumber = JOptionPane.showInputDialog("Enter Member Number:");
                    MemberReport memberReport = ManagerController.getMemberRecordFromFile(memberNumber);
                    MemberReport memberName = ManagerController.RequestMemberReport();

                    MyGUI myGUI = new ManagerGui.MyGUI();

                    String[][] data = {
                            { memberReport.getMemberName(), memberNumber,
                                    memberReport.getMemberAddress(),
                                    memberReport.getMemberCity(), memberReport.getMemberState(),
                                    memberReport.getMemberZipCode() }
                    };
                    String[] columnNames = { "Name", "ID", "Address", "City", "State", "Zipcode"
                    };

                    JTable table = new JTable(data, columnNames);
                    table.getColumnModel().getColumn(2).setPreferredWidth(50);

                    JFrame frame = new JFrame();
                    frame.add(new JScrollPane(table), BorderLayout.CENTER);
                    frame.setSize(800, 600);
                    frame.setVisible(true);
                    requestSummaryReport();

                } catch (Exception E) {
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
                    String providerNumber = JOptionPane.showInputDialog("Enter Provider Number:");
                    ProviderReport providerReport = ManagerController.getProviderRecordFromFile(providerNumber);
                    ProviderReport providerName = ManagerController.RequestProviderReport();

                    MyGUI myGUI = new ManagerGui.MyGUI();

                    String[][] data = {
                            { providerReport.getProviderName(), providerNumber,
                                    providerReport.getProviderAddress(),
                                    providerReport.getProviderCity(), providerReport.getProviderState(),
                                    providerReport.getProviderZipCode() }
                    };
                    String[] columnNames = { "Name", "ID", "Address", "City", "State", "Zipcode"
                    };

                    JTable table = new JTable(data, columnNames);
                    table.getColumnModel().getColumn(2).setPreferredWidth(50);

                    JFrame frame = new JFrame();
                    frame.add(new JScrollPane(table), BorderLayout.CENTER);
                    frame.setSize(800, 600);
                    frame.setVisible(true);

                } catch (Exception E) {
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
