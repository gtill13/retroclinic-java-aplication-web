/**
 * 
 */
package br.edu.asselvi.modelo.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.asselvi.modelo.entidade.Contato;

/**
 * @author TiLL
 * 
 */
public class ContatoDao extends DaoBase {

	public long inserirComRetorno(Contato contato) {

		if (contato == null)
			return 0;

		conectaPeloContext();
		executeUpdate("insert into contato (email, telefone, celular) values ( '"
				+ contato.getEmail()
				+ "', '"
				+ contato.getTelefone()
				+ "', '"
				+ contato.getCelular() + "' ) ");

		return getGenerationKeys();

	}

	public void atualizar(Contato contato) throws DaoException {

		if (contato == null)
			return;

		conecta();

		executeUpdate("update contato set email = '" + contato.getEmail()
				+ "', telefone = '" + contato.getTelefone() + "', celular = '"
				+ contato.getCelular() + "' where id = '" + contato.getId()
				+ "' ");
	}

	public void deletar(Contato contato) throws DaoException {

		conecta();

		executeUpdate("delete from contato where id = '" + contato.getId()
				+ "' ");
	}

	public List<Contato> buscaTodos() {

		final List<Contato> listContatos = new ArrayList<Contato>();

		executeQuery("select * from contato", new Mapeador<Contato>() {
			public void mapear(ResultSet rset) throws DaoException {
				try {
					while (rset.next()) {
						Contato contato = new Contato();

						contato.setId(rset.getLong("id"));
						contato.setCelular(rset.getString("celular"));
						contato.setEmail(rset.getString("email"));
						contato.setTelefone(rset.getString("telefone"));

						listContatos.add(contato);
					}
				} catch (SQLException e) {
					throw new DaoException(
							"Banco de dados - Erro ao criar lista em "
									+ this.getClass().toString(), e);
				}
			}
		});

		return listContatos;
	}

	public Contato buscaContatoPeloId(long id) {

		final Contato contato = new Contato();

		executeQuery("select * from contato where id = '" + id + "' ",
				new Mapeador<Contato>() {
					public void mapear(ResultSet rset) throws DaoException {
						try {
							if (rset.next()) {

								contato.setId(rset.getLong("id"));
								contato.setCelular(rset.getString("celular"));
								contato.setEmail(rset.getString("email"));
								contato.setTelefone(rset.getString("telefone"));
							}
						} catch (SQLException e) {
							throw new DaoException(
									"Banco de dados - Erro ao criar lista em "
											+ this.getClass().toString(), e);
						}
					}
				});

		return contato;
	}

}