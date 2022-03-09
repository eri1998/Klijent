package com.comtrade.hotelSlike;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import com.danilo.domen.HotelSlike;
import com.danilo.domen.User;
import com.danilo.domen.UslugeHotel;
import com.comtrade.kontrolerKI.KontrolerKI;
import com.comtrade.sajt.WebSite;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;

public class HotelFormaSlike extends JFrame {

	
	private JPanel contentPane;
	private ImageIcon imageIcon;
    private int choosePool;
    private int chooseGym;
    private int chooseWellness;
    private int chooseRestourant;
    private int chooseBar;
    private boolean checkPool;
    private boolean checkGym;
    private boolean checkWellness;
    private boolean checkRestourant;
    private boolean checkBar;
    private static int idHotel;
    private JLabel informationMessage ;
    private User user;
    
 
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HotelFormaSlike frame = new HotelFormaSlike(idHotel);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
*/
	/**
	 * Create the frame.
	 * @param idHotel 
	 * @param user 
	 */
	public HotelFormaSlike(int idHotel, User user) {
		this.user=user;
		this.idHotel=idHotel;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(-10, 0, 1560, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		contentPane.setLayout(null);
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
		List<Component>listSlika = new ArrayList<>();
		List<String>urlSlike = new ArrayList<>();
		List<ImageIcon>listImageIcon = new ArrayList<>();
		List<JLabel>listaOkvira=new ArrayList<>();
		JLabel lblTitle = new JLabel();
		lblTitle.setText("Postavite slike vaseg hotela,radi bolje prezentacije");
		lblTitle.setFont(new Font("Ink Free", Font.BOLD, 48));
		lblTitle.setForeground(Color.CYAN);
		lblTitle.setBounds(170, 20, 1170, 60);
		contentPane.add(lblTitle);
		JLabel removeMessage = new JLabel();
		removeMessage.setIcon(new ImageIcon(HotelFormaSlike.class.getResource("/slike/removeMessage.png")));
		removeMessage.setBounds(1410, 90, removeMessage.getIcon().getIconWidth(), removeMessage.getIcon().getIconHeight());
		removeMessage.hide();
		contentPane.add(removeMessage);
		removeMessage.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e ) {
				informationMessage.hide();
				removeMessage.hide();
			}
			public void mouseEntered(MouseEvent e) {
				removeMessage.show();
			}
			public void mouseExited(MouseEvent e) {
				removeMessage.hide();
			}
		});
		 informationMessage = new JLabel();
		 informationMessage.setBorder(new LineBorder(Color.RED,5));
		informationMessage.setIcon(new ImageIcon(HotelFormaSlike.class.getResource("/slike/informationMessage.png")));
		informationMessage.setBounds(1025, 100, informationMessage.getIcon().getIconWidth(), informationMessage.getIcon().getIconHeight());
		informationMessage.hide();
		contentPane.add(informationMessage);
		informationMessage.addMouseListener(new MouseAdapter() {
			public void mouseExited(MouseEvent e) {
				removeMessage.hide();
			}
            public void mouseEntered(MouseEvent e) {
				removeMessage.show();
			}
           
		});
		
		JPanel panel = new JPanel();
		panel.setOpaque(false);
		panel.setBounds(130,580,1300,330);
		panel.setLayout(new GridLayout(0,4,10,10));
		panel.setBorder(new LineBorder(Color.CYAN,2));
		contentPane.add(panel);
		JLabel poolIcon = new JLabel();
		poolIcon.setBorder(new LineBorder(Color.CYAN,1));
		poolIcon.setIcon(new ImageIcon(HotelFormaSlike.class.getResource("/slike/bazenIkonica.png")));
		poolIcon.setBounds(140, 260, poolIcon.getIcon().getIconWidth(), poolIcon.getIcon().getIconHeight());
		contentPane.add(poolIcon);
		JLabel choosePoolIcon = new JLabel();
		choosePoolIcon.setIcon(new ImageIcon(HotelFormaSlike.class.getResource("/slike/nike.png")));
		choosePoolIcon.setBounds(255, 360, choosePoolIcon.getIcon().getIconWidth(), choosePoolIcon.getIcon().getIconHeight());
		contentPane.add(choosePoolIcon);
		choosePoolIcon.hide();
		choosePool = 0;
		poolIcon.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				choosePool++;
				if(choosePool%2 != 0) {
					choosePoolIcon.setIcon(new ImageIcon(HotelFormaSlike.class.getResource("/slike/nike.png")));
					choosePoolIcon.show();
					checkPool=true;
					validate();
					repaint();
				}else {
					choosePoolIcon.hide();
					checkPool=false;
					//chooseIcon.setVisible(false);
				}
			}
			public void mouseEntered(MouseEvent e) {
				setCursor(HAND_CURSOR);
				if(choosePool%2 == 0) {
				poolIcon.setBorder(new LineBorder(Color.GREEN,1));
			}else {
				poolIcon.setBorder(new LineBorder(Color.RED,1));
				}
			}
			public void mouseExited(MouseEvent e) {
				poolIcon.setBorder(new LineBorder(Color.CYAN,1));
				setCursor(DEFAULT_CURSOR);
				
				
			}
		});
		JLabel gymIcon = new JLabel();
		gymIcon.setBorder(new LineBorder(Color.CYAN,1));
		gymIcon.setIcon(new ImageIcon(HotelFormaSlike.class.getResource("/slike/gymIkonica.png")));
		gymIcon.setBounds(250, 100, gymIcon.getIcon().getIconWidth(), gymIcon.getIcon().getIconHeight());
		contentPane.add(gymIcon);
		JLabel chooseGymIcon = new JLabel();
		chooseGymIcon.setIcon(new ImageIcon(HotelFormaSlike.class.getResource("/slike/nike.png")));
		chooseGymIcon.setBounds(365, 200, chooseGymIcon.getIcon().getIconWidth(), chooseGymIcon.getIcon().getIconHeight());
		contentPane.add(chooseGymIcon);
		chooseGymIcon.hide();
		chooseGym=0;
		gymIcon.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				chooseGym++;
				if(chooseGym%2 != 0) {
					chooseGymIcon.show();
					checkGym=true;
				}else {
					
					chooseGymIcon.hide();
					checkGym=false;
				}
			}
            public void mouseEntered(MouseEvent e) {
            	setCursor(HAND_CURSOR);
            	if(chooseGym%2 == 0) {
					gymIcon.setBorder(new LineBorder(Color.GREEN,1));
				}else {
					gymIcon.setBorder(new LineBorder(Color.RED,1));
				}
			}
			public void mouseExited(MouseEvent e) {
				gymIcon.setBorder(new LineBorder(Color.CYAN,1));
				setCursor(DEFAULT_CURSOR);
			}
		});
		JLabel restorauntIcon = new JLabel();
		restorauntIcon.setBorder(new LineBorder(Color.CYAN,1));
		restorauntIcon.setIcon(new ImageIcon(HotelFormaSlike.class.getResource("/slike/restoranIkonica.png")));
		restorauntIcon.setBounds(75, 100, restorauntIcon.getIcon().getIconWidth(), restorauntIcon.getIcon().getIconHeight());
		contentPane.add(restorauntIcon);
		JLabel chooseRestorauntIcon = new JLabel();
		chooseRestorauntIcon.setIcon(new ImageIcon(HotelFormaSlike.class.getResource("/slike/nike.png")));
		chooseRestorauntIcon.setBounds(186, 200, chooseRestorauntIcon.getIcon().getIconWidth(), chooseRestorauntIcon.getIcon().getIconHeight());
		contentPane.add(chooseRestorauntIcon);
		chooseRestorauntIcon.hide();
		chooseRestourant = 0;
		restorauntIcon.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				chooseRestourant++;
				setCursor(HAND_CURSOR);
				if(chooseRestourant%2 != 0) {
					restorauntIcon.setBorder(new LineBorder(Color.GREEN,1));
				}else {
					restorauntIcon.setBorder(new LineBorder(Color.RED,1));
				}
			}
			public void mouseExited(MouseEvent e) {
				setCursor(DEFAULT_CURSOR);
				restorauntIcon.setBorder(new LineBorder(Color.CYAN,1));
			}
			public void mouseClicked(MouseEvent e) {
				if(chooseRestourant%2!=0) {
					chooseRestorauntIcon.show();
					checkRestourant=true;
				}else {
					chooseRestorauntIcon.hide();
					checkRestourant=false;
				}
			}
		});
		JLabel barIcon = new JLabel();
		barIcon.setIcon(new ImageIcon(HotelFormaSlike.class.getResource("/slike/barIcon.png")));
		barIcon.setBorder(new LineBorder(Color.CYAN,1));
		barIcon.setBounds(425, 100, barIcon.getIcon().getIconWidth(),barIcon.getIcon().getIconHeight());
		contentPane.add(barIcon);
		JLabel chooseBarIcon = new JLabel();
		chooseBarIcon.setIcon(new ImageIcon(HotelFormaSlike.class.getResource("/slike/nike.png")));
		chooseBarIcon.setBounds(540, 200, chooseBarIcon.getIcon().getIconWidth(), chooseBarIcon.getIcon().getIconHeight());
		contentPane.add(chooseBarIcon);
		chooseBarIcon.hide();
		chooseBar=0;
		barIcon.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				chooseBar++;
				setCursor(HAND_CURSOR);
				if(chooseBar %2 != 0) {
					barIcon.setBorder(new LineBorder(Color.GREEN,1));
				}else {
					barIcon.setBorder(new LineBorder(Color.RED,1));
				}
			}
			public void mouseExited(MouseEvent e) {
				setCursor(DEFAULT_CURSOR);
				barIcon.setBorder(new LineBorder(Color.CYAN,1));
			}
			public void mouseClicked(MouseEvent e) {
				if(chooseBar %2 != 0) {
					chooseBarIcon.show();
					checkBar=true;
				}else {
					chooseBarIcon.hide();
					checkBar=false;
				}
			}
		});
		JLabel wellnessIcon = new JLabel();
		wellnessIcon.setIcon(new ImageIcon(HotelFormaSlike.class.getResource("/slike/spaIcon.png")));
		wellnessIcon.setBorder(new LineBorder(Color.CYAN,1));
		wellnessIcon.setBounds(360,265,wellnessIcon.getIcon().getIconWidth(),wellnessIcon.getIcon().getIconHeight());
		contentPane.add(wellnessIcon);
		JLabel chooseWellnessIcon = new JLabel();
		chooseWellnessIcon.setIcon(new ImageIcon(HotelFormaSlike.class.getResource("/slike/nike.png")));
		chooseWellnessIcon.setBounds(470, 364, chooseWellnessIcon.getIcon().getIconWidth(), chooseWellnessIcon.getIcon().getIconHeight());
		contentPane.add(chooseWellnessIcon);
		chooseWellnessIcon.hide();
		chooseWellness=0;
		wellnessIcon.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				chooseWellness++;
				setCursor(HAND_CURSOR);
				if(chooseWellness %2 != 0) {
					wellnessIcon.setBorder(new LineBorder(Color.GREEN,1));
				}else {
					
					wellnessIcon.setBorder(new LineBorder(Color.RED,1));
				}
			}
			public void mouseExited(MouseEvent e) {
				setCursor(DEFAULT_CURSOR);
				wellnessIcon.setBorder(new LineBorder(Color.CYAN,1));
			}
			public void mouseClicked(MouseEvent e) {
				if(chooseWellness %2 != 0) {
					chooseWellnessIcon.show();
					checkWellness=true;
				}else {
					chooseWellnessIcon.hide();
					checkWellness=false;
				}
			}
		});
		JScrollPane jScrollPane = new JScrollPane();
		jScrollPane.setOpaque(false);
		jScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		jScrollPane.setBounds(130,440,1300,300);
		contentPane.add(jScrollPane);
		jScrollPane.setViewportView(panel);
		jScrollPane.getViewport().setOpaque(false);
		
		
		JLabel lblImgIcon = new JLabel();
		lblImgIcon.setBorder(new LineBorder(Color.CYAN,2));
		lblImgIcon.setIcon(new ImageIcon(HotelFormaSlike.class.getResource("/slike/imgFles.png")));
		lblImgIcon.setBounds(650,125,lblImgIcon.getIcon().getIconHeight(),lblImgIcon.getIcon().getIconWidth());
		lblImgIcon.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				lblImgIcon.setEnabled(false);
				Cursor cursor = new Cursor(HAND_CURSOR);
			setCursor(cursor);
			}
			public void mouseExited(MouseEvent e) {
				lblImgIcon.setEnabled(true);
				setCursor(DEFAULT_CURSOR);
				
			}
			public void mouseClicked(MouseEvent e) {
				panel.show();
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.setCurrentDirectory(new File("C:\\"));
				fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
				fileChooser.showOpenDialog(HotelFormaSlike.this);
				File file = fileChooser.getSelectedFile();
				 imageIcon = new ImageIcon(file.getAbsolutePath());
				Image image = imageIcon.getImage().getScaledInstance(240, 220, Image.SCALE_SMOOTH);
				imageIcon = new ImageIcon(image);
				listImageIcon.add(imageIcon);
				String name = file.getName();
				BufferedImage buf = null;
				try {
					buf = ImageIO.read(file);
				} catch (IOException e3) {
					// TODO Auto-generated catch block
					e3.printStackTrace();
				}
				String  Location = "C:/Users\\Danilo/eclipse-workspace/trenutni projekat/TKlijent/folder/" + name;
				String format = "PNG";
				
				try {
				ImageIO.write(buf, format, new File(Location));
				} catch (IOException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				// ("C:\\Users\\win7\\eclipse-workspace\\Server\\folder\\1zvezdice.png");
				urlSlike.add(Location);
				JLabel lblSlikaProba = new JLabel(imageIcon);
				listSlika.add(lblSlikaProba);
				if(listSlika.size()>=2 ) {
					for(int i = listSlika.size()-1;i>=0;i--) {
						
						panel.add(listSlika.get(i));
						
					}
				}else {
					panel.add(listSlika.get(0));
				}
				//panel.add(lblSlikaProba);
				lblSlikaProba.addMouseListener(new MouseAdapter() {
					public void mouseEntered(MouseEvent e1) {
						
						lblSlikaProba.setBorder(new LineBorder(Color.RED,2));
						validate();
						repaint();
					}
					public void mouseExited(MouseEvent e1) {
						 lblSlikaProba.setBorder(null);
						
					}
					public void mouseClicked(MouseEvent e) {
						int pitanje = JOptionPane.showConfirmDialog(null, "Da li zelite da izbrisete sliku","Postovani,",JOptionPane.YES_NO_OPTION);
						int YES = 0;
						if(YES == pitanje) {	
							listSlika.remove(lblSlikaProba);
							listImageIcon.remove(lblSlikaProba.getIcon());
							urlSlike.remove(name);
					        panel.remove(lblSlikaProba);
					        panel.repaint();
							
						}else {
							requestFocusInWindow();
						}
					}
				});
				
				validate();
				repaint();
			}
		});
		JLabel btnUnesi = new JLabel();
		btnUnesi.setIcon(new ImageIcon(HotelFormaSlike.class.getResource("/slike/btnUnesi.png")));
		btnUnesi.setBounds(680, 400, btnUnesi.getIcon().getIconWidth(), btnUnesi.getIcon().getIconHeight());
		contentPane.add(btnUnesi);
		btnUnesi.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				setCursor(HAND_CURSOR);
				btnUnesi.setBorder(new LineBorder(Color.BLACK,2));
			}
			public void mouseExited(MouseEvent e) {
				setCursor(DEFAULT_CURSOR);
				btnUnesi.setBorder(null);
			}
			public void mouseClicked(MouseEvent e) {
				
				if(panel.countComponents()>0) {
					JOptionPane.showMessageDialog(null, "Izaberite glavnu(pocetnu) sliku");
					requestFocusInWindow();
					panel.removeAll();
					
					for(int i=0;i<listSlika.size();i++) {
						JLabel slika = new JLabel();
						listaOkvira.add(slika);
						//panel.add(slika);
						
						slika.addMouseListener(new MouseAdapter() {
							public void mouseEntered(MouseEvent e ) {
								slika.setBorder(new LineBorder(Color.GREEN,1));
							}
							public void mouseExited(MouseEvent e) {
									slika.setBorder(null);				
							}
							public void mouseClicked(MouseEvent e ) {
								int izabranaFotografija = (listaOkvira.indexOf(slika));  
								int Yes=JOptionPane.showConfirmDialog(null,"Da li ste sigurni da zelite ovu fotografiju kao profilnu?","Postovani,",JOptionPane.YES_NO_OPTION);
								if(Yes==0) {
									UslugeHotel uslugeHotel = new UslugeHotel();
									uslugeHotel.setBar(checkBar);
									uslugeHotel.setGym(checkGym);
									uslugeHotel.setPool(checkPool);
									uslugeHotel.setRestoraunt(checkRestourant);
									uslugeHotel.setWellness(checkWellness);
									uslugeHotel.setIdHotel(idHotel);
									try {
										KontrolerKI.getInstanca().upisiUslugeHotela(uslugeHotel).getServer_objekat_response();
										HotelSlike hotelSlike = new HotelSlike();
										for(int i=0;i<urlSlike.size();i++) {
											if(izabranaFotografija == i) {
											hotelSlike.setStatusForografije(1);
											}else {
												hotelSlike.setStatusForografije(0);
											}
											hotelSlike.setUrlSlike(urlSlike.get(i));
											hotelSlike.setIdHotel(idHotel);
											KontrolerKI.getInstanca().sacuvajSlikeHotela(hotelSlike);
											//JOptionPane.showMessageDialog(null, "Uspesno sacuvan hotel", "Postovani,", JOptionPane.YES_OPTION);
											WebSite webSite = new WebSite(user);
											dispose();
											webSite.setVisible(true);
										}
										
									} catch (ClassNotFoundException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									} catch (IOException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}
								}else {
									requestFocusInWindow();
								}
							}
						
						});
						}
					
					for(int index=listImageIcon.size()-1;index>=0;index--) {
						
						 listaOkvira.get(index).setIcon(listImageIcon.get(index));
						 panel.add(listaOkvira.get(index), listImageIcon.get(index));
						 
						}
					System.out.println();
					
					panel.repaint();
					//UslugeHotel uslugeHotel = new UslugeHotel();
					//uslugeHotel.setBar(checkBar);
					//uslugeHotel.setGym(checkGym);
					//uslugeHotel.setPool(checkPool);
					//uslugeHotel.setRestoraunt(checkRestourant);
					//uslugeHotel.setWellness(checkWellness);
					//uslugeHotel.setIdHotel(idHotel);
					//try {
					//	KontrolerKI.getInstanca().upisiUslugeHotela(uslugeHotel).getServer_objekat_response();
					//	HotelSlike hotelSlike = new HotelSlike();
					//	for(int i=0;i<urlSlike.size();i++) {
						//	hotelSlike.setUrlSlike(urlSlike.get(i));
						//	hotelSlike.setIdHotel(idHotel);
						//	KontrolerKI.getInstanca().sacuvajSlikeHotela(hotelSlike);
					//	}
						
					//} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
					//	e1.printStackTrace();
					//} catch (IOException e1) {
						// TODO Auto-generated catch block
						//e1.printStackTrace();
					//}
					
				}else {
					informationMessage.show();
				}
				
			}
		});
		contentPane.add(lblImgIcon);
		JLabel lblBackground = new JLabel("");
		lblBackground.setBounds(0, 0, 1540, 840);
		lblBackground.setIcon(new ImageIcon(HotelFormaSlike.class.getResource("/slike/pozadinaFles.jpg")));
		contentPane.add(lblBackground);
		
		
	}

}
