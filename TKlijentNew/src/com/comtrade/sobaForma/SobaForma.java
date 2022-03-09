package com.comtrade.sobaForma;



import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.imageio.ImageIO;
import javax.swing.AbstractAction;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.border.LineBorder;

import com.danilo.domen.Soba;
import com.danilo.domen.SobaSlike;
import com.danilo.domen.User;
import com.comtrade.kontrolerKI.KontrolerKI;
import com.danilo.transferKlasa.TransferKlasa;

import com.comtrade.uslugeSoba.UslugeSobaForma;

import java.awt.Color;
import java.awt.Component;


import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import java.awt.Font;

import java.awt.Image;



import javax.swing.JButton;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

import java.awt.image.BufferedImage;


import javax.swing.ScrollPaneConstants;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;

import java.awt.GridLayout;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class SobaForma extends JFrame {

	private JPanel contentPane;
	private JTextField tfPovrsina;
	private JTextField txtM;
	private JTextField tfCena;
	private JTextField txtperNight;
	private JComboBox cbTipSobe;
	private List<Soba>sobaBaza;
	private List<String>listUrl;
	private int idSobe;
	private File file ; 
	private String Location,name;
	private static int idHotel=5;
	int indexIstihPodataka;
	private JButton btnSacuvajSobu ;
	private  static User user;
	
	
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					SobaForma sf = new SobaForma(idHotel,user);
					sf.setVisible(true);
					

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
*/
	 
	public SobaForma(int idHotel2, User user) {
		 this.user=user;
		this.idHotel = idHotel2;
		//setVisible(true);
		//setAlwaysOnTop(true);
		//setAutoRequestFocus(false);
		listUrl = new ArrayList<>();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1241, 753);
		contentPane = new JPanel();
	
	this.setTitle("ERDOGLIJA");
	ImageIcon image = new ImageIcon(SobaForma.class.getResource("/slike/planine2.png"));
	this.setIconImage(image.getImage());
	this.setResizable(true);
	
	indexIstihPodataka = -1;

		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		cbTipSobe = new JComboBox();
		cbTipSobe.addItem("Molim vas izaberite");
		cbTipSobe.addItem("jednokrevetna");
		cbTipSobe.addItem("dvokrevetna");
		cbTipSobe.addItem("trokrevetna");
		cbTipSobe.addItem("cetvorokrevetna");
		cbTipSobe.addItem("porodicna");
		
		cbTipSobe.setBorder(new LineBorder(new Color(128, 128, 128), 3));
		cbTipSobe.setBounds(411, 46, 379, 26);
		contentPane.add(cbTipSobe);
		
		tfPovrsina = new JTextField();
		tfPovrsina.setBounds(413, 105, 185, 26);
		contentPane.add(tfPovrsina);
		tfPovrsina.setColumns(10);
		
		txtM = new JTextField();
		txtM.setEnabled(false);
		txtM.setFont(new Font("Impact", Font.PLAIN, 15));
		txtM.setBackground(new Color(192, 192, 192));
		txtM.setText("m2");
		txtM.setBounds(597, 105, 28, 26);
		contentPane.add(txtM);
		txtM.setColumns(10);
		
		tfCena = new JTextField();
		tfCena.setBounds(411, 159, 134, 26);
		contentPane.add(tfCena);
		tfCena.setColumns(10);
		
		txtperNight = new JTextField();
		txtperNight.setEnabled(false);
		txtperNight.setOpaque(false);
		txtperNight.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtperNight.setText("        \u20AC/per night");
		txtperNight.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtperNight.setBounds(559, 159, 171, 26);
		contentPane.add(txtperNight);
		txtperNight.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Broj sobe");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(499, 251, 80, 27);
		contentPane.add(lblNewLabel_1);
		
		JSpinner spinnerSprat =new JSpinner(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		spinnerSprat.getModel().setValue(1);
		
		
		
		spinnerSprat.setBounds(591, 220, 58, 20);
		contentPane.add(spinnerSprat);
		
		JSpinner spinnerBrSobe = new JSpinner(new SpinnerNumberModel(1,1,null,1));
		spinnerBrSobe.setBounds(589, 256, 60, 20);
		contentPane.add(spinnerBrSobe);
		
		JLabel lblNewLabel = new JLabel("Sprat");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel.setBounds(503, 220, 58, 17);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("Tip Sobe");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(547, 21, 93, 24);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblPovrsina = new JLabel("Povrsina");
		lblPovrsina.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblPovrsina.setBounds(499, 83, 81, 14);
		contentPane.add(lblPovrsina);
		
		JLabel lblCena = new JLabel("Cena");
		lblCena.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblCena.setBounds(461, 142, 80, 14);
		contentPane.add(lblCena);
		
		JLabel lblNewLabel_3 = new JLabel("Dodajte fotografije vase sobe");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(461, 300, 239, 26);
		contentPane.add(lblNewLabel_3);
		
		JScrollPane spResults = new JScrollPane();
		spResults.setBorder(null);
		spResults.setOpaque(false);
		
		
		UIManager.put("ScrollBar.background", new Color(100, 149, 237));
		UIManager.put("ScrollBar.foreground", new Color(100, 149, 237));
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
			
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (InstantiationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (UnsupportedLookAndFeelException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		spResults.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		spResults.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		spResults.setBounds(20, 384, 1200, 268);
		contentPane.add(spResults);
		
		JPanel panel = new JPanel();
		panel.setOpaque(false);
		
		
		spResults.setViewportView(panel);
	    spResults.getViewport().setOpaque(false);
		panel.setBounds(23, 384, 1203, 263);
		panel.setLayout(new GridLayout(0,4,10,10));
		List<Component>listLabela = new ArrayList<>();
            JButton btnDodajSlike = new JButton(new AbstractAction("Dodaj slike") {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser chooser = new JFileChooser();
				chooser.setCurrentDirectory(new File("D:\\"));
				chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
				int res = chooser.showOpenDialog(SobaForma.this);
				if(res == JFileChooser.APPROVE_OPTION) {
				 file = chooser.getSelectedFile();
					String path = file.getAbsolutePath();
					ImageIcon image = new ImageIcon(file.getAbsolutePath());
					Image scaledImage = image.getImage().getScaledInstance(240, 220, Image.SCALE_SMOOTH);
					image = new ImageIcon(scaledImage);
					JLabel proba = new JLabel(image);
					listLabela.add(proba);
					if(listLabela.size()>=2) {
					for(int i = listLabela.size()-1;i>=0;i--) {
						panel.add(listLabela.get(i));
					}
					}else {
						panel.add(listLabela.get(0));
					}
					proba.setBorder(new LineBorder(Color.DARK_GRAY,3));
				    //panel.add(proba);
				  //  System.out.println(panel.getComponentCount());
				   
				    
			        spResults.setBorder(new LineBorder(Color.DARK_GRAY,3));
					name = file.getName();
					validate();
					repaint();
					
				}
				 try { 
					 BufferedImage  buffImg = ImageIO.read(file);
						 Location = "C:/Users\\Danilo/eclipse-workspace/trenutni projekat/TKlijent/" + name + ".jpg";
						 
						 listUrl.add(Location);
						String format = "JPG";
						ImageIO.write(buffImg, format, new File(Location));
						
					}catch (Exception e2) {
						// TODO: handle exception
					}		
			}
			  	
		});
           
        
		btnDodajSlike.setBounds(536, 350, 89, 23);
		contentPane.add(btnDodajSlike);
		
		btnSacuvajSobu = new JButton(new AbstractAction() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				 
				        	String tipSobe = (String) cbTipSobe.getSelectedItem();
							int povrsina =Integer.valueOf( tfPovrsina.getText());
							int cena = Integer.valueOf(tfCena.getText());
							int sprat = (int) spinnerSprat.getValue();
							int brSobe = (int) spinnerBrSobe.getValue();
							Soba soba = new Soba();
							soba.setTipSobe(tipSobe);
						    soba.setPovrsinaSobe(povrsina);
							soba.setCenaSobe(cena);
							soba.setSpratSobe(sprat);
							soba.setBrSobe(brSobe);
							soba.setIdHotel(idHotel2);
							List<Soba>listSobaBaza = new ArrayList<>();
							List<Integer>listIdHotela = new ArrayList<>();
							List<Integer>brojSprata = new ArrayList<>();	
							List<Integer>brojSobe = new ArrayList<>();
							List<Soba>listSoba2 = new ArrayList<>();
							List<Integer>indexIstogPodatka = new ArrayList<>();
							
									
									try {
										listSobaBaza =(List<Soba>) KontrolerKI.getInstanca().vratiSveSobeBaza().getServer_objekat_response();
									} catch (ClassNotFoundException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									} catch (IOException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
									for(int i = 0 ; i < listSobaBaza.size() ; i++ ) {
										 listIdHotela.add(listSobaBaza.get(i).getIdHotel());
										 brojSprata.add(listSobaBaza.get(i).getSpratSobe());
										 brojSobe.add(listSobaBaza.get(i).getBrSobe());
									
										 
									}
									
									if(listIdHotela.contains(idHotel2)) {
										for(int i = 0; i < listSobaBaza.size() ; i++) {
											if(sprat == listSobaBaza.get(i).getSpratSobe() && brSobe == listSobaBaza.get(i).getBrSobe() && idHotel2 == listSobaBaza.get(i).getIdHotel()) {
												indexIstihPodataka = i;
												indexIstogPodatka.add(indexIstihPodataka);
												
												
												
												JOptionPane.showMessageDialog(null,"Broj sobe :"+brSobe+"na spratu :"+sprat+"je vec uneta . Molimo Vas da unesete sledecu sobu"
												    	 ,"Postovani,",JOptionPane.WARNING_MESSAGE);
												requestFocusInWindow();
												spinnerSprat.setBorder(new LineBorder(Color.RED, 1));
												spinnerBrSobe.setBorder(new LineBorder(Color.RED, 1));
												btnSacuvajSobu.addMouseListener(new MouseListener() {
													
													@Override
													public void mouseReleased(MouseEvent e) {
														// TODO Auto-generated method stub
														
													}
													
													@Override
													public void mousePressed(MouseEvent e) {
														// TODO Auto-generated method stub
														
													}
													
													@Override
													public void mouseExited(MouseEvent e) {
														// TODO Auto-generated method stub
														
													}
													
													@Override
													public void mouseEntered(MouseEvent e) {
														// TODO Auto-generated method stub
														
													}
													
													@Override
													public void mouseClicked(MouseEvent e) {
														String tipSobe = (String) cbTipSobe.getSelectedItem();
														int povrsina =Integer.valueOf( tfPovrsina.getText());
														int cena = Integer.valueOf(tfCena.getText());
														int sprat = (int) spinnerSprat.getValue();
														int brSobe = (int) spinnerBrSobe.getValue();
														Soba soba = new Soba();
														soba.setTipSobe(tipSobe);
													    soba.setPovrsinaSobe(povrsina);
														soba.setCenaSobe(cena);
														soba.setSpratSobe(sprat);
														soba.setBrSobe(brSobe);
														soba.setIdHotel(idHotel2);
														sacuvajSobu(soba);
														sacuvajSlikeSoba();
														UslugeSobaForma usf = new UslugeSobaForma(idHotel2,user);
											    		dispose();
											    		usf.setVisible(true);
														//novaSoba_da_ne(idHotel2);
														
													}
												});
												
												
												
												
								
											} 
											
											}
										
										
												if(indexIstihPodataka==-1)  {
													sacuvajSobu(soba);
												    sacuvajSlikeSoba();
												    UslugeSobaForma usf = new UslugeSobaForma(idHotel2,user);
										    		dispose();
										    		usf.setVisible(true);
													//novaSoba_da_ne(idHotel2);
													
													
												}/* else {
													novaSoba_da_ne(idHotel2);
													} */
									}else {
										
											sacuvajSobu(soba);
											sacuvajSlikeSoba();
											UslugeSobaForma usf = new UslugeSobaForma(idHotel2,user);
								    		dispose();
								    		usf.setVisible(true);
											//novaSoba_da_ne(idHotel2);
									
									}
							
								
			}});
		btnSacuvajSobu.setText("Sacuvaj Sobu");
			
		
		btnSacuvajSobu.setBounds(559, 658, 113, 23);
		contentPane.add(btnSacuvajSobu);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(SobaForma.class.getResource("/slike/soba1.jpg")));
		label.setBounds(0, 22, 1246, 695);
		contentPane.add(label);
					
			}


	protected void sacuvajSobu(Soba soba) {
		try {
			TransferKlasa transferKlasa = KontrolerKI.getInstanca().sacuvajSobu(soba);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


	protected void novaSoba_da_ne(int idHotel2) {
		int opcija =   JOptionPane.showConfirmDialog(null, "Zelite li da unesete novu sobu za ovaj hotel?", "Postovani,", JOptionPane.YES_NO_OPTION);
    	int YES = 0;
    	if(opcija == YES) {
    		SobaForma sobaForma = new SobaForma(idHotel2,user);
    		dispose();
    		sobaForma.setVisible(true);
    		
    	}else {
    		/*UslugeSobaForma usf = new UslugeSobaForma();
    		dispose();
    		usf.setVisible(true);
    		*/
    	}
		
	}


	protected void sacuvajSlikeSoba() {
		try {
			sobaBaza = (List<Soba>) KontrolerKI.getInstanca().vratiPoslednjuSobuIzBaze().getServer_objekat_response();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		for(Soba soba2 : sobaBaza) {
			 idSobe = soba2.getIdSobe();
			
		}
		SobaSlike sobaSlike = new SobaSlike();
		for(int i = 0 ; i<listUrl.size();i++) {
			SobaSlike sobaSlike2 = new SobaSlike();
			sobaSlike2.setUrlSlike(listUrl.get(i));
			sobaSlike2.setIdSobe(idSobe);
			try {
				KontrolerKI.getInstanca().sacuvajSlikeSobe(sobaSlike2).getKlijent_objekat_request();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
		
}
