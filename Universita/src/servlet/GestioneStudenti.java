package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Studenti;
import model.dao.CRUDStudenti;


@WebServlet("/studenti")
public class GestioneStudenti extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Studenti s=new Studenti();
	CRUDStudenti crdS=new CRUDStudenti();
	ArrayList<Studenti> arrayStud = null;
	PrintWriter out = null;
	ResultSet rs;
	boolean eliminato = false;
	String nome;
	String cognome;
	String username;
	String password;
	int CodStudente;
	String pagina;
	String message;
	String pagina2;
	public GestioneStudenti() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int x = Integer.parseInt(request.getParameter("x"));
		switch(x) {
		case 1://login studenti
			getServletContext().getRequestDispatcher("/profiloStud/loginStud.jsp").forward(request, response);
			break;
		case 2://inserimento studenti
			getServletContext().getRequestDispatcher("/studenti/inserimentoStud.jsp").forward(request, response);
			break;
		case 3://modifica studenti
			arrayStud = crdS.listaStud();
			request.setAttribute("arrayStud", arrayStud);
			getServletContext().getRequestDispatcher("/studenti/modificaStud.jsp").forward(request, response);
			break;
		case 4://ricerca studenti
			getServletContext().getRequestDispatcher("/studenti/ricercaStud.jsp").forward(request, response);
			break;
		case 5://lista studenti
			pagina = "/admin/error.jsp";
			arrayStud = crdS.listaStud();
			if(arrayStud!=null) {
				request.setAttribute("arrayStud", arrayStud);
				pagina="/studenti/listaStud.jsp";
			}else {
				message = "Lista non trovata";
				request.setAttribute("messaggio", message);
				pagina2= "/Universita/admin?x=2";
				request.setAttribute("page", pagina2);
			}
			getServletContext().getRequestDispatcher(pagina).forward(request, response);
			break;
		case 6://elimina stud
			arrayStud = crdS.listaStud();
			request.setAttribute("arrayStud", arrayStud);
			getServletContext().getRequestDispatcher("/studenti/eliminaStud.jsp").forward(request, response);
			break;
		case 7://forward menuStud
			getServletContext().getRequestDispatcher("/profiloStud/menuStudente.jsp").forward(request, response);
			break;
		case 8:getServletContext().getRequestDispatcher("/profiloStud/registrati.jsp").forward(request, response);
		break;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int y = Integer.parseInt(request.getParameter("y"));
		switch(y) {
		case 1://inserimento studenti
			pagina = "/admin/error.jsp";
			username=request.getParameter("username");
			password=request.getParameter("password");
			nome=request.getParameter("nome");
			cognome=request.getParameter("cognome");
			s = new Studenti(nome, cognome, username, password);
			s = crdS.inserimentoStud(s);
			if(s.getCodStudente()!=0) {
				pagina="/admin/menuAdmin.jsp";
			}else {
				message = "Studente non inserito";
				request.setAttribute("messaggio", message);
				pagina2= "/Universita/admin?x=2";
				request.setAttribute("page", pagina2);
			}
			getServletContext().getRequestDispatcher(pagina).forward(request, response);
			break;
		case 2://modifica studenti
			pagina = "/admin/error.jsp";
			nome = request.getParameter("nome");
			cognome = request.getParameter("cognome");
			password = request.getParameter("password");
			int codStudente = Integer.parseInt(request.getParameter("codStudente"));
			s = new Studenti(nome, cognome, password, codStudente);
			s=crdS.modificaStud(s);
			if(s!=null) {
				pagina="/admin/menuAdmin.jsp";
			}else {
				message = "Studente non modificato";
				request.setAttribute("messaggio", message);
				pagina2= "/Universita/admin?x=2";
				request.setAttribute("page", pagina2);
			}
			getServletContext().getRequestDispatcher(pagina).forward(request, response);
			break;
		case 3://elimina studenti
			pagina = "/admin/error.jsp";
			CodStudente = Integer.parseInt(request.getParameter("CodStudente"));
			s = new Studenti(CodStudente);
			eliminato = crdS.eliminaStud(s);
			if(eliminato==true) {
				pagina="/admin/menuAdmin.jsp";
			}else {
				message = "Studente non eliminato";
				request.setAttribute("messaggio", message);
				pagina2= "/Universita/admin?x=2";
				request.setAttribute("page", pagina2);
			}
			getServletContext().getRequestDispatcher(pagina).forward(request, response);
			break;
		case 4://ricerca studenti
			pagina = "/admin/error.jsp";
			CodStudente = Integer.parseInt(request.getParameter("CodStudente"));
			s = new Studenti(CodStudente);
			s=crdS.ricercaStud(s);
			if(s.getNome()!=null) {
				request.setAttribute("studente", s);
				pagina="/studenti/risRicerca.jsp";
			}else {
				message = "Studente non presente!";
				request.setAttribute("messaggio", message);
				pagina2= "/Universita/admin?x=2";
				request.setAttribute("page", pagina2);
			}
			getServletContext().getRequestDispatcher(pagina).forward(request, response);
			break;
		case 5://registrazione studenti
			pagina = "/admin/error.jsp";
			username=request.getParameter("username");
			password=request.getParameter("password");
			nome=request.getParameter("nome");
			cognome=request.getParameter("cognome");
			s = new Studenti(nome, cognome, username, password);
			s = crdS.inserimentoStud(s);
			if(s.getCodStudente()!=0) {
				pagina="/profiloStud/loginStud.jsp";
			}else {
				message = "Registrazione non riuscita";
				request.setAttribute("messaggio", message);
				pagina2= "/Universita/studenti?x=8";
				request.setAttribute("page", pagina2);
			}
			getServletContext().getRequestDispatcher(pagina).forward(request, response);
			break;
		}
	}
}
