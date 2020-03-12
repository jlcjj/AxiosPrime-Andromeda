package com.andromeda.apirest.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;


import com.andromeda.apirest.moldels.AgendamentoServico;
import com.andromeda.apirest.repository.AgendamentoServicoRepository;
import com.andromeda.apirest.services.exception.DataIntegrityException;
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
	
	public AgendamentoServico update(AgendamentoServico obj) {
		find(obj.getId());
		return asr.save(obj);
	}
	
	public void delete(Long id) {
		find(id);
		try {
			asr.delete(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possivel excluir um registro que possui dados filhos;");
		}
		
		
	}
	public List<AgendamentoServico> findAll(){
		return asr.findAll();
		
	}
}
