package com.andromeda.apirest.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.andromeda.apirest.moldels.Agendamento;
import com.andromeda.apirest.repository.AgendamentoRepository;
import com.andromeda.apirest.services.exception.ObjectNotFoundException;

@Service
public class AgendamentoService {
	
	@Autowired
	private AgendamentoRepository ar;
	
	public Agendamento buscar(Long id) {
		Agendamento obj = ar.findOne(id);
		if (obj == null) {
			throw new ObjectNotFoundException("Objeto não encontrado! id: " + id
					+ ", Tipo: " + Agendamento.class.getName());
		}
		return obj;

	}
	

}
