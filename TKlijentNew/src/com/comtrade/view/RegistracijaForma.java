package com.comtrade.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;



import com.danilo.domen.User;
import com.comtrade.kontrolerKI.KontrolerKI;
import com.danilo.transferKlasa.TransferKlasa;
import com.comtrade.sajt.WebSite;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.JobAttributes;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

import javax.swing.JCheckBox;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ContainerAdapter;
import java.awt.event.ContainerEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.AncestorListener;
import javax.swing.event.AncestorEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JTextArea;

public class RegistracijaForma extends JFrame {

	private JPanel contentPane;
	private JTextField tfFullName;
	private JTextField tfEmail;
	private JTextField tfUsername;
	private JPasswordField pfPassword;
	private JTextArea pfConfirmPass;
    private JCheckBox chckbxNewCheckBox;
    private JPasswordField pfPassConfirm;
    private String password;

	public RegistracijaForma() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 402, 513);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setForeground(new Color(255, 215, 0));
		lblUsername.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
		lblUsername.setBounds(146, 212, 75, 14);
		contentPane.add(lblUsername);
		
		JLabel lblFullName = new JLabel("Full Name");
		lblFullName.setForeground(new Color(255, 215, 0));
		lblFullName.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
		lblFullName.setBounds(146, 101, 62, 14);
		contentPane.add(lblFullName);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setForeground(new Color(255, 215, 0));
		lblPassword.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
		lblPassword.setBounds(146, 269, 75, 14);
		contentPane.add(lblPassword);
		
		JLabel lblConfirmPassword = new JLabel("Confirm Password");
		lblConfirmPassword.setForeground(new Color(255, 215, 0));
		lblConfirmPassword.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
		lblConfirmPassword.setBounds(125, 322, 102, 14);
		contentPane.add(lblConfirmPassword);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setForeground(new Color(255, 215, 0));
		lblEmail.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
		lblEmail.setBounds(159, 154, 46, 14);
		contentPane.add(lblEmail);
		
		tfFullName = new JTextField();
		tfFullName.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tfFullName.setText("");
			}
		});
		
		tfFullName.setText("Enter your full name");
		tfFullName.setForeground(new Color(128, 128, 128));
		tfFullName.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
		tfFullName.setOpaque(false);
		tfFullName.setBorder(null);
		tfFullName.setBounds(51, 126, 279, 20);
		contentPane.add(tfFullName);
		tfFullName.setColumns(10);
		
		tfEmail = new JTextField();
		tfEmail.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				tfEmail.setText("");
			}
		});
		
		tfEmail.setText("Enter your email");
		tfEmail.setForeground(new Color(128, 128, 128));
		tfEmail.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
		tfEmail.setOpaque(false);
		tfEmail.setBorder(null);
		tfEmail.setColumns(10);
		tfEmail.setBounds(51, 181, 279, 20);
		contentPane.add(tfEmail);
		
		tfUsername = new JTextField();
		tfUsername.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				tfUsername.setText("");
			}
		});
		
		tfUsername.setText("Enter your username");
		tfUsername.setForeground(new Color(128, 128, 128));
		tfUsername.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
		tfUsername.setOpaque(false);
		tfUsername.setBorder(null);
		tfUsername.setColumns(10);
		tfUsername.setBounds(51, 238, 279, 20);
		contentPane.add(tfUsername);
		
		pfPassword = new JPasswordField();
		pfPassword.addFocusListener(new FocusAdapter() {
			
			@Override
			public void focusGained(FocusEvent arg0) {
				pfPassword.setText("");
				
			}
			@Override
			public void focusLost(FocusEvent arg0) {
				 password  =String.valueOf( pfPassword.getPassword());
				if(password.length()<8) {
					JOptionPane.showMessageDialog(null, "Sifra mora imati najmanje 8 karaktera");
					pfPassword.setText("");
					pfPassword.requestFocusInWindow();
				}
			}
		});
		
		pfPassword.setText("\u25CF\u25CF\u25CF\u25CF\u25CF\u25CF\u25CF\u25CF");
		pfPassword.setForeground(new Color(128, 128, 128));
		pfPassword.setOpaque(false);
		pfPassword.setBorder(null);
		pfPassword.setBounds(51, 294, 279, 20);
		contentPane.add(pfPassword);
	
		
		pfPassConfirm = new JPasswordField();
		pfPassConfirm.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(password.length()>8) {
				pfPassConfirm.setText("");
			}}
		});
		pfPassConfirm.setForeground(new Color(128, 128, 128));
		pfPassConfirm.setText("\u25CF\u25CF\u25CF\u25CF\u25CF\u25CF\u25CF\u25CF");
		pfPassConfirm.setBorder(null);
		pfPassConfirm.setOpaque(false);
		pfPassConfirm.setBounds(51, 342, 279, 20);
		contentPane.add(pfPassConfirm);
		
		JSeparator separator = new JSeparator();
		separator.setBackground(new Color(255, 215, 0));
		separator.setBounds(51, 144, 279, 2);
		contentPane.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBackground(new Color(255, 215, 0));
		separator_1.setBounds(51, 200, 279, 2);
		contentPane.add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBackground(new Color(255, 215, 0));
		separator_2.setBounds(51, 257, 279, 2);
		contentPane.add(separator_2);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setBackground(new Color(255, 215, 0));
		separator_3.setBounds(51, 312, 279, 2);
		contentPane.add(separator_3);
		
		JSeparator separator_4 = new JSeparator();
		separator_4.setBackground(new Color(255, 215, 0));
		separator_4.setBounds(51, 360, 279, 2);
		contentPane.add(separator_4);
		
		JLabel lblNaslov = new JLabel("Create a new Account");
		lblNaslov.setForeground(new Color(255, 250, 250));
		lblNaslov.setFont(new Font("Ravie", Font.PLAIN, 22));
		lblNaslov.setBounds(34, 11, 321, 25);
		contentPane.add(lblNaslov);
		
		JLabel lblPodNaslov = new JLabel("It's free and always will be");
		lblPodNaslov.setForeground(new Color(255, 250, 250));
		lblPodNaslov.setFont(new Font("Ravie", Font.PLAIN, 12));
		lblPodNaslov.setBounds(77, 47, 219, 14);
		contentPane.add(lblPodNaslov);
		
		JLabel lblZvezdaLevo = new JLabel("*");
		lblZvezdaLevo.setForeground(new Color(255, 215, 0));
		lblZvezdaLevo.setFont(new Font("Berlin Sans FB", Font.PLAIN, 34));
		lblZvezdaLevo.setBounds(55, 47, 46, 25);
		contentPane.add(lblZvezdaLevo);
		
		JLabel lblZvezdaDesno = new JLabel("*");
		lblZvezdaDesno.setForeground(new Color(255, 215, 0));
		lblZvezdaDesno.setFont(new Font("Berlin Sans FB", Font.PLAIN, 34));
		lblZvezdaDesno.setBounds(302, 47, 39, 25);
		contentPane.add(lblZvezdaDesno);
		
		JLabel lblAgree = new JLabel("Agree");
		lblAgree.setForeground(new Color(255, 250, 250));
		lblAgree.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
		lblAgree.setBounds(72, 373, 46, 24);
		contentPane.add(lblAgree);
		
		JLabel lblUslovi = new JLabel("<html>\r\n<head>\r\n<body> \r\n<u> Terms and conditions </u>\r\n</body>\r\n</head>\r\n<html>");
		lblUslovi.setForeground(new Color(255, 215, 0));
		lblUslovi.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
		lblUslovi.setBounds(116, 379, 138, 14);
		contentPane.add(lblUslovi);
		
		JLabel lblNewLabel = new JLabel("Send");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String username = tfUsername.getText();
				String email = tfEmail.getText();
				String fullName = tfFullName.getText();
				String confirmPass =String.copyValueOf(pfPassConfirm.getPassword());
				if(chckbxNewCheckBox.isSelected()) {
					if(password.equals(confirmPass)) {
						User user = new User();
						user.setEmail(email);
						user.setFullName(fullName);
						user.setUsername(username);
						user.setPassword(password);
						try {
							TransferKlasa tk = KontrolerKI.getInstanca().sacuvajUser(user);
							String poruka = tk.getPoruka();
							JOptionPane.showMessageDialog(null, poruka);
							
							LogovanjeForma lf = new LogovanjeForma(user);
							lf.setVisible(true);
						} catch (ClassNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				}else {
					JOptionPane.showMessageDialog(null, "Uslovi sajta nisu prihvaceni");
				}
			}
		});
		lblNewLabel.setForeground(new Color(255, 250, 250));
		lblNewLabel.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
		lblNewLabel.setBounds(175, 426, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel btnSend = new JLabel("New label");
		btnSend.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		btnSend.setIcon(new ImageIcon(RegistracijaForma.class.getResource("/slike/DugmePosalji.png")));
		btnSend.setBounds(125, 414, 126, 38);
		contentPane.add(btnSend);
		
	    chckbxNewCheckBox = new JCheckBox("");
		chckbxNewCheckBox.setOpaque(false);
		chckbxNewCheckBox.setBounds(51, 374, 21, 23);
		contentPane.add(chckbxNewCheckBox);
		
		JLabel lbl_bcg_pic = new JLabel("New label");
		lbl_bcg_pic.setIcon(new ImageIcon(RegistracijaForma.class.getResource("/slike/registrac.png")));
		lbl_bcg_pic.setBounds(0, -11, 414, 502);
		contentPane.add(lbl_bcg_pic);
	}
}
