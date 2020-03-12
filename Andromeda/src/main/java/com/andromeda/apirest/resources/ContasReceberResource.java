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

import com.andromeda.apirest.moldels.AgendamentoServico;
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
}
