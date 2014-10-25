/**
 * 
 */
package br.edu.asselvi.modelo.dao;

import java.sql.ResultSet;

/**
 * @author TiLL
 *
 */
public interface Mapeador<T> {

	void mapear (ResultSet rset) throws DaoException;
	
}
