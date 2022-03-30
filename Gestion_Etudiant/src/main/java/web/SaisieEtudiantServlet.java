package web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sn.dao.AdresseImpl;
import sn.dao.EtudiantImpl;
import sn.dao.IAdresse;
import sn.dao.IEtudiant;
import sn.model.Adresse;
import sn.model.Etudiant;

/**
 * Servlet implementation class SaisieEtudiantServlet
 */
@WebServlet("/SaisieEtudiantServlet")
public class SaisieEtudiantServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	IEtudiant metier1;
	IAdresse metier2;
	@Override
	public void init() throws ServletException {
		metier1 = new EtudiantImpl();
		metier2 = new AdresseImpl();
	}
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SaisieEtudiantServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Adresse> liste = metier2.liste();
		request.setAttribute("listea", liste);
		request.getRequestDispatcher("view/etudiant/saisie.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String matricule = request.getParameter("matricule");
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		int telephone  = Integer.parseInt(request.getParameter("telephone"));
		Adresse adresse = new Adresse();
		adresse.setId(Integer.parseInt(request.getParameter("adresse")));
		adresse.getId();
		Etudiant et = new Etudiant(matricule, nom, prenom, telephone, adresse);
		metier1.save(et);
		response.sendRedirect("ListeEtudiantServlet");
		
	}

}
