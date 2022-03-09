package com.comtrade.kontrolerKI;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.danilo.domen.Adresa;
import com.danilo.domen.Drzava;
import com.danilo.domen.Grad;
import com.danilo.domen.Hotel;
import com.comtrade.hotelSlike.HotelFormaSlike;
import com.danilo.domen.HotelSlike;
import com.danilo.domen.PretragaHotela;
import com.danilo.domen.RezervacijaSobe;
import com.danilo.domen.Soba;
import com.danilo.domen.SobaSlike;
import com.danilo.domen.User;
import com.danilo.domen.UslugeHotel;
import com.danilo.domen.UslugeSoba;
import com.comtrade.komunikacija.Komunikacija;
import com.danilo.operacije.Operacije;
import com.danilo.transferKlasa.TransferKlasa;

public class KontrolerKI {
private static KontrolerKI instanca;
private KontrolerKI() {
	
}
public static KontrolerKI getInstanca() {
	if(instanca == null) {
		instanca = new KontrolerKI();
	}return instanca;
}

public TransferKlasa posaljiVrati(TransferKlasa transferKlasa) throws ClassNotFoundException, IOException {
	Komunikacija.getInstanca().posaljiNaServer(transferKlasa);
	TransferKlasa transferKlasa2 = Komunikacija.getInstanca().procitajSaServera();
	return transferKlasa2;
}

public TransferKlasa sacuvajUser(User user) throws ClassNotFoundException, IOException {
	TransferKlasa transferKlasa = new TransferKlasa();
	transferKlasa.setKlijent_objekat_request(user);
	transferKlasa.setOperacija(Operacije.SACUVAJ_USERA);
	return posaljiVrati(transferKlasa);

}

public TransferKlasa login(User user) throws ClassNotFoundException, IOException {
	TransferKlasa transferKlasa = new TransferKlasa();
	transferKlasa.setKlijent_objekat_request(user);
	transferKlasa.setOperacija(Operacije.LOGIN);
	return posaljiVrati(transferKlasa);
}
public TransferKlasa upisiDrzavu(Drzava drzava) throws ClassNotFoundException, IOException {
	TransferKlasa klasa = new TransferKlasa();
	klasa.setKlijent_objekat_request(drzava);
	klasa.setOperacija(Operacije.SACUVAJ_DRZAVU);
	return posaljiVrati(klasa);
}


public TransferKlasa vratiPoslednjuDrzavu() throws ClassNotFoundException, IOException {
	TransferKlasa transferKlasa = new TransferKlasa();
	transferKlasa.setOperacija(Operacije.VratiPoslednjuDrzavu);
	return posaljiVrati(transferKlasa);
	
	
}
public TransferKlasa upisiGrad(Grad grad) throws ClassNotFoundException, IOException {
	TransferKlasa transferKlasa = new TransferKlasa();
	transferKlasa.setKlijent_objekat_request(grad);
	transferKlasa.setOperacija(Operacije.SACUVAJ_GRAD);
	return posaljiVrati(transferKlasa);
}
public TransferKlasa vratiGradIzBaze() throws ClassNotFoundException, IOException {
	TransferKlasa transferKlasa = new TransferKlasa();
	transferKlasa.setOperacija(Operacije.VRATI_GRAD);
	return posaljiVrati(transferKlasa);
}
public TransferKlasa upisiAdresu(Adresa adresa) throws ClassNotFoundException, IOException {
	TransferKlasa transferKlasa = new TransferKlasa();
	transferKlasa.setKlijent_objekat_request(adresa);
	transferKlasa.setOperacija(Operacije.SACUVAJ_ADRESU);
	return posaljiVrati(transferKlasa);
}
public TransferKlasa vratiAdresuIzBaze() throws ClassNotFoundException, IOException {
	TransferKlasa transferKlasa = new TransferKlasa();
	transferKlasa.setOperacija(Operacije.VRATI_ADRESU);
	return posaljiVrati(transferKlasa);
}

public TransferKlasa sacuvajHotel(Hotel hotel) throws ClassNotFoundException, IOException {
	TransferKlasa transferKlasa = new TransferKlasa();
	transferKlasa.setKlijent_objekat_request(hotel);
	transferKlasa.setOperacija(Operacije.SACUVAJ_HOTEL);
	return posaljiVrati(transferKlasa);
	
}
public TransferKlasa sacuvajSobu(Soba soba) throws ClassNotFoundException, IOException {
	TransferKlasa transferKlasa = new TransferKlasa();
	transferKlasa.setKlijent_objekat_request(soba);
	transferKlasa.setOperacija(Operacije.SACUVAJ_SOBU);
	return posaljiVrati(transferKlasa);
	
	
}
public TransferKlasa vratiPoslednjuSobuIzBaze() throws ClassNotFoundException, IOException {
	TransferKlasa transferKlasa = new TransferKlasa();
	transferKlasa.setOperacija(Operacije.VRATI_SOBU);
	return posaljiVrati(transferKlasa);
	
	
}
public TransferKlasa sacuvajSlikeSobe(SobaSlike sobaSlike) throws ClassNotFoundException, IOException {
	TransferKlasa transferKlasa = new TransferKlasa();
	transferKlasa.setKlijent_objekat_request(sobaSlike);
	transferKlasa.setOperacija(Operacije.SACUVAJ_SLIKE_SOBA);
	return posaljiVrati(transferKlasa);
	
	
}
public TransferKlasa vratiSveSobeBaza() throws ClassNotFoundException, IOException {
	TransferKlasa transferKlasa = new TransferKlasa();
	transferKlasa.setOperacija(Operacije.VRATI_SVE_SOBE);
	return posaljiVrati(transferKlasa);
	
	
}
public TransferKlasa vratiUnetiHotelBaza() throws ClassNotFoundException, IOException {
	TransferKlasa transferKlasa = new TransferKlasa();
	transferKlasa.setOperacija(Operacije.VRATI_UNETI_HOTEL);
	return posaljiVrati(transferKlasa);
	
	
}
public TransferKlasa sacuvajUslugeSobe(UslugeSoba uslugeSoba) throws ClassNotFoundException, IOException {
	TransferKlasa transferKlasa = new TransferKlasa();
	transferKlasa.setKlijent_objekat_request(uslugeSoba);
	transferKlasa.setOperacija(Operacije.SACUVAJ_USLUGE_SOBA);
	return posaljiVrati(transferKlasa);
	
	
}
public TransferKlasa upisiUslugeHotela(UslugeHotel uslugeHotel) throws ClassNotFoundException, IOException {
	TransferKlasa transferKlasa = new TransferKlasa();
	transferKlasa.setKlijent_objekat_request(uslugeHotel);
	transferKlasa.setOperacija(Operacije.UPISI_USLUGE);
	return posaljiVrati(transferKlasa);
	
	
}
public TransferKlasa sacuvajSlikeHotela(HotelSlike hotelSlike) throws ClassNotFoundException, IOException {
	TransferKlasa transferKlasa = new TransferKlasa();
	transferKlasa.setKlijent_objekat_request(hotelSlike);
	transferKlasa.setOperacija(Operacije.SACUVAJ_SLIKE_HOTELA);
	return posaljiVrati(transferKlasa);
	
	
}
public TransferKlasa pretraga(Hotel hotel) throws ClassNotFoundException, IOException {
	List<Hotel>listsHotel = new ArrayList<>();
	TransferKlasa transferKlasa = new TransferKlasa();
	transferKlasa.setKlijent_objekat_request(hotel);
	transferKlasa.setOperacija(Operacije.PRETRAZI);
	return posaljiVrati(transferKlasa);
	
	
}
public TransferKlasa vratiSobeIzabranogHotela(Soba soba) throws ClassNotFoundException, IOException {
	TransferKlasa transferKlasa = new TransferKlasa();
	transferKlasa.setKlijent_objekat_request(soba);
	transferKlasa.setOperacija(Operacije.VRATI_SOBU_IZABRANOG_HOTELA);
	return posaljiVrati(transferKlasa);
}
public TransferKlasa rezervisiSobu(RezervacijaSobe rezervacijaSobe) throws ClassNotFoundException, IOException {
	TransferKlasa transferKlasa = new TransferKlasa();
	transferKlasa.setKlijent_objekat_request(rezervacijaSobe);
	transferKlasa.setOperacija(Operacije.REZERVACIJA);
	return posaljiVrati(transferKlasa);
	
	
}
public TransferKlasa vratiRezervacijeSobe() throws ClassNotFoundException, IOException {
	TransferKlasa transferKlasa = new  TransferKlasa();
	transferKlasa.setOperacija(Operacije.VRATI_REZERVACIJE);
	return posaljiVrati(transferKlasa);
}
}
