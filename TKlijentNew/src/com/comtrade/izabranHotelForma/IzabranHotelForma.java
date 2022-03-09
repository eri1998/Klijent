package com.comtrade.izabranHotelForma;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.xml.crypto.dsig.dom.DOMValidateContext;

import com.danilo.domen.Hotel;
import com.danilo.domen.RezervacijaSobe;
import com.danilo.domen.Soba;
import com.danilo.domen.User;
import com.comtrade.kontrolerKI.KontrolerKI;
import com.comtrade.hotelSlike.HotelSlikeWrapper;

//import javafx.scene.control.ComboBox;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import java.awt.Rectangle;
import javax.swing.JSeparator;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.UIManager;
import javax.swing.border.MatteBorder;
import java.awt.CardLayout;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;

public class IzabranHotelForma extends JFrame {
	protected static final  int PREVIUS = 1;
	protected static final  int CURRENT = 2;
	private JLabel lblSlikeHotela;
	private JPanel contentPane;
	private HotelSlikeWrapper hotelWrapper;
	private JLabel cena,lblSprat,lblBrSobe,lblPovrsina;
	private JPanel panelSlikeSoba;
	private JComboBox comboBox;
	private JLabel lblSlikeSoba;
	private int s;
	private int indexSobeGlavneLIste ;
	private Calendar dolazak;
	List<Soba>jednoKrevetneSobe = new ArrayList<>();
	List<Soba>dvoKrevetneSobe = new ArrayList<>();
	private JButton btnRezervisi;
	private JDateChooser dateChooser,dateChooserDeparture;
	List<RezervacijaSobe>datumiRezervacijaSobe = new ArrayList<>();
	
	List<Soba>listSoba = new ArrayList<>();
private Hotel hotel;
 
private	List<HotelSlikeWrapper>listUrl;
int currentPosition = 0;


