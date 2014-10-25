/**
 * 
 */
package br.edu.asselvi.modelo.dao;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



import java.util.Random;

import br.edu.asselvi.modelo.entidade.Contato;
import br.edu.asselvi.modelo.entidade.ESexo;
import br.edu.asselvi.modelo.entidade.Endereco;
import br.edu.asselvi.modelo.entidade.Paciente;

/**
 * @author TiLL
 * 
 */
public class PacienteDao extends DaoBase {

	public void inserirPadrao(Paciente paciente) throws DaoException {

		EnderecoDao enderecoDao = new EnderecoDao();
		ContatoDao contatoDao = new ContatoDao();
		conecta();
		
		executeUpdate("insert into paciente (nome, rg, cpf, sexo, id_responsavel, id_contato, id_endereco) values ( '"
				+ paciente.getNome()                            + "', '" + paciente.getRg()              + "', '"
				+ paciente.getCpf()                             + "', '" + paciente.getSexo()            + "', '"
				+ inserirResponsavel(paciente.getResponsavel()) + "', '"
				+ contatoDao.inserirComRetorno(paciente.getContato())     + "', '"
				+ enderecoDao.inserirComRetorno(paciente.getEndereco())   + "' ) ");
		
		commit();

		disconecta();
	}
	
	public long inserirComRetorno(Paciente paciente) throws DaoException {

		if(paciente == null)
			return 0; 
		
		EnderecoDao enderecoDao = new EnderecoDao();
		ContatoDao contatoDao = new ContatoDao();
		conectaPeloContext();
		
		executeUpdate("insert into paciente (nome, rg, cpf, sexo, id_responsavel, id_contato, id_endereco) values ( '"
				+ paciente.getNome()                            + "', '" + paciente.getRg()              + "', '"
				+ paciente.getCpf()                             + "', '" + paciente.getSexo()            + "', '"
				+ inserirResponsavel(paciente.getResponsavel()) + "', '"
				+ contatoDao.inserirComRetorno(paciente.getContato())     + "', '"
				+ enderecoDao.inserirComRetorno(paciente.getEndereco())   + "' ) ");

		return getGenerationKeys();
		
	}

	private long inserirResponsavel(Paciente paciente) {

		if (paciente == null)
			return 0;
		
		EnderecoDao enderecoDao = new EnderecoDao();
		ContatoDao contatoDao = new ContatoDao();
		
		conectaPeloContext();
		
		executeUpdate("insert into paciente (nome, rg, cpf, sexo, id_contato, id_endereco) values ( '"
				+ paciente.getNome() + "', '" + paciente.getRg()   + "', '"
				+ paciente.getCpf()  + "', '" + paciente.getSexo() + "', '"
				+ contatoDao.inserirComRetorno(paciente.getContato())        + "', '"
				+ enderecoDao.inserirComRetorno(paciente.getEndereco())      + "' ) ");
		
		return getGenerationKeys();
	}
	
	public void atualizar(Paciente paciente) throws DaoException {

		EnderecoDao enderecoDao = new EnderecoDao();
		ContatoDao contatoDao = new ContatoDao();
		conecta();

		enderecoDao.atualizar(paciente.getEndereco());
		contatoDao .atualizar(paciente.getContato ());
		
		executeUpdate("update paciente set nome = '" + paciente.getNome()
				+ "', rg = '" + paciente.getRg() + "', cpf = '"
				+ paciente.getCpf() + "', sexo =  '" + paciente.getSexo()
				+ "' where id = '" + paciente.getId() + "' ");
		
		commit();

		disconecta();

	}
	
	public void deletar(long id) throws DaoException {

		//EnderecoDao enderecoDao = new EnderecoDao();
		//ContatoDao contatoDao = new ContatoDao();
		conecta();

		executeUpdate("delete from paciente where id = '" + id + "' "); 

		//enderecoDao.deletar(paciente.getEndereco());
		//contatoDao.deletar(paciente.getContato());

		commit();

		disconecta();
	}
	
