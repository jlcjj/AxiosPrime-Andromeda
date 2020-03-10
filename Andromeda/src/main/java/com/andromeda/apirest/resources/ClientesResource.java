package com.andromeda.apirest.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
	public ResponseEntity<?> find(@PathVariable Long id){
		
		Clientes obj = cs.buscar(id);
		//List<Clientes> lista = new ArrayList<>();
		return ResponseEntity.ok().body(obj);
	}
}
