

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RecibirParametros
 */
@WebServlet("/RecibirParametros")
public class RecibirParametros extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public RecibirParametros() {
    	super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out;
		out = response.getWriter();
		response.setContentType("text/html");
		
		out.println("<html>");
		out.println("<head><title>Enviado</title></head>");
		out.println("<body>");
		out.println("<h1>Mensaje Enviado</h1>");
		out.println("</body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String website = request.getParameter("website");
		String message = request.getParameter("message");
		
		Mensaje m = new Mensaje();
		
		m.setName(name);
		m.setEmail(email);
		m.setWebsite(website);
		m.setMessage(message);
		
		MensajeDao mDao = new MensajeDao();
		mDao.insertar(m);
		
		Utilidades.enviarCorreo(m);
		
	}

}
