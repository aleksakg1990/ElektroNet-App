package ElektroNet;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;


public class Signup extends JFrame implements ActionListener {

    Choice loginAccount;
    TextField meterCodeText, EmployerText, usernameText, nameText;
    JPasswordField passwordText;
    JButton create, back;

    public Signup(){

        super("ElektroNet - Registracija");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 700);
        setLocationRelativeTo(null);
        setLayout(null);

        getContentPane().setBackground(new Color(240, 248, 255));

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(null);
        mainPanel.setBackground(new Color(240, 248, 255));
        mainPanel.setBounds(0, 0, 1000, 700);
        add(mainPanel);

        JLabel titleLabel = new JLabel("Kreiranje naloga");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 32));
        titleLabel.setForeground(new Color(25, 25, 112));
        titleLabel.setBounds(50, 30, 400, 50);
        mainPanel.add(titleLabel);

        JLabel subtitleLabel = new JLabel("Registrujte se za pristup ElektroNet sistemu");
        subtitleLabel.setFont(new Font("Arial", Font.ITALIC, 16));
        subtitleLabel.setForeground(new Color(70, 70, 70));
        subtitleLabel.setBounds(50, 80, 500, 25);
        mainPanel.add(subtitleLabel);

        JPanel formPanel = new JPanel();
        formPanel.setLayout(null);
        formPanel.setBackground(Color.WHITE);
        formPanel.setBounds(50, 120, 500, 450);
        formPanel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(200, 200, 200), 2),
                BorderFactory.createEmptyBorder(30, 30, 30, 30)
        ));
        mainPanel.add(formPanel);

        JLabel create_account = new JLabel("Tip naloga:");
        create_account.setFont(new Font("Arial", Font.BOLD, 16));
        create_account.setForeground(new Color(50, 50, 50));
        create_account.setBounds(20, 20, 150, 30);
        formPanel.add(create_account);

        loginAccount = new Choice();
        loginAccount.add("Admin");
        loginAccount.add("Customer");
        loginAccount.setBounds(20, 55, 400, 40);
        loginAccount.setFont(new Font("Arial", Font.PLAIN, 16));
        formPanel.add(loginAccount);

        JLabel meterCode = new JLabel("Broj brojila:");
        meterCode.setFont(new Font("Arial", Font.BOLD, 16));
        meterCode.setForeground(new Color(50, 50, 50));
        meterCode.setBounds(20, 110, 150, 30);
        meterCode.setVisible(false);
        formPanel.add(meterCode);

        meterCodeText = new TextField();
        meterCodeText.setBounds(20, 145, 400, 40);
        meterCodeText.setFont(new Font("Arial", Font.PLAIN, 16));

        meterCodeText.setVisible(false);
        formPanel.add(meterCodeText);

        JLabel Employer = new JLabel("Admin ID:");
        Employer.setFont(new Font("Arial", Font.BOLD, 16));
        Employer.setForeground(new Color(50, 50, 50));
        Employer.setBounds(20, 110, 150, 30);
        Employer.setVisible(true);
        formPanel.add(Employer);

        EmployerText = new TextField();
        EmployerText.setBounds(20, 145, 400, 40);
        EmployerText.setFont(new Font("Arial", Font.PLAIN, 16));
        EmployerText.setVisible(true);
        formPanel.add(EmployerText);

        JLabel username = new JLabel("Korisnicko ime:");
        username.setFont(new Font("Arial", Font.BOLD, 16));
        username.setForeground(new Color(50, 50, 50));
        username.setBounds(20, 200, 150, 30);
        formPanel.add(username);

        usernameText = new TextField();
        usernameText.setBounds(20, 235, 400, 40);
        usernameText.setFont(new Font("Arial", Font.PLAIN, 16));
        formPanel.add(usernameText);

        JLabel name = new JLabel("Ime i prezime:");
        name.setFont(new Font("Arial", Font.BOLD, 16));
        name.setForeground(new Color(50, 50, 50));
        name.setBounds(20, 290, 150, 30);
        formPanel.add(name);

        nameText = new TextField("");
        nameText.setBounds(20, 325, 400, 40);
        nameText.setFont(new Font("Arial", Font.PLAIN, 16));
        formPanel.add(nameText);

        meterCodeText.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {

            }

            @Override
            public void focusLost(FocusEvent e) {
                try {
                    database c = new database();
                    ResultSet resultSet = c.statement.executeQuery("select * from Signup where meterCode = '"+meterCodeText.getText()+"'");
                    if (resultSet.next()){
                        nameText.setText(resultSet.getString("name"));
                    }

                }catch (Exception E){
                    E.printStackTrace();
                }
            }
        });

        JLabel password = new JLabel("Lozinka:");
        password.setFont(new Font("Arial", Font.BOLD, 16));
        password.setForeground(new Color(50, 50, 50));
        password.setBounds(20, 370, 150, 30);
        formPanel.add(password);

        passwordText = new JPasswordField();
        passwordText.setBounds(20, 400, 400, 40);
        passwordText.setFont(new Font("Arial", Font.PLAIN, 16));
        passwordText.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(200, 200, 200), 1),
                BorderFactory.createEmptyBorder(10, 15, 10, 15)
        ));
        formPanel.add(passwordText);

        loginAccount.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                String user = loginAccount.getSelectedItem();
                if (user.equals("Customer")){
                    Employer.setVisible(false);
                    nameText.setEditable(true);
                    EmployerText.setVisible(false);
                    meterCode.setVisible(true);
                    meterCodeText.setVisible(true);

                }else {
                    Employer.setVisible(true);
                    EmployerText.setVisible(true);
                    meterCode.setVisible(false);
                    meterCodeText.setVisible(false);
                }
            }
        });

        create = new JButton("Kreiraj nalog");
        create.setBackground(new Color(25, 25, 112));
        create.setForeground(Color.WHITE);
        create.setFont(new Font("Arial", Font.BOLD, 16));
        create.setBounds(20, 480, 180, 50);
        create.setFocusPainted(false);
        create.setBorderPainted(false);
        create.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        create.addActionListener(this);
        formPanel.add(create);

        back = new JButton("Nazad");
        back.setBackground(new Color(70, 130, 180));
        back.setForeground(Color.WHITE);
        back.setFont(new Font("Arial", Font.BOLD, 16));
        back.setBounds(220, 480, 180, 50);
        back.setFocusPainted(false);
        back.setBorderPainted(false);
        back.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        back.addActionListener(this);
        formPanel.add(back);

        mainPanel.add(formPanel);

        try {
            ImageIcon signupIcon = new ImageIcon(ClassLoader.getSystemResource("icons/signup_account.jpg"));
            Image signupImg = signupIcon.getImage().getScaledInstance(400, 400, Image.SCALE_SMOOTH);
            ImageIcon signupIcon2 = new ImageIcon(signupImg);
            JLabel signupLabel = new JLabel(signupIcon2);
            signupLabel.setBounds(600, 120, 400, 400);
            mainPanel.add(signupLabel);
        } catch (Exception e){
            JLabel noImageLabel = new JLabel("👤 Registracija 👤");
            noImageLabel.setFont(new Font("Arial", Font.BOLD, 48));
            noImageLabel.setForeground(new Color(25, 25, 112));
            noImageLabel.setBounds(650, 200, 400, 100);
            mainPanel.add(noImageLabel);

            JLabel descLabel = new JLabel("Kreirajte svoj nalog za pristup sistemu");
            descLabel.setFont(new Font("Arial", Font.ITALIC, 18));
            descLabel.setForeground(new Color(70, 70, 70));
            descLabel.setBounds(650, 300, 400, 30);
            mainPanel.add(descLabel);
        }

        setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == create) {
            String sloginAs = loginAccount.getSelectedItem();
            String susername = usernameText.getText();
            String sname = nameText.getText();
            String spassword = new String(passwordText.getPassword());
            String smeterCode = meterCodeText.getText();  // ili EmployerText ako je admin

            try {
                database c = new database();
                String query;

                if (sloginAs.equals("Admin")) {
                    query = "INSERT INTO Signup (meterCode, username, name, password, usertype) " +
                            "VALUES ('" + EmployerText.getText() + "', '" + susername + "', '" + sname + "', '" + spassword + "', '" + sloginAs + "')";
                } else {

                    ResultSet rs = c.statement.executeQuery("SELECT * FROM Signup WHERE meterCode = '" + smeterCode + "'");
                    if (rs.next()) {

                        query = "UPDATE Signup SET username = '" + susername + "', password = '" + spassword + "', usertype = '" + sloginAs + "' WHERE meterCode = '" + smeterCode + "'";
                    } else {

                        query = "INSERT INTO Signup (meterCode, username, name, password, usertype) " +
                                "VALUES ('" + smeterCode + "', '" + susername + "', '" + sname + "', '" + spassword + "', '" + sloginAs + "')";
                    }
                }

                c.statement.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Account Created!");
                setVisible(false);
                new Login();

            } catch (Exception E) {
                E.printStackTrace();
            }
        } else if (e.getSource() == back) {
            setVisible(false);
            new Login();
        }
    }


    public static void main(String[] args) {

        new Signup();
    }
}
