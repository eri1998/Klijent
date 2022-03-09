package com.comtade.proxy;

import java.awt.GraphicsConfiguration;
import java.io.IOException;

import javax.swing.JOptionPane;

import com.danilo.domen.User;
import com.comtrade.kontrolerKI.KontrolerKI;
import com.comtrade.view.LogovanjeForma;
import com.comtrade.sajt.WebSite;


public class ProxyLogovanje implements IProxy {


	@Override
	public void login(User user) throws ClassNotFoundException, IOException {
		
		User user1 =  (User) KontrolerKI.getInstanca().login(user).getServer_objekat_response();
		if(user1.getEmail() != null && user1.getFullName() != null && user1.getPassword() != null && user1.getUsername() != null) {
		    WebSite wSite = new WebSite(user1);
			wSite.setVisible(true);
			
		}else {
			
			JOptionPane.showMessageDialog(null, "Netacni podaci,kreirajte nalog ukoliko niste");
			
			
		}
		LogovanjeForma lf = new LogovanjeForma(user1);
	}
	
}
