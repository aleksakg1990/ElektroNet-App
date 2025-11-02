package ElektroNet;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class meterNumberInfo extends JFrame implements ActionListener{


    Choice meterLocChoice, meterTypeChoice, phaseCodeChoice, billTypeChoice;
    JButton submit;
    String meterNbr;

    public meterNumberInfo(String meterNbr){
        super("ElektroNet - Informacije o brojilu");
        this.meterNbr = meterNbr;
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

        JLabel heading = new JLabel("Informacije o brojilu");
        heading.setBounds(50, 30, 500, 50);
        heading.setFont(new Font("Arial", Font.BOLD, 36));
        heading.setForeground(new Color(25, 25, 112));
        mainPanel.add(heading);

        JLabel subtitle = new JLabel("Unesite podatke za broj brojila: " + meterNbr);
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


        JLabel meterNumber = new JLabel("Broj brojila:");
        meterNumber.setFont(new Font("Arial", Font.BOLD, 18));
        meterNumber.setForeground(new Color(50, 50, 50));
        meterNumber.setBounds(30, 30, 250, 35);
        formPanel.add(meterNumber);

        JLabel meterNumberText = new JLabel(meterNbr);
        meterNumberText.setFont(new Font("Arial", Font.BOLD, 18));
        meterNumberText.setForeground(new Color(25, 25, 112));
        meterNumberText.setBounds(300, 30, 280, 35);
        formPanel.add(meterNumberText);

        JLabel meterLoc = new JLabel("Lokacija brojila:");
        meterLoc.setFont(new Font("Arial", Font.BOLD, 18));
        meterLoc.setForeground(new Color(50, 50, 50));
        meterLoc.setBounds(30, 90, 250, 35);
        formPanel.add(meterLoc);

        meterLocChoice = new Choice();
        meterLocChoice.add("Spolja");
        meterLocChoice.add("Unutra");
        meterLocChoice.setBounds(300, 90, 280, 35);
        meterLocChoice.setFont(new Font("Arial", Font.PLAIN, 16));
        meterLocChoice.setBackground(Color.WHITE);
        formPanel.add(meterLocChoice);

        JLabel meterType = new JLabel("Tip brojila:");
        meterType.setFont(new Font("Arial", Font.BOLD, 18));
        meterType.setForeground(new Color(50, 50, 50));
        meterType.setBounds(30, 150, 250, 35);
        formPanel.add(meterType);

        meterTypeChoice = new Choice();
        meterTypeChoice.add("Elektricno brojilo");
        meterTypeChoice.add("Solarno brojilo");
        meterTypeChoice.add("Pametno brojilo");
        meterTypeChoice.setBounds(300, 150, 280, 35);
        meterTypeChoice.setFont(new Font("Arial", Font.PLAIN, 16));
        meterTypeChoice.setBackground(Color.WHITE);
        formPanel.add(meterTypeChoice);

        JLabel phaseCode = new JLabel("Fazni kod:");
        phaseCode.setFont(new Font("Arial", Font.BOLD, 18));
        phaseCode.setForeground(new Color(50, 50, 50));
        phaseCode.setBounds(30, 210, 250, 35);
        formPanel.add(phaseCode);

        phaseCodeChoice = new Choice();
        phaseCodeChoice.add("011");
        phaseCodeChoice.add("022");
        phaseCodeChoice.add("033");
        phaseCodeChoice.add("044");
        phaseCodeChoice.add("055");
        phaseCodeChoice.add("066");
        phaseCodeChoice.add("077");
        phaseCodeChoice.add("088");
        phaseCodeChoice.add("099");
        phaseCodeChoice.setBounds(300, 210, 280, 35);
        phaseCodeChoice.setFont(new Font("Arial", Font.PLAIN, 16));
        phaseCodeChoice.setBackground(Color.WHITE);
        formPanel.add(phaseCodeChoice);

        JLabel billType = new JLabel("Tip racuna:");
        billType.setFont(new Font("Arial", Font.BOLD, 18));
        billType.setForeground(new Color(50, 50, 50));
        billType.setBounds(30, 270, 250, 35);
        formPanel.add(billType);

        billTypeChoice = new Choice();
        billTypeChoice.add("Normalan racun");
        billTypeChoice.add("Industrijski racun");
        billTypeChoice.setBounds(300, 270, 280, 35);
        billTypeChoice.setFont(new Font("Arial", Font.PLAIN, 16));
        billTypeChoice.setBackground(Color.WHITE);
        formPanel.add(billTypeChoice);

        JLabel day = new JLabel("Period naplate:");
        day.setFont(new Font("Arial", Font.BOLD, 18));
        day.setForeground(new Color(50, 50, 50));
        day.setBounds(30, 330, 250, 35);
        formPanel.add(day);

        JLabel dayValue = new JLabel("30 dana");
        dayValue.setFont(new Font("Arial", Font.PLAIN, 18));
        dayValue.setForeground(new Color(25, 25, 112));
        dayValue.setBounds(300, 330, 280, 35);
        formPanel.add(dayValue);


        JPanel notePanel = new JPanel();
        notePanel.setLayout(null);
        notePanel.setBackground(new Color(255, 250, 205));
        notePanel.setBounds(30, 390, 550, 100);
        notePanel.setBorder(BorderFactory.createLineBorder(new Color(255, 215, 0), 2));
        formPanel.add(notePanel);

        JLabel noteIcon = new JLabel("ℹ");
        noteIcon.setFont(new Font("Arial", Font.BOLD, 28));
        noteIcon.setForeground(new Color(255, 140, 0));
        noteIcon.setBounds(15, 10, 40, 40);
        notePanel.add(noteIcon);

        JLabel note = new JLabel("Napomena:");
        note.setFont(new Font("Arial", Font.BOLD, 16));
        note.setForeground(new Color(139, 69, 19));
        note.setBounds(60, 10, 150, 30);
        notePanel.add(note);

        JLabel note1 = new JLabel("Po defaultu se racun kalkulise za period od 30 dana.");
        note1.setFont(new Font("Arial", Font.PLAIN, 14));
        note1.setForeground(new Color(100, 100, 100));
        note1.setBounds(60, 40, 450, 25);
        notePanel.add(note1);

        JLabel note2 = new JLabel("Proverite da li su svi podaci ispravno uneti pre potvrde.");
        note2.setFont(new Font("Arial", Font.PLAIN, 14));
        note2.setForeground(new Color(100, 100, 100));
        note2.setBounds(60, 60, 450, 25);
        notePanel.add(note2);


        submit = new JButton("Potvrdi i sacuvaj");
        submit.setBounds(200, 510, 200, 50);
        submit.setFont(new Font("Arial", Font.BOLD, 18));
        submit.setBackground(new Color(25, 25, 112));
        submit.setForeground(Color.WHITE);
        submit.setFocusPainted(false);
        submit.setBorderPainted(false);
        submit.addActionListener(this);
        formPanel.add(submit);


        try {
            ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/details.png"));
            Image i2 = i1.getImage().getScaledInstance(420, 550, Image.SCALE_SMOOTH);
            ImageIcon i3 = new ImageIcon(i2);
            JLabel imgLabel = new JLabel(i3);
            imgLabel.setBounds(730, 150, 420, 550);
            mainPanel.add(imgLabel);
        } catch (Exception e) {

            JLabel fallbackLabel = new JLabel("Detalji");
            fallbackLabel.setFont(new Font("Arial", Font.BOLD, 48));
            fallbackLabel.setForeground(new Color(25, 25, 112));
            fallbackLabel.setBounds(800, 350, 300, 100);
            mainPanel.add(fallbackLabel);
        }

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==submit){
            String smeterNbr = meterNbr;
            String smeterLoc = meterLocChoice.getSelectedItem();
            String smeterType = meterTypeChoice.getSelectedItem();
            String sphaseCode = phaseCodeChoice.getSelectedItem();
            String sbillType = billTypeChoice.getSelectedItem();
            String sday = "30";

            String query_meterInfo = "insert into meter_info values('"+smeterNbr+"','"+smeterLoc+"','"+smeterType+"','"+sphaseCode+"','"+sbillType+"','"+sday+"')";

            try{
                database c = new database();
                c.statement.executeUpdate(query_meterInfo);

                JOptionPane.showMessageDialog(null, "Meter Information submitted successfully");
                setVisible(false);

            }catch (Exception E){
                E.printStackTrace();
            }
        }else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new meterNumberInfo("");
    }
}
