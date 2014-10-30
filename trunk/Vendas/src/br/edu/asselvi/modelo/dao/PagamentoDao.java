package br.edu.asselvi.modelo.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;

import java.util.List;

import br.edu.asselvi.modelo.entidade.Pagamento;

public class PagamentoDao extends DaoBase {

	public long inserirComRetorno(Pagamento pagamento) {

		if (pagamento == null)
			return 0;
		
		conecta();
		executeUpdate("insert into pagamento (valor, descricao) values ( '"
				+ pagamento.getValor()+ "', '" + pagamento.getDescricao()+ "' ) ");

		return getGenerationKeys();

	}

	public void inserir(Pagamento pagamento) {

		conecta();
		executeUpdate("insert into pagamento (valor, descricao) values ( '"
				+ pagamento.getValor()+ "', '" + pagamento.getDescricao()+ "' ) ");

		commit();

		disconecta();

	}

	
	public void atualizar(Pagamento pagamento) throws DaoException {

		if (pagamento == null)
			return;

		conecta();

		executeUpdate("update pagamento set valor = '" + pagamento.getValor() + "', descricao = '" + pagamento.getDescricao() 
				+ "' where id = '" + pagamento.getId() + "' ");

		commit();

		disconecta();
	}

	public void deletar(Pagamento pagamento) throws DaoException {

		deletar(pagamento.getId());
	}

	public void deletar(long id) throws DaoException {

		conecta();

		executeUpdate("delete from pagamento where id = '" + id
				+ "' ");

		commit();

		disconecta();
	}

	
	public List<Pagamento> buscaTodos() {

		final List<Pagamento> listPagamentos = new ArrayList<Pagamento>();

		executeQuery("select * from pagamento", new Mapeador<Pagamento>() {
			public void mapear(ResultSet rset) throws DaoException {
				try {
					while (rset.next()) {
						Pagamento pagamento = new Pagamento();

						pagamento.setId(rset.getLong("id"));
						pagamento.setValor(rset.getDouble("valor"));
						pagamento.setDescricao(rset.getString("descricao"));
						
						listPagamentos.add(pagamento);
					}
				} catch (SQLException e) {
					throw new DaoException(
							"Banco de dados - Erro ao criar lista em "
									+ this.getClass().toString(), e);
				}
			}
		});

		return listPagamentos;
	}

	public Pagamento buscaPagamentoPeloId(long id) {

		final Pagamento pagamento = new Pagamento();

		executeQuery("select * from pagamento where id = '" + id + "' ",
				new Mapeador<Pagamento>() {
					public void mapear(ResultSet rset) throws DaoException {
						try {
							if (rset.next()) {

								pagamento.setId(rset.getLong("id"));
								pagamento.setValor(rset.getDouble("valor"));
								pagamento.setDescricao(rset.getString("descricao"));
								
							}
						} catch (SQLException e) {
							throw new DaoException(
									"Banco de dados - Erro ao criar lista em "
											+ this.getClass().toString(), e);
						}
					}
				});

		return pagamento;
	}
	
}
