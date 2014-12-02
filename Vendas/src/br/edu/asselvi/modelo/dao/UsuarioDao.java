/**
 * 
 */
package br.edu.asselvi.modelo.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.asselvi.modelo.entidade.Usuario;

/**
 * @author TiLL
 *
 */
public class UsuarioDao extends DaoBase {
	
	public void inserirPadrao(Usuario login) throws DaoException {

		conecta();
		
		executeUpdate("insert into usuario (login, senha) values ( '"
				+ login.getLogin() + "', '" + login.getSenha() + "' ) ");
		
		commit();

		disconecta();
	}

	public long atualizar(Usuario login) throws DaoException {

		if (login == null)
			return 0;
			
		conecta();

		executeUpdate("update usuario set login = '" + login.getLogin()
				+ "', senha = '" + login.getSenha() + "' where id = '" + login.getId() + "' ");
		
		return login.getId();
	}
	
	public void deletar(long id) throws DaoException {
		
		
		conecta();

		executeUpdate("delete from usuario where id = '" + id + "' "); 
		
		commit();
		
		disconecta();
	}
	
	public void deletar(Usuario login) throws DaoException {
		if (login == null)
			return;
	
		deletar(login.getId());
	}
	
	public List<Usuario> buscaTodos () {
		
		final List<Usuario> listLogin = new ArrayList<Usuario>();
		
		executeQuery("select * from usuario", new Mapeador<Usuario>() {
			public void mapear(ResultSet rset) throws DaoException {
				try {
					while (rset.next()) {
						Usuario login = new Usuario();
						
						login.setId(rset.getLong("id"));
						login.setLogin(rset.getString("login"));
						login.setSenha(rset.getString("senha"));
						
						listLogin.add(login);
					}
				} catch (SQLException e) {
					throw new DaoException("Banco de dados - Erro ao criar lista em " + this.getClass().toString(), e);
				}
			}
		});
		
		return listLogin;
	}
	
	public Usuario buscaEnderecoPeloId (long id) {

		if (id == 0)
			return null;
		
		final Usuario login = new Usuario();
		
		executeQuery("select * from usuario where id = '" + id + "' ", new Mapeador<Usuario>() {
			public void mapear(ResultSet rset) throws DaoException {
				try {
					if (rset.next()) {
						
						login.setId(rset.getLong("id"));
						login.setLogin(rset.getString("login"));
						login.setSenha(rset.getString("senha"));
					}
				} catch (SQLException e) {
					throw new DaoException("Banco de dados - Erro ao criar lista em " + this.getClass().toString(), e);
				}
			}
		});
		
		return login;
	}
	
	public boolean verificaLogin(Usuario usuario) {

		if (usuario == null)
			return false;
		
		final Usuario login = new Usuario();
		
		executeQuery("select * from usuario where login = '" + usuario.getLogin() + "' and senha = '" + usuario.getSenha() + "' ", new Mapeador<Usuario>() {
			public void mapear(ResultSet rset) throws DaoException {
				try {
					if (rset.next()) {
						login.setId(rset.getLong("id"));
					}
				} catch (SQLException e) {
					throw new DaoException("Banco de dados - Erro ao criar lista em " + this.getClass().toString(), e);
				}
			}
		});
		return ((login.getId() != 0) ? true : false);
	}

}
