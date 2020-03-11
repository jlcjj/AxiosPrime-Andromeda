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
@Table(name="tbd_agendamentos")
public class Agendamento implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Basic
	@ManyToOne
	@JoinColumn(name = "cliente_id")
	private Clientes clientes = new Clientes();
	
	private String data_agendada;
	
	private String Hora_agendada;
	
	public Agendamento() {}

	public Agendamento(Long id, String data_agendada, String hora_agendada) {
		super();
		this.id = id;
		this.data_agendada = data_agendada;
		Hora_agendada = hora_agendada;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Clientes getClientes() {
		return clientes;
	}

	public void setClientes(Clientes clientes) {
		this.clientes = clientes;
	}

	public String getData_agendada() {
		return data_agendada;
	}

	public void setData_agendada(String data_agendada) {
		this.data_agendada = data_agendada;
	}

	public String getHora_agendada() {
		return Hora_agendada;
	}

	public void setHora_agendada(String hora_agendada) {
		Hora_agendada = hora_agendada;
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
		Agendamento other = (Agendamento) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Agendamento [id=" + id + ", clientes=" + clientes + ", data_agendada=" + data_agendada
				+ ", Hora_agendada=" + Hora_agendada + "]";
	}
	
	
	

}
