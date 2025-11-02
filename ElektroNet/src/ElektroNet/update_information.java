package ElektroNet;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class update_information extends JFrame implements ActionListener {

    JLabel nametext;

    JTextField addressText, cityText, stateText, emailText, phoneText;

    String meter;

    JButton update, cancel;

    public update_information(String meter){
        super("ElektroNet - Azuriranje informacija");
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

        JLabel heading = new JLabel("Azuriranje informacija");
        heading.setBounds(50, 30, 600, 50);
        heading.setFont(new Font("Arial", Font.BOLD, 36));
        heading.setForeground(new Color(25, 25, 112));
        mainPanel.add(heading);

        JLabel subtitle = new JLabel("Azurirajte podatke za broj brojila: " + meter);
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


        JLabel name = new JLabel("Ime i prezime:");
        name.setFont(new Font("Arial", Font.BOLD, 18));
        name.setForeground(new Color(50, 50, 50));
        name.setBounds(30, 30, 250, 35);
        formPanel.add(name);

        nametext = new JLabel("");
        nametext.setFont(new Font("Arial", Font.PLAIN, 18));
        nametext.setForeground(new Color(25, 25, 112));
        nametext.setBounds(300, 30, 280, 35);
        formPanel.add(nametext);


        JLabel meterNo = new JLabel("Broj brojila:");
        meterNo.setFont(new Font("Arial", Font.BOLD, 18));
        meterNo.setForeground(new Color(50, 50, 50));
        meterNo.setBounds(30, 90, 250, 35);
        formPanel.add(meterNo);

        JLabel meterText = new JLabel("");
        meterText.setFont(new Font("Arial", Font.PLAIN, 18));
        meterText.setForeground(new Color(25, 25, 112));
        meterText.setBounds(300, 90, 280, 35);
        formPanel.add(meterText);


        JSeparator separator = new JSeparator();
        separator.setBounds(30, 140, 550, 2);
        separator.setForeground(new Color(200, 200, 200));
        formPanel.add(separator);


        JLabel address = new JLabel("Adresa:");
        address.setFont(new Font("Arial", Font.BOLD, 18));
        address.setForeground(new Color(50, 50, 50));
        address.setBounds(30, 160, 250, 35);
        formPanel.add(address);

        addressText = new JTextField();
        addressText.setBounds(300, 160, 280, 40);
        addressText.setFont(new Font("Arial", Font.PLAIN, 16));
        addressText.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(200, 200, 200), 1),
                BorderFactory.createEmptyBorder(10, 15, 10, 15)
        ));
        formPanel.add(addressText);


        JLabel city = new JLabel("Grad:");
        city.setFont(new Font("Arial", Font.BOLD, 18));
        city.setForeground(new Color(50, 50, 50));
        city.setBounds(30, 220, 250, 35);
        formPanel.add(city);

        cityText = new JTextField();
        cityText.setBounds(300, 220, 280, 40);
        cityText.setFont(new Font("Arial", Font.PLAIN, 16));
        cityText.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(200, 200, 200), 1),
                BorderFactory.createEmptyBorder(10, 15, 10, 15)
        ));
        formPanel.add(cityText);


        JLabel state = new JLabel("Drzava:");
        state.setFont(new Font("Arial", Font.BOLD, 18));
        state.setForeground(new Color(50, 50, 50));
        state.setBounds(30, 280, 250, 35);
        formPanel.add(state);

        stateText = new JTextField();
        stateText.setBounds(300, 280, 280, 40);
        stateText.setFont(new Font("Arial", Font.PLAIN, 16));
        stateText.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(200, 200, 200), 1),
                BorderFactory.createEmptyBorder(10, 15, 10, 15)
        ));
        formPanel.add(stateText);


        JLabel email = new JLabel("Email:");
        email.setFont(new Font("Arial", Font.BOLD, 18));
        email.setForeground(new Color(50, 50, 50));
        email.setBounds(30, 340, 250, 35);
        formPanel.add(email);

        emailText = new JTextField();
        emailText.setBounds(300, 340, 280, 40);
        emailText.setFont(new Font("Arial", Font.PLAIN, 16));
        emailText.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(200, 200, 200), 1),
                BorderFactory.createEmptyBorder(10, 15, 10, 15)
        ));
        formPanel.add(emailText);


        JLabel phone = new JLabel("Telefon:");
        phone.setFont(new Font("Arial", Font.BOLD, 18));
        phone.setForeground(new Color(50, 50, 50));
        phone.setBounds(30, 400, 250, 35);
        formPanel.add(phone);

        phoneText = new JTextField();
        phoneText.setBounds(300, 400, 280, 40);
        phoneText.setFont(new Font("Arial", Font.PLAIN, 16));
        phoneText.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(200, 200, 200), 1),
                BorderFactory.createEmptyBorder(10, 15, 10, 15)
        ));
        formPanel.add(phoneText);


        try {
            database c = new database();
            ResultSet resultSet = c.statement.executeQuery("select * from new_Customer where meter = '"+meter+"'");
            if (resultSet.next()){
                nametext.setText(resultSet.getString("name"));
                meterText.setText(resultSet.getString("meter"));
                addressText.setText(resultSet.getString("address"));
                cityText.setText(resultSet.getString("city"));
                stateText.setText(resultSet.getString("state"));
                emailText.setText(resultSet.getString("email"));
                phoneText.setText(resultSet.getString("phone"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }


        JPanel notePanel = new JPanel();
        notePanel.setLayout(null);
        notePanel.setBackground(new Color(230, 240, 255));
        notePanel.setBounds(30, 460, 550, 60);
        notePanel.setBorder(BorderFactory.createLineBorder(new Color(100, 149, 237), 2));
        formPanel.add(notePanel);


        JLabel note = new JLabel("Napomena: Ime i broj brojila se ne mogu menjati.");
        note.setFont(new Font("Arial", Font.PLAIN, 14));
        note.setForeground(new Color(70, 70, 70));
        note.setBounds(50, 10, 450, 40);
        notePanel.add(note);


        update = new JButton("Azuriraj");
        update.setBounds(200, 535, 180, 50);
        update.setFont(new Font("Arial", Font.BOLD, 18));
        update.setBackground(new Color(34, 139, 34));
        update.setForeground(Color.WHITE);
        update.setFocusPainted(false);
        update.setBorderPainted(false);
        update.addActionListener(this);
        formPanel.add(update);

        cancel = new JButton("Otkazi");
        cancel.setBounds(400, 535, 180, 50);
        cancel.setFont(new Font("Arial", Font.BOLD, 18));
        cancel.setBackground(new Color(220, 20, 60));
        cancel.setForeground(Color.WHITE);
        cancel.setFocusPainted(false);
        cancel.setBorderPainted(false);
        cancel.addActionListener(this);
        formPanel.add(cancel);


        try {
            ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icons/updateInformation.png"));
            Image image = imageIcon.getImage().getScaledInstance(420, 550, Image.SCALE_SMOOTH);
            ImageIcon imageIcon1 = new ImageIcon(image);
            JLabel imgLabel = new JLabel(imageIcon1);
            imgLabel.setBounds(730, 150, 420, 550);
            mainPanel.add(imgLabel);
        } catch (Exception e) {

            JLabel fallbackLabel = new JLabel("✏ Azuriranje");
            fallbackLabel.setFont(new Font("Arial", Font.BOLD, 48));
            fallbackLabel.setForeground(new Color(25, 25, 112));
            fallbackLabel.setBounds(800, 350, 300, 100);
            mainPanel.add(fallbackLabel);
        }

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==update){
            String saddress = addressText.getText();
            String scity = cityText.getText();
            String sstate = stateText.getText();
            String semail = emailText.getText();
            String sphone = phoneText.getText();

            try {
                database c = new database();
                c.statement.executeUpdate("update new_Customer set address ='"+saddress+"', city = '"+scity+"', state = '"+sstate+"', email = '"+semail+"', phone = '"+sphone+"' where meter = '"+meter+"'");

                JOptionPane.showMessageDialog(null, "Informacije korisnika su uspesno azurirane!", "Uspesno", JOptionPane.INFORMATION_MESSAGE);
                setVisible(false);

            }catch (Exception E){
                E.printStackTrace();
                JOptionPane.showMessageDialog(null, "Greska pri azuriranju informacija!", "Greska", JOptionPane.ERROR_MESSAGE);
            }
        }else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new update_information("");
    }
}
