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

import br.edu.asselvi.modelo.dao.MedicoDao;
import br.edu.asselvi.modelo.entidade.Contato;
import br.edu.asselvi.modelo.entidade.ESexo;
import br.edu.asselvi.modelo.entidade.Endereco;
import br.edu.asselvi.modelo.entidade.Medico;

/**
 * @author gabriel
 *
 */

@WebServlet("/adicionaMedicoServlet")
public class AdicionaMedicoServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
		
		
		
		// variaveis
		PrintWriter out = response.getWriter();
				
		MedicoDao dao      = new MedicoDao();
		Medico    medico   = new Medico();
		Endereco  endereco = new Endereco();
		Contato   contato  = new Contato();
		
		//implementacao
		contato.setEmail   (request.getParameter("email"   ));
		contato.setTelefone(request.getParameter("telefone"));
		contato.setCelular (request.getParameter("celular" ));
				
		endereco.setEndereco(request.getParameter("endereco"));
		endereco.setBairro  (request.getParameter("bairro"  ));
		endereco.setCidade  (request.getParameter("bairro"  ));
		endereco.setCep     (request.getParameter("cep"     ));

		medico.setContato (contato);
		medico.setEndereco(endereco);
		medico.setNome    (request.getParameter("nome"));
		medico.setCrm     (request.getParameter("crm" ));
		medico.setCpf     (request.getParameter("cpf" ));
		
		medico.setSexo(request.getParameter("sexo").equals("F") ? ESexo.F
				: ESexo.M);
		
		dao.inserirPadrao(medico);
		
		// imprime 
        out.println("<html>");
        out.println("<body>");
        out.println("<form action="+"cadastroPaciente.jsp"+" method="+"POST"+">");
        out.println("Medico " + medico.getNome() +
                " adicionado com sucesso");
        out.println("<br>");
        out.println("<input type="+"submit"+" value="+"Voltar"+">");
        out.println("</body>");
        out.println("</html>");
	}
}
