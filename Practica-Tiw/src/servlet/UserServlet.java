package servlet;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import clases.User;
/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
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
		//Creamos nueva instancia de usuario e introducimos sus datos
		System.out.println("Entramos en el servlet");
		
		User u = new User();
		
		u.setName(request.getParameter("name"));
		u.setSurname(request.getParameter("surname"));
		u.setCity(request.getParameter("city"));
		u.setEmail(request.getParameter("email"));
		u.setPassword(request.getParameter("clave1"));
		
		//Creamos una session y pasamos el atributo usuario
		HttpSession ses = request.getSession();
		ses.setAttribute("user", u);
		
		//Creamos EntityManager
		EntityManager em;
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("Ejemplo");
		
		em=factory.createEntityManager();
		
		
		//Conexion a la bbdd
		em.getTransaction().begin();
		em.persist(u);
		em.getTransaction().commit();
		em.close();
		System.out.println("Se ha registrado el usuario con email: "+u.getEmail());
		
		//Redireccionamos a la pagina de Login
		RequestDispatcher miR = request.getRequestDispatcher("Login.jsp");
		
		miR.forward(request, response);
		
	}

}
