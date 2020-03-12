package com.andromeda.apirest.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;


import com.andromeda.apirest.moldels.ContasReceber;

import com.andromeda.apirest.repository.ContasReceberRepository;
import com.andromeda.apirest.services.exception.DataIntegrityException;
import com.andromeda.apirest.services.exception.ObjectNotFoundException;

@Service
public class ContasReceberService {
	
	@Autowired
	private ContasReceberRepository crr;
	
	public ContasReceber find(Long id) {
		ContasReceber obj = crr.findOne(id);
		if (obj == null) {
			throw new ObjectNotFoundException("Objeto não encontrado! id: " + id
					+ ", Tipo: " + ContasReceber.class.getName());
		}
		return obj;

	}
	
	public ContasReceber insert(ContasReceber obj) {
		obj.setId(null);
		return crr.save(obj);
	}

	public ContasReceber update(ContasReceber obj) {
		find(obj.getId());
		return crr.save(obj);
	}
	
	public void delete(Long id) {
		find(id);
		try {
			crr.delete(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possivel excluir um registro que possui dados filhos;");
		}
		
		
	}
	public List<ContasReceber> findAll(){
		return crr.findAll();
		
	}
}
