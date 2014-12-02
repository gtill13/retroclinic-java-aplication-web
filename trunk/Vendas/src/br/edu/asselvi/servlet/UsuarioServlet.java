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

import br.edu.asselvi.modelo.dao.MedicamentoDao;
import br.edu.asselvi.modelo.dao.UsuarioDao;
import br.edu.asselvi.modelo.entidade.Medicamento;
import br.edu.asselvi.modelo.entidade.Usuario;

/**
 * @author TiLL
 *
 */
@WebServlet("/UsuarioServlet")
public class UsuarioServlet extends ServletBase {

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
		
		// PrintWriter out = response.getWriter();

		/*if (!validaLogin(request, response))
		{
			request.getRequestDispatcher("login.jsp").forward(request, response);;	
		}*/
		
		String submitAction = request.getParameter("submitAction");
			if (submitAction != null) {

				String delimitador = "[ |]+";
				String[] acao = submitAction.split(delimitador);

				if (acao[0].equals("incluir")) {

					incluir(request, response);

				} else if (acao[0].equals("atualizar")) {

					atualizar(Long.parseLong(acao[1]), request, response);

				} else if (acao[0].equals("editar")) {

					request.setAttribute("login", editar(Long.parseLong(acao[1]), request, response));
			
				} else if (acao[0].equals("excluir")) {

					excluir(Long.parseLong(acao[1]), request, response);

				}
			}

		request.getRequestDispatcher("usuario.jsp").forward(request, response);	
		
	}

	void incluir(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		UsuarioDao dao = new UsuarioDao();
		Usuario usuario = new Usuario();

		// implementacao
		usuario.setLogin(request.getParameter("usuario"));
		usuario.setSenha(request.getParameter("senha"));

		dao.inserirPadrao(usuario);
		
	}
	
	void atualizar(long id, HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	
		UsuarioDao dao = new UsuarioDao();
		Usuario usuario = new Usuario();

		// implementacao

		usuario.setId(id);
		usuario.setLogin(request.getParameter("usuario"));
		usuario.setSenha(request.getParameter("senha"));

		dao.atualizar(usuario);
		
	}
	
	Usuario editar(long id, HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		UsuarioDao dao = new UsuarioDao();

		return dao.buscaEnderecoPeloId(id);

	}
	
	void excluir(long id, HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	
		UsuarioDao dao = new UsuarioDao();

		dao.deletar(id);
		
	}
	
}


