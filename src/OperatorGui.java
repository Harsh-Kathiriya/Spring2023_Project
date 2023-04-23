import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

import javax.swing.*;

public class OperatorGui {

    private JFrame frame;
    private JPanel panel;
    private JButton providerButton;
    private JButton memberButton;
    private JLabel titleLabel;

    public OperatorGui() {
        frame = new JFrame();
        frame.setSize(1800, 1000);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel();
        panel.setLayout(null);

        titleLabel = new JLabel("Operator GUI");
        titleLabel.setFont(new Font("Serif", Font.BOLD, 36));
        titleLabel.setBounds(700, 50, 400, 50);
        panel.add(titleLabel);

        providerButton = new JButton("Provider");
        providerButton.setBounds(700, 200, 400, 50);
        providerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showOptions("provider");
            }
        });
        panel.add(providerButton);

        memberButton = new JButton("Member");
        memberButton.setBounds(700, 300, 400, 50);
        memberButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showOptions("member");
            }
        });
        panel.add(memberButton);

        frame.add(panel);
        frame.setVisible(true);
    }

    private void showOptions(String type) {
        JFrame providerFrame = new JFrame();
        providerFrame.setSize(800, 600);
        providerFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel providerPanel = new JPanel();
        providerPanel.setLayout(null);
        if(type=="provider"){
            JLabel titleLabel = new JLabel("Provider Options");
        }
        else{
            JLabel titleLabel = new JLabel("Member Options");
        }
        
        titleLabel.setFont(new Font("Serif", Font.BOLD, 24));
        titleLabel.setBounds(250, 50, 300, 50);
        providerPanel.add(titleLabel);

        JButton addButton = new JButton("Add");
        addButton.setBounds(250, 150, 300, 50);
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showAdd(type);
            }
        });
        providerPanel.add(addButton);

        JButton removeButton = new JButton("Remove");
        removeButton.setBounds(250, 250, 300, 50);
        removeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showRemoveForm(type);
            }
        });
        providerPanel.add(removeButton);

        JButton editButton = new JButton("Edit");
        editButton.setBounds(250, 350, 300, 50);
        editButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showEditForm(type);
            }
        });
        providerPanel.add(editButton);

        providerFrame.add(providerPanel);
        providerFrame.setVisible(true);
    }

    private void showAdd(String type){
            JFrame addMemberFrame = new JFrame();
            addMemberFrame.setSize(800, 600);
            addMemberFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    
            JPanel addMemberPanel = new JPanel();
            addMemberPanel.setLayout(null);
            if(type=="provider"){
                JLabel titleLabel = new JLabel("Add Provider");
            }
            else{
                JLabel titleLabel = new JLabel("Add Member");
            }
            titleLabel.setFont(new Font("Serif", Font.BOLD, 24));
            titleLabel.setBounds(250, 50, 300, 50);
            addMemberPanel.add(titleLabel);
    
            JLabel nameLabel = new JLabel("Name:");
            nameLabel.setBounds(100, 150, 100, 30);
            addMemberPanel.add(nameLabel);
    
            JTextField nameField = new JTextField();
            nameField.setBounds(200, 150, 400, 30);
            addMemberPanel.add(nameField);
    
            JLabel addressLabel = new JLabel("Address:");
            addressLabel.setBounds(100, 200, 100, 30);
            addMemberPanel.add(addressLabel);
    
            JTextField addressField = new JTextField();
            addressField.setBounds(200, 200, 400, 30);
            addMemberPanel.add(addressField);
    
            JLabel cityLabel = new JLabel("City:");
            cityLabel.setBounds(100, 250, 100, 30);
            addMemberPanel.add(cityLabel);
    
            JTextField cityField = new JTextField();
            cityField.setBounds(200, 250, 200, 30);
            addMemberPanel.add(cityField);
    
            JLabel stateLabel = new JLabel("State:");
            stateLabel.setBounds(400, 250, 100, 30);
            addMemberPanel.add(stateLabel);
    
            JTextField stateField = new JTextField();
            stateField.setBounds(500, 250, 100, 30);
            addMemberPanel.add(stateField);
    
            JLabel zipLabel = new JLabel("Zip Code:");
            zipLabel.setBounds(100, 300, 100, 30);
            addMemberPanel.add(zipLabel);
    
            JTextField zipField = new JTextField();
            zipField.setBounds(200, 300, 100, 30);
            addMemberPanel.add(zipField);
                JButton addButton = new JButton("Add");
            addButton.setBounds(300, 400, 200, 50);
            addButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    String name = nameField.getText();
                    String address = addressField.getText();
                    String city = cityField.getText();
                    String state = stateField.getText();
                    String zip = zipField.getText();
                    if (zip.matches("\\d{5}")) {
                        // Call the addMember method in OperatorController with the entered information
                        if(type=="provider"){
                            ProviderRecord provider = new ProviderRecord(name,OperatorController.generateUniqueNumber("PROVIDER_FILE_NAME"),address, city, state, zip);
                            try {
                                OperatorController.addProvider(provider);
                            } catch (IOException e1) {
                                e1.printStackTrace();
                            }
                        JOptionPane.showMessageDialog(addMemberFrame, "Provider added successfully!");
                        }
                        else{
                            MemberRecord member = new MemberRecord(name, OperatorController.generateUniqueNumber("PROVIDER_FILE_NAME"), address, city, state, zip);
                            try {
                                OperatorController.addMember(member);
                            } catch (IOException e1) {
                                e1.printStackTrace();
                            }
                        JOptionPane.showMessageDialog(addMemberFrame, "Member added successfully!");
                        }
                        
                        addMemberFrame.dispose();
                    } else {
                        JOptionPane.showMessageDialog(addMemberFrame, "Please enter a valid 5-digit zip code!");
                    }
                }
            });
            addMemberPanel.add(addButton);
    
            addMemberFrame.add(addMemberPanel);
            addMemberFrame.setVisible(true);
        }
        private void showRemoveForm(String type) {
            JFrame removeFrame = new JFrame();
            removeFrame.setSize(800, 600);
            removeFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
            JPanel removePanel = new JPanel();
            removePanel.setLayout(null);
        
            JLabel titleLabel = new JLabel("Remove " + type + " Record");
            titleLabel.setFont(new Font("Serif", Font.BOLD, 24));
            titleLabel.setBounds(250, 50, 300, 50);
            removePanel.add(titleLabel);
        
            JLabel idLabel = new JLabel("Enter " + type + " ID:");
            idLabel.setBounds(150, 150, 150, 30);
            removePanel.add(idLabel);
        
            JTextField idField = new JTextField();
            idField.setBounds(300, 150, 200, 30);
            removePanel.add(idField);
        
            JButton removeButton = new JButton("Remove");
            removeButton.setBounds(250, 250, 300, 50);
            removeButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    String id = idField.getText();
                    if (type.equals("provider")) {
                        try {
                            OperatorController.removeProvider(id);
                        } catch (IOException e1) {
                            e1.printStackTrace();
                        }
                    } else if (type.equals("member")) {
                        try {
                            OperatorController.removeMember(id);
                        } catch (IOException e1) {
                            e1.printStackTrace();
                        }
                    }
                    removeFrame.dispose();
                }
            });
            removePanel.add(removeButton);
        
            removeFrame.add(removePanel);
            removeFrame.setVisible(true);
        }

        private void showEditForm(String type) {
            JFrame editFrame = new JFrame();
            editFrame.setSize(800, 600);
            editFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
            JPanel editPanel = new JPanel();
            editPanel.setLayout(null);
        
            JLabel titleLabel = new JLabel("Edit " + type + " Record");
            titleLabel.setFont(new Font("Serif", Font.BOLD, 24));
            titleLabel.setBounds(250, 50, 300, 50);
            editPanel.add(titleLabel);
        
            JLabel numberLabel = new JLabel("Enter " + type + " ID:");
            numberLabel.setBounds(100, 150, 150, 25);
            editPanel.add(numberLabel);
        
            JTextField numberField = new JTextField();
            numberField.setBounds(250, 150, 300, 25);
            editPanel.add(numberField);
        
            JLabel nameLabel = new JLabel("Name:");
            nameLabel.setBounds(100, 200, 150, 25);
            editPanel.add(nameLabel);
        
            JTextField nameField = new JTextField();
            nameField.setBounds(250, 200, 300, 25);
            editPanel.add(nameField);
        
            JLabel addressLabel = new JLabel("Address:");
            addressLabel.setBounds(100, 250, 150, 25);
            editPanel.add(addressLabel);
        
            JTextField addressField = new JTextField();
            addressField.setBounds(250, 250, 300, 25);
            editPanel.add(addressField);
        
            JLabel cityLabel = new JLabel("City:");
            cityLabel.setBounds(100, 300, 150, 25);
            editPanel.add(cityLabel);
        
            JTextField cityField = new JTextField();
            cityField.setBounds(250, 300, 300, 25);
            editPanel.add(cityField);
        
            JLabel stateLabel = new JLabel("State:");
            stateLabel.setBounds(100, 350, 150, 25);
            editPanel.add(stateLabel);
        
            JTextField stateField = new JTextField();
            stateField.setBounds(250, 350, 300, 25);
            editPanel.add(stateField);
        
            JLabel zipLabel = new JLabel("Zip Code:");
            zipLabel.setBounds(100, 400, 150, 25);
            editPanel.add(zipLabel);
        
            JTextField zipField = new JTextField();
            zipField.setBounds(250, 400, 300, 25);
            editPanel.add(zipField);
        
            JButton submitButton = new JButton("Submit");
            submitButton.setBounds(250, 475, 300, 50);
            submitButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    String number = numberField.getText();
                    String name = nameField.getText();
                    String address = addressField.getText();
                    String city = cityField.getText();
                    String state = stateField.getText();
                    String zip = zipField.getText();
                    boolean success = false;
        
                    if (type.equals("provider")) {
                        try {
                            OperatorController.editProvider(number, name, address, city, state, zip);
                            JOptionPane.showMessageDialog(editFrame, "Record updated successfully.");
                        } catch (IOException e1) {
                            JOptionPane.showMessageDialog(editFrame, "Error updating record.");
                        editFrame.dispose();
                            e1.printStackTrace();
                        }
                    } else if (type.equals("member")) {
                        try {
                            OperatorController.editMember(number, name, address, city, state, zip);
                            JOptionPane.showMessageDialog(editFrame, "Record updated successfully.");
                        } catch (IOException e1) {
                            JOptionPane.showMessageDialog(editFrame, "Error updating record.");
                            e1.printStackTrace();
                        }
                    }
                }
            });
            editPanel.add(submitButton);
        
            editFrame.add(editPanel);
            editFrame.setVisible(true);
        }
        public static void main(String[] args) {
            OperatorGui gui = new OperatorGui();
        }
}
        