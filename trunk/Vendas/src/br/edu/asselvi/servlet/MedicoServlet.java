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

import br.edu.asselvi.modelo.dao.MedicoDao;
import br.edu.asselvi.modelo.entidade.Contato;
import br.edu.asselvi.modelo.entidade.ESexo;
import br.edu.asselvi.modelo.entidade.Endereco;
import br.edu.asselvi.modelo.entidade.Medico;

/**
 * @author gabriel
 *
 */

@WebServlet("/MedicoServlet")
public class MedicoServlet extends HttpServlet {

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

		String submitAction = request.getParameter("submitAction");
		if (submitAction != null) {

			String delimitador = "[ |]+";
			String[] acao = submitAction.split(delimitador);

			if (acao[0].equals("incluir")) {

				incluir(request, response);

			} else if (acao[0].equals("atualizar")) {

				atualizar(Long.parseLong(acao[1]), request, response);

			} else if (acao[0].equals("editar")) {

				request.setAttribute("medico", editar(Long.parseLong(acao[1]), request, response));				

			} else if (acao[0].equals("excluir")) {

				excluir(Long.parseLong(acao[1]), request, response);

			}
		}

		request.getRequestDispatcher("medico.jsp").forward(request, response);;	
	}

	void incluir(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// variaveis
		MedicoDao dao = new MedicoDao();
		Medico medico = new Medico();
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

		medico.setContato(contato);
		medico.setEndereco(endereco);
		medico.setNome(request.getParameter("nome"));
		medico.setCrm(request.getParameter("crm"));
		medico.setCpf(request.getParameter("cpf"));

		medico.setSexo(request.getParameter("sexo").equals("F") ? ESexo.F
				: ESexo.M);

		dao.inserirPadrao(medico);
	}

	void atualizar(long id, HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// variaveis
		MedicoDao dao = new MedicoDao();
		Medico medico = new Medico();
		Endereco endereco = new Endereco();
		Contato contato = new Contato();

		// implementacao
		medico.setId(id);

		contato.setEmail(request.getParameter("email"));
		contato.setTelefone(request.getParameter("telefone"));
		contato.setCelular(request.getParameter("celular"));

		endereco.setEndereco(request.getParameter("endereco"));
		endereco.setBairro(request.getParameter("bairro"));
		endereco.setCidade(request.getParameter("bairro"));
		endereco.setCep(request.getParameter("cep"));

		medico.setContato(contato);
		medico.setEndereco(endereco);
		medico.setNome(request.getParameter("nome"));
		medico.setCrm(request.getParameter("crm"));
		medico.setCpf(request.getParameter("cpf"));

		medico.setSexo(request.getParameter("sexo").equals("F") ? ESexo.F
				: ESexo.M);

		dao.atualizar(medico);
	}

	Medico editar(long id, HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		MedicoDao dao = new MedicoDao();

		return dao.buscaMedicoPeloId(id);
	}

	void excluir(long id, HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		MedicoDao dao = new MedicoDao();

		dao.deletar(id);
	}

}
