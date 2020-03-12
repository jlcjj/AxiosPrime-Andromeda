package com.andromeda.apirest.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.andromeda.apirest.moldels.Clientes;
import com.andromeda.apirest.moldels.Telefones;
import com.andromeda.apirest.repository.TelefonesRepository;
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

}
