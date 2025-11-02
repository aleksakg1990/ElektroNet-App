package ElektroNet;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {

    JTextField userText;
    JPasswordField passwordText;
    Choice loginChoice;

    JButton loginButton, cancelButton, signupButton;


    public Login(){

        super("ElektroNet - Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 600);
        setLocationRelativeTo(null);
        setLayout(null);

        getContentPane().setBackground(new Color(240, 248, 255));

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(null);
        mainPanel.setBackground(new Color(240, 248, 255));
        mainPanel.setBounds(0, 0, 900, 600);
        add(mainPanel);

        JLabel titleLabel = new JLabel("ElektroNet");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 36));
        titleLabel.setForeground(new Color(25, 25, 112));
        titleLabel.setBounds(500, 30, 300, 50);
        mainPanel.add(titleLabel);

        JLabel subtitleLabel = new JLabel("Sistem za upravljanje elektricnim racunima");
        subtitleLabel.setFont(new Font("Arial", Font.ITALIC, 16));
        subtitleLabel.setForeground(new Color(70, 70, 70));
        subtitleLabel.setBounds(480, 80, 400, 25);
        mainPanel.add(subtitleLabel);

        JPanel formPanel = new JPanel();
        formPanel.setLayout(null);
        formPanel.setBackground(Color.WHITE);
        formPanel.setBounds(450, 120, 400, 350);
        formPanel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(200, 200, 200), 2),
                BorderFactory.createEmptyBorder(30, 30, 30, 30)
        ));
        mainPanel.add(formPanel);

        JLabel username = new JLabel("Korisnicko ime:");
        username.setFont(new Font("Arial", Font.BOLD, 16));
        username.setForeground(new Color(50, 50, 50));
        username.setBounds(20, 30, 150, 30);
        formPanel.add(username);

        userText = new JTextField();
        userText.setBounds(20, 65, 320, 40);
        userText.setFont(new Font("Arial", Font.PLAIN, 16));
        userText.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(200, 200, 200), 1),
                BorderFactory.createEmptyBorder(10, 15, 10, 15)
        ));
        formPanel.add(userText);

        JLabel password = new JLabel("Lozinka:");
        password.setFont(new Font("Arial", Font.BOLD, 16));
        password.setForeground(new Color(50, 50, 50));
        password.setBounds(20, 120, 150, 30);
        formPanel.add(password);

        passwordText = new JPasswordField();
        passwordText.setBounds(20, 155, 320, 40);
        passwordText.setFont(new Font("Arial", Font.PLAIN, 16));
        passwordText.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(200, 200, 200), 1),
                BorderFactory.createEmptyBorder(10, 15, 10, 15)
        ));
        formPanel.add(passwordText);

        JLabel login = new JLabel("Tip naloga:");
        login.setFont(new Font("Arial", Font.BOLD, 16));
        login.setForeground(new Color(50, 50, 50));
        login.setBounds(20, 210, 150, 30);
        formPanel.add(login);

        loginChoice = new Choice();
        loginChoice.add("Admin");
        loginChoice.add("Customer");
        loginChoice.setBounds(20, 245, 320, 40);
        loginChoice.setFont(new Font("Arial", Font.PLAIN, 16));
        formPanel.add(loginChoice);

        loginButton = new JButton("Prijavite se");
        loginButton.setBounds(20, 300, 150, 45);
        loginButton.setFont(new Font("Arial", Font.BOLD, 16));
        loginButton.setBackground(new Color(25, 25, 112));
        loginButton.setForeground(Color.WHITE);
        loginButton.setFocusPainted(false);
        loginButton.setBorderPainted(false);
        loginButton.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        loginButton.addActionListener(this);
        formPanel.add(loginButton);

        signupButton = new JButton("Registracija");
        signupButton.setBounds(190, 300, 150, 45);
        signupButton.setFont(new Font("Arial", Font.BOLD, 16));
        signupButton.setBackground(new Color(70, 130, 180));
        signupButton.setForeground(Color.WHITE);
        signupButton.setFocusPainted(false);
        signupButton.setBorderPainted(false);
        signupButton.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        signupButton.addActionListener(this);
        formPanel.add(signupButton);

        try {
            ImageIcon profile = new ImageIcon(ClassLoader.getSystemResource("icons/profile_user.png"));
            Image profileImg = profile.getImage().getScaledInstance(400, 400, Image.SCALE_SMOOTH);
            ImageIcon fprofile = new ImageIcon(profileImg);
            JLabel profileLabel = new JLabel(fprofile);
            profileLabel.setBounds(30, 120, 400, 400);
            mainPanel.add(profileLabel);
        } catch (Exception e) {
            JLabel noImageLabel = new JLabel("⚡ ElektroNet ⚡");
            noImageLabel.setFont(new Font("Arial", Font.BOLD, 48));
            noImageLabel.setForeground(new Color(25, 25, 112));
            noImageLabel.setBounds(50, 200, 400, 100);
            mainPanel.add(noImageLabel);

            JLabel descLabel = new JLabel("Moderna aplikacija za upravljanje elektricnim racunima");
            descLabel.setFont(new Font("Arial", Font.ITALIC, 18));
            descLabel.setForeground(new Color(70, 70, 70));
            descLabel.setBounds(50, 300, 400, 30);
            mainPanel.add(descLabel);
        }

        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginButton){
            String susername = userText.getText();
            String spassword = new String(passwordText.getPassword());
            String suser = loginChoice.getSelectedItem();

            try {
                database c = new database();
                String query = "select * from Signup where username = '"+susername+"' and password = '"+spassword+"' and usertype = '"+suser+"'";
                ResultSet resultSet = c.statement.executeQuery(query);

                if (resultSet.next()){
                    String meter = resultSet.getString("meterCode");
                    setVisible(false);
                    new main_screen(suser, meter);

                }else {
                    JOptionPane.showMessageDialog(null, "Invalid Login");
                }
            }catch (Exception E){
                E.printStackTrace();
            }
        }else if (e.getSource() == cancelButton){
            setVisible(false);
        }else if (e.getSource() == signupButton){
            setVisible(false);
            new Signup();
        }
    }

    public static void main(String[] args) {

        new Login();
    }
}

