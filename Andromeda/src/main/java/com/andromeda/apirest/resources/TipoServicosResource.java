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

import com.andromeda.apirest.moldels.ContasReceber;
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
}
