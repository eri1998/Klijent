package com.comtrade.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.danilo.domen.User;
import com.comtade.proxy.IProxy;
import com.comtade.proxy.ProxyLogovanje;

import com.comtrade.sajt.WebSite;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.JPasswordField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class LogovanjeForma extends JFrame {

	private JPanel contentPane;
	private JTextField tfUsername;
	private JPasswordField pfPassword;
   private static User userr;
	 
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LogovanjeForma frame = new LogovanjeForma(userr);
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public LogovanjeForma(User user1) {
		this.userr=user1;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 747, 555);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JSeparator separator = new JSeparator();
		separator.setBackground(new Color(255, 215, 0));
		separator.setBounds(401, 189, 251, 2);
		contentPane.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBackground(new Color(255, 215, 0));
		separator_1.setBounds(401, 256, 251, 2);
		contentPane.add(separator_1);
		
		pfPassword = new JPasswordField();
		pfPassword.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				pfPassword.setText("");
			}
		});
		
		JLabel lblSend = new JLabel("Send");
		lblSend.setForeground(new Color(240, 248, 255));
		lblSend.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
		lblSend.setBounds(507, 292, 37, 21);
		contentPane.add(lblSend);
		
		JLabel lblRegister = new JLabel("Register");
		lblRegister.setForeground(new Color(240, 248, 255));
		lblRegister.setFont(new Font("Berlin Sans FB", Font.PLAIN, 18));
		lblRegister.setBounds(484, 317, 73, 20);
		contentPane.add(lblRegister);
		pfPassword.setForeground(new Color(128, 128, 128));
		pfPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		pfPassword.setText("\u25CF\u25CF\u25CF\u25CF\u25CF\u25CF\u25CF\u25CF\u25CF\u25CF\u25CF\u25CF\u25CF\u25CF\u25CF");
		pfPassword.setBorder(null);
		pfPassword.setOpaque(false);
		pfPassword.setBounds(401, 239, 251, 20);
		contentPane.add(pfPassword);
		
		tfUsername = new JTextField();
		tfUsername.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				tfUsername.setText("");
			}
		});
		tfUsername.setText("Enter your username");
		tfUsername.setOpaque(false);
		tfUsername.setForeground(new Color(128, 128, 128));
		tfUsername.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
		tfUsername.setBorder(null);
		tfUsername.setBounds(401, 169, 251, 20);
		contentPane.add(tfUsername);
		tfUsername.setColumns(10);
		
		JLabel btnSend = new JLabel("New label");
		btnSend.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String username = tfUsername.getText();
				String password =String.copyValueOf( pfPassword.getPassword());
				User user = new User();
				user.setUsername(username);
				user.setPassword(password);
				IProxy iProxy = new ProxyLogovanje();
				try {
					iProxy.login(user);
 					if(userr.getEmail() != null) {
 						dispose();
 					}else {
 						pfPassword.requestFocusInWindow();
 					}
		
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnSend.setIcon(new ImageIcon(LogovanjeForma.class.getResource("/slike/DugmePosalji.png")));
		btnSend.setBounds(456, 285, 129, 36);
		contentPane.add(btnSend);
		
		JLabel btnRegister = new JLabel("New label");
		btnRegister.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				RegistracijaForma rf = new RegistracijaForma();
				rf.setVisible(true);
				dispose();
						}
		});
		btnRegister.setIcon(new ImageIcon(LogovanjeForma.class.getResource("/slike/registruj se.png")));
		btnRegister.setBounds(436, 297, 173, 43);
		contentPane.add(btnRegister);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Berlin Sans FB", Font.PLAIN, 12));
		lblUsername.setForeground(new Color(245, 245, 245));
		lblUsername.setBounds(484, 144, 71, 14);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Berlin Sans FB", Font.PLAIN, 12));
		lblPassword.setForeground(new Color(245, 245, 245));
		lblPassword.setBounds(484, 211, 71, 14);
		contentPane.add(lblPassword);
		
		JLabel lbl_pic_right = new JLabel("");
		lbl_pic_right.setIcon(new ImageIcon(LogovanjeForma.class.getResource("/slike/izgledFormeDesno.png")));
		lbl_pic_right.setBounds(353, 0, 368, 492);
		contentPane.add(lbl_pic_right);
		
		JLabel lbl_pic_left = new JLabel("");
		lbl_pic_left.setIcon(new ImageIcon(LogovanjeForma.class.getResource("/slike/slikaFormeLevoo.png")));
		lbl_pic_left.setBounds(0, -16, 409, 524);
		contentPane.add(lbl_pic_left);
	}
}
