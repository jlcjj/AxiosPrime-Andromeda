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
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody AgendamentoServico obj, @PathVariable Long id){
		obj.setId(id);
		obj = ass.update(obj);
		
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value="/{id}" , method=RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Long id){
		
		ass.delete(id);
		return ResponseEntity.noContent().build();
	}
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<AgendamentoServico>> findAll(){
		
		List<AgendamentoServico> list = ass.findAll();
		return ResponseEntity.ok().body(list);
	}
}
