package web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sn.dao.AdresseImpl;
import sn.dao.IAdresse;
import sn.model.Adresse;

/**
 * Servlet implementation class ListeAdresseServlet
 */
@WebServlet("/ListeAdresseServlet")
public class ListeAdresseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	IAdresse metier;
	
	@Override
	public void init() throws ServletException{
		metier = new AdresseImpl();
	}
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListeAdresseServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String matricule = request.getParameter("matricule");
		if(matricule!=null) {
			List<Adresse> lam = metier.listByMatricule(matricule);
			request.setAttribute("search", lam);
			request.getRequestDispatcher("view/adresse/liste.jsp").forward(request, response);
		} else {
			List<Adresse> la = metier.liste();
			request.setAttribute("liste", la);
			request.getRequestDispatcher("view/adresse/liste.jsp").forward(request, response);
		} 
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
