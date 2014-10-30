/**
 * 
 */
package br.edu.asselvi.servlet;

import java.io.IOException;
import java.io.PrintWriter;

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
	
	protected void service(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
		super.service(request, response);

		
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
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		
		String submitAction= request.getParameter("submitAction");
        if (submitAction != null) {
        	
        	String delimitador = "[ |]+";
        	String[] acao = submitAction.split(delimitador);
        	
        	
            if (acao[0].equals("editar")) {
               
                out.println("<html>");
                out.println("<body>");
                out.println("<form action="+"cadastroPaciente.jsp"+" method="+"POST"+">");
                out.println("if (submitAction.equals(editar)) {");
                out.println("<br>");
                out.println("<input type="+"submit"+" value="+"Voltar"+">");
                out.println("</body>");
                out.println("</html>");
            	
            	
            } else if (submitAction.equals("Generate Excel")) {
                out.println("<html>");
                out.println("<body>");
                out.println("<form action="+"cadastroPaciente.jsp"+" method="+"POST"+">");
                out.println("   } else if (submitAction.equals(Generate Excel)) {");
                out.println("<br>");
                out.println("<input type="+"submit"+" value="+"Voltar"+">");
                out.println("</body>");
                out.println("</html>");
            }
        }
		
	}
	
}
