package it.helloarticolo.dao;

import java.util.ArrayList;
import java.util.List;

import it.helloarticolo.model.Articolo;

public class DB_Mock {

	public static final List<Articolo> LISTA_ARTICOLI = new ArrayList<>();
	
	public static final List<Articolo> CARRELLO = new ArrayList<>();

	static {
		// preparo una lista mock perché ancora non ho il collegamento alla
		// base dati
		LISTA_ARTICOLI.add(new Articolo(1l, "notebook", "informatica", "dell", "inspiron", 800));
		LISTA_ARTICOLI.add(new Articolo(2l, "iphone", "telefonia", "apple", "12", 1000));
		LISTA_ARTICOLI.add(new Articolo(3l, "console", "videogiochi", "playstation", "5", 500));
		LISTA_ARTICOLI.add(new Articolo(4l, "tv", "video", "samsung", "sw3t", 1600));
		LISTA_ARTICOLI.add(new Articolo(5l, "ipad", "telefonia", "apple", "air10", 700));
		LISTA_ARTICOLI.add(new Articolo(6l, "tastiera", "informatica", "apple", "wireless", 150));
		LISTA_ARTICOLI.add(new Articolo(7l, "aspirapolvere", "casa", "dyson", "asp30", 400));
	}
	
}
