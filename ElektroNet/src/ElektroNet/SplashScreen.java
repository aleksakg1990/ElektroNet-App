package ElektroNet;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SplashScreen extends JFrame {

    private JProgressBar progressBar;
    private JLabel statusLabel;
    private JLabel titleLabel;
    private int progress = 0;
    private Timer progressTimer;


    public SplashScreen() {
        super("ElektroNet - Ucitavanje");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1200, 800);
        setLocationRelativeTo(null);
        setLayout(null);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(null);
        mainPanel.setBackground(new Color(240, 248, 255));
        mainPanel.setBounds(0, 0, 1200, 800);
        add(mainPanel);

        try {
            ImageIcon mainImageIcon = new ImageIcon(ClassLoader.getSystemResource("icons/splashscreen/Splash.jpg"));
            Image mainImage = mainImageIcon.getImage().getScaledInstance(500, 350, Image.SCALE_SMOOTH);
            ImageIcon mainImageIconScaled = new ImageIcon(mainImage);
            JLabel mainImageLabel = new JLabel(mainImageIconScaled);
            mainImageLabel.setBounds(350, 150, 500, 350);
            mainPanel.add(mainImageLabel);
        } catch (Exception e) {
            JLabel noMainImageLabel = new JLabel("Elektricna energija");
            noMainImageLabel.setFont(new Font("Arial", Font.BOLD, 64));
            noMainImageLabel.setForeground(new Color(25, 25, 112));
            noMainImageLabel.setBounds(450, 300, 400, 100);
            mainPanel.add(noMainImageLabel);
        }

        titleLabel = new JLabel("ElektroNet");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 72));
        titleLabel.setForeground(new Color(25, 25, 112));
        titleLabel.setBounds(450, 520, 400, 80);
        mainPanel.add(titleLabel);

        JLabel subtitleLabel = new JLabel("Sistem za upravljanje elektricnim racunima");
        subtitleLabel.setFont(new Font("Arial", Font.ITALIC, 22));
        subtitleLabel.setForeground(new Color(70, 70, 70));
        subtitleLabel.setBounds(350, 600, 500, 30);
        mainPanel.add(subtitleLabel);

        progressBar = new JProgressBar();
        progressBar.setBounds(300, 650, 600, 30);
        progressBar.setStringPainted(true);
        progressBar.setString("Ucitavanje aplikacije...");
        progressBar.setBackground(new Color(200, 200, 200));
        progressBar.setForeground(new Color(25, 25, 112));
        progressBar.setBorderPainted(false);
        progressBar.setStringPainted(true);
        progressBar.setString("0%");
        mainPanel.add(progressBar);

        statusLabel = new JLabel("Inicijalizacija sistema...");
        statusLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        statusLabel.setForeground(new Color(50, 50, 50));
        statusLabel.setBounds(500, 690, 300, 25);
        mainPanel.add(statusLabel);

        JLabel versionLabel = new JLabel("Verzija 1.0.0");
        versionLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        versionLabel.setForeground(new Color(100, 100, 100));
        versionLabel.setBounds(1050, 750, 100, 20);
        mainPanel.add(versionLabel);

        JLabel copyrightLabel = new JLabel("© 2025 ElektroNet. Sva prava zadrzana.");
        copyrightLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        copyrightLabel.setForeground(new Color(100, 100, 100));
        copyrightLabel.setBounds(50, 750, 300, 20);
        mainPanel.add(copyrightLabel);

        progressTimer = new Timer(50, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                progress++;
                progressBar.setValue(progress);
                progressBar.setString(progress + "%");


                if (progress < 20) {
                    statusLabel.setText("Inicijalizacija sistema...");
                } else if (progress < 40) {
                    statusLabel.setText("Ucitavanje baze podataka...");
                } else if (progress < 60) {
                    statusLabel.setText("Povezivanje sa serverom...");
                } else if (progress < 80) {
                    statusLabel.setText("Priprema interfejsa...");
                } else if (progress < 95) {
                    statusLabel.setText("Finalizacija...");
                } else {
                    statusLabel.setText("Gotovo!");
                }

                if (progress >= 100) {
                    progressTimer.stop();
                    Timer finalTimer = new Timer(500, ev -> {
                        setVisible(false);
                        dispose();
                        new Login();
                    });
                    finalTimer.setRepeats(false);
                    finalTimer.start();
                }
            }
        });

        setVisible(true);
        progressTimer.start();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new SplashScreen());
    }
}
