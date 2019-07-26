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
import model.Esami;
import model.Studenti;
import model.dao.CRUDDocenti;
import model.dao.CRUDEsami;


@WebServlet("/Esami")
public class GestioneEsami extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Docenti d=new Docenti();
	CRUDDocenti crdD=new CRUDDocenti();
	CRUDEsami crdE = new CRUDEsami();
	ArrayList<Docenti> arrayDoc= null;
	ArrayList<Esami> arrayE=null;
	ResultSet rs;
	boolean eliminato = false;
	Esami es=new Esami();
	String data;
	String nome;
	int CodEsame;
	int CodDocente;
	String pagina;
	String message;
	String pagina2;

	public GestioneEsami() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int x=Integer.parseInt(request.getParameter("x"));
		switch(x) {
		case 1://inserimento esame
			arrayDoc = crdD.listaDocenti();
			request.setAttribute("arrayDoc", arrayDoc);
			getServletContext().getRequestDispatcher("/Esami/inserimentoEsami.jsp").forward(request, response);
			break;
		case 2://elimina esame
			arrayE = crdE.listaEsami(d, data, CodEsame);
			request.setAttribute("arrayE", arrayE);
			getServletContext().getRequestDispatcher("/Esami/eliminaEsami.jsp").forward(request, response);
			break;
		case 3://lista esami
			pagina = "/admin/error.jsp";
			arrayE = crdE.listaEsami(d, data, CodEsame);
			if(arrayE!=null) {
				request.setAttribute("arrayE", arrayE);
				pagina="/Esami/listaEsami.jsp";
			}else {
				message = "Lista non trovata";
				request.setAttribute("messaggio", message);
				pagina2= "/Universita/admin?x=2";
				request.setAttribute("page", pagina2);
			}
			getServletContext().getRequestDispatcher(pagina).forward(request, response);
			break;
		case 4://modifica esame
			arrayDoc = crdD.listaDocenti();
			request.setAttribute("arrayDoc", arrayDoc);
			arrayE = crdE.listaEsami(d, data, CodEsame);
			request.setAttribute("arrayE", arrayE);
			getServletContext().getRequestDispatcher("/Esami/modificaEsami.jsp").forward(request, response);
			break;
		case 5://ricerca esami
			getServletContext().getRequestDispatcher("/Esami/ricercaEsami.jsp").forward(request, response);
			break;

		}

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int y=Integer.parseInt(request.getParameter("y"));
		switch(y) {
		case 1://inserimento esame
			data=request.getParameter("dataEsame");
			CodDocente = Integer.parseInt(request.getParameter("codDocente"));
			d = new Docenti();
			d.setCodDocente(CodDocente);
			es = new Esami(d, data);
			crdE.inserimentoEsami(es);
			pagina = "/admin/menuAdmin.jsp";
			getServletContext().getRequestDispatcher(pagina).forward(request, response);
			break;
		case 2://alimina esame
			pagina = "/admin/error.jsp";
			CodEsame = Integer.parseInt(request.getParameter("CodEsame"));
			System.out.println(CodEsame);
			es = new Esami(CodEsame);
			eliminato = crdE.eliminaEsami(es);
			if(eliminato==true) {
				pagina="/admin/menuAdmin.jsp";
			}else {
				message = "esame non eliminato";
				request.setAttribute("messaggio", message);
				pagina2= "/Universita/admin?x=2";
				request.setAttribute("page", pagina2);
			}
			getServletContext().getRequestDispatcher(pagina).forward(request, response);
			break;
		case 3://modifica Esami
			boolean successo=false;
			pagina = "/admin/error.jsp";
			CodEsame =Integer.parseInt(request.getParameter("CodEsame"));
			data = request.getParameter("dataEsame");
			d = new Docenti();
			d.setCodDocente(Integer.parseInt(request.getParameter("CodDocente")));
			es = new Esami(d,data,CodEsame);
			successo=crdE.modificaEsami(es);
			if(successo==true) {
				pagina="/admin/menuAdmin.jsp";
			}else {
				message = "Esame non modificato";
				request.setAttribute("messaggio", message);
				pagina2= "/Universita/admin?x=4";
				request.setAttribute("page", pagina2);
			}
			getServletContext().getRequestDispatcher(pagina).forward(request, response);
			break;
		case 4://ricerca esami
			pagina = "/admin/error.jsp";
			CodEsame=Integer.parseInt(request.getParameter("CodEsame"));
			es= new Esami(d,CodEsame);
			es=crdE.ricercaEsami(es);
			if(es.getData()!=null) {
				request.setAttribute("esame", es);
				pagina="/Esami/risRicerca.jsp";
			}else {
				message = "esame non presente!";
				request.setAttribute("messaggio", message);
				pagina2= "/Universita/admin?x=4";
				request.setAttribute("page", pagina2);
			}
			getServletContext().getRequestDispatcher(pagina).forward(request, response);
			break;	
			
		}
	}
}
