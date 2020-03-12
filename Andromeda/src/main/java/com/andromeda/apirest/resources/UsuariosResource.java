package com.andromeda.apirest.resources;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.andromeda.apirest.moldels.TipoServicos;
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
	public ResponseEntity<Usuarios> find(@PathVariable Long id){
		
		Usuarios obj = us.find(id);
		//List<Clientes> lista = new ArrayList<>();
		return ResponseEntity.ok().body(obj);
	}
	public ResponseEntity<Void> insert(@RequestBody Usuarios obj){
		obj = us.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
}
