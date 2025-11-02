package ElektroNet;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;

public class payBill extends JFrame implements ActionListener {

    Choice searchByMonthChoice;
    String meter;
    JButton pay, back;

    public payBill(String meter){
        super("ElektroNet - Placanje racuna");
        this.meter = meter;
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(1200, 800);
        setLocationRelativeTo(null);
        setLayout(null);


        getContentPane().setBackground(new Color(240, 248, 255));


        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(null);
        mainPanel.setBackground(new Color(240, 248, 255));
        mainPanel.setBounds(0, 0, 1200, 800);
        add(mainPanel);

        JLabel heading = new JLabel("Placanje racuna");
        heading.setFont(new Font("Arial", Font.BOLD, 36));
        heading.setForeground(new Color(25, 25, 112));
        heading.setBounds(50, 30, 500, 50);
        mainPanel.add(heading);

        JLabel subtitle = new JLabel("Platite racun za broj brojila: " + meter);
        subtitle.setFont(new Font("Arial", Font.ITALIC, 18));
        subtitle.setForeground(new Color(70, 70, 70));
        subtitle.setBounds(50, 85, 600, 30);
        mainPanel.add(subtitle);


        JPanel formPanel = new JPanel();
        formPanel.setLayout(null);
        formPanel.setBackground(Color.WHITE);
        formPanel.setBounds(50, 130, 650, 600);
        formPanel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(200, 200, 200), 2),
                BorderFactory.createEmptyBorder(30, 30, 30, 30)
        ));
        mainPanel.add(formPanel);


        JLabel meterNumber = new JLabel("Broj brojila:");
        meterNumber.setFont(new Font("Arial", Font.BOLD, 18));
        meterNumber.setForeground(new Color(50, 50, 50));
        meterNumber.setBounds(30, 30, 250, 35);
        formPanel.add(meterNumber);

        JLabel meterNumberText = new JLabel("");
        meterNumberText.setFont(new Font("Arial", Font.PLAIN, 18));
        meterNumberText.setForeground(new Color(25, 25, 112));
        meterNumberText.setBounds(300, 30, 280, 35);
        formPanel.add(meterNumberText);

        JLabel name = new JLabel("Ime i prezime:");
        name.setFont(new Font("Arial", Font.BOLD, 18));
        name.setForeground(new Color(50, 50, 50));
        name.setBounds(30, 90, 250, 35);
        formPanel.add(name);

        JLabel nameText = new JLabel("");
        nameText.setFont(new Font("Arial", Font.PLAIN, 18));
        nameText.setForeground(new Color(25, 25, 112));
        nameText.setBounds(300, 90, 280, 35);
        formPanel.add(nameText);


        JSeparator separator1 = new JSeparator();
        separator1.setBounds(30, 140, 550, 2);
        separator1.setForeground(new Color(200, 200, 200));
        formPanel.add(separator1);


        JLabel month = new JLabel("Mesec:");
        month.setFont(new Font("Arial", Font.BOLD, 18));
        month.setForeground(new Color(50, 50, 50));
        month.setBounds(30, 160, 250, 35);
        formPanel.add(month);

        searchByMonthChoice = new Choice();
        searchByMonthChoice.add("Januar");
        searchByMonthChoice.add("Februar");
        searchByMonthChoice.add("Mart");
        searchByMonthChoice.add("April");
        searchByMonthChoice.add("Maj");
        searchByMonthChoice.add("Jun");
        searchByMonthChoice.add("Jul");
        searchByMonthChoice.add("Avgust");
        searchByMonthChoice.add("Septembar");
        searchByMonthChoice.add("Oktobar");
        searchByMonthChoice.add("Novembar");
        searchByMonthChoice.add("Decembar");
        searchByMonthChoice.setBounds(300, 160, 280, 35);
        searchByMonthChoice.setFont(new Font("Arial", Font.PLAIN, 16));
        searchByMonthChoice.setBackground(Color.WHITE);
        formPanel.add(searchByMonthChoice);

        JSeparator separator2 = new JSeparator();
        separator2.setBounds(30, 210, 550, 2);
        separator2.setForeground(new Color(200, 200, 200));
        formPanel.add(separator2);


        JLabel unit = new JLabel("Potrosnja (kWh):");
        unit.setFont(new Font("Arial", Font.BOLD, 18));
        unit.setForeground(new Color(50, 50, 50));
        unit.setBounds(30, 230, 250, 35);
        formPanel.add(unit);

        JLabel unitText = new JLabel("-");
        unitText.setFont(new Font("Arial", Font.PLAIN, 18));
        unitText.setForeground(new Color(25, 25, 112));
        unitText.setBounds(300, 230, 280, 35);
        formPanel.add(unitText);

        JLabel totalBill = new JLabel("Ukupan racun:");
        totalBill.setFont(new Font("Arial", Font.BOLD, 18));
        totalBill.setForeground(new Color(50, 50, 50));
        totalBill.setBounds(30, 290, 250, 35);
        formPanel.add(totalBill);

        JLabel totalBillText = new JLabel("-");
        totalBillText.setFont(new Font("Arial", Font.BOLD, 22));
        totalBillText.setForeground(new Color(220, 20, 60));
        totalBillText.setBounds(300, 290, 280, 35);
        formPanel.add(totalBillText);

        JLabel status = new JLabel("Status:");
        status.setFont(new Font("Arial", Font.BOLD, 18));
        status.setForeground(new Color(50, 50, 50));
        status.setBounds(30, 350, 250, 35);
        formPanel.add(status);

        JLabel statusText = new JLabel("-");
        statusText.setFont(new Font("Arial", Font.BOLD, 18));
        statusText.setForeground(new Color(0, 128, 0));
        statusText.setBounds(300, 350, 280, 35);
        formPanel.add(statusText);


        try{
            database c = new database();
            ResultSet resultSet = c.statement.executeQuery("select * from new_Customer where meter = '"+meter+"'");
            while(resultSet.next()){
                meterNumberText.setText(meter);
                nameText.setText(resultSet.getString("name"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }


        searchByMonthChoice.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                database c = new database();
                try {
                    ResultSet resultSet = c.statement.executeQuery("select * from bill where meter_number = '"+meter+"' and month = '"+searchByMonthChoice.getSelectedItem()+"'");
                    if(resultSet.next()){
                        unitText.setText(resultSet.getString("unit") + " kWh");
                        totalBillText.setText(resultSet.getString("total_bill") + " RSD");
                        String billStatus = resultSet.getString("status");
                        statusText.setText(billStatus);


                        if(billStatus.equals("Paid") || billStatus.equals("Placeno")){
                            statusText.setForeground(new Color(0, 128, 0));
                        } else {
                            statusText.setForeground(new Color(220, 20, 60));
                        }
                    } else {
                        unitText.setText("Nema podataka");
                        totalBillText.setText("-");
                        statusText.setText("-");
                        statusText.setForeground(Color.GRAY);
                    }
                }catch (Exception E){
                    E.printStackTrace();
                }
            }
        });


        JPanel notePanel = new JPanel();
        notePanel.setLayout(null);
        notePanel.setBackground(new Color(230, 240, 255));
        notePanel.setBounds(30, 410, 550, 80);
        notePanel.setBorder(BorderFactory.createLineBorder(new Color(100, 149, 237), 2));
        formPanel.add(notePanel);

        JLabel note = new JLabel("Napomena:");
        note.setFont(new Font("Arial", Font.BOLD, 14));
        note.setForeground(new Color(25, 25, 112));
        note.setBounds(60, 10, 150, 25);
        notePanel.add(note);

        JLabel note1 = new JLabel("Izaberite mesec iz padajuce liste da vidite detalje racuna.");
        note1.setFont(new Font("Arial", Font.PLAIN, 13));
        note1.setForeground(new Color(70, 70, 70));
        note1.setBounds(60, 35, 450, 20);
        notePanel.add(note1);

        JLabel note2 = new JLabel("Platite racun klikom na dugme 'Plati racun'.");
        note2.setFont(new Font("Arial", Font.PLAIN, 13));
        note2.setForeground(new Color(70, 70, 70));
        note2.setBounds(60, 55, 450, 20);
        notePanel.add(note2);


        pay = new JButton("Plati racun");
        pay.setBounds(150, 510, 180, 50);
        pay.setFont(new Font("Arial", Font.BOLD, 18));
        pay.setBackground(new Color(34, 139, 34));
        pay.setForeground(Color.WHITE);
        pay.setFocusPainted(false);
        pay.setBorderPainted(false);
        pay.addActionListener(this);
        formPanel.add(pay);

        back = new JButton("Nazad");
        back.setBounds(350, 510, 180, 50);
        back.setFont(new Font("Arial", Font.BOLD, 18));
        back.setBackground(new Color(70, 130, 180));
        back.setForeground(Color.WHITE);
        back.setFocusPainted(false);
        back.setBorderPainted(false);
        back.addActionListener(this);
        formPanel.add(back);


        try {
            ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/payBill.png"));
            Image i2 = i1.getImage().getScaledInstance(420, 550, Image.SCALE_SMOOTH);
            ImageIcon i3 = new ImageIcon(i2);
            JLabel imgLabel = new JLabel(i3);
            imgLabel.setBounds(730, 150, 420, 550);
            mainPanel.add(imgLabel);
        } catch (Exception e) {

            JLabel fallbackLabel = new JLabel("Placanje");
            fallbackLabel.setFont(new Font("Arial", Font.BOLD, 48));
            fallbackLabel.setForeground(new Color(25, 25, 112));
            fallbackLabel.setBounds(800, 350, 300, 100);
            mainPanel.add(fallbackLabel);
        }

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==pay){
            try {
                database c = new database();
                c.statement.executeUpdate("update bill set status = 'Paid' where meter_number = '"+meter+"' and month = '"+searchByMonthChoice.getSelectedItem()+"'");
            }catch (Exception E){
                E.printStackTrace();
            }
            setVisible(false);
            new paymentBill(meter);
        }else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new payBill("");


    }

}