	public IzabranHotelForma(Hotel hoteliBaza, User user) throws ClassNotFoundException, IOException {
		Soba soba = new Soba();
		soba.setIdHotel(hoteliBaza.getIdHotel());
		
		listSoba = (List<Soba>) KontrolerKI.getInstanca().vratiSobeIzabranogHotela(soba).getServer_objekat_response();
		hotelWrapper = new HotelSlikeWrapper();
		hotelWrapper.setHotel(hoteliBaza);
		listUrl = new ArrayList<>();
		listUrl.add(hotelWrapper);
		hotelWrapper.setLabelaSlike(lblSlikeHotela);
		this.hotel=hoteliBaza;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(-10, 0, 1540, 840);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		JLabel levo = new JLabel("New label");
		levo.setBounds(36, 189, 45, 45);
		ImageIcon iconImg = new ImageIcon(IzabranHotelForma.class.getResource("/slike/prv.png"));
		Image im = iconImg.getImage().getScaledInstance(levo.getWidth(), levo.getHeight(), Image.SCALE_SMOOTH);
		iconImg = new ImageIcon(im);
		levo.setIcon(iconImg);
		
		
		contentPane.add(levo);
		levo.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				navigationJLabelClicked((JLabel)e.getSource(),HotelSlikeWrapper.PREVIUS);
			}
		});
		JLabel desno = new JLabel("New label");
		desno.setBounds(341, 189, 45, 45);
		ImageIcon imageIcon = new ImageIcon(IzabranHotelForma.class.getResource("/slike/nxt.png"));
		Image image = imageIcon.getImage().getScaledInstance(desno.getWidth(), desno.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon img = new ImageIcon(image);
		desno.setIcon(img);
		//desno.setIcon(new ImageIcon(IzabranHotelForma.class.getResource("/slike/nxt.png")));
		
		contentPane.add(desno);
		desno.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				
				navigationJLabelClicked((JLabel)e.getSource(),HotelSlikeWrapper.NEXT);
				
			}
		});
		
		
		 lblSlikeHotela = new JLabel("");
		 lblSlikeHotela.setBorder(UIManager.getBorder("DesktopIcon.border"));
		lblSlikeHotela.setBounds(80, 57, 261, 274);
		contentPane.add(lblSlikeHotela);
		hotelWrapper.setLabelaSlike(lblSlikeHotela);
		
		
		 lblBrSobe = new JLabel("");
		 lblBrSobe.setForeground(Color.YELLOW);
		 lblBrSobe.setFont(new Font("Ink Free", Font.PLAIN, 42));
		lblBrSobe.setBounds(646, 211, 141, 37);
		contentPane.add(lblBrSobe);
		
		 lblSprat = new JLabel("");
		 lblSprat.setFont(new Font("Ink Free", Font.PLAIN, 42));
		 lblSprat.setForeground(Color.YELLOW);
		lblSprat.setBounds(646, 75, 141, 29);
		contentPane.add(lblSprat);
		
		 cena = new JLabel("");
		 cena.setForeground(Color.YELLOW);
		 cena.setFont(new Font("Ink Free", Font.PLAIN, 42));
		cena.setBounds(564, 296, 71, 55);
		contentPane.add(cena);
		
		lblPovrsina = new JLabel("");
		lblPovrsina.setForeground(Color.YELLOW);
		lblPovrsina.setFont(new Font("Ink Free", Font.PLAIN, 42));
		lblPovrsina.setBounds(564, 116, 71, 55);
		contentPane.add(lblPovrsina);
		
		JLabel lblNazad = new JLabel("New label");
		lblNazad.setForeground(Color.WHITE);
		lblNazad.setIcon(new ImageIcon(IzabranHotelForma.class.getResource("/slike/levo copy.png")));
		lblNazad.setBounds(956, 310, 38, 45);
		contentPane.add(lblNazad);
		lblNazad.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				try {
					
					roomsOfHotel(hoteliBaza,(JLabel)e.getSource(),PREVIUS);
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		
		 dateChooser = new JDateChooser();
		Date currentDate = new Date();
		LocalDateTime danasnjiDatum = LocalDateTime.ofInstant(currentDate.toInstant(), ZoneId.systemDefault());
		Date dateFromLocalDT = Date.from(danasnjiDatum.atZone(ZoneId.systemDefault()).toInstant());
		dateChooser.setMinSelectableDate(dateFromLocalDT);
		dateChooser.setBounds(1303, 85, 148, 19);
		contentPane.add(dateChooser);
		
		 dateChooserDeparture = new JDateChooser();
		dateChooserDeparture.setMinSelectableDate(dateChooser.getDate());
		dateChooserDeparture.setBounds(1303, 201, 148, 19);
		dateChooserDeparture.setMinSelectableDate(dateFromLocalDT);
		contentPane.add(dateChooserDeparture);
		
		JLabel lblNapred = new JLabel("New label");
		lblNapred.setIcon(new ImageIcon(IzabranHotelForma.class.getResource("/slike/desno copy.png")));
		lblNapred.setBounds(1006, 310, 52, 45);
		contentPane.add(lblNapred);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setOpaque(true);
		scrollPane.setBounds(1303, 792, 221, -792);
		contentPane.add(scrollPane);
   
		
	
		
		 scrollPane.setViewportView(panelSlikeSoba);
		    scrollPane.getViewport().setOpaque(false);
    
		lblNapred.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				try {
					
					
					roomsOfHotel(hoteliBaza,(JLabel)e.getSource(),CURRENT);
				
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
												
		});
	
		
		JSeparator separator_2_1 = new JSeparator();
		separator_2_1.setOrientation(SwingConstants.VERTICAL);
		separator_2_1.setBounds(396, 13, 5, 348);
		contentPane.add(separator_2_1);
		
		JSeparator separator_2_2 = new JSeparator();
		separator_2_2.setOrientation(SwingConstants.VERTICAL);
		separator_2_2.setBounds(817, 13, 5, 348);
		contentPane.add(separator_2_2);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(20, 13, 799, 2);
		contentPane.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(20, 361, 799, 2);
		contentPane.add(separator_1);
		
		JSeparator separator_2_1_1 = new JSeparator();
		separator_2_1_1.setOrientation(SwingConstants.VERTICAL);
		separator_2_1_1.setBounds(20, 13, 5, 348);
		contentPane.add(separator_2_1_1);
	
		JSeparator separator_2_1_2 = new JSeparator();
		separator_2_1_2.setOrientation(SwingConstants.VERTICAL);
		separator_2_1_2.setBounds(512, 13, 5, 348);
		contentPane.add(separator_2_1_2);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(396, 63, 420, 2);
		contentPane.add(separator_2);
		
		JSeparator separator_2_3 = new JSeparator();
		separator_2_3.setBounds(396, 116, 420, 2);
		contentPane.add(separator_2_3);
		
		JSeparator separator_2_3_1 = new JSeparator();
		separator_2_3_1.setBounds(396, 176, 420, 2);
		contentPane.add(separator_2_3_1);
		
		JSeparator separator_2_3_1_1 = new JSeparator();
		separator_2_3_1_1.setBounds(396, 284, 420, 2);
		contentPane.add(separator_2_3_1_1);
		
		JLabel lblNewLabel = new JLabel(" Broj Sobe :");
		lblNewLabel.setForeground(Color.GREEN);
		lblNewLabel.setFont(new Font("NSimSun", Font.PLAIN, 18));
		lblNewLabel.setBounds(396, 211, 117, 52);
		contentPane.add(lblNewLabel); 
		
		 comboBox = new JComboBox();
		 comboBox.setOpaque(false);
		 comboBox.setFont(new Font("NSimSun",Font.PLAIN,33));
		 comboBox.setBounds(512, 13, 308, 52);
		 contentPane.add(comboBox);
		 popuniComboBox();
		 comboBox.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					
					 s = comboBox.getSelectedIndex();
					 try {
						roomsOfHotel(hoteliBaza, lblNewLabel, CURRENT);
						//sobaInfo(s);
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					//sobaInfo(s);
				}

			
				
			});
		
		 JComboBox comboBrSobe = new JComboBox();
		 comboBrSobe.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
			 s =	comboBrSobe.getSelectedIndex();
			 try {
				roomsOfHotel(hoteliBaza, lblNewLabel, CURRENT);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				JOptionPane.showMessageDialog(null, indexSobeGlavneLIste);
			}
		});
		 popuniKomboBrSobe(comboBrSobe);
			comboBrSobe.setBounds(697, 212, 71, 37);
			contentPane.add(comboBrSobe);
			
		 
		 JLabel cena_1_1 = new JLabel("squares of meters");
			cena_1_1.setForeground(Color.YELLOW);
			cena_1_1.setFont(new Font("Ink Free", Font.PLAIN, 22));
			cena_1_1.setBounds(622, 128, 185, 45);
			contentPane.add(cena_1_1);
			
			
			JPanel panel = new JPanel();
			panel.add(new JLabel("aaa"));
			panel.setBounds(359, 452, 514, 253);
			contentPane.add(panel);
			
		 JLabel cena_1 = new JLabel("euro/per night");
			cena_1.setForeground(Color.YELLOW);
			cena_1.setFont(new Font("Ink Free", Font.PLAIN, 26));
			cena_1.setBounds(622, 306, 185, 45);
			contentPane.add(cena_1);
			
			
			JSeparator separator_2_2_1 = new JSeparator();
			separator_2_2_1.setOrientation(SwingConstants.VERTICAL);
			separator_2_2_1.setBounds(1232, 13, 5, 348);
			contentPane.add(separator_2_2_1);
			
			 lblSlikeSoba = new JLabel("");
			lblSlikeSoba.setBorder(UIManager.getBorder("DesktopIcon.border"));
			lblSlikeSoba.setBounds(906, 25, 261, 274);
			contentPane.add(lblSlikeSoba);
			String urlSlikeSoba = listSoba.get(s).getUrl().get(0);
			File file = new File(urlSlikeSoba);
			try {
			BufferedImage bufferedImage =  ImageIO.read(file);
			Image scaled = bufferedImage.getScaledInstance(lblSlikeSoba.getWidth(), lblSlikeSoba.getHeight(), Image.SCALE_SMOOTH);
			ImageIcon icon = new ImageIcon(scaled);
			lblSlikeSoba.setIcon(icon);
			}catch (Exception e) {
				// TODO: handle exception
			}
		
			JSeparator separator_2_3_2 = new JSeparator();
			separator_2_3_2.setBounds(817, 13, 420, 2);
			contentPane.add(separator_2_3_2);
			
			JSeparator separator_2_3_3 = new JSeparator();
			separator_2_3_3.setBounds(817, 359, 420, 2);
			contentPane.add(separator_2_3_3);
			
			 btnRezervisi = new JButton("rezervisi");
			btnRezervisi.setBounds(1332, 310, 85, 21);
			contentPane.add(btnRezervisi);
			btnRezervisi.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					RezervacijaSobe rezervacijaSobe = new RezervacijaSobe();
					try {
						datumiRezervacijaSobe = (List<RezervacijaSobe>) KontrolerKI.getInstanca().vratiRezervacijeSobe().getServer_objekat_response();
						JOptionPane.showMessageDialog(null, "ima ukupno rezervacija ove sobe"+datumiRezervacijaSobe.size());
					} catch (ClassNotFoundException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					} catch (IOException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					Date date = dateChooser.getDate();
					SimpleDateFormat dateFormat = new SimpleDateFormat("dd MM yyyy");  
				
				
				Date date2 = dateChooserDeparture.getDate();
		    	String datumOdlaska = dateFormat.format(date2);
		    	String datumDolaska = dateFormat.format(date);
		    	
		    
		    	
			int result = date.compareTo(date2);
			if(result == 0) {
				JOptionPane.showMessageDialog(null, "izabrali ste isti datum");
			}else if(result <0) {
				
				rezervacijaSobe.setDatumDolaska(datumDolaska);
				rezervacijaSobe.setDatumOdlaska(datumOdlaska);
				rezervacijaSobe.setIdSobe(listSoba.get(s).getIdSobe());
				long brojDana = ChronoUnit.DAYS.between(date.toInstant(), date2.toInstant());
				int brojRezervisanihDana = (int) (brojDana);
				double cenaPlacanje = (double)(brojRezervisanihDana*listSoba.get(s).getCenaSobe());
				JOptionPane.showMessageDialog(null, "cena za placanje"+cenaPlacanje);
				rezervacijaSobe.setIdUser(user.getIdUser());
				rezervacijaSobe.setBrojDana(brojRezervisanihDana);
				rezervacijaSobe.setCena(cenaPlacanje);
				
//				try {
//					KontrolerKI.getInstanca().rezervisiSobu(rezervacijaSobe);
//					
//				} catch (ClassNotFoundException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				} catch (IOException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
//				
//			}else {
//				JOptionPane.showMessageDialog(null, "pogresno uneti datum");
			}
			
			//int brojDana = date2.getDate()-date.getDate();
			
				
//				if(datumDolaska.)) {
//					
//				}
				
				//DateFormat dateFormat = new SimpleDateFormat("dd MMMM yyyy");  
//			String datumOdlaska = dateFormat.format(date2);
//			JOptionPane.showMessageDialog(null, datumOdlaska);
			//datumDolaska.compareTo(datumOdlaska);
				}
			});
			
			
		JLabel lblNewLabel_1 = new JLabel("    Sprat :");
		lblNewLabel_1.setForeground(Color.GREEN);
		lblNewLabel_1.setFont(new Font("NSimSun", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(396, 66, 117, 52);
		contentPane.add(lblNewLabel_1);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(0, -345, 799, 2);
		contentPane.add(separator_3);
		
		JLabel lblNewLabel_2 = new JLabel("  Povrsina :");
		lblNewLabel_2.setForeground(Color.GREEN);
		lblNewLabel_2.setFont(new Font("NSimSun", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(396, 116, 117, 62);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("  Cena :");
		lblNewLabel_3.setForeground(Color.RED);
		lblNewLabel_3.setFont(new Font("NSimSun", Font.PLAIN, 26));
		lblNewLabel_3.setBounds(396, 284, 117, 74);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("  Tip");
		lblNewLabel_4.setForeground(Color.GREEN);
		lblNewLabel_4.setFont(new Font("NSimSun", Font.PLAIN, 18));
		lblNewLabel_4.setBounds(420, 13, 71, 37);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_4_1 = new JLabel("   sobe");
		lblNewLabel_4_1.setFont(new Font("NSimSun", Font.PLAIN, 16));
		lblNewLabel_4_1.setForeground(Color.GREEN);
		lblNewLabel_4_1.setBounds(411, 25, 61, 45);
		contentPane.add(lblNewLabel_4_1);
		
		JLabel background = new JLabel();
		background.setForeground(Color.WHITE);
		background.setBounds(new Rectangle(0, -27, 1540, 840));
		background.setIcon(new ImageIcon(IzabranHotelForma.class.getResource("/slike/pozadinska.jpg")));
		contentPane.add(background);
	
		
		lblPovrsina.setText(String.valueOf(listSoba.get(0).getPovrsinaSobe()));
		lblSprat.setText(String.valueOf(listSoba.get(0).getSpratSobe()));
		lblBrSobe.setText(String.valueOf(listSoba.get(0).getBrSobe()));
		cena.setText(String.valueOf(listSoba.get(0).getCenaSobe()));
	
	prikaziUI(hoteliBaza);
	roomsOfHotel(hoteliBaza, lblNapred, CURRENT);
	
	
	

	
	
	
	}
	
	

	



	private void roomsOfHotel(Hotel idHotel, JLabel jLabel, int current2) throws ClassNotFoundException, IOException {
		

		
	
		if(currentPosition>=listSoba.size()) {
			currentPosition =0;
		}else if(currentPosition<0) {
			currentPosition=listSoba.size()-1;
		}
			List<String>url = new ArrayList<>();
			
			if(url.isEmpty()) {
			url.addAll(listSoba.get(currentPosition).getUrl());
			}else {
				url.clear();
				url.addAll(listSoba.get(currentPosition).getUrl());
			}
			
			String urlSlikeSoba = listSoba.get(s).getUrl().get(currentPosition);

			File file = new File(urlSlikeSoba);
			try {
			BufferedImage bufferedImage =  ImageIO.read(file);
			Image scaled = bufferedImage.getScaledInstance(lblSlikeSoba.getWidth(), lblSlikeSoba.getHeight(), Image.SCALE_SMOOTH);
			ImageIcon icon = new ImageIcon(scaled);
			lblSlikeSoba.setIcon(icon);
			
			lblPovrsina.setText(String.valueOf(listSoba.get(s).getPovrsinaSobe())); // videti da li se uklapa sa prvobitnom listom
			lblSprat.setText(String.valueOf(listSoba.get(s).getSpratSobe()));
			lblBrSobe.setText(String.valueOf(listSoba.get(s).getBrSobe()));
			cena.setText(String.valueOf(listSoba.get(s).getCenaSobe()));
			}catch (Exception e) {
				// TODO: handle exception
			}
			
		
			if(current2 == 1) {
				currentPosition--;
				

			}else {
				currentPosition++;
				
			}
			
						}
	
			
	
	private void popuniComboBox() {


//ovde kreni da rastavljas listu na delove
		//preko uslova izvuci grupe tipova
		//dodaj iz svake grupe tip prvi clan u kombo
	
		
		

		for(int i=0;i<listSoba.size();i++) {
			if(listSoba.get(i).getTipSobe().equals("jednokrevetna")) {
				jednoKrevetneSobe.add(listSoba.get(i)); 
				
			}else if (listSoba.get(i).getTipSobe().equals("dvokrevetna")) {
				dvoKrevetneSobe.add(listSoba.get(i));
			}
//				else if (listSoba.get(i).getTipSobe().equals("trokrevetne")) {
//				dvoKrevetneSobe.add(listSoba.get(i));
//			}
			
			
			
			
			
		//	comboBox.addItem(dvoKrevetneSobe.get(0).getTipSobe());
			
			}
	
		comboBox.addItem(jednoKrevetneSobe.get(0).getTipSobe());
		if(!dvoKrevetneSobe.isEmpty()) {
			comboBox.addItem(dvoKrevetneSobe.get(0).getTipSobe());
		}
		 // postasviti if uslov da li je lista prazna ako 
	
	}
	
	private void popuniKomboBrSobe(JComboBox comboBrSobe) {
		 for(int i=0;i<jednoKrevetneSobe.size();i++) {
			 comboBrSobe.addItem(jednoKrevetneSobe.get(i).getBrSobe());
		 }
			sobaInfo(indexSobeGlavneLIste);
		
	}

	private void sobaInfo(int indexSobeGlavneLIste ) {
		
		//s = indexSobeGlavneLIste;
		//String urlSlikeSoba = listSoba.get(indexSobeGlavneLIste).getUrl().get(currentPosition);
	//	JOptionPane.showMessageDialog(null, currentPosition);
	//	File file = new File(urlSlikeSoba);
		try {
	//	BufferedImage bufferedImage =  ImageIO.read(file);
	//	Image scaled = bufferedImage.getScaledInstance(lblSlikeSoba.getWidth(), lblSlikeSoba.getHeight(), Image.SCALE_SMOOTH);
	//	ImageIcon icon = new ImageIcon(scaled);
	//	lblSlikeSoba.setIcon(icon);
		}catch (Exception e) {
			// TODO: handle exception
		}
		
//		lblPovrsina.setText(String.valueOf(listSoba.get(indexSobeGlavneLIste).getPovrsinaSobe())); // videti da li se uklapa sa prvobitnom listom
//		lblSprat.setText(String.valueOf(listSoba.get(indexSobeGlavneLIste).getSpratSobe()));
//		lblBrSobe.setText(String.valueOf(listSoba.get(indexSobeGlavneLIste).getBrSobe()));
//		cena.setText(String.valueOf(listSoba.get(indexSobeGlavneLIste).getCenaSobe()));
	}

	protected void navigationJLabelClicked(JLabel label,int izabranSmer) {
	
			
			//HotelSlikeWrapper hotelWrapper = getHotelWrapper(label);
			if (hotelWrapper != null) {
				hotelWrapper.setSlika(izabranSmer);
			
		}
		
		
	

			
		
	
	
	
	
}
	
	private void prikaziUI(Hotel hoteliBaza ) {
		
		try {
			String url = hoteliBaza.getUrlSlika().get(0);
			File file = new File(url);
			BufferedImage buf = ImageIO.read(file);
			Image scaled = buf.getScaledInstance(lblSlikeHotela.getWidth(), lblSlikeHotela.getHeight(), Image.SCALE_SMOOTH);
			ImageIcon icon = new ImageIcon(scaled);
			lblSlikeHotela.setIcon(icon);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
