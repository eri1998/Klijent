package com.comtrade.hotelForma;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.TrayIcon.MessageType;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import com.danilo.domen.Adresa;
import com.danilo.domen.Drzava;
import com.danilo.domen.Grad;
import com.danilo.domen.Hotel;
import com.danilo.domen.User;
import com.comtrade.kontrolerKI.KontrolerKI;
import com.comtrade.sobaForma.SobaForma;
import com.danilo.transferKlasa.TransferKlasa;
import com.comtrade.view.LogovanjeForma;
import com.comtrade.view.RegistracijaForma;

import javax.swing.border.LineBorder;
import javax.swing.AbstractAction;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import java.io.IOException;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class HotelForma extends JFrame{
		private JPanel contentPane;
		private JTextField tfNazivHotela;
		private JComboBox comboBox,comboBoxTwo;
		private List<Drzava>list;
		private List<Grad>listGrad;
		private List<Adresa>listAdresa;
		private  User user;
		private JTextField tfGrad;
		private JTextField tfAdresa;
		private JTextField tfBroj;
	    private JTextField tfNotification;
	    private JTextField tfNotifiDrzava;
	    private JTextField tfNotifiUlica;
	    private JTextField tfNotifiGrad;
	    private JTextField tfNotifiBroj;
	    private JTextField tfNotifiHotel;
	   private int idHotel;
	   

	    

		
		public HotelForma(User user) {
			this.user = user;
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(0, 0, 1150, 730);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			contentPane.setLayout(null);
		
			JLabel lblNazivHotela = new JLabel("Unesite naziv vaseg hotela ? ");
			lblNazivHotela.setForeground(new Color(255, 250, 250));
			lblNazivHotela.setFont(new Font("Berlin Sans FB", Font.PLAIN, 26));
			lblNazivHotela.setBounds(404, 53, 357, 30);
			contentPane.add(lblNazivHotela);
			
			JLabel lblBrojZvezdica = new JLabel("Broj zvezdica ?");
			lblBrojZvezdica.setForeground(new Color(255, 250, 250));
			lblBrojZvezdica.setFont(new Font("Berlin Sans FB", Font.PLAIN, 26));
			lblBrojZvezdica.setBounds(452, 118, 200, 30);
			contentPane.add(lblBrojZvezdica);
			
			
			tfNotifiHotel = new JTextField();
			tfNotifiHotel.setText("Ovo polje je obavezno");
			tfNotifiHotel.setForeground(new Color(255, 69, 0));
			tfNotifiHotel.setFont(new Font("Times New Roman", Font.PLAIN, 18));
			tfNotifiHotel.setColumns(10);
			tfNotifiHotel.setBorder(new LineBorder(Color.RED));
			tfNotifiHotel.setBackground(Color.BLACK);
			tfNotifiHotel.setBounds(644, 83, 173, 30);
			tfNotifiHotel.setVisible(false);
			tfNotifiHotel.setEditable(false);
			contentPane.add(tfNotifiHotel);
			
			tfNazivHotela = new JTextField();
			tfNazivHotela.setFont(new Font("Times New Roman", Font.PLAIN, 18));
			tfNazivHotela.setOpaque(false);
			tfNazivHotela.setForeground(new Color(255, 215, 0));
			tfNazivHotela.setColumns(10);
			tfNazivHotela.setCaretColor(new Color(255, 250, 250));
			tfNazivHotela.setBorder(new LineBorder(new Color(255, 250, 250), 2));
			tfNazivHotela.setBackground(new Color(255, 250, 250));
			tfNazivHotela.setBounds(274, 83, 543, 30);
			contentPane.add(tfNazivHotela);
		    comboBox = new JComboBox();
		 
		comboBox.setForeground(new Color(255, 215, 0));
		comboBox.setBackground(new Color(25, 25, 112));
		comboBox.addItem("Izaberi");
		comboBox.addItem("\u2605");
		comboBox.addItem("\u2605\u2605");
		comboBox.addItem("\u2605\u2605\u2605");
		comboBox.addItem("\u2605\u2605\u2605\u2605");
		comboBox.addItem("\u2605\u2605\u2605\u2605\u2605");
		comboBox.setBounds(462, 146, 129, 20);
		contentPane.add(comboBox);
		
		JLabel lblGdeSeNalazi = new JLabel("Gde se nalazi vas objekat?");
		lblGdeSeNalazi.setForeground(new Color(255, 215, 0));
		lblGdeSeNalazi.setFont(new Font("Berlin Sans FB", Font.PLAIN, 32));
		lblGdeSeNalazi.setBounds(134, 232, 357, 30);
		contentPane.add(lblGdeSeNalazi);
		
		JLabel lblDrzava = new JLabel("Drzava");
		lblDrzava.setForeground(new Color(255, 250, 250));
		lblDrzava.setFont(new Font("Berlin Sans FB", Font.PLAIN, 26));
		lblDrzava.setBounds(313, 320, 200, 30);
		contentPane.add(lblDrzava);
		
		JLabel lblGrad = new JLabel("Grad");
		lblGrad.setForeground(new Color(255, 250, 250));
		lblGrad.setFont(new Font("Berlin Sans FB", Font.PLAIN, 26));
		lblGrad.setBounds(325, 372, 200, 30);
		contentPane.add(lblGrad);
		
		JLabel lblUlica = new JLabel("Ulica");
		lblUlica.setForeground(new Color(255, 250, 250));
		lblUlica.setFont(new Font("Berlin Sans FB", Font.PLAIN, 26));
		lblUlica.setBounds(325, 437, 193, 30);
		contentPane.add(lblUlica);
		
		JLabel lblBroj = new JLabel("Broj");
		lblBroj.setForeground(new Color(255, 250, 250));
		lblBroj.setFont(new Font("Berlin Sans FB", Font.PLAIN, 26));
		lblBroj.setBounds(332, 497, 193, 30);
		contentPane.add(lblBroj);
		
		 comboBoxTwo = new JComboBox();
		 comboBoxTwo.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent arg0) {
		 		if(comboBoxTwo.getSelectedItem().equals("Drzava")) {
		 			tfNotifiDrzava.setVisible(true);
		 		}else {
		 			tfNotifiDrzava.setVisible(false);
		 		}
		 	}
		 });
		 comboBoxTwo.setModel(new DefaultComboBoxModel(new String[] { "Drzava", "Albanija", "Al\u017Eir",
					"Andora", "Angola", "Antigva i Barbuda", "Argentina", "Australija", "Austrija", "Avganistan",
					"Azerbejd\u017Ean", "Bahame", "Bahrein", "Banglade\u0161", "Barbados", "Belgija", "Belize",
					"Belorusija", "Benin", "Bermuda", "Bocvana", "Bolivija", "Bosna i Hercegovina", "Brazil", "Brunej",
					"Bugarska", "Burkina Faso", "Burundi", "Butan", "Centralnoafri\u010Dka Republika", "Crna Gora",
					"\u010Cad", "\u010Ce\u0161ka", "\u010Cile", "Danska", "Dominika", "Dominikanska Republika",
					"D\u017Eibuti", "Egipat", "Ekvador", "Ekvatorijalna Gvineja", "Eritreja", "Etiopija", "Estonija",
					"Fid\u017Ei", "Filipini", "Finska", "Francuska", "Gabon", "Gambija", "Gana", "Gr\u010Dka", "Grenada",
					"Gruzija", "Gvajana", "Gvatemala", "Gvineja", "Gvineja Bisao", "Haiti", "Holandija", "Honduras",
					"Hrvatska", "Indija", "Indonezija", "Irak", "Iran", "Irska, Republika", "Island", "Isto\u010Dni Timor",
					"Italija", "Izrael", "Jamajka", "Japan", "Jemen", "Jermenija", "Jordan", "Ju\u017Ena Koreja",
					"Ju\u017Enoafri\u010Dka Republika", "Kambod\u017Ea", "Kamerun", "Kanada", "Katar", "Kazahstan",
					"Kenija", "Kina", "Kipar", "Kirgistan", "Kiribati", "Kolumbija", "Komori",
					"Kongo, Demokratska Republika", "Kongo, Republika", "Kostarika", "Kuba", "Kuvajt", "Laos", "Lesoto",
					"Letonija", "Liban", "Liberija", "Libija", "Lihten\u0161tajn", "Litvanija", "Luksemburg", "Madagaskar",
					"Ma\u0111arska", "Malavi", "Maldivi", "Malezija", "Mali", "Malta", "Maroko", "Mauricijus",
					"Mauritanija", "Meksiko", "Mikronezija", "Mjanmar", "Moldavija", "Monako", "Mongolija", "Mozambik",
					"Namibija", "Nauru", "Nema\u010Dka", "Nepal", "Niger", "Nigerija", "Nikaragva", "Norve\u0161ka",
					"Novi Zeland", "Obala Slonova\u010De", "Oman", "Pakistan", "Palau", "Panama", "Papua Nova Gvineja",
					"Paragvaj", "Peru", "Poljska", "Portugal", "Ruanda", "Rumunija", "Rusija", "Salvador", "Samoa",
					"San Marino", "Sao Tome i Prinsipe", "Saudijska Arabija", "Sej\u0161eli", "Senegal", "Severna Koreja",
					"Severna Makedonija", "Sijera Leone", "Singapur", "Sirija", "Sjedinjene Ameri\u010Dke Dr\u017Eave",
					"Slova\u010Dka", "Slovenija", "Solomonova Ostrva", "Somalija", "Srbija", "Sudan", "Surinam",
					"Svazilend", "Sveta Lucija", "Sveti Kristofer i Nevis", "Sveti Vinsent i Grenadini", "\u0160panija",
					"\u0160ri Lanka", "\u0160vajcarska", "\u0160vedska", "Tad\u017Eikistan", "Tajland", "Tanzanija", "Togo",
					"Tonga", "Trinidad i Tobago", "Tunis", "Turkmenistan", "Turska", "Tuvalu", "Uganda",
					"Ujedinjeni Arapski Emirati", "Ujedinjeno Kraljevstvo", "Ukrajina", "Urugvaj", "Uzbekistan", "Vanuatu",
					"Vatikan", "Venecuela", "Vijetnam", "Zair", "Zambija", "Zelenortska Ostrva", "Zimbabve" }));
		 comboBoxTwo.setBounds(295, 352, 129, 20);
		contentPane.add(comboBoxTwo);
		
		
		
		
		
		tfNotifiUlica = new JTextField();
		tfNotifiUlica.setDisabledTextColor(new Color(255, 69, 0));
		tfNotifiUlica.setText("Ovo polje je obavezno");
		tfNotifiUlica.setForeground(new Color(255, 69, 0));
		tfNotifiUlica.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		tfNotifiUlica.setBackground(Color.BLACK);
		tfNotifiUlica.setBorder(new LineBorder(new Color(255, 0, 0)));
		tfNotifiUlica.setBounds(479, 467, 173, 30);
		tfNotifiUlica.setVisible(false);
		tfNotifiUlica.setEnabled(false);
		contentPane.add(tfNotifiUlica);
		tfNotifiUlica.setColumns(10);
		
		tfNotifiGrad = new JTextField();
		tfNotifiGrad.setDisabledTextColor(new Color(255, 69, 0));
		tfNotifiGrad.setSelectionColor(Color.ORANGE);
		tfNotifiGrad.setText("Ovo polje je obavezno");
		tfNotifiGrad.setForeground(Color.ORANGE);
		tfNotifiGrad.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		tfNotifiGrad.setBackground(Color.BLACK);
		tfNotifiGrad.setBorder(new LineBorder(Color.RED, 1));
		tfNotifiGrad.setBounds(479, 407, 173, 30);
		tfNotifiGrad.setVisible(false);
		tfNotifiGrad.setEnabled(false);
		contentPane.add(tfNotifiGrad);
		tfNotifiGrad.setColumns(10);
		
		tfNotifiBroj = new JTextField();
		tfNotifiBroj.setDisabledTextColor(new Color(255, 69, 0));
		tfNotifiBroj.setText("Ovo polje je obavezno");
		tfNotifiBroj.setForeground(new Color(255, 69, 0));
		tfNotifiBroj.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		tfNotifiBroj.setBackground(Color.BLACK);
		tfNotifiBroj.setBorder(new LineBorder(Color.RED, 1));
		tfNotifiBroj.setBounds(479, 525, 173, 30);
		tfNotifiBroj.setVisible(false);
		tfNotifiBroj.setEnabled(false);
		contentPane.add(tfNotifiBroj);
		tfNotifiBroj.setColumns(10);
		
		tfGrad = new JTextField();
		tfGrad.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		tfGrad.setOpaque(false);
		tfGrad.setForeground(new Color(255, 215, 0));
		tfGrad.setColumns(10);
		tfGrad.setCaretColor(new Color(255, 250, 250));
		tfGrad.setBorder(new LineBorder(new Color(255, 250, 250), 2));
		tfGrad.setBackground(new Color(255, 250, 250));
		tfGrad.setBounds(109, 407, 543, 30);
		contentPane.add(tfGrad);
		
		tfAdresa = new JTextField();
		tfAdresa.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		tfAdresa.setOpaque(false);
		tfAdresa.setForeground(new Color(255, 215, 0));
		tfAdresa.setColumns(10);
		tfAdresa.setCaretColor(new Color(255, 250, 250));
		tfAdresa.setBorder(new LineBorder(new Color(255, 250, 250), 2));
		tfAdresa.setBackground(new Color(255, 250, 250));
		tfAdresa.setBounds(109, 467, 543, 30);
		contentPane.add(tfAdresa);
		
		tfBroj = new JTextField();
		tfBroj.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		tfBroj.setOpaque(false);
		tfBroj.setForeground(new Color(255, 215, 0));
		tfBroj.setColumns(10);
		tfBroj.setCaretColor(new Color(255, 250, 250));
		tfBroj.setBorder(new LineBorder(new Color(255, 250, 250), 2));
		tfBroj.setBackground(new Color(255, 250, 250));
		tfBroj.setBounds(109, 525, 543, 30);
		contentPane.add(tfBroj);
		
		tfNotification = new JTextField();
		tfNotification.setDisabledTextColor(new Color(255, 69, 0));
		tfNotification.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		tfNotification.setForeground(new Color(255, 69, 0));
		tfNotification.setBounds(598, 146, 173, 20);
		tfNotification.setColumns(10);
		tfNotification.setOpaque(true);
		tfNotification.setBorder(new LineBorder(Color.RED,1));
		tfNotification.setEditable(false);
		tfNotification.setVisible(false);
		contentPane.add(tfNotification);
		
		


		
		tfNotifiDrzava = new JTextField();
		tfNotifiDrzava.setText("Ovo polje je obavezno");
		tfNotifiDrzava.setForeground(new Color(255, 69, 0));
		tfNotifiDrzava.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		tfNotifiDrzava.setBackground(Color.BLACK);
		tfNotifiDrzava.setBorder(new LineBorder(Color.RED, 1));
		tfNotifiDrzava.setBounds(427, 352, 173, 20);
		tfNotifiDrzava.setVisible(false);
		contentPane.add(tfNotifiDrzava);
		tfNotifiDrzava.setColumns(10);
		 		JButton btnNext = new JButton(new AbstractAction("Next"){ 
			@Override
			public void actionPerformed(ActionEvent e) {
				usloviZaUpisivanjePodataka();
			}
								
			
		});
		
		 		btnNext.setBounds(309, 599, 89, 23);
	 			contentPane.add(btnNext);
		 		
		

		JLabel lblPozadina = new JLabel("New label");
		lblPozadina.setOpaque(true);
		lblPozadina.setIcon(new ImageIcon(HotelForma.class.getResource("/slike/thff.png")));
		lblPozadina.setBounds(0, 0, 1134, 681);
		contentPane.add(lblPozadina);
		
	
		
		
			
		}



		


