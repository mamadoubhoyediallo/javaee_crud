package web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sn.dao.EtudiantImpl;
import sn.dao.IEtudiant;
import sn.model.Etudiant;

/**
 * Servlet implementation class ListeEtudiantServlet
 */
@WebServlet("/ListeEtudiantServlet")
public class ListeEtudiantServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	IEtudiant metier;
	
	@Override
	public void init() throws ServletException{
		metier = new EtudiantImpl();
	}
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListeEtudiantServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Etudiant> lp = metier.liste();
		request.setAttribute("liste", lp);
		request.getRequestDispatcher("view/etudiant/liste.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
