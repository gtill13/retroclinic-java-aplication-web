/**
 * 
 */
package br.edu.asselvi.modelo.entidade;

/**
 * @author Gabriel Tillmann
 * 
 */
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Contrato {

	public Contrato(Paciente contratante, Medico contratada,
			Date dataCriacao, Date dataExpiracao) {
		this();
		this.contratante = contratante;
		this.contratada = contratada;
		this.dataCriacao = dataCriacao;
		this.dataExpiracao = dataExpiracao;
	}
	
	private long id;
	
	private Paciente contratante;
	
	private Medico contratada;
	
	private Date dataCriacao;
	
	private Date dataExpiracao;
	
	private List<Pagamento> pagamentos;

	public Contrato() {
		pagamentos = new ArrayList<Pagamento>();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Paciente getContratante() {
		return contratante;
	}

	public void setContratante(Paciente contratante) {
		this.contratante = contratante;
	}

	public Medico getContratada() {
		return contratada;
	}

	public void setContratada(Medico contratada) {
		this.contratada = contratada;
	}

	public Date getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public Date getDataExpiracao() {
		return dataExpiracao;
	}

	public void setDataExpiracao(Date dataExpiracao) {
		this.dataExpiracao = dataExpiracao;
	}

	public List<Pagamento> getPagamentos() {
		return pagamentos;
	}

	public void setPagamentos(List<Pagamento> pagamentos) {
		this.pagamentos = pagamentos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result	+ ((contratada == null) ? 0 : contratada.hashCode());
		result = prime * result	+ ((contratante == null) ? 0 : contratante.hashCode());
		result = prime * result	+ ((dataCriacao == null) ? 0 : dataCriacao.hashCode());
		result = prime * result	+ ((dataExpiracao == null) ? 0 : dataExpiracao.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Contrato other = (Contrato) obj;
		if (contratada == null) {
			if (other.contratada != null)
				return false;
		} else if (!contratada.equals(other.contratada))
			return false;
		if (contratante == null) {
			if (other.contratante != null)
				return false;
		} else if (!contratante.equals(other.contratante))
			return false;
		if (dataCriacao == null) {
			if (other.dataCriacao != null)
				return false;
		} else if (!dataCriacao.equals(other.dataCriacao))
			return false;
		if (dataExpiracao == null) {
			if (other.dataExpiracao != null)
				return false;
		} else if (!dataExpiracao.equals(other.dataExpiracao))
			return false;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Contrato [id=").append(id).append(", contratante=")
				.append(contratante).append(", contratada=").append(contratada)
				.append(", dataCriacao=").append(dataCriacao)
				.append(", dataExpiracao=").append(dataExpiracao)
				.append(", pagamentos=").append(pagamentos).append("]");
		return builder.toString();
	}
	
}