package Algoritmafinal;

import javax.swing.*;
import java.awt.event.*;

public class mdcGUI extends JFrame {

    JTextField usernameField;
    JPasswordField passwordField;
    JButton loginButton;
    JLabel statusLabel;
    String currentUser = "";

    public mdcGUI() {
        setTitle("MDC Giriş Paneli");
        setSize(300, 220);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        JLabel userLabel = new JLabel("Kullanıcı Adı:");
        userLabel.setBounds(20, 20, 100, 25);
        add(userLabel);

        usernameField = new JTextField();
        usernameField.setBounds(120, 20, 140, 25);
        add(usernameField);

        JLabel passLabel = new JLabel("Şifre:");
        passLabel.setBounds(20, 60, 100, 25);
        add(passLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(120, 60, 140, 25);
        add(passwordField);

        loginButton = new JButton("Giriş Yap");
        loginButton.setBounds(90, 100, 100, 30);
        add(loginButton);

        statusLabel = new JLabel("");
        statusLabel.setBounds(20, 140, 250, 25);
        add(statusLabel);

        loginButton.addActionListener(e -> {
            String user = usernameField.getText();
            String pass = new String(passwordField.getPassword());

            if (user.equals("Murat") && pass.equals("123mrt123")) {
                currentUser = user;
                openMainPanel();
                dispose();
            } else {
                statusLabel.setText("Hatalı kullanıcı adı veya şifre!");
            }
        });

        setVisible(true);
    }

    private void openMainPanel() {
        JFrame panelFrame = new JFrame("MDC Ana Panel - Hoş geldin " + currentUser);
        panelFrame.setSize(500, 350);
        panelFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        panelFrame.setLayout(null);

        String[] options = {
                "Şüpheli Sorgulama",
                "Plaka Sorgulama",
                "Rapor Ekle",
                "Görev Belirle",
                "Kullanıcı Ekle"
        };

        JList<String> list = new JList<>(options);
        list.setBounds(30, 30, 200, 150);
        panelFrame.add(list);

        JButton secButton = new JButton("Seç");
        secButton.setBounds(250, 80, 100, 30);
        panelFrame.add(secButton);

        secButton.addActionListener(e -> {
            int selected = list.getSelectedIndex();
            switch (selected) {
                case 0 -> suspectSorgu();
                case 1 -> plakaSorgu();
                case 2 -> raporEkle();
                case 3 -> gorevBelirle();
                case 4 -> kullaniciEkle();
                default -> JOptionPane.showMessageDialog(panelFrame, "Lütfen bir işlem seçin.");
            }
        });

        panelFrame.setVisible(true);
    }

    private void suspectSorgu() {
        String tc = JOptionPane.showInputDialog("T.C. Kimlik Numarası girin:");
        if (tc == null) return;

        if (tc.equals("12345678901")) {
            JOptionPane.showMessageDialog(this, "Ad: Ahmet Yılmaz\nSuç Kaydı: Hırsızlık (2022)\nAranma Durumu: Aktif");
        } else if (tc.equals("98765432109")) {
            JOptionPane.showMessageDialog(this, "Ad: Elif Demir\nSuç Kaydı: Temiz\nAranma Durumu: Yok");
        } else {
            JOptionPane.showMessageDialog(this, "Kayıt bulunamadı.");
        }
    }

    private void plakaSorgu() {
        String plaka = JOptionPane.showInputDialog("Plaka girin (örn: 34ABC123):");
        if (plaka == null) return;

        if (plaka.equalsIgnoreCase("34ABC123")) {
            JOptionPane.showMessageDialog(this, "Araç Sahibi: Cem Karaca\nMarka: BMW\nÇalıntı Durumu: Hayır");
        } else if (plaka.equalsIgnoreCase("06XYZ789")) {
            JOptionPane.showMessageDialog(this, "Araç Sahibi: Sevim Kaya\nMarka: Mercedes\nÇalıntı Durumu: Çalıntı!");
        } else {
            JOptionPane.showMessageDialog(this, "Plaka bilgisi bulunamadı.");
        }
    }

    private void raporEkle() {
        String yazan = JOptionPane.showInputDialog("Raporu yazan kişi:");
        String lokasyon = JOptionPane.showInputDialog("Olay lokasyonu:");
        String olay = JOptionPane.showInputDialog("Olayı açıklayın:");
        String tarih = JOptionPane.showInputDialog("Tarih (örn: 25/04/2025 18:45):");

        JOptionPane.showMessageDialog(this, "Rapor Yazarı: " + yazan + "\nOlay: " + olay + "\nLokasyon: " + lokasyon + "\nTarih: " + tarih);
    }

    private void gorevBelirle() {
        String polis = JOptionPane.showInputDialog("Polisin adı:");
        String lokasyon = JOptionPane.showInputDialog("Görev lokasyonu:");

        JOptionPane.showMessageDialog(this, "TELSİZ: Memur " + polis + ", " + currentUser + " amir tarafından " + lokasyon + " görevine yönlendirildi.");
    }

    private void kullaniciEkle() {
        String mod = JOptionPane.showInputDialog("Ekleyen moderatör:");
        String uname = JOptionPane.showInputDialog("Yeni kullanıcı adı:");
        String pass = JOptionPane.showInputDialog("Yeni kullanıcı şifresi:");
        String rutbe = JOptionPane.showInputDialog("Yeni kullanıcı rütbesi:");

        JOptionPane.showMessageDialog(this, "Yeni kullanıcı eklendi!\nUsername: " + uname + "\nŞifre: " + pass + "\nRütbe: " + rutbe);
    }

    public static void main(String[] args) {
        new mdcGUI();
    }
}
