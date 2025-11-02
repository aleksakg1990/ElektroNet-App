package ElektroNet;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class newCustomer extends JFrame implements ActionListener {

    JLabel heading, customerName, meterNumberText, meterNumber, address, city, state, email, phone;
    JButton next, cancel;
    TextField nameText, addressText, cityText, stateText, emailText, phoneText;

    public newCustomer(){
        super("ElektroNet - Novi korisnik");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(1000, 700);
        setLocationRelativeTo(null);
        setLayout(null);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(240, 248, 255));
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
        add(panel);

        heading = new JLabel("Novi korisnik");
        heading.setBounds(200, 20, 400, 50);
        heading.setFont(new Font("Arial", Font.BOLD, 32));
        heading.setForeground(new Color(25, 25, 112));
        panel.add(heading);

        JLabel subtitle = new JLabel("Dodajte novog korisnika u sistem");
        subtitle.setFont(new Font("Arial", Font.ITALIC, 16));
        subtitle.setForeground(new Color(70, 70, 70));
        subtitle.setBounds(200, 70, 500, 25);
        panel.add(subtitle);

        JPanel formPanel = new JPanel();
        formPanel.setLayout(null);
        formPanel.setBackground(Color.WHITE);
        formPanel.setBounds(70, 120, 500, 450);
        formPanel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(200, 200, 200), 1),
                BorderFactory.createEmptyBorder(20, 20, 20, 20)
        ));

        customerName = new JLabel("Ime i Prezime:");
        customerName.setFont(new Font("Arial", Font.BOLD, 14));
        customerName.setForeground(new Color(50, 50, 50));
        customerName.setBounds(20, 20, 120, 25);
        formPanel.add(customerName);

        nameText = new TextField();
        nameText.setBounds(150, 20, 300, 35);
        nameText.setFont(new Font("Arial", Font.PLAIN, 14));
        formPanel.add(nameText);

        meterNumber = new JLabel("Broj brojila:");
        meterNumber.setFont(new Font("Arial", Font.BOLD, 14));
        meterNumber.setForeground(new Color(50, 50, 50));
        meterNumber.setBounds(20, 70, 120, 25);
        formPanel.add(meterNumber);

        meterNumberText = new JLabel("");
        meterNumberText.setBounds(150, 70, 300, 25);
        meterNumberText.setFont(new Font("Arial", Font.BOLD, 14));
        meterNumberText.setForeground(new Color(25, 25, 112));
        formPanel.add(meterNumberText);

        Random ran = new Random();
        long number = ran.nextLong() % 1000000;
        meterNumberText.setText("" + Math.abs(number));

        address = new JLabel("Adresa:");
        address.setFont(new Font("Arial", Font.BOLD, 14));
        address.setForeground(new Color(50, 50, 50));
        address.setBounds(20, 120, 120, 25);
        formPanel.add(address);

        addressText = new TextField();
        addressText.setBounds(150, 120, 300, 35);
        addressText.setFont(new Font("Arial", Font.PLAIN, 14));
        formPanel.add(addressText);

        city = new JLabel("Grad:");
        city.setFont(new Font("Arial", Font.BOLD, 14));
        city.setForeground(new Color(50, 50, 50));
        city.setBounds(20, 170, 120, 25);
        formPanel.add(city);

        cityText = new TextField();
        cityText.setBounds(150, 170, 300, 35);
        cityText.setFont(new Font("Arial", Font.PLAIN, 14));
        formPanel.add(cityText);

        state = new JLabel("Drzava:");
        state.setFont(new Font("Arial", Font.BOLD, 14));
        state.setForeground(new Color(50, 50, 50));
        state.setBounds(20, 220, 120, 25);
        formPanel.add(state);

        stateText = new TextField();
        stateText.setBounds(150, 220, 300, 35);
        stateText.setFont(new Font("Arial", Font.PLAIN, 14));
        formPanel.add(stateText);

        email = new JLabel("Email:");
        email.setFont(new Font("Arial", Font.BOLD, 14));
        email.setForeground(new Color(50, 50, 50));
        email.setBounds(20, 270, 120, 25);
        formPanel.add(email);

        emailText = new TextField();
        emailText.setBounds(150, 270, 300, 35);
        emailText.setFont(new Font("Arial", Font.PLAIN, 14));
        formPanel.add(emailText);

        phone = new JLabel("Telefon:");
        phone.setFont(new Font("Arial", Font.BOLD, 14));
        phone.setForeground(new Color(50, 50, 50));
        phone.setBounds(20, 320, 120, 25);
        formPanel.add(phone);

        phoneText = new TextField();
        phoneText.setBounds(150, 320, 300, 35);
        phoneText.setFont(new Font("Arial", Font.PLAIN, 14));
        formPanel.add(phoneText);

        next = new JButton("Dalje");
        next.setBounds(150, 370, 120, 40);
        next.setFont(new Font("Arial", Font.BOLD, 14));
        next.setBackground(new Color(25, 25, 112));
        next.setForeground(Color.WHITE);
        next.setFocusPainted(false);
        next.setBorderPainted(false);
        next.addActionListener(this);
        formPanel.add(next);

        cancel = new JButton("Otkazi");
        cancel.setBounds(300, 370, 120, 40);
        cancel.setFont(new Font("Arial", Font.BOLD, 14));
        cancel.setBackground(new Color(70, 130, 180));
        cancel.setForeground(Color.WHITE);
        cancel.setFocusPainted(false);
        cancel.setBorderPainted(false);
        cancel.addActionListener(this);
        formPanel.add(cancel);

        panel.add(formPanel);

        setLayout(new BorderLayout());
        add(panel, "Center");


        ImageIcon image1 = new ImageIcon(ClassLoader.getSystemResource("icons/person.png"));
        Image image2 = image1.getImage().getScaledInstance(300,350, Image.SCALE_DEFAULT);
        ImageIcon image3 = new ImageIcon(image2);
        JLabel imageLabel = new JLabel(image3);
        add(imageLabel, "West");
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==next){
            String sname = nameText.getText();
            String smeter = meterNumberText.getText();
            String saddress = addressText.getText();
            String scity = cityText.getText();
            String sstate = stateText.getText();
            String eemail = emailText.getText();
            String sphone = phoneText.getText();


            String query_customer = "insert into new_Customer values('"+sname+"','"+smeter+"','"+saddress+"','"+scity+"','"+sstate+"','"+eemail+"','"+sphone+"')";
            String query_signup = "insert into Signup values('"+smeter+"','','"+sname+"','','')";

            try {
                database c = new database();
                c.statement.executeUpdate(query_customer);
                c.statement.executeUpdate(query_signup);

                JOptionPane.showMessageDialog(null, "Customer Details Added Successfully");
                setVisible(false);
                new meterNumberInfo(smeter);
            }catch (Exception E){
                E.printStackTrace();
            }
        }else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new newCustomer();
    }
}

