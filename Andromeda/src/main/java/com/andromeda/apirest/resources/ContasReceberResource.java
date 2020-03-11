package com.andromeda.apirest.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
	public ResponseEntity<?> find(@PathVariable Long id){
		
		ContasReceber obj = crs.buscar(id);
		//List<Clientes> lista = new ArrayList<>();
		return ResponseEntity.ok().body(obj);
	}
}
