package model.idao;

import java.util.ArrayList;

import model.Studenti;

public interface ICRUDStudenti {
	Studenti loginStudenti(String username, String password);
	Studenti inserimentoStud(Studenti s);
	ArrayList<Studenti> listaStud();
	Studenti modificaStud(Studenti s);
	boolean eliminaStud(Studenti s);
	Studenti ricercaStud(Studenti s);
}
