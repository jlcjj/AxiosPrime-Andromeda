package com.andromeda.apirest.moldels;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="tbd_clientes")
public class Clientes implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable = false, length = 80)
	private String nome;

	@Column(nullable = true, length = 15)
	private String rg;
	
	@Column(nullable = false, length = 20)
	private String cpf;

	@Column(nullable = false, length = 100)
	private String endereco;

	@Column(nullable = true, length = 8)
	private String numero;

	@Column(nullable = true, length = 80)
	private String complemento;

	@Column(nullable = true, length = 80)
	private String bairro;

	@Column(nullable = true, length = 10)
	private String cep;

	@Column(nullable = true, length = 80)
	private String cidade;

	@Column(nullable = true, length = 15)
	private String UF;
	
	@Column(nullable = true, length = 15)
	private String data_nascimento;

	@Column(nullable = true, length = 200)
	private String observacao;

	@Column(nullable = true, length = 20)
	private String status;


	@OneToMany
	private List<Telefones> tel ;
	
	
	public Clientes() {}


	public Clientes(Long id, String nome, String rg, String cpf, String endereco, String numero, String complemento,
			String bairro, String cep, String cidade, String uF, String data_nascimento, String observacao,
			String status) {
		super();
		this.id = id;
		this.nome = nome;
		this.rg = rg;
		this.cpf = cpf;
		this.endereco = endereco;
		this.numero = numero;
		this.complemento = complemento;
		this.bairro = bairro;
		this.cep = cep;
		this.cidade = cidade;
		UF = uF;
		this.data_nascimento = data_nascimento;
		this.observacao = observacao;
		this.status = status;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getRg() {
		return rg;
	}


	public void setRg(String rg) {
		this.rg = rg;
	}


	public String getCpf() {
		return cpf;
	}


	public void setCpf(String cpf) {
		this.cpf = cpf;
	}


	public String getEndereco() {
		return endereco;
	}


	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}


	public String getNumero() {
		return numero;
	}


	public void setNumero(String numero) {
		this.numero = numero;
	}


	public String getComplemento() {
		return complemento;
	}


	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}


	public String getBairro() {
		return bairro;
	}


	public void setBairro(String bairro) {
		this.bairro = bairro;
	}


	public String getCep() {
		return cep;
	}


	public void setCep(String cep) {
		this.cep = cep;
	}


	public String getCidade() {
		return cidade;
	}


	public void setCidade(String cidade) {
		this.cidade = cidade;
	}


	public String getUF() {
		return UF;
	}


	public void setUF(String uF) {
		UF = uF;
	}


	public String getData_nascimento() {
		return data_nascimento;
	}


	public void setData_nascimento(String data_nascimento) {
		this.data_nascimento = data_nascimento;
	}


	public String getObservacao() {
		return observacao;
	}


	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}
	
	public List<Telefones> getTel() {
		return tel;
	}


	public void setTel(List<Telefones> tel) {
		this.tel = tel;
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
		Clientes other = (Clientes) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Clientes [id=" + id + ", nome=" + nome + ", rg=" + rg + ", cpf=" + cpf + ", endereco=" + endereco
				+ ", numero=" + numero + ", complemento=" + complemento + ", bairro=" + bairro + ", cep=" + cep
				+ ", cidade=" + cidade + ", UF=" + UF + ", data_nascimento=" + data_nascimento + ", observacao="
				+ observacao + ", status=" + status + "]";
	}


	
	
	
		    
}
