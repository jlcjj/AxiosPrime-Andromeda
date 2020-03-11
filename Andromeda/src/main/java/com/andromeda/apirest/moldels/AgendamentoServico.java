package com.andromeda.apirest.moldels;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="tbd_agendamento_servico")
public class AgendamentoServico implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Basic
	@ManyToOne
	@JoinColumn(name = "agendamentos_id")
	private Agendamento agendamento = new Agendamento();
	
	@Basic
	@ManyToOne
	@JoinColumn(name = "tiposerv_id")
	private TipoServicos tiposervicos = new TipoServicos();
	
	public AgendamentoServico() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Agendamento getAgendamento() {
		return agendamento;
	}

	public void setAgendamento(Agendamento agendamento) {
		this.agendamento = agendamento;
	}

	public TipoServicos getTiposervicos() {
		return tiposervicos;
	}

	public void setTiposervicos(TipoServicos tiposervicos) {
		this.tiposervicos = tiposervicos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		AgendamentoServico other = (AgendamentoServico) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "AgendamentoServico [id=" + id + ", agendamento=" + agendamento + ", tiposervicos=" + tiposervicos + "]";
	}
	
	

}
