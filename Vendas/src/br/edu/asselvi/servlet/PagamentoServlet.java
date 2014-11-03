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

import br.edu.asselvi.modelo.dao.PagamentoDao;
import br.edu.asselvi.modelo.entidade.Pagamento;

/**
 * @author gabriel
 *
 */
@WebServlet("/PagamentoServlet")
public class PagamentoServlet extends HttpServlet {

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

				request.setAttribute("pagamento", editar(Long.parseLong(acao[1]), request, response));
				
			} else if (acao[0].equals("excluir")) {

				excluir(Long.parseLong(acao[1]), request, response);

			}
		}

		request.getRequestDispatcher("pagamento.jsp").forward(request, response);;	
	}

	void incluir(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PagamentoDao dao = new PagamentoDao();
		Pagamento pagamento = new Pagamento();

		// implementacao
		pagamento.setDescricao(request.getParameter("descricao"));
		pagamento.setValor(Double.parseDouble(request.getParameter("valor")));

		dao.inserir(pagamento);
	}

	void atualizar(long id, HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		PagamentoDao dao = new PagamentoDao();
		Pagamento pagamento = new Pagamento();

		// implementacao

		pagamento.setId(id);
		pagamento.setDescricao(request.getParameter("descricao"));
		pagamento.setValor(Double.parseDouble(request.getParameter("valor")));

		dao.atualizar(pagamento);
	}

	Pagamento editar(long id, HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		PagamentoDao dao = new PagamentoDao();

		return dao.buscaPagamentoPeloId(id);
	}

	void excluir(long id, HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		PagamentoDao dao = new PagamentoDao();

		dao.deletar(id);
	}
}
