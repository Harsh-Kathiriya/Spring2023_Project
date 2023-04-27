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

    void requestMemberReport() {
        try {
            MemberRecordHash memberRecordHash = new MemberRecordHash();
            MemberRecord currentMember;
            ServiceList serviceList = new ServiceList();
            ProviderDirectory providerDirectory = new ProviderDirectory();
            ProviderRecord providerRecord;
            providerRecordHash providerRecordHash = new providerRecordHash();
            ArrayList<Service> memberServices;
            ManagerController managerController = new ManagerController();
            ProviderReport providerReport;
            /*
             * ArrayList<Integer> dateOfServices;
             * ArrayList<String> providerNames;
             * ArrayList<String> serviceNames;
             */
            Service currentService;
            String serviceName;

            // Create a new JFrame to display the member report
            JFrame frame = new JFrame();
            frame.setTitle("Member Report");
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.setLayout(new BorderLayout());

            // Create a JTextArea to display the member report information
            JTextArea textArea = new JTextArea();
            textArea.setEditable(false);
            textArea.setLineWrap(true);
            textArea.setWrapStyleWord(true);

            for (int i = 0; i < memberRecordHash.getSize(); i++) {
                currentMember = memberRecordHash.memberAt(i);
                textArea.append(currentMember.getName() + " " + currentMember.getNumber() + " "
                        + currentMember.getAddress() + " " + currentMember.getCity() + " " + currentMember.getState()
                        + " "
                        + currentMember.getZipCode() + "\n");
                memberServices = serviceList.usersServices(Integer.valueOf(currentMember.getNumber()));
                for (int j = 0; j < memberServices.size(); j++) {
                    currentService = memberServices.get(j);
                    providerReport = ManagerController
                            .getProviderRecordFromFile(Integer.toString(currentService.getProviderNum()));
                    serviceName = providerDirectory.serviceLookup(currentService.getServiceCode());
                    textArea.append(currentService.getDateProvided() + " " + providerReport.getProviderName() + " "
                            + serviceName + "\n");
                }
            }

            // Add the JTextArea to a JScrollPane and add it to the JFrame
            JScrollPane scrollPane = new JScrollPane(textArea);
            frame.add(scrollPane, BorderLayout.CENTER);

            // Set the size and visibility of the JFrame
            frame.setSize(800, 600);
            frame.setVisible(true);

        } catch (Exception e) {
            System.out.println("Error");
        }
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
                    requestMemberReport();

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
