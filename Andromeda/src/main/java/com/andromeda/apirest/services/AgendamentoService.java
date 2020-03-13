package com.andromeda.apirest.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.andromeda.apirest.moldels.Agendamento;
import com.andromeda.apirest.repository.AgendamentoRepository;
import com.andromeda.apirest.services.exception.DataIntegrityException;
import com.andromeda.apirest.services.exception.ObjectNotFoundException;

@Service
public class AgendamentoService {
	
	@Autowired
	private AgendamentoRepository ar;
	
	public Agendamento find(Long id) {
		Agendamento obj = ar.findOne(id);
		if (obj == null) {
			throw new ObjectNotFoundException("Objeto não encontrado! id: " + id
					+ ", Tipo: " + Agendamento.class.getName());
		}
		return obj;

	}
	public Agendamento insert(Agendamento obj) {
		obj.setId(null);
		return ar.save(obj);
	}
	
	public Agendamento update(Agendamento obj) {
		find(obj.getId());
		return ar.save(obj);
	}
	
	public void delete(Long id) {
		find(id);
		try {
			ar.delete(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possivel excluir um registro que possui dados filhos;");
		}
		
		
	}
	public List<Agendamento> findAll(){
		return ar.findAll();
		
	}
	public Page<Agendamento> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = new PageRequest(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return ar.findAll(pageRequest);
	}

}
