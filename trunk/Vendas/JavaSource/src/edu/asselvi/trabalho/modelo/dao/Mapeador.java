/**
 * 
 */
package edu.asselvi.trabalho.modelo.dao;

import java.sql.ResultSet;

/**
 * @author TiLL
 *
 */
public interface Mapeador<T> {

	void mapear (ResultSet rset) throws DaoException;
	
}
