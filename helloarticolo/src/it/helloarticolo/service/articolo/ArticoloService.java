package it.helloarticolo.service.articolo;

import java.util.List;

import it.helloarticolo.dao.articolo.ArticoloDAO;
import it.helloarticolo.model.Articolo;

public interface ArticoloService {
	public void setArticoloDAO(ArticoloDAO articoloDAO);

	public List<Articolo> list() throws Exception;

	public Articolo get(Long idInput) throws Exception;

	public int update(Articolo articoloInput) throws Exception;

	public int insert(Articolo articoloInput) throws Exception;

	public int delete(Articolo articoloInput) throws Exception;
}
