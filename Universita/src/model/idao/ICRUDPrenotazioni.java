package model.idao;

import java.util.ArrayList;

import model.Prenotazioni;

public interface ICRUDPrenotazioni {
	Prenotazioni prenota(Prenotazioni p);
	ArrayList<Prenotazioni> listaesami(Prenotazioni p);
	boolean eliminaprenotazione(Prenotazioni p);
}
