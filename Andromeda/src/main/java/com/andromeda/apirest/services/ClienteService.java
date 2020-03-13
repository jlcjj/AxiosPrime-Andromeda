package com.andromeda.apirest.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
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
	public List<Clientes> findAll(){
		return cr.findAll();
		
	}
	
	public Page<Clientes> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = new PageRequest(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return cr.findAll(pageRequest);
	}
	
	
}
