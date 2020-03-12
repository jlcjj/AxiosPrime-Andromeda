package com.andromeda.apirest.dto;

import java.io.Serializable;

import com.andromeda.apirest.moldels.AgendamentoServico;

public class AgendamentoServicoDTO  implements Serializable{

	private static final long serialVersionUID = 1L;

	private Long id;

	public AgendamentoServicoDTO() {}
	

	public AgendamentoServicoDTO(AgendamentoServico obj) {
		
		setId(obj.getId());
		
		
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}
	

}
