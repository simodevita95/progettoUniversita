package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import model.Amministratori;
import model.Studenti;
import model.dao.CRUDStudenti;
import model.dao.DaoAmministratore;


@WebServlet("/login")
public class GestioneLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Amministratori adm = new Amministratori();
	DaoAmministratore daoA = new DaoAmministratore();
	CRUDStudenti crdS = new CRUDStudenti();
	String username;
	String password;
	String pagina;
	String message;
	String pagina2;
	PrintWriter out=null;
	public GestioneLogin() {
		super();

	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int x=Integer.parseInt(request.getParameter("x"));
		switch(x) {
		case 1:
			HttpSession session =request.getSession();
			session.invalidate();
			pagina = "/logout.jsp";
			message = "Logout effettuato!";
			request.setAttribute("messaggio", message);
			pagina2= "/Universita/index.jsp";
			request.setAttribute("page", pagina2);
			getServletContext().getRequestDispatcher(pagina).forward(request, response);
			break;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int y=Integer.parseInt(request.getParameter("y"));
		switch(y) {
		case 1: //login amministratore
			pagina = "/admin/error.jsp";
			username=request.getParameter("username");
			password=request.getParameter("password");
			Amministratori adm = daoA.loginAdmin(username, password);
			if (adm!=null) {
				HttpSession session = request.getSession();
				session.setAttribute("admin", adm);
				pagina = "/admin/menuAdmin.jsp";
			}
			else {
				message = "User o password non corrette";
				request.setAttribute("messaggio", message);
				pagina2= "/Universita/admin?x=1";
				request.setAttribute("page", pagina2);
			}
			getServletContext().getRequestDispatcher(pagina).forward(request, response);
			break;
		case 2://login studente
			pagina = "/admin/error.jsp";
			username=request.getParameter("username");
			password=request.getParameter("password");
			Studenti s = crdS.loginStudenti(username, password);
			if (s!=null) {
				HttpSession session = request.getSession();
				session.setAttribute("stud", s);
				pagina = "/profiloStud/menuStudente.jsp";
			}
			else {
				message = "User o password non corrette";
				request.setAttribute("messaggio", message);
				pagina2= "/Universita/studenti?x=1";
				request.setAttribute("page", pagina2);
			}
			getServletContext().getRequestDispatcher(pagina).forward(request, response);
			break;
		}
	}

}
