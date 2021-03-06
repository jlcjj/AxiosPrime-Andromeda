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

import com.andromeda.apirest.dto.ContasReceberDTO;
import com.andromeda.apirest.moldels.ContasReceber;
import com.andromeda.apirest.services.ContasReceberService;

import io.swagger.annotations.Api;

@RestController
@RequestMapping(value="/contasreceber")
@Api(value="API REST Contas Receber")
@CrossOrigin(origins = "*")
public class ContasReceberResource {
	
	@Autowired
	private ContasReceberService crs;
	
	@RequestMapping(value="/{id}" , method=RequestMethod.GET)
	public ResponseEntity<ContasReceber> find(@PathVariable Long id){
		
		ContasReceber obj = crs.find(id);
		//List<Clientes> lista = new ArrayList<>();
		return ResponseEntity.ok().body(obj);
	}
	public ResponseEntity<Void> insert(@RequestBody ContasReceber obj){
		obj = crs.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	

	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody ContasReceber obj, @PathVariable Long id){
		obj.setId(id);
		obj = crs.update(obj);
		
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value="/{id}" , method=RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Long id){
		
		crs.delete(id);
		return ResponseEntity.noContent().build();
	}
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<ContasReceberDTO>> findAll(){
		
		List<ContasReceber> list = crs.findAll();
		List<ContasReceberDTO> listDto = list.stream().map(obj -> new ContasReceberDTO(obj)).collect(Collectors.toList());
		
		return ResponseEntity.ok().body(listDto);

	}
	@RequestMapping(value="/page", method=RequestMethod.GET)
	public ResponseEntity<Page<ContasReceberDTO>> findPage(
			@RequestParam(value="page", defaultValue="0") Integer page, 
			@RequestParam(value="linesPerPage", defaultValue="24") Integer linesPerPage, 
			@RequestParam(value="orderBy", defaultValue="data_pagamento") String orderBy, 
			@RequestParam(value="direction", defaultValue="ASC") String direction) {
		Page<ContasReceber> list = crs.findPage(page, linesPerPage, orderBy, direction);
		Page<ContasReceberDTO> listDto = list.map(obj -> new ContasReceberDTO(obj));  
		return ResponseEntity.ok().body(listDto);
	}
}
