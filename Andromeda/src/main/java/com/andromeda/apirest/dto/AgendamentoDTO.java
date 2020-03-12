package com.andromeda.apirest.dto;

import java.io.Serializable;

import com.andromeda.apirest.moldels.Agendamento;

public class AgendamentoDTO implements Serializable{

	private static final long serialVersionUID = 1L;

	
	private Long id;
	private String data_agendada;
	private String Hora_agendada;
	public AgendamentoDTO() {}
	
	public AgendamentoDTO(Agendamento obj) {
		
		id = obj.getId();
		data_agendada = obj.getData_agendada();
		Hora_agendada = obj.getHora_agendada();
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
	
	

}
