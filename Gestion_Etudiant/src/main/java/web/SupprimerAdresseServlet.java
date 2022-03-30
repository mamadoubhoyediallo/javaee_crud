package web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sn.dao.AdresseImpl;
import sn.dao.IAdresse;

/**
 * Servlet implementation class SupprimerAdresseServlet
 */
@WebServlet("/SupprimerAdresseServlet")
public class SupprimerAdresseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	IAdresse metier;
	@Override
	public void init() throws ServletException{
		metier = new AdresseImpl();
	}
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SupprimerAdresseServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		metier.delete(id);
		response.sendRedirect("ListeAdresseServlet");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
