package com.andromeda.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.andromeda.apirest.moldels.Telefones;

public interface TelefonesRepository extends  JpaRepository<Telefones, Long>{
	
	Telefones findById(long id);
	

}
