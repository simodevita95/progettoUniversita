package servlet;

import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Docenti;
import model.dao.CRUDDocenti;


@WebServlet("/docenti")
public class GestioneDocenti extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Docenti d=new Docenti();
	CRUDDocenti crdD=new CRUDDocenti();
	ArrayList<Docenti> arrayDoc= null;
	ResultSet rs;
	boolean eliminato = false;
	String nome;
	String cognome;
	String insegnamento;
	int CodDocente;
	String pagina;
	String message;
	String pagina2;
	
    public GestioneDocenti() {
        super();
    
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int x = Integer.parseInt(request.getParameter("x"));
		switch(x) {
		case 1://inserimento docenti
			getServletContext().getRequestDispatcher("/docenti/inserimentoDoc.jsp").forward(request, response);
			break;
		case 2://modifica docenti
			arrayDoc = crdD.listaDocenti();
			request.setAttribute("arrayDoc", arrayDoc);
			getServletContext().getRequestDispatcher("/docenti/modificaDoc.jsp").forward(request, response);
			break;
		case 3://ricerca docenti
			getServletContext().getRequestDispatcher("/docenti/ricercaDoc.jsp").forward(request, response);
			break;
		case 4://lista docenti
			pagina = "/admin/error.jsp";
			arrayDoc = crdD.listaDocenti();
			if(arrayDoc!=null) {
				request.setAttribute("arrayDoc", arrayDoc);
				pagina="/docenti/listaDoc.jsp";
			}else {
				message = "Lista non trovata";
				request.setAttribute("messaggio", message);
				pagina2= "/Universita/admin?x=4";
				request.setAttribute("page", pagina2);
			}
			getServletContext().getRequestDispatcher(pagina).forward(request, response);
			break;
		case 5://elimina docenti
			arrayDoc = crdD.listaDocenti();
			request.setAttribute("arrayDoc", arrayDoc);
			getServletContext().getRequestDispatcher("/docenti/eliminaDoc.jsp").forward(request, response);
			break;	
			
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int y = Integer.parseInt(request.getParameter("y"));
		switch(y) {
		case 1://inserimento docenti
			nome=request.getParameter("nome");
			cognome=request.getParameter("cognome");
			insegnamento=request.getParameter("insegnamento");
			d=new Docenti(nome,cognome,insegnamento);
			d=crdD.inserimentoDocenti(d);
			pagina = "/admin/menuAdmin.jsp";
			getServletContext().getRequestDispatcher(pagina).forward(request, response);
			break;
		case 2://modifica docenti
			pagina = "/admin/error.jsp";
			nome = request.getParameter("nome");
			cognome = request.getParameter("cognome");
			insegnamento = request.getParameter("insegnamento");
			CodDocente = Integer.parseInt(request.getParameter("codDocente"));
			d = new Docenti(nome, cognome, insegnamento, CodDocente);
			d=crdD.modificaDocenti(d);
			if(d!=null) {
				pagina="/admin/menuAdmin.jsp";
			}else {
				message = "Docente non modificato";
				request.setAttribute("messaggio", message);
				pagina2= "/Universita/admin?x=4";
				request.setAttribute("page", pagina2);
			}
			getServletContext().getRequestDispatcher(pagina).forward(request, response);
			break;
		case 3:
			pagina = "/admin/error.jsp";
			CodDocente = Integer.parseInt(request.getParameter("CodDocente"));
			d = new Docenti(CodDocente);
			eliminato = crdD.eliminaDocenti(d);
			if(eliminato==true) {
				pagina="/admin/menuAdmin.jsp";
			}else {
				message = "Docente non eliminato";
				request.setAttribute("messaggio", message);
				pagina2= "/Universita/admin?x=4";
				request.setAttribute("page", pagina2);
			}
			getServletContext().getRequestDispatcher(pagina).forward(request, response);
			break;
		case 4: 
			pagina = "/admin/error.jsp";
			CodDocente = Integer.parseInt(request.getParameter("CodDocente"));
			d = new Docenti(CodDocente);
			d=crdD.ricercaDocenti(d);
			if(d.getNome()!=null) {
				request.setAttribute("docente", d);
				pagina="/docenti/risRicercaD.jsp";
			}else {
				message = "Docente non presente!";
				request.setAttribute("messaggio", message);
				pagina2= "/Universita/admin?x=4";
				request.setAttribute("page", pagina2);
			}
			getServletContext().getRequestDispatcher(pagina).forward(request, response);
			break;	
		}
	
	}

}
