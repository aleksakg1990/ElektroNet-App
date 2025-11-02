package ElektroNet;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class customerDetails extends JFrame implements ActionListener {

    Choice searchMeterChoice, searchNameChoice;
    JTable table;
    JButton search, print, close;

    public customerDetails(){

        super("ElektroNet - Detalji korisnika");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(1000, 700);
        setLocationRelativeTo(null);
        setLayout(null);

        getContentPane().setBackground(new Color(240, 248, 255));

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(null);
        mainPanel.setBackground(new Color(240, 248, 255));
        mainPanel.setBounds(0, 0, 1000, 700);
        add(mainPanel);

        JLabel titleLabel = new JLabel("Detalji korisnika");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 32));
        titleLabel.setForeground(new Color(25, 25, 112));
        titleLabel.setBounds(50, 30, 400, 50);
        mainPanel.add(titleLabel);

        JLabel subtitleLabel = new JLabel("Pregled i pretraga korisnickih podataka");
        subtitleLabel.setFont(new Font("Arial", Font.ITALIC, 16));
        subtitleLabel.setForeground(new Color(70, 70, 70));
        subtitleLabel.setBounds(50, 80, 500, 25);
        mainPanel.add(subtitleLabel);

        JPanel formPanel = new JPanel();
        formPanel.setLayout(null);
        formPanel.setBackground(Color.WHITE);
        formPanel.setBounds(50, 120, 900, 100);
        formPanel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(200, 200, 200), 2),
                BorderFactory.createEmptyBorder(20, 20, 20, 20)
        ));
        mainPanel.add(formPanel);

        JLabel searchMeter = new JLabel("Pretraga po broju brojila:");
        searchMeter.setFont(new Font("Arial", Font.BOLD, 16));
        searchMeter.setForeground(new Color(50, 50, 50));
        searchMeter.setBounds(20, 20, 200, 30);
        formPanel.add(searchMeter);

        searchMeterChoice = new Choice();
        searchMeterChoice.setBounds(20, 55, 200, 30);
        searchMeterChoice.setFont(new Font("Arial", Font.PLAIN, 14));
        formPanel.add(searchMeterChoice);

        try{
            database c = new database();
            ResultSet resultSet = c.statement.executeQuery("select * from new_Customer");
            while (resultSet.next()){
                searchMeterChoice.add(resultSet.getString("meter"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        JLabel searchName = new JLabel("Pretraga po imenu:");
        searchName.setFont(new Font("Arial", Font.BOLD, 16));
        searchName.setForeground(new Color(50, 50, 50));
        searchName.setBounds(250, 20, 200, 30);
        formPanel.add(searchName);

        searchNameChoice = new Choice();
        searchNameChoice.setBounds(250, 55, 200, 30);
        searchNameChoice.setFont(new Font("Arial", Font.PLAIN, 14));
        formPanel.add(searchNameChoice);


        try{
            database c = new database();
            ResultSet resultSet = c.statement.executeQuery("select * from new_Customer");
            while (resultSet.next()){
                searchNameChoice.add(resultSet.getString("name"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        table = new JTable();
        try {
            database c = new database();
            ResultSet resultSet = c.statement.executeQuery("select * from new_Customer");
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        }catch (Exception e){
            e.printStackTrace();
        }

        JPanel tablePanel = new JPanel();
        tablePanel.setLayout(null);
        tablePanel.setBackground(Color.WHITE);
        tablePanel.setBounds(50, 240, 900, 400);
        tablePanel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(200, 200, 200), 2),
                BorderFactory.createEmptyBorder(10, 10, 10, 10)
        ));
        mainPanel.add(tablePanel);

        table.setFont(new Font("Arial", Font.PLAIN, 14));
        table.setRowHeight(25);
        table.setBackground(Color.WHITE);
        table.setGridColor(new Color(200, 200, 200));

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(10, 10, 880, 380);
        scrollPane.setBackground(Color.WHITE);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        tablePanel.add(scrollPane);

        search = new JButton("Pretrazi");
        search.setBounds(500, 20, 120, 40);
        search.setFont(new Font("Arial", Font.BOLD, 16));
        search.setBackground(new Color(25, 25, 112));
        search.setForeground(Color.WHITE);
        search.setFocusPainted(false);
        search.setBorderPainted(false);
        search.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        search.addActionListener(this);
        formPanel.add(search);

        print = new JButton("Stampaj");
        print.setBounds(650, 20, 120, 40);
        print.setFont(new Font("Arial", Font.BOLD, 16));
        print.setBackground(new Color(70, 130, 180));
        print.setForeground(Color.WHITE);
        print.setFocusPainted(false);
        print.setBorderPainted(false);
        print.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        print.addActionListener(this);
        formPanel.add(print);

        close = new JButton("Zatvori");
        close.setBounds(780, 20, 100, 40);
        close.setFont(new Font("Arial", Font.BOLD, 16));
        close.setBackground(new Color(220, 20, 60));
        close.setForeground(Color.WHITE);
        close.setFocusPainted(false);
        close.setBorderPainted(false);
        close.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        close.addActionListener(this);
        formPanel.add(close);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==search){
            String query_search = "select * from new_Customer where meter = '"+searchMeterChoice.getSelectedItem()+"' and name = '"+searchNameChoice.getSelectedItem()+"'";
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

        new customerDetails();
    }

}
