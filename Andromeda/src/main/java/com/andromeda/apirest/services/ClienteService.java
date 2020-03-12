package com.andromeda.apirest.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.andromeda.apirest.moldels.Clientes;
import com.andromeda.apirest.repository.ClientesRepository;
import com.andromeda.apirest.services.exception.DataIntegrityException;
import com.andromeda.apirest.services.exception.ObjectNotFoundException;

@Service
public class ClienteService {
	
	@Autowired
	private ClientesRepository cr;
	
	public Clientes find(Long id) {
		Clientes obj = cr.findOne(id);
		if (obj == null) {
			throw new ObjectNotFoundException("Objeto não encontrado! id: " + id
					+ ", Tipo: " + Clientes.class.getName());
		}
		return obj;

	}
	
	public Clientes insert(Clientes obj) {
		obj.setId(null);
		return cr.save(obj);
	}

	public Clientes update(Clientes obj) {
		find(obj.getId());
		return cr.save(obj);
	}
	
	public void delete(Long id) {
		find(id);
		try {
			cr.delete(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possivel excluir um Cliente que possui dados filhos;");
		}
		
		
	}
	
	
}
