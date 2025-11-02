package ElektroNet;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class depositDetails extends JFrame implements ActionListener {

    Choice searchMeterChoice, searchByMonthChoice;
    JTable table;
    JButton search, print, close;

    public depositDetails(){
        super("ElektroNet - Detalji depozita");
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


        JLabel titleLabel = new JLabel("Detalji depozita");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 36));
        titleLabel.setForeground(new Color(25, 25, 112));
        titleLabel.setBounds(50, 30, 500, 50);
        mainPanel.add(titleLabel);

        JLabel subtitleLabel = new JLabel("Pregled i pretraga depozita korisnika");
        subtitleLabel.setFont(new Font("Arial", Font.ITALIC, 18));
        subtitleLabel.setForeground(new Color(70, 70, 70));
        subtitleLabel.setBounds(50, 85, 600, 30);
        mainPanel.add(subtitleLabel);


        JPanel formPanel = new JPanel();
        formPanel.setLayout(null);
        formPanel.setBackground(Color.WHITE);
        formPanel.setBounds(50, 120, 1100, 120);
        formPanel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(200, 200, 200), 2),
                BorderFactory.createEmptyBorder(20, 20, 20, 20)
        ));
        mainPanel.add(formPanel);

        JLabel searchMeter = new JLabel("Pretraga po broju brojila:");
        searchMeter.setFont(new Font("Arial", Font.BOLD, 16));
        searchMeter.setForeground(new Color(50, 50, 50));
        searchMeter.setBounds(30, 20, 220, 30);
        formPanel.add(searchMeter);

        searchMeterChoice = new Choice();
        searchMeterChoice.setBounds(260, 20, 200, 30);
        searchMeterChoice.setFont(new Font("Arial", Font.PLAIN, 16));
        searchMeterChoice.setBackground(Color.WHITE);
        formPanel.add(searchMeterChoice);

        try{
            database c = new database();
            ResultSet resultSet = c.statement.executeQuery("select * from bill");
            while (resultSet.next()){
                searchMeterChoice.add(resultSet.getString("meter_number"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        JLabel searchByMonth = new JLabel("Pretraga po mesecu:");
        searchByMonth.setFont(new Font("Arial", Font.BOLD, 16));
        searchByMonth.setForeground(new Color(50, 50, 50));
        searchByMonth.setBounds(490, 20, 180, 30);
        formPanel.add(searchByMonth);

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
        searchByMonthChoice.setBounds(680, 20, 200, 30);
        searchByMonthChoice.setFont(new Font("Arial", Font.PLAIN, 16));
        searchByMonthChoice.setBackground(Color.WHITE);
        formPanel.add(searchByMonthChoice);


        search = new JButton("Pretrazi");
        search.setBounds(900, 20, 120, 40);
        search.setFont(new Font("Arial", Font.BOLD, 16));
        search.setBackground(new Color(25, 25, 112));
        search.setForeground(Color.WHITE);
        search.setFocusPainted(false);
        search.setBorderPainted(false);
        search.addActionListener(this);
        formPanel.add(search);

        print = new JButton("Stampaj");
        print.setBounds(30, 70, 120, 40);
        print.setFont(new Font("Arial", Font.BOLD, 14));
        print.setBackground(new Color(70, 130, 180));
        print.setForeground(Color.WHITE);
        print.setFocusPainted(false);
        print.setBorderPainted(false);
        print.addActionListener(this);
        formPanel.add(print);

        close = new JButton("Zatvori");
        close.setBounds(900, 70, 120, 40);
        close.setFont(new Font("Arial", Font.BOLD, 14));
        close.setBackground(new Color(220, 20, 60));
        close.setForeground(Color.WHITE);
        close.setFocusPainted(false);
        close.setBorderPainted(false);
        close.addActionListener(this);
        formPanel.add(close);


        JPanel tablePanel = new JPanel();
        tablePanel.setLayout(null);
        tablePanel.setBackground(Color.WHITE);
        tablePanel.setBounds(50, 250, 1100, 500);
        tablePanel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(200, 200, 200), 2),
                BorderFactory.createEmptyBorder(10, 10, 10, 10)
        ));
        mainPanel.add(tablePanel);

        table = new JTable();
        table.setFont(new Font("Arial", Font.PLAIN, 14));
        table.setRowHeight(25);
        table.setBackground(Color.WHITE);
        table.setGridColor(new Color(200, 200, 200));

        try {
            database c = new database();
            ResultSet resultSet = c.statement.executeQuery("select * from bill");
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        }catch (Exception e){
            e.printStackTrace();
        }

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(10, 10, 1080, 480);
        scrollPane.setBackground(Color.WHITE);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        tablePanel.add(scrollPane);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==search){
            String query_search = "select * from bill where meter_number = '"+searchMeterChoice.getSelectedItem()+"' and month = '"+searchByMonthChoice.getSelectedItem()+"'";
            try {
                database c = new database();
                ResultSet resultSet = c.statement.executeQuery(query_search);
                table.setModel(DbUtils.resultSetToTableModel(resultSet));
            }catch (Exception E){
                E.printStackTrace();
            }
        } else if (e.getSource()==print) {
            try{
                table.print();
            }catch (Exception E){
                E.printStackTrace();
            }
        }else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new depositDetails();
    }
}
