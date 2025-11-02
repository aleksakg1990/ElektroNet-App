package ElektroNet;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class generateBill extends JFrame implements ActionListener {

    Choice searchByMonthChoice;
    String meter;
    JTextArea area;
    JButton bill;

    public generateBill(String meter){
        super("ElektroNet - Generisanje racuna");
        this.meter = meter;
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(1000, 800);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        getContentPane().setBackground(new Color(240, 248, 255));


        JPanel topPanel = new JPanel();
        topPanel.setLayout(null);
        topPanel.setBackground(new Color(240, 248, 255));
        topPanel.setPreferredSize(new Dimension(1000, 150));
        topPanel.setBorder(BorderFactory.createEmptyBorder(20, 30, 10, 30));

        JLabel heading = new JLabel("Generisanje racuna");
        heading.setFont(new Font("Arial", Font.BOLD, 36));
        heading.setForeground(new Color(25, 25, 112));
        heading.setBounds(20, 10, 500, 50);
        topPanel.add(heading);

        JLabel subtitle = new JLabel("Generisi racun za broj brojila: " + meter);
        subtitle.setFont(new Font("Arial", Font.ITALIC, 18));
        subtitle.setForeground(new Color(70, 70, 70));
        subtitle.setBounds(20, 60, 600, 30);
        topPanel.add(subtitle);

        JLabel meterLabel = new JLabel("Broj brojila:");
        meterLabel.setFont(new Font("Arial", Font.BOLD, 16));
        meterLabel.setForeground(new Color(50, 50, 50));
        meterLabel.setBounds(20, 100, 150, 30);
        topPanel.add(meterLabel);

        JLabel meter_no = new JLabel(meter);
        meter_no.setFont(new Font("Arial", Font.BOLD, 16));
        meter_no.setForeground(new Color(25, 25, 112));
        meter_no.setBounds(180, 100, 200, 30);
        topPanel.add(meter_no);

        JLabel monthLabel = new JLabel("Mesec:");
        monthLabel.setFont(new Font("Arial", Font.BOLD, 16));
        monthLabel.setForeground(new Color(50, 50, 50));
        monthLabel.setBounds(420, 100, 100, 30);
        topPanel.add(monthLabel);

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
        searchByMonthChoice.setBounds(530, 100, 250, 30);
        searchByMonthChoice.setFont(new Font("Arial", Font.PLAIN, 16));
        searchByMonthChoice.setBackground(Color.WHITE);
        topPanel.add(searchByMonthChoice);

        add(topPanel, BorderLayout.NORTH);


        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BorderLayout());
        centerPanel.setBackground(Color.WHITE);
        centerPanel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createEmptyBorder(10, 30, 10, 30),
                BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(new Color(200, 200, 200), 2),
                        BorderFactory.createEmptyBorder(20, 20, 20, 20)
                )
        ));

        area = new JTextArea();
        area.setText("\n\n\t\t--- Kliknite na dugme 'Generisi racun' ---\n\n\t\tza prikaz detalja racuna");
        area.setFont(new Font("Monospaced", Font.PLAIN, 16));
        area.setEditable(false);
        area.setBackground(Color.WHITE);
        area.setForeground(new Color(50, 50, 50));
        JScrollPane pane = new JScrollPane(area);
        pane.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200), 1));
        centerPanel.add(pane, BorderLayout.CENTER);

        add(centerPanel, BorderLayout.CENTER);


        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
        bottomPanel.setBackground(new Color(240, 248, 255));
        bottomPanel.setBorder(BorderFactory.createEmptyBorder(10, 30, 20, 30));

        bill = new JButton("Generisi racun");
        bill.setFont(new Font("Arial", Font.BOLD, 18));
        bill.setBackground(new Color(25, 25, 112));
        bill.setForeground(Color.WHITE);
        bill.setPreferredSize(new Dimension(200, 50));
        bill.setFocusPainted(false);
        bill.setBorderPainted(false);
        bill.addActionListener(this);
        bottomPanel.add(bill);

        add(bottomPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            database c = new database();
            String smonth = searchByMonthChoice.getSelectedItem();
            area.setText("\n Power Limited \n ElektroNet Bill for month of " + smonth + ",2025 \n\n\n" );
            ResultSet resultSet = c.statement.executeQuery("select * from new_Customer where meter = '" + meter + "'");
            if (resultSet.next()){
                area.append("\n    Customer Name    :"+resultSet.getString("name"));
                area.append("\n    Customer Meter Number    :"+resultSet.getString("meter"));
                area.append("\n    Customer Address    :"+resultSet.getString("address"));
                area.append("\n    Customer City    :"+resultSet.getString("city"));
                area.append("\n    Customer State    :"+resultSet.getString("state"));
                area.append("\n    Customer Email    :"+resultSet.getString("email"));
                area.append("\n    Customer phone    :"+resultSet.getString("phone"));
            }

            resultSet = c.statement.executeQuery("select * from meter_info where meter_number = '"+meter+"'");
            if (resultSet.next()){
                area.append("\n    Customer Meter Location    :"+resultSet.getString("meter_location"));
                area.append("\n    Customer Meter Type    :"+resultSet.getString("meter_type"));
                area.append("\n    Customer Phase Code    :"+resultSet.getString("phase_code"));
                area.append("\n    Customer Bill Type    :"+resultSet.getString("bill_type"));
                area.append("\n    Customer Day    :"+resultSet.getString("day"));
            }

            resultSet = c.statement.executeQuery("select * from tax");
            if (resultSet.next()){
                area.append("\n    Cost Per Unit    :"+resultSet.getString("cost_per_unit"));
                area.append("\n    Meter Rent    :"+resultSet.getString("meter_rent"));
                area.append("\n    Service Charge    :"+resultSet.getString("service_charge"));
                area.append("\n    Service Tax    :"+resultSet.getString("service_tax"));
                area.append("\n    Acss    :"+resultSet.getString("acss"));
                area.append("\n    Fixed Tax    :"+resultSet.getString("fixed_tax"));
            }

            resultSet = c.statement.executeQuery("select * from bill where meter_number = '"+meter+"' and month = '"+searchByMonthChoice.getSelectedItem()+"'");
            if (resultSet.next()){
                area.append("\n    Current Month   :"+resultSet.getString("month"));
                area.append("\n    Units Consumed    :"+ resultSet.getString("unit"));
                area.append("\n    Total Charges    :"+resultSet.getString("total_bill"));
                area.append("\n    Total Payable    :"+resultSet.getString("total_bill"));


            }

        }catch (Exception E){
            E.printStackTrace();
        }
    }

    public static void main(String[] args) {

        new generateBill("");

    }
}
