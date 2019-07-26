package model.idao;

import java.util.ArrayList;

import model.Docenti;


public interface ICRUDDocenti {
	Docenti inserimentoDocenti(Docenti d);
	ArrayList<Docenti> listaDocenti();
	Docenti modificaDocenti(Docenti d);
	boolean eliminaDocenti(Docenti d);
	Docenti ricercaDocenti(Docenti d);
}
