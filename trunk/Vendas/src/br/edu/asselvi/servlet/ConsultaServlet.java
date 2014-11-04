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

import br.edu.asselvi.modelo.dao.ConsultaDao;
import br.edu.asselvi.modelo.entidade.Consulta;
import br.edu.asselvi.modelo.entidade.Medicamento;
import br.edu.asselvi.modelo.entidade.Medico;
import br.edu.asselvi.modelo.entidade.Paciente;
import br.edu.asselvi.modelo.entidade.Pagamento;

/**
 * @author gabriel
 *
 */
@WebServlet("/ConsultaServlet")
public class ConsultaServlet extends HttpServlet {
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

				request.setAttribute("consulta", editar(Long.parseLong(acao[1]), request, response));
	
			} else if (acao[0].equals("excluir")) {

				excluir(Long.parseLong(acao[1]), request, response);

			}
		}

		request.getRequestDispatcher("consulta.jsp").forward(request, response);;	
	}

	void incluir(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ConsultaDao dao = new ConsultaDao();
		Consulta consulta = new Consulta();
		Paciente paciente = new Paciente();
		Medico medico = new Medico();
		Medicamento medicamento = new Medicamento();
		Pagamento pagamento = new Pagamento();
		
		// implementacao
		medico.setId(Long.parseLong(request.getParameter("medico")));
		paciente.setId(Long.parseLong(request.getParameter("paciente")));
		medicamento.setId(Long.parseLong(request.getParameter("medicamento")));
		pagamento.setId(Long.parseLong(request.getParameter("pagamento")));
		
		consulta.setMedicamento(medicamento);
		consulta.setMedico(medico);
		consulta.setPaciente(paciente);
		consulta.setPagamento(pagamento);
		dao.inserirPadrao(consulta);
	}

	void atualizar(long id, HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		ConsultaDao dao = new ConsultaDao();
		Consulta consulta = new Consulta();
		Paciente paciente = new Paciente();
		Medico medico = new Medico();
		Medicamento medicamento = new Medicamento();
		Pagamento pagamento = new Pagamento();
		
		// implementacao
		medico.setId(Long.parseLong(request.getParameter("medico")));
		paciente.setId(Long.parseLong(request.getParameter("paciente")));
		medicamento.setId(Long.parseLong(request.getParameter("medicamento")));
		pagamento.setId(Long.parseLong(request.getParameter("pagamento")));
		
		consulta.setId(id);
		consulta.setMedicamento(medicamento);
		consulta.setMedico(medico);
		consulta.setPaciente(paciente);
		consulta.setPagamento(pagamento);
		dao.atualizar(consulta);
	}

	Consulta editar(long id, HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		ConsultaDao dao = new ConsultaDao();

		return dao.buscaConsultaPeloId(id);
	}

	void excluir(long id, HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		ConsultaDao dao = new ConsultaDao();

		dao.deletar(id);
	}
}
