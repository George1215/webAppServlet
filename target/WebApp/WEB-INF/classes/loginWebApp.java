import static java.lang.System.out;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class loginWebApp {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		System.out.println("<html>");
		System.out.println("<body>");
		System.out.println("Hello there " + "  " + userName + "welcome to the task you have assigned ");
		System.out.println("The password entered is : " + "  " + password + "<br>");
		System.out.println("</body></html>");
	}
}
