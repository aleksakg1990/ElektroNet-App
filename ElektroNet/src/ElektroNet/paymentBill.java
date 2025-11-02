package ElektroNet;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Clipboard;
import java.net.URI;

public class paymentBill extends JFrame implements ActionListener{

    JButton back, payButton, copyButton;
    JTextField urlField;
    String meter;
    JPanel mainPanel, formPanel;
    boolean paymentCompleted = false;


    public paymentBill(String meter){

        super("ElektroNet - Online placanje");
        this.meter = meter;
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(1200, 800);
        setLocationRelativeTo(null);
        setLayout(null);

        getContentPane().setBackground(new Color(240, 248, 255));

        mainPanel = new JPanel();
        mainPanel.setLayout(null);
        mainPanel.setBackground(new Color(240, 248, 255));
        mainPanel.setBounds(0, 0, 1200, 800);
        add(mainPanel);

        JLabel titleLabel = new JLabel("Online placanje");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 36));
        titleLabel.setForeground(new Color(25, 25, 112));
        titleLabel.setBounds(50, 30, 500, 50);
        mainPanel.add(titleLabel);

        JLabel subtitleLabel = new JLabel("Platite racun online za broj brojila: " + meter);
        subtitleLabel.setFont(new Font("Arial", Font.ITALIC, 18));
        subtitleLabel.setForeground(new Color(70, 70, 70));
        subtitleLabel.setBounds(50, 85, 600, 30);
        mainPanel.add(subtitleLabel);

        showPaymentScreen();

        setVisible(true);
    }

    private void showPaymentScreen() {
        if (formPanel != null) {
            mainPanel.remove(formPanel);
        }

        formPanel = new JPanel();
        formPanel.setLayout(null);
        formPanel.setBackground(Color.WHITE);
        formPanel.setBounds(50, 130, 1100, 600);
        formPanel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(200, 200, 200), 2),
                BorderFactory.createEmptyBorder(30, 30, 30, 30)
        ));
        mainPanel.add(formPanel);


        JLabel paymentTitle = new JLabel("Placanje racuna");
        paymentTitle.setFont(new Font("Arial", Font.BOLD, 28));
        paymentTitle.setForeground(new Color(25, 25, 112));
        paymentTitle.setBounds(420, 160, 350, 40);
        formPanel.add(paymentTitle);

        JLabel infoLabel = new JLabel("Molimo vas da izvrsite placanje putem sledeceg linka:");
        infoLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        infoLabel.setForeground(new Color(70, 70, 70));
        infoLabel.setBounds(300, 220, 550, 30);
        formPanel.add(infoLabel);

        urlField = new JTextField("https://paytm.com/online-payments");
        urlField.setBounds(250, 270, 600, 45);
        urlField.setFont(new Font("Arial", Font.PLAIN, 16));
        urlField.setEditable(false);
        urlField.setBackground(new Color(245, 245, 245));
        urlField.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(200, 200, 200), 2),
                BorderFactory.createEmptyBorder(10, 15, 10, 15)
        ));
        formPanel.add(urlField);

        JButton openBrowserButton = new JButton("Otvori u browseru");
        openBrowserButton.setBounds(300, 335, 200, 45);
        openBrowserButton.setFont(new Font("Arial", Font.BOLD, 16));
        openBrowserButton.setBackground(new Color(100, 149, 237));
        openBrowserButton.setForeground(Color.WHITE);
        openBrowserButton.setFocusPainted(false);
        openBrowserButton.setBorderPainted(false);
        openBrowserButton.addActionListener(e -> openInBrowser());
        formPanel.add(openBrowserButton);

        copyButton = new JButton("Kopiraj link");
        copyButton.setBounds(520, 335, 180, 45);
        copyButton.setFont(new Font("Arial", Font.BOLD, 16));
        copyButton.setBackground(new Color(70, 130, 180));
        copyButton.setForeground(Color.WHITE);
        copyButton.setFocusPainted(false);
        copyButton.setBorderPainted(false);
        copyButton.addActionListener(e -> copyToClipboard());
        formPanel.add(copyButton);

        JPanel notePanel = new JPanel();
        notePanel.setLayout(null);
        notePanel.setBackground(new Color(255, 250, 205));
        notePanel.setBounds(150, 400, 800, 100);
        notePanel.setBorder(BorderFactory.createLineBorder(new Color(255, 215, 0), 2));
        formPanel.add(notePanel);


        JLabel note = new JLabel("Napomena:");
        note.setFont(new Font("Arial", Font.BOLD, 16));
        note.setForeground(new Color(139, 69, 19));
        note.setBounds(60, 10, 150, 30);
        notePanel.add(note);

        JLabel note1 = new JLabel("Nakon sto izvrsite plasanje na sajtu, kliknite na dugme 'Potvrdite placanje'.");
        note1.setFont(new Font("Arial", Font.PLAIN, 14));
        note1.setForeground(new Color(100, 100, 100));
        note1.setBounds(60, 40, 700, 25);
        notePanel.add(note1);

        JLabel note2 = new JLabel("Status vaseg racuna ce biti automatski azuriran u sistemu.");
        note2.setFont(new Font("Arial", Font.PLAIN, 14));
        note2.setForeground(new Color(100, 100, 100));
        note2.setBounds(60, 60, 700, 25);
        notePanel.add(note2);

        payButton = new JButton("Potvrdite placanje");
        payButton.setBounds(400, 520, 300, 50);
        payButton.setFont(new Font("Arial", Font.BOLD, 18));
        payButton.setBackground(new Color(34, 139, 34));
        payButton.setForeground(Color.WHITE);
        payButton.setFocusPainted(false);
        payButton.setBorderPainted(false);
        payButton.addActionListener(this);
        formPanel.add(payButton);

        back = new JButton("Nazad");
        back.setBounds(50, 520, 150, 50);
        back.setFont(new Font("Arial", Font.BOLD, 18));
        back.setBackground(new Color(220, 20, 60));
        back.setForeground(Color.WHITE);
        back.setFocusPainted(false);
        back.setBorderPainted(false);
        back.addActionListener(this);
        formPanel.add(back);

        mainPanel.revalidate();
        mainPanel.repaint();

    }

    private void showSuccessScreen() {

        mainPanel.remove(formPanel);


        formPanel = new JPanel();
        formPanel.setLayout(null);
        formPanel.setBackground(Color.WHITE);
        formPanel.setBounds(50, 130, 1100, 600);
        formPanel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(200, 200, 200), 2),
                BorderFactory.createEmptyBorder(30, 30, 30, 30)
        ));
        mainPanel.add(formPanel);


        JLabel successMessage = new JLabel("Placanje uspesno!");
        successMessage.setFont(new Font("Arial", Font.BOLD, 32));
        successMessage.setForeground(new Color(25, 25, 112));
        successMessage.setBounds(400, 180, 350, 50);
        formPanel.add(successMessage);

        JLabel infoLabel1 = new JLabel("Vas racun je uspesno placen.");
        infoLabel1.setFont(new Font("Arial", Font.PLAIN, 18));
        infoLabel1.setForeground(new Color(70, 70, 70));
        infoLabel1.setBounds(380, 250, 400, 30);
        formPanel.add(infoLabel1);

        JLabel infoLabel2 = new JLabel("Status racuna je azuriran u sistemu.");
        infoLabel2.setFont(new Font("Arial", Font.PLAIN, 18));
        infoLabel2.setForeground(new Color(70, 70, 70));
        infoLabel2.setBounds(360, 285, 450, 30);
        formPanel.add(infoLabel2);

        JSeparator separator = new JSeparator();
        separator.setBounds(150, 340, 800, 2);
        separator.setForeground(new Color(200, 200, 200));
        formPanel.add(separator);

        JPanel detailsPanel = new JPanel();
        detailsPanel.setLayout(null);
        detailsPanel.setBackground(new Color(240, 248, 255));
        detailsPanel.setBounds(150, 360, 800, 150);
        detailsPanel.setBorder(BorderFactory.createLineBorder(new Color(100, 149, 237), 2));
        formPanel.add(detailsPanel);

        JLabel detailsTitle = new JLabel("Detalji placanja:");
        detailsTitle.setFont(new Font("Arial", Font.BOLD, 20));
        detailsTitle.setForeground(new Color(25, 25, 112));
        detailsTitle.setBounds(30, 20, 250, 30);
        detailsPanel.add(detailsTitle);

        JLabel meterLabel = new JLabel("Broj brojila:");
        meterLabel.setFont(new Font("Arial", Font.BOLD, 16));
        meterLabel.setForeground(new Color(50, 50, 50));
        meterLabel.setBounds(30, 60, 200, 25);
        detailsPanel.add(meterLabel);

        JLabel meterValue = new JLabel(meter);
        meterValue.setFont(new Font("Arial", Font.PLAIN, 16));
        meterValue.setForeground(new Color(25, 25, 112));
        meterValue.setBounds(250, 60, 300, 25);
        detailsPanel.add(meterValue);

        JLabel statusLabel = new JLabel("Status:");
        statusLabel.setFont(new Font("Arial", Font.BOLD, 16));
        statusLabel.setForeground(new Color(50, 50, 50));
        statusLabel.setBounds(30, 95, 200, 25);
        detailsPanel.add(statusLabel);

        JLabel statusValue = new JLabel("Placeno");
        statusValue.setFont(new Font("Arial", Font.BOLD, 16));
        statusValue.setForeground(new Color(34, 139, 34));
        statusValue.setBounds(250, 95, 300, 25);
        detailsPanel.add(statusValue);

        back = new JButton("Nazad na pocetnu");
        back.setBounds(450, 530, 200, 50);
        back.setFont(new Font("Arial", Font.BOLD, 18));
        back.setBackground(new Color(70, 130, 180));
        back.setForeground(Color.WHITE);
        back.setFocusPainted(false);
        back.setBorderPainted(false);
        back.addActionListener(this);
        formPanel.add(back);

        mainPanel.revalidate();
        mainPanel.repaint();
    }

    private void showErrorScreen() {

        mainPanel.remove(formPanel);


        formPanel = new JPanel();
        formPanel.setLayout(null);
        formPanel.setBackground(Color.WHITE);
        formPanel.setBounds(50, 130, 1100, 600);
        formPanel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(200, 200, 200), 2),
                BorderFactory.createEmptyBorder(30, 30, 30, 30)
        ));
        mainPanel.add(formPanel);


        JLabel errorMessage = new JLabel("Greska pri placanju!");
        errorMessage.setFont(new Font("Arial", Font.BOLD, 32));
        errorMessage.setForeground(new Color(220, 20, 60));
        errorMessage.setBounds(380, 180, 400, 50);
        formPanel.add(errorMessage);

        JLabel infoLabel1 = new JLabel("Doslo je do greske pri obradi placanja.");
        infoLabel1.setFont(new Font("Arial", Font.PLAIN, 18));
        infoLabel1.setForeground(new Color(70, 70, 70));
        infoLabel1.setBounds(350, 250, 450, 30);
        formPanel.add(infoLabel1);

        JLabel infoLabel2 = new JLabel("Molimo pokusajte ponovo ili kontaktirajte podrsku.");
        infoLabel2.setFont(new Font("Arial", Font.PLAIN, 18));
        infoLabel2.setForeground(new Color(70, 70, 70));
        infoLabel2.setBounds(310, 285, 550, 30);
        formPanel.add(infoLabel2);

        JSeparator separator = new JSeparator();
        separator.setBounds(150, 340, 800, 2);
        separator.setForeground(new Color(200, 200, 200));
        formPanel.add(separator);

        JPanel notePanel = new JPanel();
        notePanel.setLayout(null);
        notePanel.setBackground(new Color(255, 240, 245));
        notePanel.setBounds(150, 360, 800, 120);
        notePanel.setBorder(BorderFactory.createLineBorder(new Color(220, 20, 60), 2));
        formPanel.add(notePanel);


        JLabel note = new JLabel("Moguci razlozi:");
        note.setFont(new Font("Arial", Font.BOLD, 16));
        note.setForeground(new Color(139, 0, 0));
        note.setBounds(60, 10, 150, 30);
        notePanel.add(note);

        JLabel note1 = new JLabel("• Nedovoljno sredstava na racunu");
        note1.setFont(new Font("Arial", Font.PLAIN, 14));
        note1.setForeground(new Color(100, 100, 100));
        note1.setBounds(60, 40, 700, 25);
        notePanel.add(note1);

        JLabel note2 = new JLabel("• Problem sa mreznom konekcijom");
        note2.setFont(new Font("Arial", Font.PLAIN, 14));
        note2.setForeground(new Color(100, 100, 100));
        note2.setBounds(60, 60, 700, 25);
        notePanel.add(note2);

        JLabel note3 = new JLabel("• Greska na platnom servisu");
        note3.setFont(new Font("Arial", Font.PLAIN, 14));
        note3.setForeground(new Color(100, 100, 100));
        note3.setBounds(60, 80, 700, 25);
        notePanel.add(note3);

        JButton retryButton = new JButton("Pokusaj ponovo");
        retryButton.setBounds(400, 500, 300, 50);
        retryButton.setFont(new Font("Arial", Font.BOLD, 18));
        retryButton.setBackground(new Color(255, 140, 0));
        retryButton.setForeground(Color.WHITE);
        retryButton.setFocusPainted(false);
        retryButton.setBorderPainted(false);
        retryButton.addActionListener(e -> showPaymentScreen());
        formPanel.add(retryButton);

        back = new JButton("Nazad");
        back.setBounds(50, 500, 150, 50);
        back.setFont(new Font("Arial", Font.BOLD, 18));
        back.setBackground(new Color(70, 130, 180));
        back.setForeground(Color.WHITE);
        back.setFocusPainted(false);
        back.setBorderPainted(false);
        back.addActionListener(this);
        formPanel.add(back);

        mainPanel.revalidate();
        mainPanel.repaint();
    }

    private void openInBrowser() {
        try {
            String url = "https://paytm.com/online-payments";
            if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
                Desktop.getDesktop().browse(new URI(url));
                JOptionPane.showMessageDialog(this, "Browser je otvoren sa stranicom za placanje.", "Uspesno", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Nije moguce otvoriti browser. Molimo kopirajte link rucno.", "Greska", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Greska pri otvaranju browsera. Molimo kopirajte link rucno.", "Greska", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void copyToClipboard() {
        try {
            String url = "https://paytm.com/online-payments";
            StringSelection stringSelection = new StringSelection(url);
            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
            clipboard.setContents(stringSelection, null);
            JOptionPane.showMessageDialog(this, "Link je uspesno kopiran u clipboard!", "Uspesno", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Greska pri kopiranju linka.", "Greska", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void processPayment() {
        // Simulacija placanja - 80% sanse za uspeh, 20% za gresku
        int result = JOptionPane.showConfirmDialog(this,
                "Da li ste izvrsili placanje na sajtu?",
                "Potvrda placanja",
                JOptionPane.YES_NO_OPTION);

        if (result == JOptionPane.YES_OPTION) {
            // Simulacija - mozete promeniti logiku
            double random = Math.random();
            if (random > 0.2) { // 80% uspeh
                showSuccessScreen();
                paymentCompleted = true;
            } else { // 20% greska
                showErrorScreen();
            }
        }
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == back){
            dispose();
            SwingUtilities.invokeLater(()-> new payBill(meter));
        } else if (e.getSource() == payButton) {
            processPayment();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(()-> new paymentBill(""));
    }
}



