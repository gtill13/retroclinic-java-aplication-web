package br.edu.asselvi.modelo.entidade;

public class Contato {
	
	public Contato(long id, String email, String telefone, String celular) {
		super();
		this.id = id;
		this.email = email;
		this.telefone = telefone;
		this.celular = celular;
	}

	public Contato(String email, String telefone, String celular) {
		super();
		this.email = email;
		this.telefone = telefone;
		this.celular = celular;
	}

	public Contato() {
		// TODO Auto-generated constructor stub
	}

	private long id;
	private String email;
	private String telefone;
	private String celular;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

		
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder .append("Contato [ email = ")
		        .append(email)
		        .append(", telefone = ")
				.append(telefone)
				.append(", celular = ")
				.append(celular)
				.append(" ]");
		return builder.toString();
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((celular == null) ? 0 : celular.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result
				+ ((telefone == null) ? 0 : telefone.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Contato other = (Contato) obj;
		if (celular == null) {
			if (other.celular != null)
				return false;
		} else if (!celular.equals(other.celular))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (id != other.id)
			return false;
		if (telefone == null) {
			if (other.telefone != null)
				return false;
		} else if (!telefone.equals(other.telefone))
			return false;
		return true;
	}
	
	
}