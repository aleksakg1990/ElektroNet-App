package ElektroNet;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class main_screen extends JFrame implements ActionListener {

    String acctype;
    String meter_pass;

    public main_screen(String acctype, String meter_pass){

        super("ElektroNet - Glavni prozor");
        this.acctype = acctype;
        this.meter_pass = meter_pass;
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        getContentPane().setBackground(new Color(240, 248, 255));

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icons/main_image.png"));
        Image image = imageIcon.getImage().getScaledInstance(1530, 830, Image.SCALE_SMOOTH);
        ImageIcon imageIcon1 = new ImageIcon(image);
        JLabel imageLabel = new JLabel(imageIcon1);
        add(imageLabel);

        JMenuBar menuBar  = new JMenuBar();
        menuBar.setBackground(new Color(25, 25, 112));
        menuBar.setBorder(BorderFactory.createEmptyBorder(8, 15, 8, 15));
        setJMenuBar(menuBar);

        JMenu menu = new JMenu("Meni");
        menu.setFont(new Font("Arial", Font.BOLD, 16));
        menu.setForeground(Color.WHITE);


        JMenuItem new_customer = new JMenuItem("Novi korisnik");
        new_customer.setFont(new Font("Arial", Font.PLAIN, 14));
        ImageIcon customerImg = new ImageIcon(ClassLoader.getSystemResource("icons/newCustomer.png"));
        Image customerImage = customerImg.getImage().getScaledInstance(20,20,Image.SCALE_SMOOTH);
        new_customer.setIcon(new ImageIcon(customerImage));
        new_customer.addActionListener(this);
        menu.add(new_customer);

        JMenuItem customerdetails = new JMenuItem("Detalji korisnika");
        customerdetails.setFont(new Font("Arial", Font.PLAIN, 14));
        ImageIcon customerdetailsImg = new ImageIcon(ClassLoader.getSystemResource("icons/customerDetails.png"));
        Image customerdetailsImage = customerdetailsImg.getImage().getScaledInstance(20,20,Image.SCALE_SMOOTH);
        customerdetails.setIcon(new ImageIcon(customerdetailsImage));
        customerdetails.addActionListener(this);
        menu.add(customerdetails);

        JMenuItem depositdetails = new JMenuItem("Detalji depozita");
        depositdetails.setFont(new Font("Arial", Font.PLAIN, 14));
        ImageIcon depositdetailsImg = new ImageIcon(ClassLoader.getSystemResource("icons/depositDetails.png"));
        Image depositdetailsImage = depositdetailsImg.getImage().getScaledInstance(20,20,Image.SCALE_SMOOTH);
        depositdetails.setIcon(new ImageIcon(depositdetailsImage));
        depositdetails.addActionListener(this);
        menu.add(depositdetails);

        JMenuItem calculatebill = new JMenuItem("Kalkulacija racuna");
        calculatebill.setFont(new Font("Arial", Font.PLAIN, 14));
        ImageIcon calculatebillImg = new ImageIcon(ClassLoader.getSystemResource("icons/calculateBill.png"));
        Image calculatebillImage = calculatebillImg.getImage().getScaledInstance(20,20,Image.SCALE_SMOOTH);
        calculatebill.setIcon(new ImageIcon(calculatebillImage));
        calculatebill.addActionListener(this);
        menu.add(calculatebill);

        JMenu info = new JMenu("Informacije");
        info.setFont(new Font("Arial", Font.BOLD, 16));
        info.setForeground(Color.WHITE);

        JMenuItem upinfo = new JMenuItem("Azuriranje informacija");
        upinfo.setFont(new Font("Arial", Font.PLAIN, 14));
        ImageIcon upinfoImg = new ImageIcon(ClassLoader.getSystemResource("icons/updateInformation.png"));
        Image upinfoImage = upinfoImg.getImage().getScaledInstance(20,20,Image.SCALE_SMOOTH);
        upinfo.setIcon(new ImageIcon(upinfoImage));
        upinfo.addActionListener(this);
        info.add(upinfo);

        JMenuItem viewInfo = new JMenuItem("Pregled informacija");
        viewInfo.setFont(new Font("Arial", Font.PLAIN, 14));
        ImageIcon viewInfoImg = new ImageIcon(ClassLoader.getSystemResource("icons/viewInformation.png"));
        Image viewInfoImage = viewInfoImg.getImage().getScaledInstance(20,20,Image.SCALE_SMOOTH);
        viewInfo.setIcon(new ImageIcon(viewInfoImage));
        viewInfo.addActionListener(this);
        info.add(viewInfo);

        JMenu user = new JMenu("Korisnik");
        user.setFont(new Font("Arial", Font.BOLD, 16));
        user.setForeground(Color.WHITE);

        JMenuItem payBill = new JMenuItem("Placanje racuna");
        payBill.setFont(new Font("Arial", Font.PLAIN, 14));
        ImageIcon payBillImg = new ImageIcon(ClassLoader.getSystemResource("icons/payBill.png"));
        Image payBillImage = payBillImg.getImage().getScaledInstance(20,20,Image.SCALE_SMOOTH);
        payBill.setIcon(new ImageIcon(payBillImage));
        payBill.addActionListener(this);
        user.add(payBill);

        JMenuItem billDetails = new JMenuItem("Detalji racuna");
        billDetails.setFont(new Font("Arial", Font.PLAIN, 14));
        ImageIcon billDetailsImg = new ImageIcon(ClassLoader.getSystemResource("icons/billDetails.png"));
        Image billDetailsImage = billDetailsImg.getImage().getScaledInstance(20,20,Image.SCALE_SMOOTH);
        billDetails.setIcon(new ImageIcon(billDetailsImage));
        billDetails.addActionListener(this);
        user.add(billDetails);

        JMenu bill = new JMenu("Racun");
        bill.setFont(new Font("Arial", Font.BOLD, 16));
        bill.setForeground(Color.WHITE);

        JMenuItem printBill = new JMenuItem("Stampanje racuna");
        printBill.setFont(new Font("Arial", Font.PLAIN, 14));
        ImageIcon printBillImg = new ImageIcon(ClassLoader.getSystemResource("icons/printBill.png"));
        Image printBillImage = printBillImg.getImage().getScaledInstance(20,20,Image.SCALE_SMOOTH);
        printBill.setIcon(new ImageIcon(printBillImage));
        printBill.addActionListener(this);
        bill.add(printBill);

        JMenu feature = new JMenu("Alati");
        feature.setFont(new Font("Arial", Font.BOLD, 16));
        feature.setForeground(Color.WHITE);

        JMenuItem notepad = new JMenuItem("Notepad");
        notepad.setFont(new Font("Arial", Font.PLAIN, 14));
        ImageIcon notepadImg = new ImageIcon(ClassLoader.getSystemResource("icons/notepad.png"));
        Image notepadImage = notepadImg.getImage().getScaledInstance(20,20,Image.SCALE_SMOOTH);
        notepad.setIcon(new ImageIcon(notepadImage));
        notepad.addActionListener(this);
        feature.add(notepad);

        JMenuItem calculator = new JMenuItem("Kalkulator");
        calculator.setFont(new Font("Arial", Font.PLAIN, 14));
        ImageIcon calculatorImg = new ImageIcon(ClassLoader.getSystemResource("icons/calculator.png"));
        Image calculatorImage = calculatorImg.getImage().getScaledInstance(20,20,Image.SCALE_SMOOTH);
        calculator.setIcon(new ImageIcon(calculatorImage));
        calculator.addActionListener(this);
        feature.add(calculator);

        JMenu exit = new JMenu("Izlaz");
        exit.setFont(new Font("Arial", Font.BOLD, 16));
        exit.setForeground(Color.WHITE);

        JMenuItem eexit = new JMenuItem("Izlaz");
        eexit.setFont(new Font("Arial", Font.PLAIN, 14));
        ImageIcon eexitImg = new ImageIcon(ClassLoader.getSystemResource("icons/exit.png"));
        Image eexitImage = eexitImg.getImage().getScaledInstance(20,20,Image.SCALE_SMOOTH);
        eexit.setIcon(new ImageIcon(eexitImage));
        eexit.addActionListener(this);
        exit.add(eexit);


        if (acctype.equals("Admin")){
            menuBar.add(menu);
        }else {
            menuBar.add(bill);
            menuBar.add(user);
            menuBar.add(info);
        }
        menuBar.add(feature);
        menuBar.add(exit);

        setLayout(new FlowLayout());
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String msg = e.getActionCommand();
        if (msg.equals("Novi korisnik")){
            new newCustomer();
        } else if (msg.equals("Detalji korisnika")) {
            new customerDetails();
        }else if (msg.equals("Detalji depozita")){
            new depositDetails();
        } else if (msg.equals("Kalkulacija racuna")) {
            new CalculateBillForm();
        } else if (msg.equals("Pregled informacija")) {
            new view_information(meter_pass);
        } else if (msg.equals("Azuriranje informacija")) {
            new update_information(meter_pass);
        } else if (msg.equals("Detalji racuna")) {
            new billDetails(meter_pass);
        } else if (msg.equals("Kalkulator")) {
            try {
                Runtime.getRuntime().exec("calc.exe");
            }catch (Exception E){
                E.printStackTrace();
            }
        } else if (msg.equals("Notepad")) {
            try {
                Runtime.getRuntime().exec("notepad.exe");
            }catch (Exception E){
                E.printStackTrace();
            }
        } else if (msg.equals("Izlaz")) {
            setVisible(false);
            new Login();
        } else if (msg.equals("Placanje racuna")) {
            new payBill(meter_pass);
        } else if (msg.equals("Stampanje racuna")) {
            new generateBill(meter_pass);
        }
    }

    public static void main(String[] args) {
        new main_screen("", "");

    }
}
