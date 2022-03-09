package com.comtrade.vrstaObjekta;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.danilo.domen.User;
import com.comtrade.hotelForma.HotelForma;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class VrstaObjektaForma extends JFrame {

	private JPanel contentPane;
private User user;
	
	public VrstaObjektaForma(User user) {
		this.user = user;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 741, 525);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				otvaranjeHotelForme();
			}

			
		});
		lblNewLabel.setIcon(new ImageIcon(VrstaObjektaForma.class.getResource("/slike/hotel1.jpg")));
		lblNewLabel.setBounds(38, 105, 223, 168);
		contentPane.add(lblNewLabel);
		
		JLabel lblHotel = new JLabel("Hotel");
		lblHotel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				otvaranjeHotelForme();
			}
		});
		lblHotel.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblHotel.setBounds(124, 274, 46, 14);
		contentPane.add(lblHotel);
		
		JLabel lblIzaberiteVrstuVaseg = new JLabel("Izaberite vrstu vaseg objekta");
		lblIzaberiteVrstuVaseg.setFont(new Font("Times New Roman", Font.PLAIN, 28));
		lblIzaberiteVrstuVaseg.setBounds(226, 11, 356, 37);
		contentPane.add(lblIzaberiteVrstuVaseg);
	}


	protected void otvaranjeHotelForme() {
		dispose();
		HotelForma uhf = new HotelForma(user);
		uhf.setVisible(true);
		
	}
}
