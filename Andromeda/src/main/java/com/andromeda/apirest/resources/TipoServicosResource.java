package com.andromeda.apirest.resources;

import java.net.URI;
import java.util.List;

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
import com.andromeda.apirest.services.TipoServicoService;

import io.swagger.annotations.Api;

@RestController
@RequestMapping(value="/servicos")
@Api(value="API REST Servicos")
@CrossOrigin(origins = "*")
public class TipoServicosResource {
	
	@Autowired
	private TipoServicoService ss;
	
	@RequestMapping(value="/{id}" , method=RequestMethod.GET)
	public ResponseEntity<TipoServicos> find(@PathVariable Long id){
		
		TipoServicos obj = ss.find(id);
		//List<Clientes> lista = new ArrayList<>();
		return ResponseEntity.ok().body(obj);
	}
	public ResponseEntity<Void> insert(@RequestBody TipoServicos obj){
		obj = ss.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	

	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody TipoServicos obj, @PathVariable Long id){
		obj.setId(id);
		obj = ss.update(obj);
		
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value="/{id}" , method=RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Long id){
		
		ss.delete(id);
		return ResponseEntity.noContent().build();
	}
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<TipoServicos>> findAll(){
		
		List<TipoServicos> list = ss.findAll();
		return ResponseEntity.ok().body(list);
	}
}
