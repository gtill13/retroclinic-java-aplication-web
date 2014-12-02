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

import br.edu.asselvi.modelo.dao.PacienteDao;
import br.edu.asselvi.modelo.entidade.Contato;
import br.edu.asselvi.modelo.entidade.ESexo;
import br.edu.asselvi.modelo.entidade.Endereco;
import br.edu.asselvi.modelo.entidade.Paciente;

/**
 * @author TiLL
 *
 */
@WebServlet("/PacienteServlet")
public class PacienteServlet extends ServletBase {

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

				request.setAttribute("paciente", editar(Long.parseLong(acao[1]), request, response));				

			} else if (acao[0].equals("excluir")) {

				excluir(Long.parseLong(acao[1]), request, response);

			}
		}

		request.getRequestDispatcher("paciente.jsp").forward(request, response);;	
	}

	void incluir(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PacienteDao dao = new PacienteDao();
		Paciente paciente = new Paciente();
		Endereco endereco = new Endereco();
		Contato contato = new Contato();

		// implementacao
		contato.setEmail(request.getParameter("email"));
		contato.setTelefone(request.getParameter("telefone"));
		contato.setCelular(request.getParameter("celular"));

		endereco.setEndereco(request.getParameter("endereco"));
		endereco.setBairro(request.getParameter("bairro"));
		endereco.setCidade(request.getParameter("bairro"));
		endereco.setCep(request.getParameter("cep"));

		paciente.setContato(contato);
		paciente.setEndereco(endereco);
		paciente.setNome(request.getParameter("nome"));
		paciente.setRg(request.getParameter("rg"));
		paciente.setCpf(request.getParameter("cpf"));

		paciente.setSexo(request.getParameter("sexo").equals("F") ? ESexo.F
				: ESexo.M);

		dao.inserirPadrao(paciente);
	}

	void atualizar(long id, HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		PacienteDao dao = new PacienteDao();
		Paciente paciente = new Paciente();
		Endereco endereco = new Endereco();
		Contato contato = new Contato();

		// implementacao
		paciente.setId(id);

		contato.setEmail(request.getParameter("email"));
		contato.setTelefone(request.getParameter("telefone"));
		contato.setCelular(request.getParameter("celular"));

		endereco.setEndereco(request.getParameter("endereco"));
		endereco.setBairro(request.getParameter("bairro"));
		endereco.setCidade(request.getParameter("bairro"));
		endereco.setCep(request.getParameter("cep"));

		paciente.setContato(contato);
		paciente.setEndereco(endereco);
		paciente.setNome(request.getParameter("nome"));
		paciente.setRg(request.getParameter("rg"));
		paciente.setCpf(request.getParameter("cpf"));

		paciente.setSexo(request.getParameter("sexo").equals("F") ? ESexo.F
				: ESexo.M);

		dao.atualizar(paciente);
	}

	Paciente editar(long id, HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		PacienteDao dao = new PacienteDao();

		return dao.buscaPacientePeloId(id);
	}

	void excluir(long id, HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		PacienteDao dao = new PacienteDao();

		dao.deletar(id);
	}

}
