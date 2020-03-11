package com.andromeda.apirest.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.andromeda.apirest.moldels.Usuarios;
import com.andromeda.apirest.repository.UsuariosRepository;
import com.andromeda.apirest.services.exception.ObjectNotFoundException;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuariosRepository ur;
	
	public Usuarios buscar(Long id) {
		Usuarios obj = ur.findOne(id);
		if (obj == null) {
			throw new ObjectNotFoundException("Objeto não encontrado! id: " + id
					+ ", Tipo: " + Usuarios.class.getName());
		}
		return obj;

	}
	

}
