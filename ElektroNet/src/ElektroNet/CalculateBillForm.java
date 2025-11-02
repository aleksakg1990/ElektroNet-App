package ElektroNet;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;

public class CalculateBillForm extends JFrame implements ActionListener {

    JLabel nameText, addressText;
    TextField unitText;
    Choice meter_numChoice, monthChoice;
    JButton submit, cancel;

    public CalculateBillForm(){

        super("ElektroNet - Kalkulacija racuna");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        setSize(1200, 800);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(240, 248, 255));
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
        add(panel, "Center");


        JLabel heading = new JLabel("Kalkulacija racuna");
        heading.setBounds(50, 30, 600, 50);
        heading.setFont(new Font("Arial", Font.BOLD, 36));
        heading.setForeground(new Color(25, 25, 112));
        panel.add(heading);

        JLabel subtitle = new JLabel("Izracunajte racun za elektricnu energiju");
        subtitle.setFont(new Font("Arial", Font.ITALIC, 18));
        subtitle.setForeground(new Color(70, 70, 70));
        subtitle.setBounds(50, 85, 550, 30);
        panel.add(subtitle);


        JPanel formPanel = new JPanel();
        formPanel.setLayout(null);
        formPanel.setBackground(Color.WHITE);
        formPanel.setBounds(50, 130, 650, 520);
        formPanel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(200, 200, 200), 2),
                BorderFactory.createEmptyBorder(30, 30, 30, 30)
        ));

        JLabel meter_num = new JLabel("Broj brojila:");
        meter_num.setFont(new Font("Arial", Font.BOLD, 16));
        meter_num.setForeground(new Color(50, 50, 50));
        meter_num.setBounds(30, 30, 180, 30);
        formPanel.add(meter_num);

        meter_numChoice = new Choice();
        try {
            database c = new database();
            ResultSet resultSet = c.statement.executeQuery("select * from new_Customer");
            while (resultSet.next()){
                meter_numChoice.add(resultSet.getString("meter"));
            }
        } catch (Exception E) {
            E.printStackTrace();
        }

        meter_numChoice.setBounds(220, 30, 380, 40);
        meter_numChoice.setFont(new Font("Arial", Font.PLAIN, 16));
        formPanel.add(meter_numChoice);

        JLabel name = new JLabel("Ime:");
        name.setFont(new Font("Arial", Font.BOLD, 16));
        name.setForeground(new Color(50, 50, 50));
        name.setBounds(30, 90, 180, 30);
        formPanel.add(name);

        nameText = new JLabel("");
        nameText.setBounds(220, 90, 380, 30);
        nameText.setFont(new Font("Arial", Font.PLAIN, 16));
        nameText.setForeground(new Color(25, 25, 112));
        formPanel.add(nameText);

        JLabel address = new JLabel("Adresa:");
        address.setFont(new Font("Arial", Font.BOLD, 16));
        address.setForeground(new Color(50, 50, 50));
        address.setBounds(30, 150, 180, 30);
        formPanel.add(address);

        addressText = new JLabel("");
        addressText.setBounds(220, 150, 380, 30);
        addressText.setFont(new Font("Arial", Font.PLAIN, 16));
        addressText.setForeground(new Color(25, 25, 112));
        formPanel.add(addressText);

        try {
            database c = new database();
            ResultSet resultSet = c.statement.executeQuery("select * from new_Customer where meter = '"+meter_numChoice.getSelectedItem()+"' ");
            while (resultSet.next()){
                nameText.setText(resultSet.getString("name"));
                addressText.setText(resultSet.getString("address"));
            }
        }catch (Exception E){
            E.printStackTrace();
        }
        meter_numChoice.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                try {
                    database c = new database();
                    ResultSet resultSet = c.statement.executeQuery("select * from new_Customer where meter = '"+meter_numChoice.getSelectedItem()+"' ");
                    while (resultSet.next()){
                        nameText.setText(resultSet.getString("name"));
                        addressText.setText(resultSet.getString("address"));
                    }
                }catch (Exception E){
                    E.printStackTrace();
                }
            }
        });

        JLabel unitconsumed = new JLabel("Potrosnja (kWh):");
        unitconsumed.setFont(new Font("Arial", Font.BOLD, 16));
        unitconsumed.setForeground(new Color(50, 50, 50));
        unitconsumed.setBounds(30, 210, 180, 30);
        formPanel.add(unitconsumed);

        unitText = new TextField();
        unitText.setBounds(220, 210, 380, 40);
        unitText.setFont(new Font("Arial", Font.PLAIN, 16));
        formPanel.add(unitText);

        JLabel month = new JLabel("Mesec:");
        month.setFont(new Font("Arial", Font.BOLD, 16));
        month.setForeground(new Color(50, 50, 50));
        month.setBounds(30, 270, 180, 30);
        formPanel.add(month);

        monthChoice = new Choice();
        monthChoice.add("Januar");
        monthChoice.add("Februar");
        monthChoice.add("Mart");
        monthChoice.add("April");
        monthChoice.add("Maj");
        monthChoice.add("Jun");
        monthChoice.add("Jul");
        monthChoice.add("Avgust");
        monthChoice.add("Septembar");
        monthChoice.add("Oktobar");
        monthChoice.add("Novembar");
        monthChoice.add("Decembar");
        monthChoice.setBounds(220, 270, 380, 40);
        monthChoice.setFont(new Font("Arial", Font.PLAIN, 16));
        formPanel.add(monthChoice);


        submit = new JButton("Izracunaj");
        submit.setBounds(220, 340, 180, 45);
        submit.setFont(new Font("Arial", Font.BOLD, 16));
        submit.setBackground(new Color(25, 25, 112));
        submit.setForeground(Color.WHITE);
        submit.setFocusPainted(false);
        submit.setBorderPainted(false);
        submit.addActionListener(this);
        formPanel.add(submit);

        cancel = new JButton("Otkazi");
        cancel.setBounds(420, 340, 180, 45);
        cancel.setFont(new Font("Arial", Font.BOLD, 16));
        cancel.setBackground(new Color(70, 130, 180));
        cancel.setForeground(Color.WHITE);
        cancel.setFocusPainted(false);
        cancel.setBorderPainted(false);
        cancel.addActionListener(this);
        formPanel.add(cancel);

        panel.add(formPanel);


        try {
            ImageIcon img1 = new ImageIcon(ClassLoader.getSystemResource("icons/budzet.png"));
            Image img2 = img1.getImage().getScaledInstance(400, 520, Image.SCALE_SMOOTH);
            ImageIcon img3 = new ImageIcon(img2);
            JLabel imageLabel = new JLabel(img3);
            JPanel rightPanel = new JPanel(null);
            rightPanel.setBackground(new Color(240, 248, 255));
            rightPanel.setPreferredSize(new Dimension(450, 800));
            imageLabel.setBounds(25, 130, 400, 520);
            rightPanel.add(imageLabel);
            add(rightPanel, BorderLayout.EAST);
        } catch (Exception ignore) {}

        setVisible(true);
    }

    public static void main(String[] args) {
        new CalculateBillForm();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==submit){
            String smeterNumber = meter_numChoice.getSelectedItem();
            String sunit = unitText.getText();
            String smonth = monthChoice.getSelectedItem();


            int totalBill = 0;
            int units = Integer.parseInt(sunit);
            String query_tax = "select * from tax";
            try {
                database c = new database();
                ResultSet resultSet = c.statement.executeQuery(query_tax);
                while (resultSet.next()){
                    totalBill += units * Integer.parseInt(resultSet.getString("cost_per_unit"));
                    totalBill += Integer.parseInt(resultSet.getString("meter_rent"));
                    totalBill += Integer.parseInt(resultSet.getString("service_charge"));
                    totalBill += Integer.parseInt(resultSet.getString("acss"));
                    totalBill += Integer.parseInt(resultSet.getString("fixed_tax"));
                }
            } catch (Exception E){
                E.printStackTrace();
            }

            String query_total_bill = "insert into bill values('"+smeterNumber+"','"+smonth+"','"+sunit+"','"+totalBill+"','Not Paid')";
            try{
                database c = new database();
                c.statement.executeUpdate(query_total_bill);

                JOptionPane.showMessageDialog(null, "Customer Bill Updated Successfully");
                setVisible(false);
            }catch (Exception E){
                E.printStackTrace();
            }

        }else {
            setVisible(false);
        }
    }
}
