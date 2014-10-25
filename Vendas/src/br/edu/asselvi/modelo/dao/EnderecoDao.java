/**
 * 
 */
package br.edu.asselvi.modelo.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.asselvi.modelo.entidade.Endereco;

/**
 * @author TiLL
 *
 */
public class EnderecoDao extends DaoBase {

	public long inserirComRetorno(Endereco endereco) {

		if (endereco == null)
			return 0;
		
		conectaPeloContext();
		executeUpdate("insert into endereco (endereco, cidade, bairro, cep) values ( '" + endereco.getEndereco() + "', '" + endereco.getCidade() + "', '" + endereco.getBairro() + "', '" + endereco.getCep() + "' ) ");

		return getGenerationKeys();
	}
	
	public long atualizar(Endereco endereco) throws DaoException {

		if (endereco == null)
			return 0;
		else if (endereco.getId() == 0)
			return this.inserirComRetorno(endereco);
			
		conecta();

		executeUpdate("update endereco set endereco = '" + endereco.getEndereco()
				+ "', cidade = '" + endereco.getCidade() + "', bairro = '"
				+ endereco.getBairro() + "', cep =  '" + endereco.getCep()
				+ "' where id = '" + endereco.getId() + "' ");
		
		return endereco.getId();
	}
	
	public void deletar(Endereco endereco) throws DaoException {

		if (endereco == null)
			return;
		
		conecta();

		executeUpdate("delete from endereco where id = '" + endereco.getId() + "' "); 
	}
	
	public List<Endereco> buscaTodos () {
		
		final List<Endereco> listEnderecos = new ArrayList<Endereco>();
		
		executeQuery("select * from endereco", new Mapeador<Endereco>() {
			public void mapear(ResultSet rset) throws DaoException {
				try {
					while (rset.next()) {
						Endereco endereco = new Endereco();
						
						endereco.setId(rset.getLong("id"));
						endereco.setEndereco(rset.getString("endereco"));
						endereco.setCidade(rset.getString("cidade"));
						endereco.setBairro(rset.getString("bairro"));
						endereco.setCep(rset.getString("cep"));

						listEnderecos.add(endereco);
					}
				} catch (SQLException e) {
					throw new DaoException("Banco de dados - Erro ao criar lista em " + this.getClass().toString(), e);
				}
			}
		});
		
		return listEnderecos;
	}
	
	public Endereco buscaEnderecoPeloId (long id) {

		if (id == 0)
			return null;
		
		final Endereco endereco = new Endereco();
		
		executeQuery("select * from endereco where id = '" + id + "' ", new Mapeador<Endereco>() {
			public void mapear(ResultSet rset) throws DaoException {
				try {
					if (rset.next()) {
						
						endereco.setId(rset.getLong("id"));
						endereco.setEndereco(rset.getString("endereco"));
						endereco.setCidade(rset.getString("cidade"));
						endereco.setBairro(rset.getString("bairro"));
						endereco.setCep(rset.getString("cep"));
					}
				} catch (SQLException e) {
					throw new DaoException("Banco de dados - Erro ao criar lista em " + this.getClass().toString(), e);
				}
			}
		});
		
		return endereco;
	}
}
