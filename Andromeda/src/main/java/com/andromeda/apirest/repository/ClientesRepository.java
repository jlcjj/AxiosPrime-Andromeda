package com.andromeda.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.andromeda.apirest.moldels.Clientes;

public interface ClientesRepository extends  JpaRepository<Clientes, Long>{
	
	Clientes findById(long id);

}
