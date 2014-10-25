package br.edu.asselvi.modelo.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.asselvi.modelo.entidade.Medicamento;


public class MedicamentoDao extends DaoBase {

	public void inserir(Medicamento medicamento) throws DaoException {

		conecta();
		
		executeUpdate("insert into medicamento (nome, descricao) values ( '"
				+ medicamento.getNome()                            + "', '" + medicamento.getDescricao()+ "' ) ");
		
		commit();

		disconecta();
	}
	
	public long inserirComRetorno(Medicamento medicamento) throws DaoException {

		if(medicamento == null)
			return 0;
		
		conecta();
		
		executeUpdate("insert into medicamento (nome, descricao) values ( '"
						+ medicamento.getNome() + "', '" + medicamento.getDescricao()+ "' ) ");
		
		return getGenerationKeys();
	}


	public void atualizar(Medicamento medicamento) throws DaoException {

		conecta();

		executeUpdate("update medicamento set nome = '" + medicamento.getNome()
				+ "', descricao = '" + medicamento.getDescricao() 	+ "' where id = '" + medicamento.getId() + "' ");
		
		commit();

		disconecta();

	}
	
	public void deletar(Medicamento medicamento) throws DaoException {

		//EnderecoDao enderecoDao = new EnderecoDao();
		//ContatoDao contatoDao = new ContatoDao();
		conecta();

		executeUpdate("delete from medicamento where id = '" + medicamento.getId() + "' "); 

		//enderecoDao.deletar(paciente.getEndereco());
		//contatoDao.deletar(paciente.getContato());

		commit();

		disconecta();
	}

	public List<Medicamento> buscaTodos () {
		
		final List<Medicamento> listMedicamento = new ArrayList<Medicamento>();
		
		executeQuery("select * from medicamento", new Mapeador<Medicamento>() {
			public void mapear(ResultSet rset) throws DaoException {
				try {
					while (rset.next()) {
						Medicamento medicamento = new Medicamento();
						
						medicamento.setId(rset.getLong("id"));
						medicamento.setNome(rset.getString("nome"));
						medicamento.setDescricao(rset.getString("descricao"));

						listMedicamento.add(medicamento);
					}
				} catch (SQLException e) {
					throw new DaoException("Banco de dados - Erro ao criar lista em " + this.getClass().toString(), e);
				}
			}
		});
		
		return listMedicamento;
	}
	
	public Medicamento buscaMedicamentoPeloId(long id) {

		final Medicamento medicamento = new Medicamento();

		executeQuery("select * from medicamento where id = '" + id + "' ",
				new Mapeador<Medicamento>() {
					public void mapear(ResultSet rset) throws DaoException {
						try {
							if (rset.next()) {

								medicamento.setId(rset.getLong("id"));
								medicamento.setNome(rset.getString("nome"));
								medicamento.setDescricao(rset.getString("descricao"));
							}
						} catch (SQLException e) {
							throw new DaoException(
									"Banco de dados - Erro ao criar lista em "
											+ this.getClass().toString(), e);
						}
					}
				});

		return medicamento;
	}
	
}
