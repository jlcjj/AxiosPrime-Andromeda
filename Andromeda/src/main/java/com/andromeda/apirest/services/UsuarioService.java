package com.andromeda.apirest.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.andromeda.apirest.moldels.Clientes;
import com.andromeda.apirest.moldels.Usuarios;
import com.andromeda.apirest.repository.UsuariosRepository;
import com.andromeda.apirest.services.exception.DataIntegrityException;
import com.andromeda.apirest.services.exception.ObjectNotFoundException;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuariosRepository ur;
	
	public Usuarios find(Long id) {
		Usuarios obj = ur.findOne(id);
		if (obj == null) {
			throw new ObjectNotFoundException("Objeto não encontrado! id: " + id
					+ ", Tipo: " + Usuarios.class.getName());
		}
		return obj;

	}
	public Usuarios insert(Usuarios obj) {
		obj.setId(null);
		return ur.save(obj);
	}

	public Usuarios update(Usuarios obj) {
		find(obj.getId());
		return ur.save(obj);
	}
	
	public void delete(Long id) {
		find(id);
		try {
			ur.delete(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possivel excluir um registro que possui dados filhos;");
		}
		
		
	}
	public List<Usuarios> findAll(){
		return ur.findAll();
		
	}
	public Page<Usuarios> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = new PageRequest(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return ur.findAll(pageRequest);
	}
	
}
