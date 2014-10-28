/**
 * 
 */
package br.edu.asselvi.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.asselvi.modelo.dao.MedicamentoDao;
import br.edu.asselvi.modelo.entidade.Medicamento;

/**
 * @author TiLL
 *
 */

@WebServlet("/adicionaMedicamentoServlet")
public class AdicionaMedicamentoServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
		
		// variaveis
		PrintWriter out = response.getWriter();
				
		MedicamentoDao dao         = new MedicamentoDao();
		Medicamento    medicamento = new Medicamento();
		
		//implementacao
		medicamento.setNome     (request.getParameter("nome"     ));
		medicamento.setDescricao(request.getParameter("descricao"));
				
		dao.inserir(medicamento);
		
		// imprime 
        out.println("<html>");
        out.println("<body>");
        out.println("<form action="+"cadastroPaciente.jsp"+" method="+"POST"+">");
        out.println("Medicamento " + medicamento.getNome() +
                " adicionado com sucesso");
        out.println("<br>");
        out.println("<input type="+"submit"+" value="+"Voltar"+">");
        out.println("</body>");
        out.println("</html>");
	}
	
}
