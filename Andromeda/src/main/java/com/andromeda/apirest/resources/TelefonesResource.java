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

import com.andromeda.apirest.dto.TelefonesDTO;
import com.andromeda.apirest.moldels.Telefones;
import com.andromeda.apirest.services.TelefoneServie;

import io.swagger.annotations.Api;

@RestController
@RequestMapping(value="/telefones")
@Api(value="API REST Telefones")
@CrossOrigin(origins = "*")
public class TelefonesResource {

	@Autowired
	TelefoneServie ts;
	

	
	@RequestMapping(value="/{id}" , method=RequestMethod.GET)
	public ResponseEntity<Telefones> find(@PathVariable Long id){
		Telefones obj = ts.find(id);
		
		//List<Telefones> lista = new ArrayList<>();
		
		return ResponseEntity.ok().body(obj);
	}
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody Telefones obj){
		obj = ts.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody Telefones obj, @PathVariable Long id){
		obj.setId(id);
		obj = ts.update(obj);
		
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value="/{id}" , method=RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Long id){
		
		ts.delete(id);
		return ResponseEntity.noContent().build();
	}
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<TelefonesDTO>> findAll(){
		
		List<Telefones> list = ts.findAll();
		List<TelefonesDTO> listDto = list.stream().map(obj -> new TelefonesDTO(obj)).collect(Collectors.toList());
		
		return ResponseEntity.ok().body(listDto);
	}
	
}
