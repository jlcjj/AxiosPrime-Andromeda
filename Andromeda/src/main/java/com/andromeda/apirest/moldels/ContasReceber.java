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
@Table(name="tbd_contas_receber")
public class ContasReceber implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Basic
	@ManyToOne
	@JoinColumn(name = "cliente_id")
	private Clientes clientes = new Clientes();
	
	@Basic
	@ManyToOne
	@JoinColumn(name = "tiposervico_id")
	private TipoServicos tiposervicos = new TipoServicos();
	
	private String forma_pagamento;
	
	private long valor_inicial;
	
	private String desconto;
	
	private long valor_cobrado;
	
	private long num_parcelas;
	
	private long valor_parcela;
	
	private long valor_total;
	
	private String data_pagamento;
	
	public ContasReceber() {}

	public ContasReceber(Long id, String forma_pagamento, long valor_inicial, String desconto, long valor_cobrado,
			long num_parcelas, long valor_parcela, long valor_total, String data_pagamento) {
		super();
		this.id = id;
		this.forma_pagamento = forma_pagamento;
		this.valor_inicial = valor_inicial;
		this.desconto = desconto;
		this.valor_cobrado = valor_cobrado;
		this.num_parcelas = num_parcelas;
		this.valor_parcela = valor_parcela;
		this.valor_total = valor_total;
		this.data_pagamento = data_pagamento;
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

	public TipoServicos getTiposervicos() {
		return tiposervicos;
	}

	public void setTiposervicos(TipoServicos tiposervicos) {
		this.tiposervicos = tiposervicos;
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
		ContasReceber other = (ContasReceber) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ContasReceber [id=" + id + ", clientes=" + clientes + ", tiposervicos=" + tiposervicos
				+ ", forma_pagamento=" + forma_pagamento + ", valor_inicial=" + valor_inicial + ", desconto=" + desconto
				+ ", valor_cobrado=" + valor_cobrado + ", num_parcelas=" + num_parcelas + ", valor_parcela="
				+ valor_parcela + ", valor_total=" + valor_total + ", data_pagamento=" + data_pagamento + "]";
	}
	
	
	

}
