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

public class LoginPage extends JFrame implements ActionListener {
    JLabel usernameLabel = new JLabel("Username:");
    JLabel passwordLabel = new JLabel("Password:");
    JTextField usernameTextField = new JTextField();
    JPasswordField passwordTextField = new JPasswordField();
    JButton buttonLogin = new JButton("Login");

    public LoginPage() {
        setTitle("Halaman Login");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        usernameLabel.setBounds(50, 50, 100, 25);
        usernameTextField.setBounds(150, 50, 200, 25);
        passwordLabel.setBounds(50, 90, 100, 25);
        passwordTextField.setBounds(150, 90, 200, 25);
        buttonLogin.setBounds(150, 140, 100, 30);
        buttonLogin.addActionListener(this);

        add(usernameLabel);
        add(usernameTextField);
        add(passwordLabel);
        add(passwordTextField);
        add(buttonLogin);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String username = usernameTextField.getText();
        String password = new String(passwordTextField.getPassword());

        if (username.equals("123230101") && password.equals("ifkelasg")) {
            JOptionPane.showMessageDialog(this, "Login Berhasil!");
            new MainPage(username);
            dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Login Gagal!");
        }
    }
}
