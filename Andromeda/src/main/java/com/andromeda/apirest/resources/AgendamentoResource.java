package com.andromeda.apirest.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
	public ResponseEntity<?> find(@PathVariable Long id){
		
		Agendamento obj = as.buscar(id);
		//List<Clientes> lista = new ArrayList<>();
		return ResponseEntity.ok().body(obj);
	}
}
