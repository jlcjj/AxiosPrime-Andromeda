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

import com.andromeda.apirest.moldels.Telefones;
import com.andromeda.apirest.services.TelefoneServie;

import io.swagger.annotations.Api;

@RestController
@RequestMapping(value="/telefones")
@Api(value="API REST Telefones")
@CrossOrigin(origins = "*")
public class TelefonesResource {

	@Autowired
	TelefoneServie ts;
	

	
	@RequestMapping(value="/{id}" , method=RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Long id){
		Telefones obj = ts.buscar(id);
		
		List<Telefones> lista = new ArrayList<>();
		
		return ResponseEntity.ok().body(obj);
	}
	
}
