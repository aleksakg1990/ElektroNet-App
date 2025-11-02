package ElektroNet;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;

public class billDetails extends JFrame {

    String meter;

    public billDetails(String meter){

        super("ElektroNet - Detalji racuna");
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

        JLabel titleLabel = new JLabel("Detalji racuna");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 32));
        titleLabel.setForeground(new Color(25, 25, 112));
        titleLabel.setBounds(50, 30, 400, 50);
        mainPanel.add(titleLabel);

        JLabel subtitleLabel = new JLabel("Pregled racuna za broj brojila: " + meter);
        subtitleLabel.setFont(new Font("Arial", Font.ITALIC, 16));
        subtitleLabel.setForeground(new Color(70, 70, 70));
        subtitleLabel.setBounds(50, 80, 500, 25);
        mainPanel.add(subtitleLabel);

        JPanel tablePanel = new JPanel();
        tablePanel.setLayout(null);
        tablePanel.setBackground(Color.WHITE);
        tablePanel.setBounds(50, 120, 900, 500);
        tablePanel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(200, 200, 200), 2),
                BorderFactory.createEmptyBorder(10, 10, 10, 10)
        ));
        mainPanel.add(tablePanel);

        JTable table = new JTable();
        table.setFont(new Font("Arial", Font.PLAIN, 14));
        table.setRowHeight(25);
        table.setBackground(Color.WHITE);
        table.setGridColor(new Color(200, 200, 200));

        try {
            database c = new database();
            String query_bill = "select * from bill where meter_number = '"+meter+"'";
            ResultSet resultSet = c.statement.executeQuery(query_bill);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        }catch (Exception e){
            e.printStackTrace();
        }

        JScrollPane sp = new JScrollPane(table);
        sp.setBounds(10, 10, 880, 480);
        sp.setBackground(Color.WHITE);
        sp.setBorder(BorderFactory.createEmptyBorder());
        tablePanel.add(sp);


        setVisible(true);
    }

    public static void main(String[] args) {

        new billDetails("");
    }
}
