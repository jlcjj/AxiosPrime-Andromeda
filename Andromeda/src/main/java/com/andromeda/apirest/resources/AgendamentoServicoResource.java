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

import com.andromeda.apirest.moldels.Agendamento;
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
	public ResponseEntity<AgendamentoServico> find(@PathVariable Long id){
		
		AgendamentoServico obj = ass.find(id);
		//List<Clientes> lista = new ArrayList<>();
		return ResponseEntity.ok().body(obj);
	}
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody AgendamentoServico obj){
		obj = ass.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
}
