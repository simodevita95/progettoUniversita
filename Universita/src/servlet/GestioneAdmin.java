package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/admin")
public class GestioneAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;


	public GestioneAdmin() {
		super();

	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int x=Integer.parseInt(request.getParameter("x"));
		switch(x) {
		case 1:getServletContext().getRequestDispatcher("/admin/loginAdmin.jsp").forward(request, response);
		break;
		case 2:
			HttpSession session = request.getSession();
			session.getAttribute("admin");
			getServletContext().getRequestDispatcher("/admin/gestioneStudenti.jsp").forward(request, response);
			break;
		case 3:getServletContext().getRequestDispatcher("/admin/gestioneEsami.jsp").forward(request, response);
		break;
		case 4:getServletContext().getRequestDispatcher("/admin/gestioneDocenti.jsp").forward(request, response);
		break;
		case 5:getServletContext().getRequestDispatcher("/admin/menuAdmin.jsp").forward(request, response);
		break;
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
