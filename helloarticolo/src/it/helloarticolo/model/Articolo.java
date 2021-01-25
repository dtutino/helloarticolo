package it.helloarticolo.model;

public class Articolo {

	private Long idArticolo;
	private String nome;
	private String categoria;
	private String marca;
	private String modello;
	private int prezzo;
	
	public Articolo() {}
	
	public Articolo(Long idArticolo, String nome, String categoria, String marca, String modello, int prezzo) {
		super();
		this.idArticolo = idArticolo;
		this.nome = nome;
		this.categoria = categoria;
		this.marca = marca;
		this.modello = modello;
		this.prezzo = prezzo;
	}

	public Long getIdArticolo() {
		return idArticolo;
	}

	public void setIdArticolo(Long idArticolo) {
		this.idArticolo = idArticolo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModello() {
		return modello;
	}

	public void setModello(String modello) {
		this.modello = modello;
	}

	public int getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(int prezzo) {
		this.prezzo = prezzo;
	}
	
	
	
}
