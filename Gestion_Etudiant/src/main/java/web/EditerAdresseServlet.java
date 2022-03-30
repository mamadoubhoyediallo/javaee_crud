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
 * Servlet implementation class EditerAdresseServlet
 */
@WebServlet("/EditerAdresseServlet")
public class EditerAdresseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	IAdresse metier;
	@Override
	public void init() throws ServletException {
		metier = new AdresseImpl();
	}
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditerAdresseServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Adresse a = metier.getAdresse(id);
		request.setAttribute("editer", a);
		request.getRequestDispatcher("view/adresse/editer.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
