/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany._almawulansaptaningrum_kuispbo_if.g;

/**
 *
 * @author Lenovo
 */
import javax.swing.*;
import java.awt.event.*;

class MainPage extends JFrame implements ActionListener {
    JTextField nameField = new JTextField();
    JTextField idField = new JTextField();
    JTextField malamField = new JTextField();
    JComboBox<String> kamarBox;
    JCheckBox sarapanBox = new JCheckBox("Sarapan (+Rp 50.000)");
    JCheckBox kolamBox = new JCheckBox("Kolam Renang (+Rp 100.000)");
    JCheckBox spaBox = new JCheckBox("Spa (+Rp 200.000)");
    JButton pesanButton = new JButton("Pesan");
    JButton logoutButton = new JButton("Logout");

    public MainPage(String username) {
        setTitle("Reservasi Hotel");
        setSize(400, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        JLabel nameLabel = new JLabel("Nama:");
        JLabel idLabel = new JLabel("Identitas:");
        JLabel malamLabel = new JLabel("Jumlah Malam:");
        JLabel kamarLabel = new JLabel("Pilih Kamar:");
        JLabel addOnLabel = new JLabel("Fasilitas Tambahan:");

        nameLabel.setBounds(50, 20, 100, 25);
        nameField.setBounds(150, 20, 200, 25);
        idLabel.setBounds(50, 50, 100, 25);
        idField.setBounds(150, 50, 200, 25);
        malamLabel.setBounds(50, 80, 100, 25);
        malamField.setBounds(150, 80, 200, 25);
        kamarLabel.setBounds(50, 110, 100, 25);
        addOnLabel.setBounds(50, 180, 150, 25);

        String[] kamar = {"Standard", "Deluxe", "Suite"};
        kamarBox = new JComboBox<>(kamar);
        kamarBox.setBounds(150, 110, 200, 25);

        sarapanBox.setBounds(50, 210, 200, 25);
        kolamBox.setBounds(50, 240, 200, 25);
        spaBox.setBounds(50, 270, 200, 25);

        pesanButton.setBounds(50, 310, 100, 30);
        logoutButton.setBounds(200, 310, 100, 30);
        pesanButton.addActionListener(this);
        logoutButton.addActionListener(this);

        add(nameLabel);
        add(nameField);
        add(idLabel);
        add(idField);
        add(malamLabel);
        add(malamField);
        add(kamarLabel);
        add(kamarBox);
        add(addOnLabel);
        add(sarapanBox);
        add(kolamBox);
        add(spaBox);
        add(pesanButton);
        add(logoutButton);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == pesanButton) {
            try {
                // input2
                String name = nameField.getText();
                int id = Integer.parseInt(idField.getText());
                int malam = Integer.parseInt(malamField.getText());
                // error handling
                if (name.isEmpty() || malam < 1) {
                    throw new Exception("Nama harus diisi dan jumlah malam tidak boleh kosong");
                }
                // buat milih jenis kamar
                int hargaKamar = 0;
                switch (kamarBox.getSelectedIndex()) {
                    case 0: hargaKamar = 300000; 
                    break;
                    case 1: hargaKamar = 500000; 
                    break;
                    case 2: hargaKamar = 1500000; 
                    break;
                }

                int hargaFasilitas = 0;
                // set harga per fasilitas
                if (sarapanBox.isSelected()) hargaFasilitas += 50000;
                if (kolamBox.isSelected()) hargaFasilitas += 100000;
                if (spaBox.isSelected()) hargaFasilitas += 200000;

                int hargaBiasa = (hargaKamar * malam); //harga kamar dikali berapa lama nginep
                int totalPrice = hargaBiasa + hargaFasilitas; //total harga kamar ditambah add on/fasilitas

                // halaman/pop out after submit
                JOptionPane.showMessageDialog(this, "Reservasi Berhasil!\n" +
                        "\nNama: " + name + "\n" +
                        "Identitas: " + id + "\n" +
                        "Lama Inap: " + malam + " malam" +
                        "\nHarga Kamar: " + hargaKamar + " x " + malam + " = Rp. " + hargaBiasa +
                        "\nFasilitas Tambahan: Rp. " + hargaFasilitas +
                        "\nTotal Harga: Rp. " + totalPrice);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Masukkan angka untuk Identitas dan Jumlah Malam");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage());
            }
        } else if (e.getSource() == logoutButton) { //log out
            new LoginPage();
            this.dispose();
        }
    }
}
