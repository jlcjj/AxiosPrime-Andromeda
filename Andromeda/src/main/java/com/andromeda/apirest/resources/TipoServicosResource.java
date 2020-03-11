package com.andromeda.apirest.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
	public ResponseEntity<?> find(@PathVariable Long id){
		
		TipoServicos obj = ss.buscar(id);
		//List<Clientes> lista = new ArrayList<>();
		return ResponseEntity.ok().body(obj);
	}
}
