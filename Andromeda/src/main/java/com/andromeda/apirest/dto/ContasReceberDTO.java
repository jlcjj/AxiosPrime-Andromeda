package com.andromeda.apirest.dto;

import java.io.Serializable;

import com.andromeda.apirest.moldels.ContasReceber;

public class ContasReceberDTO  implements Serializable{

	private static final long serialVersionUID = 1L;

	
	private Long id;
	private String forma_pagamento;
	private long valor_inicial;
	private String desconto;
	private long valor_cobrado;
	private long num_parcelas;
	private long valor_parcela;
	private long valor_total;
	private String data_pagamento;

	public ContasReceberDTO() {}
	
	public ContasReceberDTO(ContasReceber obj) {
		
		id = obj.getId();
		forma_pagamento = obj.getForma_pagamento();
		valor_inicial = obj.getValor_inicial();
		desconto = obj.getDesconto();
		valor_cobrado = obj.getValor_cobrado();
		num_parcelas = obj.getNum_parcelas();
		valor_parcela = obj.getValor_parcela();
		valor_total = obj.getValor_total();
		data_pagamento = obj.getData_pagamento();
		
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getForma_pagamento() {
		return forma_pagamento;
	}

	public void setForma_pagamento(String forma_pagamento) {
		this.forma_pagamento = forma_pagamento;
	}

	public long getValor_inicial() {
		return valor_inicial;
	}

	public void setValor_inicial(long valor_inicial) {
		this.valor_inicial = valor_inicial;
	}

	public String getDesconto() {
		return desconto;
	}

	public void setDesconto(String desconto) {
		this.desconto = desconto;
	}

	public long getValor_cobrado() {
		return valor_cobrado;
	}

	public void setValor_cobrado(long valor_cobrado) {
		this.valor_cobrado = valor_cobrado;
	}

	public long getNum_parcelas() {
		return num_parcelas;
	}

	public void setNum_parcelas(long num_parcelas) {
		this.num_parcelas = num_parcelas;
	}

	public long getValor_parcela() {
		return valor_parcela;
	}

	public void setValor_parcela(long valor_parcela) {
		this.valor_parcela = valor_parcela;
	}

	public long getValor_total() {
		return valor_total;
	}

	public void setValor_total(long valor_total) {
		this.valor_total = valor_total;
	}

	public String getData_pagamento() {
		return data_pagamento;
	}

	public void setData_pagamento(String data_pagamento) {
		this.data_pagamento = data_pagamento;
	}

}
