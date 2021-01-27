package it.helloarticolo.dao.articolo;

import java.sql.Connection;
import java.util.List;

import it.helloarticolo.dao.IBaseDAO;
import it.helloarticolo.model.Articolo;

public interface ArticoloDAO extends IBaseDAO<Articolo> {

	public void setConnection(Connection connection);
	
	public List<Articolo> listCarrello() throws Exception;
	
	public int addToCarrello(Articolo input) throws Exception;
	
	public int removeFromCarrello(Articolo input) throws Exception;
	
	public int totaleImportoCarrello() throws Exception;
	
}
