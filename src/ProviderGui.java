import java.awt.*;
import java.awt.event.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;

public class ProviderGui {

    private JFrame frame;
    private JPanel panel;
    private JLabel titleLabel;
    private String providerId;
    private String memberId = "";
    JTextField serviceCodeField;
    JLabel serviceInfo;

    public ProviderGui() {
        frame = new JFrame();
        frame.setSize(800, 800);
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
                validateMemberGui();

            }
        });
        panel.add(billChocAn);

        JButton validateMember = new JButton("Validate member");
        validateMember.setBounds(250, 250, 300, 50);
        validateMember.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                validateMemberGui();
            }
        });
        panel.add(validateMember);

        JButton serviceLoopUP = new JButton("Service lookup");
        serviceLoopUP.setBounds(250, 350, 300, 50);
        serviceLoopUP.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                lookupGui("service");
            }
        });
        panel.add(serviceLoopUP);
        JButton feesLoopUp = new JButton("Fees lookup");
        feesLoopUp.setBounds(250, 450, 300, 50);
        feesLoopUp.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               lookupGui("fee");
            }
        });
        panel.add(feesLoopUp);

        JButton ReqProviderDir = new JButton("Request Provider Directory");
        ReqProviderDir.setBounds(250, 550, 300, 50);
        ReqProviderDir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               requestProviderDir();
            }
        });
        panel.add(ReqProviderDir);

        frame.add(panel);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    

        public void setId(String id){
            this.providerId = id;
        }
        public void billChocAn () {
            JFrame billChocAnframe = new JFrame();
                billChocAnframe.setSize(800, 700);
                billChocAnframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

                JPanel billChocAnPanel = new JPanel();
                billChocAnPanel.setLayout(null);

                JLabel todayDateLabel = new JLabel("Today's Date: ");
                todayDateLabel.setBounds(150, 150, 150, 30);
                billChocAnPanel.add(todayDateLabel);
                JTextField todayDateField = new JTextField();
                todayDateField.setToolTipText("Enter date in formate MMDDYYYY");
                todayDateField.setBounds(400, 150, 200, 30);
                billChocAnPanel.add(todayDateField);

                JLabel serviceDateLabel = new JLabel("Date Service was provided: ");
                serviceDateLabel.setBounds(150, 250, 300, 30);
                billChocAnPanel.add(serviceDateLabel);
                JTextField serviceDateField = new JTextField();
                serviceDateField.setToolTipText("Enter date in formate MMDDYYYY");
                serviceDateField.setBounds(400, 250, 200, 30);
                billChocAnPanel.add(serviceDateField);

                JLabel serviceCodeLabel = new JLabel("Service Code: ");
                serviceCodeLabel.setBounds(150, 350, 150, 30);
                billChocAnPanel.add(serviceCodeLabel);
                serviceCodeField = new JTextField();
                serviceCodeField.setBounds(400, 350, 200, 30);
                billChocAnPanel.add(serviceCodeField);
                serviceInfo = new JLabel();
                serviceInfo.setBounds(350, 370, 400, 30);
                serviceInfo.setHorizontalAlignment(SwingConstants.CENTER);
                serviceCodeField.getDocument().addDocumentListener(new serviceCodeDoc());
                billChocAnPanel.add(serviceInfo);

                JLabel commentsLable = new JLabel("Comments: ");
                commentsLable.setBounds(150, 450, 150, 30);
                billChocAnPanel.add(commentsLable);
                JTextArea comments = new JTextArea();
                comments.setBounds(400, 450, 200,60);
                comments.setLineWrap(true);
                comments.setWrapStyleWord(true);
                comments.setDocument(new CommentDocument());
                JScrollPane scroll = new JScrollPane (comments);
                scroll.setBounds(400, 450, 200, 60);
                 scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
                 scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
                 billChocAnPanel.add(comments);
                 billChocAnPanel.add(scroll);
                
                 JButton billChocAn = new JButton("Bill ChocAn");
                 billChocAn.setBounds(250, 550, 300, 50);
                 billChocAn.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        if(todayDateField.getText().matches("\\d{8}") && serviceCodeField.getText().matches("\\d{6}") && serviceDateField.getText().matches("\\d{8}")){
                        File file = new File(System.getProperty("user.dir") + "/serviceTest");
                        FileWriter fileWriter;
                        try {
                            fileWriter = new FileWriter(file, true);
                            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                            bufferedWriter.write(todayDateField.getText() + "," +
                                          serviceDateField.getText() + "," +
                                          providerId + "," +
                                          memberId + "," +
                                          serviceCodeField.getText() + "," +
                                          comments.getText() + "\n");
                
                           // Close the file
                          bufferedWriter.close();
                          frame.dispose();
                        } catch (IOException e1) {
                            e1.printStackTrace();
                        }}
                        else{
                            JOptionPane.showMessageDialog(billChocAnframe, "Please enter a valid Information");
                        }
                        
                     }
                 });
                
                 billChocAnPanel.add(billChocAn);

            
                billChocAnframe.add(billChocAnPanel);
                billChocAnframe.setLocationRelativeTo(null);
                billChocAnframe.setVisible(true);

        }
        public void validateMemberGui(){
            frame = new JFrame();
            frame.setSize(800, 800);
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.setResizable(false);
    
            panel = new JPanel();
            panel.setLayout(null);
    
            titleLabel = new JLabel("Member Validation");
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
                    String id = idField.getText();
                    if (id.matches("\\d{9}")) {
                        int a = Verification.userVerification(Integer.valueOf(id));
                        if(a==-1){
                            JOptionPane.showMessageDialog(frame, "Invalid ID. Try again");
                        }
                        else if(a==3){
                            JOptionPane.showMessageDialog(frame, "Validated");
                            memberId = id;
                            frame.dispose();
                            billChocAn();
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
        
        public void lookupGui(String type) {
            // Set up the components
            JFrame LookupFrame = new JFrame();
            LookupFrame.setSize(400, 100);
            LookupFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

            JPanel LookupPanel = new JPanel();
            JLabel codeLabel = new JLabel("Service Code:");
            codeLabel.setBounds(10, 50, 50, 20);
            JTextField codeField = new JTextField(10);
            codeField.setBounds(80, 50, 50, 10);
            JButton lookupButton = new JButton("Lookup");
            lookupButton.setBounds(150, 50, 50, 10);
            JLabel outputLabel = new JLabel("");
            outputLabel.setBounds(10, 130, 200, 20);
            
    
            // Set up the layout
            
            //LookupPanel.setLayout(new GridLayout(2, 2, 5, 5));
            LookupPanel.add(codeLabel);
            LookupPanel.add(codeField);
            LookupPanel.add(lookupButton);
            LookupPanel.add(outputLabel);
            LookupFrame.add(LookupPanel);
    
            // Set up the button action
            lookupButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(type=="fee"){
                    try {
                        int code = Integer.parseInt(codeField.getText());
                        int fee = providerController.feeLookup(code);
                        outputLabel.setText("Fee: $" + fee);
                    } catch (NumberFormatException ex) {
                        outputLabel.setText("Invalid code");
                    }
                }
                else if(type == "service"){
                    try {
                        int code = Integer.parseInt(codeField.getText());
                        String service = providerController.serviceLookup(code);
                        outputLabel.setText("Service Name: "+ service);
                    } catch (NumberFormatException ex) {
                        outputLabel.setText("Invalid code");
                    }
                }
                }
            });
    
            // Set up the frame
            
            LookupFrame.setLocationRelativeTo(null);
            LookupFrame.setVisible(true);
        }
        public void requestProviderDir(){
            JFrame frame = new JFrame();
            frame.setSize(500, 500);
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

            JPanel panel = new JPanel();
            String[] columns = { "Service Code", "Service Name", "Service Fee" };
            DefaultTableModel model = new DefaultTableModel(columns, 0);
            JTable table = new JTable(model);
            JScrollPane scrollPane = new JScrollPane(table);
            panel.add(scrollPane, BorderLayout.CENTER);
            ProviderDirectory dir = new ProviderDirectory();
            dir.requestProviderDirectory();
            for(int i=0; i < dir.serviceCodes.size(); i++){
                model.addRow(new Object[] { dir.serviceCodes.get(i), dir.serviceNames.get(i), dir.serviceFees.get(i) });
            }
            
            
            frame.setLocationRelativeTo(null);
            frame.add(panel);
            frame.setVisible(true);

        }
        public class CommentDocument extends PlainDocument {
            private static final int MAX_LENGTH = 100;
        
            @Override
            public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
                if (str == null) {
                    return;
                }
        
                int currentLength = getLength();
                int insertedLength = str.length();
                int newLength = currentLength + insertedLength;
        
                if (newLength > MAX_LENGTH) {
                    int trimLength = MAX_LENGTH - currentLength;
                    if (trimLength > 0) {
                        str = str.substring(0, trimLength);
                    } else {
                        return;
                    }
                }
        
                super.insertString(offs, str, a);
            }
        }
        public class serviceCodeDoc implements DocumentListener {
            public void insertUpdate(DocumentEvent e) {
                showServiceInfo();
            }
            
            public void removeUpdate(DocumentEvent e) {
                showServiceInfo();
            }
            
            public void changedUpdate(DocumentEvent e) {
            }
            public void showServiceInfo(){
                if(!serviceCodeField.getText().matches("\\d{6}")){
                    serviceInfo.setText("Invalid Code");
                  }
                  else{
                    
                        int code = Integer.parseInt(serviceCodeField.getText());
                        int fee = providerController.feeLookup(code);
                        String serviceName = providerController.serviceLookup(code);
                        if(fee == 99999){
                            serviceInfo.setText("Invalid Code");
                        }
                        else{
                            serviceInfo.setText("Fee: " + fee + "$, Name: " + serviceName);
                        }
                        
                }
            }
        }
        public static void main(String[] args) {
            ProviderGui gui = new ProviderGui();
        }
}
        
