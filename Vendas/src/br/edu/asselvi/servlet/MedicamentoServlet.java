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
import br.edu.asselvi.modelo.entidade.Medicamento;

/**
 * @author TiLL
 *
 */

@WebServlet("/MedicamentoServlet")
public class MedicamentoServlet extends HttpServlet {

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

				request.setAttribute("medicamento", editar(Long.parseLong(acao[1]), request, response));
	
			} else if (acao[0].equals("excluir")) {

				excluir(Long.parseLong(acao[1]), request, response);

			}
		}

		request.getRequestDispatcher("medicamento.jsp").forward(request, response);;	
	}

	void incluir(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		MedicamentoDao dao = new MedicamentoDao();
		Medicamento medicamento = new Medicamento();

		// implementacao
		medicamento.setNome(request.getParameter("nome"));
		medicamento.setDescricao(request.getParameter("descricao"));

		dao.inserir(medicamento);
	}

	void atualizar(long id, HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		MedicamentoDao dao = new MedicamentoDao();
		Medicamento medicamento = new Medicamento();

		// implementacao

		medicamento.setId(id);
		medicamento.setNome(request.getParameter("nome"));
		medicamento.setDescricao(request.getParameter("descricao"));

		dao.atualizar(medicamento);
	}

	Medicamento editar(long id, HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		MedicamentoDao dao = new MedicamentoDao();

		return dao.buscaMedicamentoPeloId(id);
	}

	void excluir(long id, HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		MedicamentoDao dao = new MedicamentoDao();

		dao.deletar(id);
	}
}
