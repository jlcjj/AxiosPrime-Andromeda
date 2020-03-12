package com.andromeda.apirest.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.andromeda.apirest.moldels.Clientes;
import com.andromeda.apirest.moldels.TipoServicos;
import com.andromeda.apirest.repository.TipoServicosRepository;
import com.andromeda.apirest.services.exception.ObjectNotFoundException;

@Service
public class TipoServicoService {
	
	@Autowired
	private TipoServicosRepository sr;
	
	public TipoServicos find(Long id) {
		TipoServicos obj = sr.findOne(id);
		if (obj == null) {
			throw new ObjectNotFoundException("Objeto não encontrado! id: " + id
					+ ", Tipo: " + TipoServicos.class.getName());
		}
		return obj;

	}
	
	public TipoServicos insert(TipoServicos obj) {
		obj.setId(null);
		return sr.save(obj);
	}

}
