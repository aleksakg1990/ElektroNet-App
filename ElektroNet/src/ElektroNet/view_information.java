package ElektroNet;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class view_information extends JFrame implements ActionListener {

    String view;
    JButton cancel;

    public view_information(String view) {

        super("ElektroNet - Pregled informacija");
        this.view = view;
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

        JLabel heading = new JLabel("Pregled informacija");
        heading.setBounds(50, 30, 600, 50);
        heading.setFont(new Font("Arial", Font.BOLD, 36));
        heading.setForeground(new Color(25, 25, 112));
        mainPanel.add(heading);

        JLabel subtitle = new JLabel("Pregledajte podatke za broj brojila: " + view);
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

        JLabel nameLabel = new JLabel("Ime i prezime:");
        nameLabel.setFont(new Font("Arial", Font.BOLD, 18));
        nameLabel.setForeground(new Color(50, 50, 50));
        nameLabel.setBounds(30, 30, 250, 35);
        formPanel.add(nameLabel);

        JLabel nameLabelText = new JLabel("");
        nameLabelText.setFont(new Font("Arial", Font.PLAIN, 18));
        nameLabelText.setForeground(new Color(25, 25, 112));
        nameLabelText.setBounds(300, 30, 280, 35);
        formPanel.add(nameLabelText);

        JLabel meterNum = new JLabel("Broj brojila:");
        meterNum.setFont(new Font("Arial", Font.BOLD, 18));
        meterNum.setForeground(new Color(50, 50, 50));
        meterNum.setBounds(30, 90, 250, 35);
        formPanel.add(meterNum);

        JLabel meterNumText = new JLabel("");
        meterNumText.setFont(new Font("Arial", Font.PLAIN, 18));
        meterNumText.setForeground(new Color(25, 25, 112));
        meterNumText.setBounds(300, 90, 280, 35);
        formPanel.add(meterNumText);

        JLabel address = new JLabel("Adresa:");
        address.setFont(new Font("Arial", Font.BOLD, 18));
        address.setForeground(new Color(50, 50, 50));
        address.setBounds(30, 150, 250, 35);
        formPanel.add(address);

        JLabel addressText = new JLabel("");
        addressText.setFont(new Font("Arial", Font.PLAIN, 18));
        addressText.setForeground(new Color(25, 25, 112));
        addressText.setBounds(300, 150, 280, 35);
        formPanel.add(addressText);

        JLabel city = new JLabel("Grad:");
        city.setFont(new Font("Arial", Font.BOLD, 18));
        city.setForeground(new Color(50, 50, 50));
        city.setBounds(30, 210, 250, 35);
        formPanel.add(city);

        JLabel cityText = new JLabel("");
        cityText.setFont(new Font("Arial", Font.PLAIN, 18));
        cityText.setForeground(new Color(25, 25, 112));
        cityText.setBounds(300, 210, 280, 35);
        formPanel.add(cityText);

        JLabel state = new JLabel("Drzava:");
        state.setFont(new Font("Arial", Font.BOLD, 18));
        state.setForeground(new Color(50, 50, 50));
        state.setBounds(30, 270, 250, 35);
        formPanel.add(state);

        JLabel stateText = new JLabel("");
        stateText.setFont(new Font("Arial", Font.PLAIN, 18));
        stateText.setForeground(new Color(25, 25, 112));
        stateText.setBounds(300, 270, 280, 35);
        formPanel.add(stateText);

        JLabel email = new JLabel("Email:");
        email.setFont(new Font("Arial", Font.BOLD, 18));
        email.setForeground(new Color(50, 50, 50));
        email.setBounds(30, 330, 250, 35);
        formPanel.add(email);

        JLabel emailText = new JLabel("");
        emailText.setFont(new Font("Arial", Font.PLAIN, 18));
        emailText.setForeground(new Color(25, 25, 112));
        emailText.setBounds(300, 330, 280, 35);
        formPanel.add(emailText);

        JLabel phone = new JLabel("Telefon:");
        phone.setFont(new Font("Arial", Font.BOLD, 18));
        phone.setForeground(new Color(50, 50, 50));
        phone.setBounds(30, 390, 250, 35);
        formPanel.add(phone);

        JLabel phoneText = new JLabel("");
        phoneText.setFont(new Font("Arial", Font.PLAIN, 18));
        phoneText.setForeground(new Color(25, 25, 112));
        phoneText.setBounds(300, 390, 280, 35);
        formPanel.add(phoneText);

        try {
            database c = new database();
            ResultSet resultSet = c.statement.executeQuery("select * from new_Customer where meter = '" + view + "'");
            if (resultSet.next()) {
                nameLabelText.setText(resultSet.getString("name"));
                meterNumText.setText(resultSet.getString("meter"));
                addressText.setText(resultSet.getString("address"));
                cityText.setText(resultSet.getString("city"));
                stateText.setText(resultSet.getString("state"));
                emailText.setText(resultSet.getString("email"));
                phoneText.setText(resultSet.getString("phone"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        JPanel notePanel = new JPanel();
        notePanel.setLayout(null);
        notePanel.setBackground(new Color(240, 255, 240));
        notePanel.setBounds(30, 450, 550, 60);
        notePanel.setBorder(BorderFactory.createLineBorder(new Color(34, 139, 34), 2));
        formPanel.add(notePanel);


        JLabel note = new JLabel("Ovo je pregled svih informacija o korisniku. Za izmenu koristite 'Azuriranje informacija'.");
        note.setFont(new Font("Arial", Font.PLAIN, 13));
        note.setForeground(new Color(70, 70, 70));
        note.setBounds(50, 10, 480, 40);
        notePanel.add(note);

        cancel = new JButton("Zatvori");
        cancel.setBounds(225, 525, 200, 50);
        cancel.setFont(new Font("Arial", Font.BOLD, 18));
        cancel.setBackground(new Color(70, 130, 180));
        cancel.setForeground(Color.WHITE);
        cancel.setFocusPainted(false);
        cancel.setBorderPainted(false);
        cancel.addActionListener(this);
        formPanel.add(cancel);

        try {
            ImageIcon a1 = new ImageIcon(ClassLoader.getSystemResource("icons/viewInfo.png"));
            Image a2 = a1.getImage().getScaledInstance(420, 550, Image.SCALE_SMOOTH);
            ImageIcon a3 = new ImageIcon(a2);
            JLabel img = new JLabel(a3);
            img.setBounds(730, 150, 420, 550);
            mainPanel.add(img);
        } catch (Exception e) {
            JLabel fallbackLabel = new JLabel("Pregled");
            fallbackLabel.setFont(new Font("Arial", Font.BOLD, 48));
            fallbackLabel.setForeground(new Color(25, 25, 112));
            fallbackLabel.setBounds(800, 350, 300, 100);
            mainPanel.add(fallbackLabel);
        }

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==cancel){
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new view_information("");
    }
}
