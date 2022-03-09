package com.comtrade.hotelSlike;

import java.awt.Image;
import java.awt.Label;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.imageio.ImageReadParam;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import com.danilo.domen.Hotel;

public class HotelSlikeWrapper {
private JLabel btnNext;
private JLabel btnPrevius;
private Hotel hotel;
private JLabel labelaSlike;
private int currentPosition = 0;
public static int CURRENT=0;
public static int PREVIUS=1;
public static int NEXT=2;
public JLabel getBtnNext() {
	return btnNext;
}
public void setBtnNext(JLabel btnNext) {
	this.btnNext = btnNext;
}
public JLabel getBtnPrevius() {
	return btnPrevius;
}
public void setBtnPrevius(JLabel btnPrevius) {
	this.btnPrevius = btnPrevius;
}
public Hotel getHotel() {
	return hotel;
}
public void setHotel(Hotel hotel) {
	this.hotel = hotel;
}
public JLabel getLabelaSlike() {
	return labelaSlike;
}
public void setLabelaSlike(JLabel labelaSlike) {
	this.labelaSlike = labelaSlike;
}
public int getCurrentPosition() {
	return currentPosition;
}
public void setCurrentPosition(int currentPosition) {
	this.currentPosition = currentPosition;
}
public void setSlika(int izabranSmer) {
	
	if(izabranSmer == NEXT) {
		currentPosition++;
		if(currentPosition>hotel.getUrlSlika().size()-1) {
			currentPosition=0;
		}
	}else if(izabranSmer == PREVIUS) {
		currentPosition--;
		if(currentPosition<0) {
			currentPosition=hotel.getUrlSlika().size()-1;
		}
	}
		
	
	String url = hotel.getUrlSlika().get(currentPosition);
	File sourceImage = new File(url);
	try {
		BufferedImage readImage = ImageIO.read(sourceImage);
		Image scaled = readImage.getScaledInstance(labelaSlike.getWidth(), labelaSlike.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon icon = new ImageIcon(scaled);
		labelaSlike.setIcon(icon);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}




}
