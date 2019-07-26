package model.idao;

import java.util.ArrayList;

import model.Docenti;
import model.Esami;


public interface ICRUDEsami {
	ArrayList<Esami> listaEsami(Docenti d, String data, int codEsame);
	boolean modificaEsami(Esami e);
	boolean eliminaEsami(Esami e);
	Esami ricercaEsami(Esami e);
	Esami inserimentoEsami(Esami es);
}
