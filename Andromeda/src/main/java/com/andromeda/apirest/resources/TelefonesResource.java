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

import com.andromeda.apirest.moldels.Clientes;
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
	
}
