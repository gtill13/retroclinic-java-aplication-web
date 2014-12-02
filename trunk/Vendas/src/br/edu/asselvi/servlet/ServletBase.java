/**
 * 
 */
package br.edu.asselvi.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author TiLL
 *
 */
public class ServletBase extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void goHome(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("index.jsp").forward(request, response);	
	}
	
}
