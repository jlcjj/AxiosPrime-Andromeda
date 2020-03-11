package com.andromeda.apirest.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.andromeda.apirest.moldels.AgendamentoServico;
import com.andromeda.apirest.services.AgendamentoServicoService;

import io.swagger.annotations.Api;

@RestController
@RequestMapping(value="/agendamentoervico")
@Api(value="API REST Agendamento Servico")
@CrossOrigin(origins = "*")
public class AgendamentoServicoResource {
	
	@Autowired
	private AgendamentoServicoService ass;
	
	@RequestMapping(value="/{id}" , method=RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Long id){
		
		AgendamentoServico obj = ass.buscar(id);
		//List<Clientes> lista = new ArrayList<>();
		return ResponseEntity.ok().body(obj);
	}
}
