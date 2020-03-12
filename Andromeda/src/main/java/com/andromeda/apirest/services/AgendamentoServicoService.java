package com.andromeda.apirest.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.andromeda.apirest.moldels.Agendamento;
import com.andromeda.apirest.moldels.AgendamentoServico;
import com.andromeda.apirest.repository.AgendamentoServicoRepository;
import com.andromeda.apirest.services.exception.ObjectNotFoundException;

@Service
public class AgendamentoServicoService {

	@Autowired
	private AgendamentoServicoRepository asr;
	
	public AgendamentoServico find(Long id) {
		AgendamentoServico obj = asr.findOne(id);
		if (obj == null) {
			throw new ObjectNotFoundException("Objeto não encontrado! id: " + id
					+ ", Tipo: " + AgendamentoServico.class.getName());
		}
		return obj;

	}
	public AgendamentoServico insert(AgendamentoServico obj) {
		obj.setId(null);
		return asr.save(obj);
	}
}
