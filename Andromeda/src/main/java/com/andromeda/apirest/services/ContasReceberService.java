package com.andromeda.apirest.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.andromeda.apirest.moldels.Clientes;
import com.andromeda.apirest.moldels.ContasReceber;
import com.andromeda.apirest.repository.ContasReceberRepository;
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

}
