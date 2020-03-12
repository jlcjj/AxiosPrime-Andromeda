package com.andromeda.apirest.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.andromeda.apirest.moldels.Clientes;
import com.andromeda.apirest.moldels.Usuarios;
import com.andromeda.apirest.repository.UsuariosRepository;
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


}
