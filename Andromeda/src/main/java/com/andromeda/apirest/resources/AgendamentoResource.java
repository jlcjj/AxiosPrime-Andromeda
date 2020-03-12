package com.andromeda.apirest.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.andromeda.apirest.dto.AgendamentoDTO;
import com.andromeda.apirest.moldels.Agendamento;
import com.andromeda.apirest.services.AgendamentoService;

import io.swagger.annotations.Api;

@RestController
@RequestMapping(value="/agendamento")
@Api(value="API REST Agendamento")
@CrossOrigin(origins = "*")
public class AgendamentoResource {
	
	@Autowired
	private AgendamentoService as;
	
	@RequestMapping(value="/{id}" , method=RequestMethod.GET)
	public ResponseEntity<Agendamento> find(@PathVariable Long id){
		
		Agendamento obj = as.find(id);
		//List<Clientes> lista = new ArrayList<>();
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody Agendamento obj){
		obj = as.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody Agendamento obj, @PathVariable Long id){
		obj.setId(id);
		obj = as.update(obj);
		
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value="/{id}" , method=RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Long id){
		
		as.delete(id);
		return ResponseEntity.noContent().build();
	}
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<AgendamentoDTO>> findAll(){

		List<Agendamento> list = as.findAll();
		List<AgendamentoDTO> listDto = list.stream().map(obj -> new AgendamentoDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
}
