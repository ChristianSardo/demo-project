package br.edu.sc.senac.demo.demoproject;

public final class ClientDTO {

	public static final ProductDTO NULL_VALUE = new ProductDTO(Long.valueOf(0), "", "", Double.valueOf(0.0));

	private final Long id;
	private final String name;
	private final String date;
	
	public ClientDTO(final Long id, final String name, final String date) {
		this.id = id;
		this.name = name;
		this.date = date;
	}

	public Long getId() {
		return this.id;
	}

	public String getName() {
		return this.name;
	}

	public String getDate() {
		return this.date;
	}

}