/**
 * 
 */
package br.edu.asselvi.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.asselvi.modelo.dao.UsuarioDao;
import br.edu.asselvi.modelo.entidade.Usuario;


/**
 * @author TiLL
 *
 */
@WebServlet("/LogarServlet")
public class LogarServlet extends ServletBase {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		// TODO Auto-generated method stub
		super.service(request, response);
	}

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	
		String submitAction = request.getParameter("submitAction");
		if (submitAction != null) {
			
			String delimitador = "[ |]+";
			String[] acao = submitAction.split(delimitador);

			if (acao[0].equals("logar")) {

				//validaLogin(request, response);
					
				
				Usuario usuario = new Usuario();
				UsuarioDao dao = new UsuarioDao();
				
				// implementacao
				usuario.setLogin(request.getParameter("usuario"));
				usuario.setSenha(request.getParameter("senha"));

				if (dao.verificaLogin(usuario)) {
					request.setAttribute("usuario", usuario.getLogin());
				}
				else {
					request.getParameterMap().replace("usuario", null);
				}
			} else if (acao[0].equals("home")) {
				goHome(request, response);
				return;
			}
			
		}
		
		request.getRequestDispatcher("index.jsp").forward(request, response);	
	}
}
