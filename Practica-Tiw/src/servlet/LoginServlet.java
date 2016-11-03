package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import clases.User;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		System.out.println("email y contraseña recogidos" + email + password);

		try {
			
			//Esta conexion esta mal, debemos crea query para consultar bbdd
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tiw", "root", "admin");
			Statement st = con.createStatement();

			System.out.println("Vamos a consultar la base de datos");
			ResultSet i = st.executeQuery("select Email, Password from tiw.User where Email = '" + email
					+ "' and Password = '" + password + "'");

			// Creamos la sesion del usuario
			HttpSession ses = request.getSession(true);

			// Registro realizado con exito
			if (i.next()) {

				// Consultar bbdd para saber cual es el nombre del email

				User persona = null;

				EntityManagerFactory emf = Persistence.createEntityManagerFactory("Ejemplo");
				EntityManager em = emf.createEntityManager();
				TypedQuery<User> consultaAlumnos = em.createNamedQuery("UserEmail", User.class);
				consultaAlumnos.setParameter("email", email);
				List<User> lista = consultaAlumnos.getResultList();
				User a = lista.get(0);
				em.close();

				ses.setAttribute("name", a.getName());
				ses.setAttribute("id", a.getId());
				ses.setAttribute("surname", a.getSurname());
				ses.setAttribute("usuario", a);
				response.sendRedirect("Bienvenido.jsp");

			} else {

				String err = "Email y/o contraseñas incorrectos";
				String com = "0";

				ses.setAttribute("error", err);
				ses.setAttribute("com", com);
				response.sendRedirect("Login.jsp");
			}

		} catch (SQLException e) {
			System.out.println("No hemos podido conectar con la bbdd");
		}
	}

}
