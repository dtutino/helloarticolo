package it.helloarticolo.dao.articolo;

import java.sql.Connection;

import it.helloarticolo.dao.IBaseDAO;
import it.helloarticolo.model.Articolo;

public interface ArticoloDAO extends IBaseDAO<Articolo> {

	public void setConnection(Connection connection);
	
}
