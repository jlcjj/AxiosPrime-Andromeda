package com.andromeda.apirest.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;


import com.andromeda.apirest.moldels.Telefones;

import com.andromeda.apirest.repository.TelefonesRepository;
import com.andromeda.apirest.services.exception.DataIntegrityException;
import com.andromeda.apirest.services.exception.ObjectNotFoundException;

@Service
public class TelefoneServie {
	@Autowired
	private TelefonesRepository tr;
	
	public Telefones find(Long id) {
		Telefones obj = tr.findOne(id);
		if (obj == null) {
			throw new ObjectNotFoundException("Objeto não encontrado! id: " + id
					+ ", Tipo: " + Telefones.class.getName());
		}
		return obj;

	}
	
	public Telefones insert(Telefones obj) {
		obj.setId(null);
		return tr.save(obj);
	}

	public Telefones update(Telefones obj) {
		find(obj.getId());
		return tr.save(obj);
	}
	
	public void delete(Long id) {
		find(id);
		try {
			tr.delete(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possivel excluir um registro que possui dados filhos;");
		}
		
		
	}
	public List<Telefones> findAll(){
		return tr.findAll();
		
	}
}
