package br.edu.sc.senac.demo.demoproject;

public final class ClientDTO {

	public static final ClientDTO NULL_VALUE = new ClientDTO("", "", "");

	private final String name;
	private final String date;
	private final String email;
	
	public ClientDTO(final String name, final String date, final String email) {
	
		this.name = name;
		this.date = date;
		this.email = email;
	}

	public String getName() {
		return this.name;
	}

	public String getDate() {
		return this.date;
	}
	
	public String getEmail() {
		return this.email;
	}

}