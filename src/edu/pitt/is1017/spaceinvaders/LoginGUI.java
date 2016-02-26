package edu.pitt.is1017.spaceinvaders;

import javax.swing.*;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JTextArea;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginGUI {

	private JFrame mainFrame;
	private JLabel lblEmail;
	private JLabel lblPassword;
	private JTextField txtEmail;
	private JTextField txtPassword;
	private JButton btnRegister;
	private JButton btnLogin;
	private JButton btnCancel;

	public static void main(String[] args) {
		LoginGUI gui = new LoginGUI();
	}

	public LoginGUI() {
		init();
	}

	public void init() {
		mainFrame = new JFrame("SpaceInvaders - Login");
		mainFrame.setSize(440, 300);
		mainFrame.setLayout(null);

		lblEmail = new JLabel("Email:");
		lblEmail.setBounds(30, 30, 150, 40);
		mainFrame.add(lblEmail);

		lblPassword = new JLabel("Password:");
		lblPassword.setBounds(30, 80, 150, 40);
		mainFrame.add(lblPassword);

		txtEmail = new JTextField();
		txtEmail.setBounds(160, 39, 220, 22);
		mainFrame.add(txtEmail);
		txtEmail.setColumns(10);

		txtPassword = new JTextField();
		txtPassword.setColumns(10);
		txtPassword.setBounds(160, 89, 220, 22);
		mainFrame.add(txtPassword);

		btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				RegisterGUI newReg = new RegisterGUI();
			}
		});
		btnRegister.setBounds(30, 130, 90, 25);
		mainFrame.add(btnRegister);

		btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String email = txtEmail.getText();
				String password = txtPassword.getText();
				User user = new User(email, password);
				if (user.isLoggedIn()) {
					JOptionPane.showMessageDialog(null, "Login Successfull "
							+ user.getFirstName() + "!");

					Thread t = new Thread("Game Launch Thread") {
						public void run() {
							ScoreTracker st = new ScoreTracker(user);
							Game g = new Game(user);
							g.gameLoop();
						}
					};

					t.start();
				} else {
					JOptionPane.showMessageDialog(null, "Login Failed");
				}
			}
		});
		btnLogin.setBounds(160, 130, 90, 25);
		mainFrame.add(btnLogin);

		btnCancel = new JButton("Cancel");
		btnCancel.setBounds(290, 130, 90, 25);
		mainFrame.add(btnCancel);
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		mainFrame.add(btnCancel);
		mainFrame.setLocation(200, 300);

		mainFrame.setVisible(true);

		// exits program if you close the window
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
