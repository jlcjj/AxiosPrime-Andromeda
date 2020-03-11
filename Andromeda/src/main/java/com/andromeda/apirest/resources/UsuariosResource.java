package com.andromeda.apirest.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.andromeda.apirest.moldels.Usuarios;
import com.andromeda.apirest.services.UsuarioService;

import io.swagger.annotations.Api;

@RestController
@RequestMapping(value="/usuarios")
@Api(value="API REST Usuarios")
@CrossOrigin(origins = "*")
public class UsuariosResource {
	
	@Autowired
	private UsuarioService us;
	
	@RequestMapping(value="/{id}" , method=RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Long id){
		
		Usuarios obj = us.buscar(id);
		//List<Clientes> lista = new ArrayList<>();
		return ResponseEntity.ok().body(obj);
	}
}