	public void deletar(Paciente paciente) throws DaoException {

		//EnderecoDao enderecoDao = new EnderecoDao();
		//ContatoDao contatoDao = new ContatoDao();
		conecta();

		executeUpdate("delete from paciente where id = '" + paciente.getId() + "' "); 

		//enderecoDao.deletar(paciente.getEndereco());
		//contatoDao.deletar(paciente.getContato());

		commit();

		disconecta();
	}

	public List<Paciente> buscaTodos () {
		
		final EnderecoDao enderecoDao = new EnderecoDao();
		final ContatoDao contatoDao = new ContatoDao();
		final List<Paciente> listPacientes = new ArrayList<Paciente>();
		
		executeQuery("select * from paciente", new Mapeador<Paciente>() {
			public void mapear(ResultSet rset) throws DaoException {
				try {
						while (rset.next()) {
						Paciente paciente = new Paciente();
						
						paciente.setId(rset.getLong("id"));
						paciente.setNome(rset.getString("nome"));
						paciente.setCpf(rset.getString("cpf"));
						paciente.setRg(rset.getString("rg"));
						paciente.setSexo(ESexo.valueOf(rset.getString("sexo")));

						paciente.setEndereco(enderecoDao.buscaEnderecoPeloId(rset.getLong("id_endereco")));
						paciente.setContato(contatoDao.buscaContatoPeloId(rset.getLong("id_contato")));
						paciente.setResponsavel(buscaPacientePeloId(rset.getLong("id_responsavel")));
						
						listPacientes.add(paciente);
					}
				} catch (SQLException e) {
					throw new DaoException("Banco de dados - Erro ao criar lista em " + this.getClass().toString(), e);
				}
			}
		});
		
		return listPacientes;
	}
	
	public Paciente buscaPacientePeloId(long id) {

		final Paciente paciente = new Paciente();

		executeQuery("select * from paciente where id = '" + id + "' ",
				new Mapeador<Paciente>() {
					public void mapear(ResultSet rset) throws DaoException {
						try {
							if (rset.next()) {

								EnderecoDao enderecoDao = new EnderecoDao();
								ContatoDao contatoDao = new ContatoDao();
								
								paciente.setId(rset.getLong("id"));
								paciente.setNome(rset.getString("nome"));
								paciente.setCpf(rset.getString("cpf"));
								paciente.setRg(rset.getString("rg"));
								paciente.setSexo(ESexo.valueOf(rset.getString("sexo")));
								
								paciente.setEndereco(enderecoDao.buscaEnderecoPeloId(rset.getLong("id_endereco")));
								paciente.setContato(contatoDao.buscaContatoPeloId(rset.getLong("id_contato")));
								paciente.setResponsavel(buscaPacientePeloId(rset.getLong("id_responsavel")));
								
							}
						} catch (SQLException e) {
							throw new DaoException(
									"Banco de dados - Erro ao criar lista em "
											+ this.getClass().toString(), e);
						}
					}
				});

		return paciente;
	}

	public void CriaDemo() {
		Paciente paciente = new Paciente();
		Contato contato = new Contato();
		Endereco endereco = new Endereco();
		Random random = new Random();
		
		for(int i = 0; i < 10; ++i)
		{
			paciente.setNome(stringAleatoria(25));
			paciente.setCpf(stringAleatoria(12));
			paciente.setRg(stringAleatoria(8));
			paciente.setSexo((random.nextInt()%2 == 0) ? ESexo.F : ESexo.M);

			contato.setEmail(stringAleatoria(40));
			contato.setCelular(stringAleatoria(9));
			contato.setTelefone(stringAleatoria(9));
			
			endereco.setEndereco(stringAleatoria(90));
			endereco.setCidade(stringAleatoria(15));
			endereco.setCep(stringAleatoria(7));
			endereco.setBairro(stringAleatoria(14));
			
			paciente.setContato(contato);
			paciente.setEndereco(endereco);
			
			inserirPadrao(paciente);
		}
	}
} 

