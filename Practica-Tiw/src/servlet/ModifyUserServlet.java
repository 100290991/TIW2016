package servlet;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import clases.User;

/**
 * Servlet implementation class ModifyUserServlet
 */
@WebServlet("/ModifyUserServlet")
public class ModifyUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ModifyUserServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		// Usuario para guardar datos modificados
		User u = new User();

		// Parametros obtenidos en el formulario para modificar
		
		u.setName(request.getParameter("name"));
		u.setSurname(request.getParameter("surname"));
		u.setCity(request.getParameter("city"));
		u.setEmail(request.getParameter("email"));
		u.setPassword(request.getParameter("clave1"));

		// Recuperamos el usuario de la sesion para ver los atributos que han
		// sido modificados
		HttpSession misession = (HttpSession) request.getSession();
		User u1 = (User) misession.getAttribute("usuario");

		//Guardamos en el nuevo usuario la id que se encuentra en sesion
		u.setId(u1.getId());
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Ejemplo");
		EntityManager em = emf.createEntityManager();

		System.out.println(u.toString());
		System.out.println(u1.toString());
		
		// Si los nombres son distintos los modifico
		if (!(u.getName().equals(u1.getName()))) {
			em.getTransaction().begin();
			
			Query q = em.createNamedQuery("UpdateName", User.class);
			q.setParameter("name", u.getName());
			q.setParameter("id", u1.getId());
			q.executeUpdate();
			
			em.getTransaction().commit();
			
			
		}

		em.close();
		
		//Modificar el usuario de que estaba en la session por el nuevo usuario
		misession.removeAttribute("usuario");
		misession.setAttribute("usuario", u);
		

		// Redirigir a la pagina de Index

		RequestDispatcher miR = request.getRequestDispatcher("Bienvenido.jsp");

		miR.forward(request, response);

	}

}
