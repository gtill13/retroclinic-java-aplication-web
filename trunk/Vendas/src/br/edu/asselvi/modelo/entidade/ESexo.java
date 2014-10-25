package br.edu.asselvi.modelo.entidade;

public enum ESexo {

	M("Masculino"), F("Feminino");
	

	private final String descricao;

	/*
	 * @return the descricao
	 */
	public String getDescricao() {
		return descricao;
	}

	private ESexo(String descricao) {
		this.descricao = descricao;
	}

}
