package com.andromeda.apirest.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;


import com.andromeda.apirest.moldels.TipoServicos;
import com.andromeda.apirest.moldels.Usuarios;
import com.andromeda.apirest.repository.TipoServicosRepository;
import com.andromeda.apirest.services.exception.DataIntegrityException;
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

	public TipoServicos update(TipoServicos obj) {
		find(obj.getId());
		return sr.save(obj);
	}
	
	public void delete(Long id) {
		find(id);
		try {
			sr.delete(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possivel excluir um registro que possui dados filhos;");
		}
		
		
	}
	public List<TipoServicos> findAll(){
		return sr.findAll();
		
	}
	
	public Page<TipoServicos> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = new PageRequest(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return sr.findAll(pageRequest);
	}
}
