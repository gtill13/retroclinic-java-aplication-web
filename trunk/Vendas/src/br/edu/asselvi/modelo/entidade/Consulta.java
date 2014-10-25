/**
 * 
 */
package br.edu.asselvi.modelo.entidade;


/**
 * @author Gabriel Tillmann
 *
 */
public class Consulta {


	/**
	 * 
	 */
	public Consulta() {
		super();
	}

	/**
	 * @param id
	 * @param medico
	 * @param paciente
	 * @param dataCriacao
	 * @param medicamento
	 * @param pagamento
	 */
	public Consulta(long id, Medico medico, Paciente paciente,
			Medicamento medicamento,
			Pagamento pagamento) {
		super();
		this.id = id;
		this.medico = medico;
		this.paciente = paciente;
		this.medicamento = medicamento;
		this.pagamento = pagamento;
	}

	private long id;
	
	private Medico medico;
	
	private Paciente paciente;
	
	private Medicamento medicamento;
	
	private Pagamento pagamento;

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the medico
	 */
	public Medico getMedico() {
		return medico;
	}

	/**
	 * @param medico the medico to set
	 */
	public void setMedico(Medico medico) {
		this.medico = medico;
	}

	/**
	 * @return the paciente
	 */
	public Paciente getPaciente() {
		return paciente;
	}

	/**
	 * @param paciente the paciente to set
	 */
	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	/**
	 * @return the medicamento
	 */
	public Medicamento getMedicamento() {
		return medicamento;
	}

	/**
	 * @param medicamento the medicamento to set
	 */
	public void setMedicamento(Medicamento medicamento) {
		this.medicamento = medicamento;
	}

	/**
	 * @return the pagamento
	 */
	public Pagamento getPagamento() {
		return pagamento;
	}

	/**
	 * @param pagamento the pagamento to set
	 */
	public void setPagamento(Pagamento pagamento) {
		this.pagamento = pagamento;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Consulta [id=").append(id).append(", medico=")
				.append(medico).append(", paciente=").append(paciente)
				.append(", medicamento=").append(medicamento)
				.append(", pagamento=").append(pagamento).append("]");
		return builder.toString();
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((medicamento == null) ? 0 : medicamento.hashCode());
		result = prime * result + ((medico == null) ? 0 : medico.hashCode());
		result = prime * result
				+ ((paciente == null) ? 0 : paciente.hashCode());
		result = prime * result
				+ ((pagamento == null) ? 0 : pagamento.hashCode());
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
		Consulta other = (Consulta) obj;
		if (medicamento == null) {
			if (other.medicamento != null)
				return false;
		} else if (!medicamento.equals(other.medicamento))
			return false;
		if (medico == null) {
			if (other.medico != null)
				return false;
		} else if (!medico.equals(other.medico))
			return false;
		if (paciente == null) {
			if (other.paciente != null)
				return false;
		} else if (!paciente.equals(other.paciente))
			return false;
		if (pagamento == null) {
			if (other.pagamento != null)
				return false;
		} else if (!pagamento.equals(other.pagamento))
			return false;
		return true;
	}

	public String toSimpleString() {
		StringBuilder builder = new StringBuilder();
		builder.append("consulta [id=").append(id).append(", medico=").append(medico.toSimpleString()).append(", paciente=").append(paciente.toSimpleString()).append("]");
		return builder.toString();
	}


}
