package it.helloarticolo.dao.articolo;

import java.sql.Connection;
import java.util.List;

import it.helloarticolo.dao.DB_Mock;
import it.helloarticolo.model.Articolo;

public class ArticoloDAOImpl implements ArticoloDAO {
	
	private Connection connection;
	
	@Override
	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	@Override
	public List<Articolo> list() throws Exception {
		return DB_Mock.LISTA_ARTICOLI;
	}

	@Override
	public Articolo get(Long id) throws Exception {
		if (id == null)
			return null;
		Articolo result = new Articolo();
		
		for (Articolo articoloItem : this.list()) {
			if (articoloItem.getIdArticolo().equals(id)) 
				result = articoloItem;
		}
		
		return result;
	}

	@Override
	public int update(Articolo input) throws Exception {
		if(input == null)
			return 0;
		List<Articolo> lista = this.list();
		Articolo articoloDaSostituire = this.get(input.getIdArticolo());
		lista.remove(articoloDaSostituire);
		lista.add(input);
		
		return 1;
	}

	@Override
	public int insert(Articolo input) throws Exception {
		if(input == null)
			return 0;
		
		this.list().add(input);
		return 1;
	}

	@Override
	public int delete(Articolo input) throws Exception {
		if (input == null)
			return 0;
		
		this.list().remove(input);
		return 1;
	}

}
