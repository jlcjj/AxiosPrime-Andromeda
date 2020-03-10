package com.andromeda.apirest.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.andromeda.apirest.moldels.Clientes;
import com.andromeda.apirest.repository.ClientesRepository;
import com.andromeda.apirest.services.exception.ObjectNotFoundException;

@Service
public class ClienteService {
	
	@Autowired
	private ClientesRepository cr;
	
	public Clientes buscar(Long id) {
		Clientes obj = cr.findOne(id);
		if (obj == null) {
			throw new ObjectNotFoundException("Objeto não encontrado! id: " + id
					+ ", Tipo: " + Clientes.class.getName());
		}
		return obj;

	}
	

}
