package web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sn.dao.EtudiantImpl;
import sn.dao.IEtudiant;
import sn.model.Etudiant;

/**
 * Servlet implementation class EditerEtudiantServlet
 */
@WebServlet("/EditerEtudiantServlet")
public class EditerEtudiantServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	IEtudiant metier;
	@Override
	public void init() throws ServletException {
		metier = new EtudiantImpl();
	}
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditerEtudiantServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Etudiant e = metier.getEtudiant(id);
		request.setAttribute("editer", e);
		request.getRequestDispatcher("view/etudiant/editer.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