protected void usloviZaUpisivanjePodataka() {
	if(!comboBox.getSelectedItem().equals("Izaberi")  && !comboBoxTwo.getSelectedItem().equals("Drzava") && !tfGrad.getText().isEmpty() && !tfAdresa.getText().isEmpty()  && !tfNazivHotela.getText().isEmpty() && !tfBroj.getText().isEmpty() ) {
		  upisi_Drzavu_u_Bazu();
		
		if(comboBox.getSelectedItem().equals("Izaberi")) {
	          comboBox.setBorder(new LineBorder(Color.BLACK,2,true));
	          tfNotification.setText("Ovo polje je obavezno");
			  tfNotification.setBorder(new LineBorder(new Color(255, 0, 0)));
			  tfNotification.setBackground(new Color(0, 0, 0));
				  tfNotification.setVisible(true);
				   akcijaCombo();
			        
			} if(tfNazivHotela.getText().isEmpty()){
				tfNotifiHotel.setVisible(true);
				akcijaTextFieldNazivHotela();
				
			} if(tfGrad.getText().isEmpty()){
				tfNotifiGrad.setVisible(true);
				akcijaTextFieldGrad();
	
		    } if(tfAdresa.getText().isEmpty()){
			tfNotifiUlica.setVisible(true);
			akcijaTextFieldUlica();
			
		    } if(tfBroj.getText().isEmpty()){
				tfNotifiBroj.setVisible(true);
				akcijaTextFieldBroj();
				
			}if(comboBoxTwo.getSelectedItem().equals("Drzava")) {
				tfNotifiDrzava.setVisible(true);
				
			}
				
				
		
		}


			
		}







		private void upisi_Drzavu_u_Bazu( ) {
			String drzavaCombo = String.valueOf(comboBoxTwo.getSelectedItem());
			Drzava drzava = new Drzava();
			drzava.setDrzava(drzavaCombo);
			try {
				TransferKlasa transferKlasa = KontrolerKI.getInstanca().upisiDrzavu(drzava);
				vrati_Drzavu_iz_Baze();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		private void vrati_Drzavu_iz_Baze( ) {
			try {
				
				list = (List<Drzava>) KontrolerKI.getInstanca().vratiPoslednjuDrzavu().getServer_objekat_response();
				upisi_Grad_u_Bazu(list);
				
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
		private void upisi_Grad_u_Bazu(List<Drzava> list2) {
			String imeGrada = tfGrad.getText();
			 Grad grad = new Grad();
			 grad.setImeGrada(imeGrada);
			 for(Drzava drzava : list2) {
				 grad.setIdDrzave(drzava.getIdDrzave());
			 }
			try {
				TransferKlasa transferKlasa = KontrolerKI.getInstanca().upisiGrad(grad);
				vrati_Grad_iz_Baze();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		

		private void vrati_Grad_iz_Baze( ) {
			
			try {
				listGrad = (List<Grad>) KontrolerKI.getInstanca().vratiGradIzBaze().getServer_objekat_response();
		        upisi_Adresu_u_Bazu(listGrad);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}


		private void upisi_Adresu_u_Bazu(List<Grad> listGrad2)  {
			String ulica = tfAdresa.getText();
			String broj = tfBroj.getText();
			Adresa adresa = new Adresa();
			adresa.setUlica(ulica);
			adresa.setBroj(broj);
			for(Grad grad : listGrad2) {
				adresa.setIdGrad(grad.getIdGrad());
			} 
			try {
				TransferKlasa transferKlasa = KontrolerKI.getInstanca().upisiAdresu(adresa);
				vrati_Adresu_iz_Baze();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		private void vrati_Adresu_iz_Baze( ) {
			 try {
				listAdresa = (List<Adresa>) KontrolerKI.getInstanca().vratiAdresuIzBaze().getServer_objekat_response();
				upisiHotel(listAdresa);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}


		private void upisiHotel(List<Adresa> listAdresa2 ) {
			  String nazivHotela = tfNazivHotela.getText();
			  Hotel hotel = new Hotel();
			  
			  if( comboBox.getSelectedIndex() == 1) {
				  hotel.setBrZvezdica("1 zvezdica");
			  }else if(comboBox.getSelectedIndex() == 2 ) {
				  hotel.setBrZvezdica("2 zvezdice");
			  }else if(comboBox.getSelectedIndex() == 3) {
				  hotel.setBrZvezdica("3 zvezdice");
			  }else if(comboBox.getSelectedIndex() == 4) {
				  hotel.setBrZvezdica("4 zvezdice");
			  }else if(comboBox.getSelectedIndex() == 5) {
				  hotel.setBrZvezdica("5 zvezdica");
			  }
			   
			  hotel.setNazivHotel(nazivHotela); 
			  hotel.setIdUser(user.getIdUser());
		      for(Adresa adresa2 : listAdresa2) {
		    	  hotel.setIdAdresa(adresa2.getIdAdresa());
		      }
			  try {
				TransferKlasa transferKlasa = KontrolerKI.getInstanca().sacuvajHotel(hotel);
				List<Hotel>listHotel=(List<Hotel>) KontrolerKI.getInstanca().vratiUnetiHotelBaza().getServer_objekat_response();
				for(Hotel hotelBaza : listHotel) {
				 idHotel = hotelBaza.getIdHotel();
				
				}
				dispose();
			SobaForma sobaForma = new SobaForma(idHotel,user);
			sobaForma.setVisible(true);
	
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	
		

		
		
		}



		private void akcijaTextFieldNazivHotela() {
			tfNazivHotela.addFocusListener(new FocusListener() {
				
				@Override
				public void focusLost(FocusEvent e) {
					if(tfNazivHotela.getText().isEmpty()) {
						tfNotifiHotel.setVisible(true);
					}
					
				}
				
				@Override
				public void focusGained(FocusEvent e) {
					tfNotifiHotel.setVisible(false);
					
				}
			});
			
		}




		private void akcijaTextFieldGrad() {
			tfGrad.addFocusListener(new FocusListener() {
				
				@Override
				public void focusLost(FocusEvent e) {
					if(tfGrad.getText().isEmpty()) {
						tfNotifiGrad.setVisible(true);
					}
					
				}
				
				@Override
				public void focusGained(FocusEvent e) {
					tfNotifiGrad.setVisible(false);
					
				}
			});
			
		}




		private void akcijaTextFieldUlica() {
			tfAdresa.addFocusListener(new FocusListener() {
				
				@Override
				public void focusLost(FocusEvent e) {
					if(tfNotifiUlica.getText().isEmpty()) {
						tfNotifiUlica.setVisible(false);
					}
					
				}
				
				@Override
				public void focusGained(FocusEvent e) {
					tfNotifiUlica.setVisible(false);
					
				}
			});
			
		}




		private void akcijaTextFieldBroj() {
			tfBroj.addFocusListener(new FocusListener() {
				
				@Override
				public void focusLost(FocusEvent e) {
					if(tfBroj.getText().isEmpty()) {
						tfNotifiBroj.setVisible(true);
					}
				}
				
				@Override
				public void focusGained(FocusEvent e) {
					tfNotifiBroj.setVisible(false);
					
				}
			});
			
		}




		private void akcijaCombo() {
			
			comboBox.addActionListener(new ActionListener() {
		    	public void actionPerformed(ActionEvent arg0) {
		    		if(!comboBox.getSelectedItem().equals("Izaberi")) {
		    			tfNotification.setVisible(false);
						}else{
							tfNotification.setVisible(true);
						}
		    	}
		    });
		
	
		}
			

}
