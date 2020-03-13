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

import com.andromeda.apirest.dto.ClientesDTO;
import com.andromeda.apirest.moldels.Clientes;
import com.andromeda.apirest.services.ClienteService;

import io.swagger.annotations.Api;

@RestController
@RequestMapping(value="/clientes")
@Api(value="API REST Clientes")
@CrossOrigin(origins = "*")
public class ClientesResource {
	
	@Autowired
	private ClienteService cs;
	
	@RequestMapping(value="/{id}" , method=RequestMethod.GET)
	public ResponseEntity<Clientes> find(@PathVariable Long id){
		
		Clientes obj = cs.find(id);
		//List<Clientes> lista = new ArrayList<>();
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody Clientes obj){
		obj = cs.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody Clientes obj, @PathVariable Long id){
		obj.setId(id);
		obj = cs.update(obj);
		
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value="/{id}" , method=RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Long id){
		
		cs.delete(id);
		return ResponseEntity.noContent().build();
	}
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<ClientesDTO>> findAll(){
		
		List<Clientes> list = cs.findAll();
		List<ClientesDTO> listDto = list.stream().map(obj -> new ClientesDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
	
	@RequestMapping(value="/page", method=RequestMethod.GET)
	public ResponseEntity<Page<ClientesDTO>> findPage(
			@RequestParam(value="page", defaultValue="0") Integer page, 
			@RequestParam(value="linesPerPage", defaultValue="24") Integer linesPerPage, 
			@RequestParam(value="orderBy", defaultValue="nome") String orderBy, 
			@RequestParam(value="direction", defaultValue="ASC") String direction) {
		Page<Clientes> list = cs.findPage(page, linesPerPage, orderBy, direction);
		Page<ClientesDTO> listDto = list.map(obj -> new ClientesDTO(obj));  
		return ResponseEntity.ok().body(listDto);
	}
	
}
