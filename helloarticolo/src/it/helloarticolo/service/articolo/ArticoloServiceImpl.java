package it.helloarticolo.service.articolo;

import java.util.List;

import it.helloarticolo.dao.articolo.ArticoloDAO;
import it.helloarticolo.model.Articolo;

public class ArticoloServiceImpl implements ArticoloService {

	private ArticoloDAO articoloDAO;
	
	@Override
	public void setArticoloDAO(ArticoloDAO articoloDAO) {
		this.articoloDAO = articoloDAO;

	}

	@Override
	public List<Articolo> list() throws Exception {
		try {

			return articoloDAO.list();

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	public List<Articolo> listCarrello() throws Exception {
		try {

			return articoloDAO.listCarrello();

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public Articolo get(Long idInput) throws Exception {
		try {

			return articoloDAO.get(idInput);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public int update(Articolo articoloInput) throws Exception {
		try {

			return articoloDAO.update(articoloInput);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public int insert(Articolo articoloInput) throws Exception {
		try {

			return articoloDAO.insert(articoloInput);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public int delete(Articolo articoloInput) throws Exception {
		try {

			return articoloDAO.delete(articoloInput);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	public int aggiungiACarrello(Articolo articoloInput) throws Exception {
		try {

			return articoloDAO.addToCarrello(articoloInput);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	public int rimuoviDaCarrello(Articolo articoloInput) throws Exception {
		try {

			return articoloDAO.removeFromCarrello(articoloInput);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	public int totaleCarrello() throws Exception {
		try {

			return articoloDAO.totaleImportoCarrello();

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

}
