package com.comtrade.uslugeSoba;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.ComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.xml.crypto.dsig.dom.DOMValidateContext;

import com.danilo.domen.Soba;
import com.danilo.domen.User;
import com.danilo.domen.UslugeSoba;
import com.comtrade.kontrolerKI.KontrolerKI;
import com.comtrade.sobaForma.SobaForma;
import com.comtrade.hotelSlike.HotelFormaSlike;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UslugeSobaForma extends JFrame {
	int klikovi,klikovi1,klikovi2,klikovi3,klikovi4;
	private JPanel contentPane;
    private int idHotel;
    private User user;
	/**
	 * Launch the application.
	 * @param idHotel2 
	 * @param user 
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UslugeSobaForma frame = new UslugeSobaForma();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public UslugeSobaForma(int idHotel2, User user) {
		this.user=user;
		this.idHotel = idHotel2;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 0, 1364, 720);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JLabel lblNewLabel_1 = new JLabel("");
		
		JLabel lblChc3 = new JLabel("");
		lblChc3.setBounds(708, 211, 205, 171);
		contentPane.add(lblChc3);
		
		JLabel lblChc4 = new JLabel("");
		lblChc4.setBounds(1135, 220, 205, 171);
		contentPane.add(lblChc4);
		
		JLabel lblChc2 = new JLabel("");
		lblChc2.setBounds(969, 434, 205, 171);
		contentPane.add(lblChc2);
		
		JLabel lblChc = new JLabel("");
		lblChc.setBounds(388, 437, 205, 171);
		contentPane.add(lblChc);
		
		lblNewLabel_1.setBounds(252, 192, 205, 171);
		contentPane.add(lblNewLabel_1);
		 klikovi = 0;
		 klikovi1=0;
		 klikovi2=0;
		 klikovi3=0;
		 klikovi4=0;
		JLabel lblNewLabel = new JLabel("New label");
		 
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				klikovi++;
				if(klikovi%2 != 0) {
					lblNewLabel_1.setIcon(new ImageIcon(UslugeSobaForma.class.getResource("/slike/chc.png")));
					  validate();
				}else {
					lblNewLabel_1.setIcon(null);
					  validate();
				}
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				
				lblNewLabel.setEnabled(false);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblNewLabel.setEnabled(true);
			}
		
		});
		
		lblNewLabel.setIcon(new ImageIcon(UslugeSobaForma.class.getResource("/slike/wifi.png")));
		lblNewLabel.setBounds(82, 125, 232, 233);
		contentPane.add(lblNewLabel);
		lblNewLabel.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {

		
		//lblNewLabel.setVisible(false);
			}
		});
		JLabel lblPicSmoking = new JLabel("");
		lblPicSmoking.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblPicSmoking.setEnabled(false);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblPicSmoking.setEnabled(true);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				klikovi1++;
				if(klikovi1%2 != 0) {
					lblChc3.setIcon(new ImageIcon(UslugeSobaForma.class.getResource("/slike/chc.png")));
					
					  validate();
				}else {
					lblChc3.setIcon(null);
					  validate();
				}
				
			}
		});
		lblPicSmoking.setIcon(new ImageIcon(UslugeSobaForma.class.getResource("/slike/pljuge2.png")));
		lblPicSmoking.setBounds(539, 125, 256, 266);
		contentPane.add(lblPicSmoking);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblNewLabel_2.setEnabled(false);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblNewLabel_2.setEnabled(true);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				klikovi2++;
				if(klikovi2%2 != 0) {
					lblChc2.setIcon(new ImageIcon(UslugeSobaForma.class.getResource("/slike/chc.png")));
					
					  validate();
				}else {
					lblChc2.setIcon(null);
					  validate();
				}
			}
		});
		lblNewLabel_2.setIcon(new ImageIcon(UslugeSobaForma.class.getResource("/slike/keri2.png")));
		lblNewLabel_2.setBounds(815, 372, 256, 233);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblTerasa = new JLabel("");
		lblTerasa.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblTerasa.setEnabled(false);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblTerasa.setEnabled(true);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				klikovi3++;
				if(klikovi3%2 != 0) {
					lblChc.setIcon(new ImageIcon(UslugeSobaForma.class.getResource("/slike/chc.png")));
					
					  validate();
				}else {
					lblChc.setIcon(null);
					  validate();
				}
			}
		});
		lblTerasa.setIcon(new ImageIcon(UslugeSobaForma.class.getResource("/slike/balkonPng.png")));
		lblTerasa.setBounds(165, 362, 296, 233);
		contentPane.add(lblTerasa);
		
		JLabel lblTV = new JLabel("");
		lblTV.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblTV.setEnabled(false);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblTV.setEnabled(true);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				klikovi4++;
				if(klikovi4%2 != 0) {
					lblChc4.setIcon(new ImageIcon(UslugeSobaForma.class.getResource("/slike/chc.png")));
				
					  validate();
				}else {
					lblChc4.setIcon(null);
					  validate();
				}
			}
		});
		lblTV.setIcon(new ImageIcon(UslugeSobaForma.class.getResource("/slike/tv21.png")));
		lblTV.setBounds(974, 153, 296, 233);
		contentPane.add(lblTV);
		
		JButton btnNewButton = new JButton("Send");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UslugeSoba uslugeSoba = new UslugeSoba();
				List<Soba>listSoba = new ArrayList<>();
				try {
				listSoba = (List<Soba>) KontrolerKI.getInstanca().vratiPoslednjuSobuIzBaze().getServer_objekat_response();
					for(Soba sobaBaza : listSoba) {
						uslugeSoba.setIdSoba(sobaBaza.getIdSobe());
					}
				} catch (ClassNotFoundException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				} catch (IOException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				
				if(klikovi%2 == 0) {
					uslugeSoba.setWiFi(false);
				}else {
					uslugeSoba.setWiFi(true);
				}
				if(klikovi1%2 == 0) {
					uslugeSoba.setCigarette(false);
				}else {
					uslugeSoba.setCigarette(true);
				}
				if(klikovi2%2 == 0) {
					uslugeSoba.setPets(false);
				}else {
					uslugeSoba.setPets(true);
				}
				if(klikovi3%2 == 0) {
					uslugeSoba.setBalcony(false);
				}else {
					uslugeSoba.setBalcony(true);
				}
				if(klikovi4%2 == 0) {
					uslugeSoba.setTv(false);
				}else {
					uslugeSoba.setTv(true);
				}
				try {
					KontrolerKI.getInstanca().sacuvajUslugeSobe(uslugeSoba).getServer_objekat_response();
					novaSoba_da_ne();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton.setBounds(615, 562, 136, 36);
		contentPane.add(btnNewButton);

		JLabel lblBackgroundPic = new JLabel();
	lblBackgroundPic.setBounds(0, 10, 1364, 680);
		lblBackgroundPic.setIcon(new ImageIcon(UslugeSobaForma.class.getResource("/slike/genije.jpg")));
		contentPane.add(lblBackgroundPic);
		
		
		
		
		
		
		
		
		
		
		
	

	
		
	}

	protected void novaSoba_da_ne() {
		int opcija =   JOptionPane.showConfirmDialog(null, "Zelite li da unesete novu sobu za ovaj hotel?", "Postovani,", JOptionPane.YES_NO_OPTION);
    	int YES = 0;
    	if(opcija == YES) {
    		SobaForma sobaForma = new SobaForma(idHotel,user);
    		dispose();
    		sobaForma.setVisible(true);
    		
    	}else {
    		HotelFormaSlike hotelSlike = new HotelFormaSlike(idHotel,user);
    		dispose();
    		hotelSlike.setVisible(true);
    	}
		
	}
}
