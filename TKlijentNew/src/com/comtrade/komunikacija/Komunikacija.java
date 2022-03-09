package com.comtrade.komunikacija;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import com.danilo.konstante.Konstante;
import com.danilo.transferKlasa.TransferKlasa;

public class Komunikacija {
private Socket socket;
private static Komunikacija instanca;
private Komunikacija() {
	try {
		socket = new Socket(Konstante.IP_ADRESA.get_Ip_adresa(),Konstante.PORT.getPort());
	} catch (UnknownHostException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
public static Komunikacija getInstanca() {
	if(instanca == null) {
		instanca = new Komunikacija();
	}return instanca;
}

public void posaljiNaServer(TransferKlasa transferKlasa) {
	try {
		ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
		oos.writeObject(transferKlasa);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}
public TransferKlasa procitajSaServera() throws ClassNotFoundException, IOException {
	
		ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
		return (TransferKlasa) ois.readObject();
	
	
	
	
}
}
