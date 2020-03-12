package com.andromeda.apirest.dto;

import java.io.Serializable;

import com.andromeda.apirest.moldels.TipoServicos;

public class TipoServicosDTO  implements Serializable{

	private static final long serialVersionUID = 1L;

	
	private Long id;
	private String descricao;
	private long valor;
	
	public TipoServicosDTO() {}
	
	public TipoServicosDTO(TipoServicos obj) {
		
		id = obj.getId();
		descricao = obj.getDescricao();
		valor = obj.getValor();
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public long getValor() {
		return valor;
	}

	public void setValor(long valor) {
		this.valor = valor;
	}
	

}
