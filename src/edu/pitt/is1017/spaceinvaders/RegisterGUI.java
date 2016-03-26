package edu.pitt.is1017.spaceinvaders;

import javax.swing.*;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RegisterGUI 
{
	private JFrame mainFrame;
	private JTextField txtLastName;
	private JTextField txtEmail;
	private JTextField txtPassword;
	private JTextField txtConPassword;
	private JTextField txtFirstName;
	private JLabel lblFirstName;
	private JLabel lblLastName;
	private JLabel lblEmail;
	private JLabel lblPassword;
	private JLabel lblConPassword;
	private JButton btnRegister;
	private JButton btnCancel;
	

	public RegisterGUI()
	{
		init();
		mainFrame.setVisible(true);
	}

	public void init()
	{
		mainFrame = new JFrame("SpaceInvaders - Registration");
		mainFrame.setSize(415,300);
		mainFrame.getContentPane().setLayout(null);
		
		lblFirstName = new JLabel("First Name:");
		lblFirstName.setBounds(30, 30, 110, 20);
		mainFrame.getContentPane().add(lblFirstName);
		
		lblLastName = new JLabel("Last Name:");
		lblLastName.setBounds(30, 60, 110, 20);
		mainFrame.getContentPane().add(lblLastName);
		
		lblEmail = new JLabel("Email:");
		lblEmail.setBounds(30, 90, 110, 20);
		mainFrame.getContentPane().add(lblEmail);
		
		lblPassword = new JLabel("Password:");
		lblPassword.setBounds(30, 120, 110, 20);
		mainFrame.getContentPane().add(lblPassword);
		
		lblConPassword = new JLabel("Confirm Password:");
		lblConPassword.setBounds(30,150,110,20);
		mainFrame.getContentPane().add(lblConPassword);
		
		btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			//create instance of user call appropriate constructor
				User user = new User(txtFirstName.getText(),txtLastName.getText(),txtEmail.getText(),txtPassword.getText());
				user.saveUserInfo();
			}	
		});
		btnRegister.setBounds(150, 192, 100, 25);
		mainFrame.getContentPane().add(btnRegister);
		
		btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			mainFrame.dispose();
			}
		});
		btnCancel.setBounds(265, 192, 100, 25);
		mainFrame.getContentPane().add(btnCancel);
		
		txtFirstName = new JTextField();
		txtFirstName.setBounds(150, 29, 215, 22);
		mainFrame.getContentPane().add(txtFirstName);
		txtFirstName.setColumns(10);
		
		txtLastName = new JTextField();
		txtLastName.setBounds(150, 59, 215, 22);
		mainFrame.getContentPane().add(txtLastName);
		txtLastName.setColumns(10);
		
		txtEmail = new JTextField();
		txtEmail.setText("");
		txtEmail.setBounds(150, 89, 215, 22);
		mainFrame.getContentPane().add(txtEmail);
		txtEmail.setColumns(10);
		
		txtPassword = new JTextField();
		txtPassword.setBounds(150, 119, 215, 22);
		mainFrame.getContentPane().add(txtPassword);
		txtPassword.setColumns(10);
		
		txtConPassword = new JTextField();
		txtConPassword.setBounds(150, 149, 215, 22);
		mainFrame.getContentPane().add(txtConPassword);
		txtConPassword.setColumns(10);
		
		mainFrame.setVisible(true);
		
		//exits program if you close the window
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
