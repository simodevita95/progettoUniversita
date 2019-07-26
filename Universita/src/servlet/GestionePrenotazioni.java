package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Docenti;
import model.Esami;
import model.Prenotazioni;
import model.Studenti;
import model.dao.CRUDEsami;
import model.dao.CRUDPrenotazioni;

@WebServlet("/prenotazioni")
public class GestionePrenotazioni extends HttpServlet {
	private static final long serialVersionUID = 1L;
	HttpSession session;
	CRUDEsami crdE = new CRUDEsami();
	CRUDPrenotazioni crdP= new CRUDPrenotazioni();
	Docenti d = new Docenti();
	Esami es = new Esami();
	Studenti s= new Studenti();
	Prenotazioni p=new Prenotazioni();
	String data;
	int CodEsame;
	int CodStud;
	int codPrenotazione;
	String pagina;
	String pagina2;
	String message;
	ArrayList <Esami> arrayE = new ArrayList<>();
	public GestionePrenotazioni() {
		super();

	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int x=Integer.parseInt(request.getParameter("x"));
		switch(x) {
		case 1:  arrayE = crdE.listaEsami(d, data, CodEsame);
		request.setAttribute("listaE", arrayE);
		for(Esami eser:arrayE) {
			System.out.println(eser.getCodEsame()+eser.getData()+eser.getD().getCodDocente());
		}

		getServletContext().getRequestDispatcher("/profiloStud/prenotaEsame.jsp").forward(request, response);
		break;
		case 2:HttpSession session = request.getSession();
		s=(Studenti)session.getAttribute("stud");
		p.setS(s);
		ArrayList<Prenotazioni>arrayP=crdP.listaesami(p);
		request.setAttribute("arrayP", arrayP);
		getServletContext().getRequestDispatcher("/profiloStud/listaEsami.jsp").forward(request, response);
		break;
		case 3:
		session = request.getSession();
		s=(Studenti)session.getAttribute("stud");
		p.setS(s);
		ArrayList<Prenotazioni>arrayPE=crdP.listaesami(p);
		request.setAttribute("arrayPE", arrayPE);
		getServletContext().getRequestDispatcher("/profiloStud/eliminaPrenotazione.jsp").forward(request, response);
		break;
		case 4:getServletContext().getRequestDispatcher("/profiloStud/modificaProfilo.jsp").forward(request, response);
		break;
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int y=Integer.parseInt(request.getParameter("y"));
		switch(y) {
		case 1: 
			pagina = "/admin/error.jsp";
			HttpSession session=request.getSession();
			s=(Studenti)session.getAttribute("stud");
			CodEsame=Integer.parseInt(request.getParameter("CodEsame"));
			es.setCodEsame(CodEsame);
			p=new Prenotazioni(s,es);
			crdP.prenota(p);
			if(p.getIdprenotazione()==0) {
				pagina="/profiloStud/menuStudente.jsp";
			}else {
				message = "Prenotazione non effettuata";
				request.setAttribute("messaggio", message);
				pagina2= "/Universita/studenti?x=7";
				request.setAttribute("page", pagina2);
			}
			getServletContext().getRequestDispatcher(pagina).forward(request, response);
			break;
		case 2:
			pagina = "/admin/error.jsp";
			codPrenotazione=Integer.parseInt(request.getParameter("CodPrenotazione"));
			p.setIdprenotazione(codPrenotazione);
			boolean successo=crdP.eliminaprenotazione(p);
			if(successo==true) {
				pagina="/profiloStud/menuStudente.jsp";
			}else {
				message = "Prenotazione non cancellata";
				request.setAttribute("messaggio", message);
				pagina2= "/Universita/studenti?x=7";
				request.setAttribute("page", pagina2);
			}
			getServletContext().getRequestDispatcher(pagina).forward(request, response);

		}
	}

}
