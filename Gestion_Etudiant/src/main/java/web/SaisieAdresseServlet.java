package web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sn.dao.AdresseImpl;
import sn.dao.IAdresse;
import sn.model.Adresse;

/**
 * Servlet implementation class SaisieAdresseServlet
 */
@WebServlet("/SaisieAdresseServlet")
public class SaisieAdresseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	IAdresse metier;
	@Override
	public void init() throws ServletException {
		metier = new AdresseImpl();
	}
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SaisieAdresseServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String matricule = request.getParameter("matricule");
		String ville = request.getParameter("ville");
		String quartier = request.getParameter("quartier");
		String rue = request.getParameter("rue");
		Adresse a = new Adresse(matricule, ville, quartier, rue);
		metier.save(a);
		response.sendRedirect("ListeAdresseServlet");
	}

}
