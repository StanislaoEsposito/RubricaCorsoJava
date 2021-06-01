package it.rdev.rubrica.model.file;

import java.sql.SQLException;


public interface DAOFile<T> {
	
	boolean persist(T t) throws SQLException;
	
	boolean delete(T t) throws SQLException;
	
	boolean update(T t) throws SQLException;

}
