package com.andromeda.apirest.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.andromeda.apirest.dto.UsuariosDTO;
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
	

	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody Usuarios obj, @PathVariable Long id){
		obj.setId(id);
		obj = us.update(obj);
		
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value="/{id}" , method=RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Long id){
		
		us.delete(id);
		return ResponseEntity.noContent().build();
	}
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<UsuariosDTO>> findAll(){
		
		List<Usuarios> list = us.findAll();
		List<UsuariosDTO> listDto = list.stream().map(obj -> new UsuariosDTO(obj)).collect(Collectors.toList());
		
		return ResponseEntity.ok().body(listDto);
	}
	@RequestMapping(value="/page", method=RequestMethod.GET)
	public ResponseEntity<Page<UsuariosDTO>> findPage(
			@RequestParam(value="page", defaultValue="0") Integer page, 
			@RequestParam(value="linesPerPage", defaultValue="24") Integer linesPerPage, 
			@RequestParam(value="orderBy", defaultValue="nome") String orderBy, 
			@RequestParam(value="direction", defaultValue="ASC") String direction) {
		Page<Usuarios> list = us.findPage(page, linesPerPage, orderBy, direction);
		Page<UsuariosDTO> listDto = list.map(obj -> new UsuariosDTO(obj));  
		return ResponseEntity.ok().body(listDto);
	}
}
