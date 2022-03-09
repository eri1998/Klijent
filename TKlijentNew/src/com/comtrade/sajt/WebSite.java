package com.comtrade.sajt;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import com.danilo.domen.Hotel;
import com.danilo.domen.HotelSlike;
import com.danilo.domen.PretragaHotela;
import com.danilo.domen.User;
import com.comtrade.izabranHotelForma.IzabranHotelForma;
import com.comtrade.kontrolerKI.KontrolerKI;
import com.comtrade.sobaForma.SobaForma;
import com.comtrade.view.LogovanjeForma;
import com.comtrade.vrstaObjekta.VrstaObjektaForma;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.Color;
import java.awt.Component;
import java.awt.ComponentOrientation;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JTextField;
import javax.swing.JViewport;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class WebSite extends JFrame {

	private JPanel contentPane;
	private  User user;	
	private JTextField search;
	private List<Hotel>listHotel ;
	private JLabel proba,brZvezdica,lblSlikaHotel,slikeHotela;
	private JPanel panelSlika,panelLabele,jPanel;
	private JScrollPane scrollPane;
	private JPanel panelTable,panelProba;
	private GridBagConstraints c,a ;
	private int indexOfUrl;
	
	
	public WebSite(User user1) {
	
		
		this.user=user1;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(-10, 0, 1540, 840);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		listHotel = new ArrayList<>();
		
		panelTable = new JPanel();
  		panelTable.setOpaque(false);
	   
	    
	    
		
		 JScrollPane scrollPane = new JScrollPane();
		 scrollPane.setOpaque(false);
		 scrollPane.getViewport().setOpaque(false);
		 scrollPane.add(panelTable);
		 scrollPane.getViewport().setView(panelTable);
		 scrollPane.setBounds(567, 87, 949, 593);
		 contentPane.add(scrollPane);
			
			
		 

			UIManager.put("ScrollBar.background", new Color(100, 149, 237));
			UIManager.put("ScrollBar.foreground", new Color(100, 149, 237));
		  
		
			scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
			scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	   
		

	  	JLabel searchIcon = new JLabel();
		searchIcon.setIcon(new ImageIcon(WebSite.class.getResource("/slike/searchIconPng.png")));
		searchIcon.setBounds(1297, 28, 45, 34);
		contentPane.add(searchIcon);
		searchIcon.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				searchIcon.setBorder(new LineBorder(Color.WHITE,1));
			}
            public void mouseExited(MouseEvent e) {
            	searchIcon.setBorder(null);
			}
            public void mouseClicked(MouseEvent e) {
            	revalidate();
				repaint();
            	pretraga();
            }
		});
		
		 search = new JTextField();
		search.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					revalidate();
					repaint();
					pretraga();
				}
			}
		});
		search.setFont(new Font("Constantia", Font.ITALIC, 14));
		search.setForeground(Color.WHITE);
		search.setBounds(709, 28, 633, 34);
		search.setOpaque(false);
		search.setBorder(new LineBorder(Color.darkGray,3));
		contentPane.add(search);
		search.setColumns(10);
		
		JLabel btnYourObject = new JLabel("");
		btnYourObject.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		btnYourObject.setIcon(new ImageIcon(WebSite.class.getResource("/slike/addObject.png")));
		btnYourObject.setBounds(206, 26, 136, 48);
		contentPane.add(btnYourObject);
		btnYourObject.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				biranjeObjekata();
			}
			public void mouseEntered(MouseEvent e ) {
				btnYourObject.setBorder(new LineBorder(Color.white,1));
			}
			public void mouseExited(MouseEvent e ) {
				btnYourObject.setBorder(null);
			}
		});
		JLabel lblDobrodoslicaKorisniku = new JLabel("");
		lblDobrodoslicaKorisniku.setForeground(new Color(51, 204, 204));
		lblDobrodoslicaKorisniku.setText("Dobro dosao/la:"+" "+user.getFullName());
		lblDobrodoslicaKorisniku.setFont(new Font("Constantia", Font.ITALIC, 14));
		lblDobrodoslicaKorisniku.setBounds(906, -13, 427, 55);
		contentPane.add(lblDobrodoslicaKorisniku);
		
		JLabel bckPhoto = new JLabel("");
		bckPhoto.setIcon(new ImageIcon(WebSite.class.getResource("/slike/bckWebTr.jpg")));
		bckPhoto.setBounds(0, 0, 1540, 840);
		contentPane.add(bckPhoto);
		
		

		
	}

	protected void pretraga() {
    clearOldSearch();
    scheduleOfJPanel();
	searchAndReturnHotel();	
	refreshWindow();
	}
					
		
	private void refreshWindow() {
		revalidate();
		repaint();
		
	}

	private void searchAndReturnHotel() {
		String kljucnaRecPretraga = search.getText();
		Hotel hotel = new Hotel();
		hotel.setKljucnaRec(kljucnaRecPretraga);
		try {
			listHotel=(List<Hotel>) KontrolerKI.getInstanca().pretraga(hotel).getServer_objekat_response();
			putHotelImage();
		}catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private void putHotelImage() throws IOException {
		for(Hotel hoteliBaza : listHotel) {
			slikeHotela = new JLabel();
			slikeHotela.setHorizontalAlignment(SwingConstants.CENTER);
			slikeHotela.setVerticalAlignment(SwingConstants.CENTER);
			slikeHotela.setBorder(new LineBorder(Color.LIGHT_GRAY,5));
			List<Integer>statusFotografije = hoteliBaza.getStatusFotografije();
			
			for(int i=0;i<statusFotografije.size();i++) {
				if(statusFotografije.get(i)==1) {
					 indexOfUrl = statusFotografije.indexOf(statusFotografije.get(i));
					System.out.println("Pozicija:"+statusFotografije.indexOf(statusFotografije.get(i)));
				}
			}
			List<String>listUrl =hoteliBaza.getUrlSlika();
				File slikaBaza = new File(listUrl.get(indexOfUrl));
				
				BufferedImage buf = ImageIO.read(slikaBaza);
				Image scaled=null;
				if(listHotel.size()<2) {
					 scaled = buf.getScaledInstance(330, 300, Image.SCALE_SMOOTH);
				}else if(listHotel.size()==2) {
					 scaled = buf.getScaledInstance(330, 278, Image.SCALE_SMOOTH);
				}else {
				 scaled = buf.getScaledInstance(330, 300, Image.SCALE_SMOOTH);
				}
				ImageIcon imageIcon = new  ImageIcon(scaled);
				slikeHotela.setIcon(imageIcon);
				panelSlika.add(slikeHotela);
				putInformationOfHotels(hoteliBaza);
			}
			}
			
	

	private void putInformationOfHotels(Hotel hoteliBaza) throws IOException {
		putHotelsName(hoteliBaza);
		putNumberOfStars(hoteliBaza);
		putCityOfHotels(hoteliBaza);
		putCountryOfHotels(hoteliBaza);
		spaceBetweenHotels();
		putButtonMoreInfo(hoteliBaza);
		
		
	}

		
	

	private void putButtonMoreInfo(Hotel hoteliBaza) {
		
		JLabel button = new JLabel();
		ImageIcon icon = new ImageIcon(WebSite.class.getResource("/slike/btnHTF.png"));
		button.setIcon(icon);
		button.setHorizontalAlignment(SwingConstants.CENTER);
		int visinaDugmeta =  button.getIcon().getIconHeight()/2;
		 panelProba.setLayout(new GridLayout(0,1,0,278-visinaDugmeta));
		 panelProba.add(button);
		 button.addMouseListener(new MouseAdapter() {
			 public void mouseClicked(MouseEvent e) {
				 IzabranHotelForma izabranHotelForma;
				try {
					izabranHotelForma = new IzabranHotelForma(hoteliBaza,user);
					izabranHotelForma.setVisible(true);
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
					
			 }
		});
	}
	

	private void spaceBetweenHotels() {
		
		
		JSeparator space = new JSeparator();
		space.setBorder(new LineBorder(Color.LIGHT_GRAY,5));
		space.setBackground(Color.WHITE);
		space.setForeground(Color.lightGray);
		//panelLabele.add(space);
		c.gridx = 0;
		c.gridy = 4;
		c.ipady=10;
		c.fill=GridBagConstraints.HORIZONTAL;
		c.insets = new Insets(0, 0, 16, 0);
	    jPanel.add(space,c);
		panelLabele.add(jPanel);
		
	}

	private void putCountryOfHotels(Hotel hoteliBaza) {
		
		JLabel drzava = new JLabel();
		drzava.setBorder(new LineBorder(Color.WHITE,3));
		drzava.setText(hoteliBaza.getDrzava());
		drzava.setHorizontalAlignment(SwingConstants.CENTER);
		drzava.setFont(new Font("Tahoma",Font.PLAIN,45));
		drzava.setForeground(Color.GREEN);
		drzava.setMaximumSize(panelLabele.getMaximumSize());
		
		
		c.fill=GridBagConstraints.HORIZONTAL;
	    c.weightx=0.5;
		c.gridx = 0;
		c.gridy = 3;
	jPanel.add(drzava,c);
		panelLabele.add(jPanel);
		
	}

	private void putCityOfHotels(Hotel hoteliBaza) {
		
		
	    
		
		JLabel grad = new JLabel();
		
		grad.setText(hoteliBaza.getGrad());
		grad.setMaximumSize(panelLabele.getMaximumSize());
		grad.setHorizontalAlignment(SwingConstants.CENTER);
     	grad.setFont(new Font("Tahoma",Font.PLAIN,45));
		grad.setBorder(new LineBorder(Color.GREEN,3));
		grad.setForeground(Color.white);
		
		
		c.fill=GridBagConstraints.HORIZONTAL;
		c.weightx=0.5;
		c.gridx = 0;
		c.gridy = 2;
		c.ipady=0;
	    jPanel.add(grad,c);
		panelLabele.add(jPanel);
		
	}

	private void putNumberOfStars(Hotel hoteliBaza) throws IOException {
		
		JLabel brZvezdica = new JLabel();
		brZvezdica.setBorder(new LineBorder(Color.WHITE,3));
		brZvezdica.setHorizontalAlignment(SwingConstants.CENTER);
		
		String urlSlike = null;
	    if(hoteliBaza.getBrZvezdica().equals("1 zvezdica")) {
	    	urlSlike = ("C:\\Users\\Danilo\\eclipse-workspace\\TKlijentNew\\folder\\1z.png");
	    	
	    	}else if(hoteliBaza.getBrZvezdica().equals("2 zvezdice")) {
	    		urlSlike = ("C:\\Users\\Danilo\\eclipse-workspace\\TKlijentNew\\folder\\2z.png");
	    	}else if(hoteliBaza.getBrZvezdica().equals("3 zvezdice")) {
	    		urlSlike = ("C:\\Users\\Danilo\\eclipse-workspace\\TKlijentNew\\folder\\3z.png");
	    	}else if(hoteliBaza.getBrZvezdica().equals("4 zvezdice")) {
	    		urlSlike = ("C:\\Users\\Danilo\\eclipse-workspace\\TKlijentNew\\folder\\4z.png");
	    	}else if(hoteliBaza.getBrZvezdica().equals("5 zvezdica")) {
	    		urlSlike = ("C:\\Users\\Danilo\\eclipse-workspace\\TKlijentNew\\folder\\5z.png");
	    	}
		File filefile = new File(urlSlike);
		BufferedImage  slika = ImageIO.read(filefile);
		Image scaIedCitac = null;
		if(hoteliBaza.getBrZvezdica().equals("1 zvezdica")) {
			 scaIedCitac = slika.getScaledInstance(60, 50, Image.SCALE_SMOOTH);
	    	}else if(hoteliBaza.getBrZvezdica().equals("2 zvezdice")) {
	    		 scaIedCitac = slika.getScaledInstance(90, 50, Image.SCALE_SMOOTH);
	    	}else if(hoteliBaza.getBrZvezdica().equals("3 zvezdice")) {
	    		 scaIedCitac = slika.getScaledInstance(120, 50, Image.SCALE_SMOOTH);
	    	}else if(hoteliBaza.getBrZvezdica().equals("4 zvezdice")) {
	    		 scaIedCitac = slika.getScaledInstance(180, 50, Image.SCALE_SMOOTH);
	    	}else if(hoteliBaza.getBrZvezdica().equals("5 zvezdica")) {
	    		 scaIedCitac = slika.getScaledInstance(210, 50, Image.SCALE_SMOOTH);
	    		 brZvezdica.setBorder(new LineBorder(Color.red,3));
	    	}
		ImageIcon imaIcon = new ImageIcon(scaIedCitac);
		brZvezdica.setIcon(imaIcon);
		
		c.fill=GridBagConstraints.WEST;
		c.gridx = 0;
		c.gridy = 1;
		c.ipady=34;
	jPanel.add(brZvezdica,c);
		panelLabele.add(jPanel);
		
			
			
		
	}

	private void putHotelsName(Hotel hoteliBaza) {
		c = new GridBagConstraints();
		jPanel = new JPanel();
		jPanel.setOpaque(false);
		jPanel.setLayout(new GridBagLayout());

		JLabel naziviHotela = new JLabel();
		naziviHotela.setText(hoteliBaza.getNazivHotel());
		naziviHotela.setHorizontalAlignment(SwingConstants.CENTER);
		naziviHotela.setFont(new Font("Tahoma",Font.PLAIN,45));
		naziviHotela.setBorder(new LineBorder(Color.GREEN,3));
		naziviHotela.setForeground(Color.YELLOW);
		naziviHotela.setMaximumSize(panelLabele.getMaximumSize());
		
		c.fill=GridBagConstraints.HORIZONTAL;
        c.weightx=0.5;
		c.gridx = 0;
		c.gridy = 0;
	    c.insets=new Insets(0, 0, 11, 0);
		
	jPanel.add(naziviHotela,c);
		panelLabele.add(jPanel);
		
	}

	private void scheduleOfJPanel() {
		
		panelTable.setLayout(new GridBagLayout());
		c = new GridBagConstraints();
		
		panelSlika = new JPanel();
		panelSlika.setOpaque(false);	
	    panelSlika.setLayout(new GridLayout(0,1,0,8));
	    c.ipadx=100;
	    c.ipady=100;
		panelTable.add(panelSlika,c);
	 
	    panelProba = new JPanel();
	    panelProba.setOpaque(false);
	    c.ipadx=20;
	    panelTable.add(panelProba,c);
	   
	  
	    panelLabele = new JPanel();
	    panelLabele.setLayout(new GridLayout(0,1,0,0));
	    panelLabele.setBorder(BorderFactory.createMatteBorder(0, 1, 0, 0, Color.BLACK));
	  
	    c.ipadx=160;
	    c.ipady=1;
	    panelLabele.setOpaque(false);
	    panelTable.add(panelLabele,c);
		
	
	   
	
	}

	private void clearOldSearch() {
		
		panelTable.removeAll();
		
		
	}

	
	

	protected void biranjeObjekata() {
		dispose();
		VrstaObjektaForma vof = new VrstaObjektaForma(user);
		vof.setVisible(true);
		
		
	}
	 
	 
	    
	 
}
